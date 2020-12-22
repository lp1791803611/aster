package ${cfg.customServicePackage};

import ${cfg.customEntityPackage}.${entity};
import ${superServiceClassPackage};

import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @Author ${author}
 * @Date ${date}
 * @Version 1.0
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
    List<${entity}> get${entity}List();
}
</#if>
