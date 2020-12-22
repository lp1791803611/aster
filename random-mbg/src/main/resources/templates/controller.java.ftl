package ${cfg.customControllerPackage};

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ${cfg.customServicePackage}.${table.serviceName};
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import ${cfg.customEntityPackage}.${entity};

import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @Author ${author}
 * @Date ${date}
 * @Version 1.0
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

    @GetMapping(value = "/list")
    @ResponseBody
    public List<${entity}> get${entity}List(){
        return ${table.serviceName ? uncap_first}.get${entity}List();
    }
}
</#if>
