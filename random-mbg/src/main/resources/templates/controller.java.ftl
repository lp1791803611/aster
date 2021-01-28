package ${cfg.customControllerPackage};

import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import ${cfg.customServicePackage}.${table.serviceName};
import top.plgxs.common.api.ResultInfo;
import top.plgxs.common.page.PageDataInfo;
import ${cfg.customEntityPackage}.${entity};
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

import java.util.List;

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
     * ${table.comment!}页面
     * @author ${author}
     * @since ${date}
     */
    @GetMapping("/list")
    public String list(){
        return "${cfg.customTableName}/${table.entityPath?replace(cfg.customTableName,"")?uncap_first}/list";
    }

    /**
     * 分页查询列表
     * @param searchParams 查询条件
     * @param pageNo 第几页
     * @param pageSize 每页几条
     * @return
     * @author ${author}
     * @since ${date}
     */
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "searchParams", required = false) String searchParams, @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        //TODO 查询条件
        Page<${entity}> page = new Page<>(pageNo, pageSize);
        IPage<${entity}> pageList = ${table.serviceName ? uncap_first}.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<${entity}>(pageList.getRecords(),pageList.getTotal()));
    }

    /**
     * 添加页面
     * @author ${author}
     * @since ${date}
     */
    @GetMapping("/add")
    public String add(){
        return "${cfg.customTableName}/${table.entityPath?replace(cfg.customTableName,"")?uncap_first}/add";
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
     * 编辑页面
     * @author ${author}
     * @since ${date}
     */
    @GetMapping("/edit")
    public String edit(){
        return "${cfg.customTableName}/${table.entityPath?replace(cfg.customTableName,"")?uncap_first}/edit";
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

    /**
     * 批量删除
     * @param ids id数组
     * @author ${author}
     * @since ${date}
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids){
        boolean result = ${table.serviceName ? uncap_first}.removeByIds(ids);
        if(result){
            return ResultInfo.success("删除成功",null);
        }else{
            return ResultInfo.failed("删除失败");
        }
    }
}
</#if>
