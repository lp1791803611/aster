<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <th:block th:include="common/include :: header('新增${table.comment!}')"/>
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <#list table.fields as field>
        <#if field.propertyName != 'id' && field.propertyName != 'gmtCreate'
        && field.propertyName != 'gmtModified' && field.propertyName != 'isDeleted'
        && field.propertyName != 'status'>
            <#if field.propertyName == 'remark'>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">备注信息</label>
                    <div class="layui-input-block">
                        <textarea name="remark" class="layui-textarea" placeholder="请输入备注信息"></textarea>
                    </div>
                </div>
            <#else>
                <div class="layui-form-item">
                    <label class="layui-form-label required">${field.comment}</label>
                    <div class="layui-input-block">
                        <input type="text" name="${field.propertyName}" lay-verify="required"
                               lay-reqtext="${field.comment}不能为空" placeholder="请输入${field.comment}" value=""
                               class="layui-input">
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
<th:block th:include="common/include :: footer"/>

<script th:inline="javascript">
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            $.ajax({
                url: ctx + '${table.entityPath}/insert',
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