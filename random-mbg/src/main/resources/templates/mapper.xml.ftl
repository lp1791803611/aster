<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">
    <#if enableCache>
        <!-- 开启二级缓存 -->
        <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>
    </#if>
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${cfg.customEntityPackage}.${entity}">
        <#list table.fields as field>
            <#if field.keyFlag><#--生成主键排在第一位-->
                <id property="${field.propertyName}" column="${field.name}"/>
            </#if>
        </#list>
        <#list table.commonFields as field><#--生成公共字段 -->
            <result property="${field.propertyName}" column="${field.name}"/>
        </#list>
        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
                <result property="${field.propertyName}" column="${field.name}"/>
            </#if>
        </#list>
    </resultMap>
    <!-- 通用查询映射结果 -->
    <resultMap id="OtherResultMap" type="${cfg.customEntityPackage}.${entity}">
        <#list table.fields as field>
            <#if field.keyFlag><#--生成主键排在第一位-->
                <id property="${field.propertyName}" column="other_${field.name}"/>
            </#if>
        </#list>
        <#list table.commonFields as field><#--生成公共字段 -->
            <result property="${field.propertyName}" column="other_${field.name}"/>
        </#list>
        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
                <result property="${field.propertyName}" column="other_${field.name}"/>
            </#if>
        </#list>
    </resultMap>

    <!-- 通用查询结果列 -->
    <sql id="other_Column_List">
        <#list table.fields as field>
            other.${field.name}         other_${field.name},
        </#list>
        <#list table.commonFields as field><#--生成公共字段 -->
            other.${field.name}         other_${field.name},
        </#list>
    </sql>
    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
        <#list table.fields as field>
            ${field.name}               ${field.name},
        </#list>
        <#list table.commonFields as field><#--生成公共字段 -->
            ${field.name}               ${field.name},
        </#list>
    </sql>
</mapper>
