<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${cfg.customMapperPackage}.${table.mapperName}">

<#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>

</#if>
<#if baseResultMap>
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${cfg.customEntityPackage}.${entity}">
        <#list table.fields as field>
            <#if field.keyFlag><#--生成主键排在第一位-->
        <id column="${field.name}" property="${field.propertyName}" />
            </#if>
        </#list>
<#list table.commonFields as field><#--生成公共字段 -->
    <result column="${field.name}" property="${field.propertyName}" />
</#list>
<#list table.fields as field>
    <#if !field.keyFlag><#--生成普通字段 -->
        <result column="${field.name}" property="${field.propertyName}" />
    </#if>
</#list>
    </resultMap>

</#if>
<#if baseColumnList>
    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
        <#list table.commonFields as field>
            ${field.name},
        </#list>
        ${table.fieldNames}
    </sql>

</#if>
    <select id="select${entity}List" parameterType="${cfg.customEntityPackage}.${entity}" resultType="${cfg.customEntityPackage}.${entity}">
        select <include refid="Base_Column_List"/>
        from ${table.name} t
        where 1 = 1
        <#list table.fields as field>
            <#if field.type?contains('char')>
            <if test="${field.propertyName} != null and ${field.propertyName} != ''">
                and t.${field.name} = ${r'#{'}${field.propertyName}}
            </if>
            <#elseif field.type?contains('text')>
            <if test="${field.propertyName} != null and ${field.propertyName} != ''">
                and t.${field.name} like concat('%',  ${r'#{'}${field.propertyName}}, '%')
            </if>
            <#else>
            <if test="${field.propertyName} != null">
                and t.${field.name} = ${r'#{'}${field.propertyName}}
            </if>
            </#if>
        </#list>
    </select>
</mapper>