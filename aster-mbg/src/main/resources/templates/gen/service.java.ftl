package ${cfg.customServicePackage};

import ${cfg.customEntityPackage}.${entity};
import ${superServiceClassPackage};

import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 * @version 1.0
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
    /**
     * 数据查询列表
     * @return
     * @author ${author}
     * @date ${date}
     */
    List<${entity}> get${entity}List();
}
</#if>
