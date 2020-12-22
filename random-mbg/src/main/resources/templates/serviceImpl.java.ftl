package ${cfg.customServiceImplPackage};

import ${cfg.customEntityPackage}.${entity};
import ${cfg.customMapperPackage}.${table.mapperName};
import ${cfg.customServicePackage}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @Author ${author}
 * @Date ${date}
 * @Version 1.0
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    @Resource
    private ${table.mapperName} ${table.mapperName?uncap_first};

    @Override
    public List<${entity}> get${entity}List() {
        return ${table.mapperName?uncap_first}.select${entity}List(null);
    }
}
</#if>
