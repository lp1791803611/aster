<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <th:block th:include="common/include :: header('编辑${table.comment!}')"/>
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form" th:object="${r'$'}{${entity?uncap_first}}">
    <input name="id" type="hidden" th:field="${r'*{id}'}"/>
    <#list cfg.columns as column>
        <#if column.isEdit == '0'  && column.columnName != 'gmt_modified' && column.columnName != 'modified_by'
        && column.columnName != 'is_deleted' && column.columnName != 'gmt_create' && column.columnName != 'create_by'>
        <#if column.showType == 'input'>
            <div class="layui-form-item">
                <label class="layui-form-label <#if column.isRequired == '0'>required</#if> ">${column.columnComment}</label>
                <div class="layui-input-block">
                <#if column.columnName == 'status'>
                    <input type="checkbox" name="status" lay-skin="switch" lay-text="启用|禁用"
                           th:checked="${r'$'}{${entity?uncap_first}.status == '1' ? false : true}">
                <#else>
                    <input type="text" name="${column.propertyName}"
                           <#if column.isRequired == '0'>lay-verify="required" lay-reqtext="${column.columnComment}不能为空"</#if>
                           placeholder="请输入${column.columnComment}" th:field="${r'*{'}${column.propertyName}${r'}'}" class="layui-input">
                </#if>
                </div>
            </div>
        </#if>
        <#if column.showType == 'textarea'>
            <div class="layui-form-item">
                <label class="layui-form-label <#if column.isRequired == '0'>required</#if> ">${column.columnComment}</label>
                <div class="layui-input-block">
                    <textarea name="${column.propertyName}" class="layui-textarea"
                              placeholder="请输入${column.columnComment}" th:field="${r'*{'}${column.propertyName}${r'}'}" >
                    </textarea>
                </div>
            </div>
        </#if>
        <#if column.showType == 'date'>
            <div class="layui-form-item">
                <label class="layui-form-label <#if column.isRequired == '0'>required</#if> ">${column.columnComment}</label>
                <div class="layui-input-block">
                    <input type="text" name="${column.propertyName}" id="${column.propertyName}"
                           <#if column.isRequired == '0'>lay-verify="required" lay-reqtext="${column.columnComment}不能为空"</#if>
                           placeholder="请输入${column.columnComment}" th:field="${r'*{'}${column.propertyName}${r'}'}" class="layui-input">
                </div>
            </div>
        </#if>
        <#if column.showType == 'radio' && column.dictType != ''>
            <div class="layui-form-item">
                <label class="layui-form-label <#if column.isRequired == '0'>required</#if> ">${column.columnComment}</label>
                <div class="layui-input-block" th:with="type=${r'${'}@dict.getDict('${column.dictType}')${r'}'}">
                    <input type="radio" name="${column.propertyName}" th:each="dict : ${r'${type}'}"
                           th:value="${r'${dict.dictValue}'}" th:title="${r'${dict.dictLabel}'}" th:field="${r'*{'}${column.propertyName}${r'}'}" >
                </div>
            </div>
        </#if>
        <#if column.showType == 'select' && column.dictType != ''>
            <div class="layui-form-item">
                <label class="layui-form-label <#if column.isRequired == '0'>required</#if> ">${column.columnComment}</label>
                <div class="layui-input-block">
                    <select name="${column.propertyName}" th:with="type=${r'${'}@dict.getDict('${column.dictType}')${r'}'}">
                        <option value="">请选择</option>
                        <option th:each="dict : ${r'${type}'}" th:text="${r'${dict.dictLabel}'}" th:value="${r'${dict.dictValue}'}" th:field="${r'*{'}${column.propertyName}${r'}'}" ></option>
                    </select>
                </div>
            </div>
        </#if>
        </#if>
    </#list>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
</div>
<th:block th:include="common/include :: footer"/>

<script th:inline="javascript">
    layui.use(['form', 'laydate'], function () {
        var form = layui.form,
            laydate = layui.laydate,
            layer = layui.layer,
            $ = layui.$;

        <#list cfg.columns as column>
            <#if column.isEdit == '0' && column.showType == 'date'>
        laydate.render({
            elem: '#${column.propertyName}',
            type: 'datetime'
        });
            </#if>
        </#list>

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            <#list cfg.columns as column>
            <#if column.propertyName == 'status'>
            data.field.status = $("input[name='status']").is(':checked') == true ? 0 : 1;
            </#if>
            </#list>
            $.ajax({
                url: ctx + '${table.entityPath}/update',
                type: 'POST',
                async: false,
                contentType: 'application/json; charset=UTF-8',
                dataType: "json",
                data: JSON.stringify(data.field),
                success: function (res) {
                    var index = layer.alert(res.msg, {
                        title: '提示信息'
                    }, function () {
                        // 重新加载列表
                        window.parent.location.reload();
                        // 关闭弹出层
                        layer.close(index);
                        var iframeIndex = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(iframeIndex);
                    });
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.close(index);
                    if (XMLHttpRequest.status == 404) {
                        window.location.href = "404";
                    } else {
                        layer.msg("服务器好像出了点问题！请稍后试试");
                    }
                }
            });

            return false;
        });

    });
</script>
</body>
</html>