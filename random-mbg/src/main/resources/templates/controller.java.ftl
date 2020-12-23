package ${cfg.customControllerPackage};

import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import ${cfg.customServicePackage}.${table.serviceName};
import top.plgxs.common.api.ResultInfo;
import ${cfg.customEntityPackage}.${entity};
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 * @version 1.0
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Resource
    private ${table.serviceName} ${table.serviceName ? uncap_first};

    /**
     * 分页查询列表
     * @param query 查询条件
     * @param pageNo 第几页
     * @param pageSize 每页几条
     * @return
     * @author ${author}
     * @since ${date}
     */
    @GetMapping("/list")
    @ResponseBody
    public ResultInfo<IPage<${entity}>> queryPageList(@RequestParam("query") String query, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        //TODO 查询条件
        Page<${entity}> page = new Page<>(pageNo, pageSize);
        IPage<${entity}> pageList = ${table.serviceName ? uncap_first}.page(page, queryWrapper);
        return ResultInfo.success(pageList);
    }

    /**
     * 插入一条数据
     * @param ${entity?uncap_first}
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author ${author}
     * @since ${date}
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody ${entity} ${entity?uncap_first}){
        boolean result = ${table.serviceName ? uncap_first}.save(${entity?uncap_first});
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 更新一条数据
     * @param ${entity?uncap_first}
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author ${author}
     * @since ${date}
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody ${entity} ${entity?uncap_first}){
        if(${entity?uncap_first} == null || StringUtils.isBlank(${entity?uncap_first}.getId())){
            return ResultInfo.validateFailed();
        }
        boolean result = ${table.serviceName ? uncap_first}.updateById(${entity?uncap_first});
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 逻辑删除一条数据
     * @param id 主键
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author ${author}
     * @since ${date}
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){
            return ResultInfo.validateFailed();
        }
        boolean result = ${table.serviceName ? uncap_first}.removeById(id);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }
}
</#if>
