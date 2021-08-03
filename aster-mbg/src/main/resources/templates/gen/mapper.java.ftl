package ${cfg.customMapperPackage};

import ${cfg.customEntityPackage}.${entity};
import ${superMapperClassPackage};
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 * @version 1.0
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    /**
     * 分页数据查询
     * @param ${entity?uncap_first}
     * @return
     * @author ${author}
     * @date ${date}
     */
    List<${entity}> select${entity}List(${entity} ${entity?uncap_first});
}
</#if>