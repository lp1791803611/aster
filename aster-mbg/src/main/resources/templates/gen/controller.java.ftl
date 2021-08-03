package ${cfg.customControllerPackage};

import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
<#if cfg.swagger>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
</#if>
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ${cfg.customServicePackage}.${table.serviceName};
import top.plgxs.common.core.annotation.Log;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.api.page.PageDataInfo;
import ${cfg.customEntityPackage}.${entity};
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

import java.time.LocalDateTime;
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
<#if cfg.swagger>
@Api(tags = "${table.comment!}管理")
</#if>
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
    <#if cfg.swagger>
    @ApiOperation(value = "分页查询${table.comment!}列表", notes = "条件查询")
    </#if>
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "searchParams", required = false) String searchParams,
                                                    @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(searchParams)) {
            JSONObject jsonObject = JSONObject.parseObject(searchParams);
            <#list cfg.columns as column>
                <#if column.isSearch == '0'>
            String ${column.propertyName} = String.valueOf(jsonObject.get("${column.propertyName}"));
            if (StrUtil.isNotBlank(${column.propertyName})) {
                queryWrapper.<#if column.searchType == ''>eq<#else>${column.searchType}</#if>("${column.columnName}", ${column.propertyName});
            }
                </#if>
            </#list>
        }
        queryWrapper.orderByDesc("gmt_create");
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
    <#if cfg.swagger>
    @ApiOperation(value = "插入${table.comment!}", notes = "插入单条数据")
    </#if>
    @Log(title = "${table.comment!}", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody ${entity} ${entity?uncap_first}){
        ${entity?uncap_first}.setGmtCreate(LocalDateTime.now());
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
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        ${entity} ${entity?uncap_first} = ${table.serviceName ? uncap_first}.getById(id);
        model.addAttribute("${entity?uncap_first}",${entity?uncap_first});
        return "${cfg.customTableName}/${table.entityPath?replace(cfg.customTableName,"")?uncap_first}/edit";
    }

    /**
     * 更新一条数据
     * @param ${entity?uncap_first}
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author ${author}
     * @since ${date}
     */
    <#if cfg.swagger>
    @ApiOperation(value = "更新${table.comment!}", notes = "更新单条数据")
    </#if>
    @Log(title = "${table.comment!}", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody ${entity} ${entity?uncap_first}){
        if(${entity?uncap_first} == null || StringUtils.isBlank(${entity?uncap_first}.getId())){
            return ResultInfo.validateFailed();
        }
        ${entity?uncap_first}.setGmtModified(LocalDateTime.now());
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
    <#if cfg.swagger>
    @ApiOperation(value = "删除${table.comment!}", notes = "删除单条数据")
    </#if>
    @Log(title = "${table.comment!}", businessType = BusinessType.DELETE)
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
    <#if cfg.swagger>
    @ApiOperation(value = "批量删除${table.comment!}", notes = "批量删除数据")
    </#if>
    @Log(title = "${table.comment!}", businessType = BusinessType.DELETE)
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

    /**
     * 切换状态
     * @param id 主键
     * @param status 状态
     * @author ${author}
     * @since ${date}
     */
    <#if cfg.swagger>
    @ApiOperation(value = "切换${table.comment!}状态", notes = "切换状态")
    </#if>
    @Log(title = "${table.comment!}", businessType = BusinessType.SWITCH)
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name="id") String id, @RequestParam(name = "status") String status){
        ${entity} ${entity?uncap_first} = new ${entity}();
        ${entity?uncap_first}.setId(id);
        ${entity?uncap_first}.setStatus(status);
        boolean result = ${table.serviceName ? uncap_first}.updateById(${entity?uncap_first});
        if(result){
            return ResultInfo.success("切换成功",null);
        }else{
            return ResultInfo.failed("切换失败");
        }
    }
}
</#if>
