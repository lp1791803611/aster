<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <th:block th:include="common/include :: header('编辑${table.comment!}')" />
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form" th:object="${r'$'}{${entity?uncap_first}}">
    <input name="id"  type="hidden"  th:field="*{id}" />
    <#list table.fields as field>
        <#if field.propertyName != 'id' && field.propertyName != 'gmtCreate'
            && field.propertyName != 'gmtModified' && field.propertyName != 'isDeleted'>
             <#if field.propertyName == 'remark'>
                 <div class="layui-form-item layui-form-text">
                     <label class="layui-form-label">备注信息</label>
                     <div class="layui-input-block">
                         <textarea name="remark" class="layui-textarea" placeholder="请输入备注信息" th:field="*{remark}"></textarea>
                     </div>
                 </div>
             <#elseif field.propertyName == 'status'>
                <div class="layui-form-item">
                    <label class="layui-form-label required">启用状态</label>
                    <div class="layui-input-block">
                        <input type="checkbox" name="status" lay-skin="switch" lay-text="启用|禁用"
                               th:checked="${r'$'}{${entity?uncap_first}.status == '1' ? false : true}">
                    </div>
                </div>
             <#else>
                 <div class="layui-form-item">
                     <label class="layui-form-label required">${field.comment}</label>
                     <div class="layui-input-block">
                         <input type="text" name="${field.propertyName}" lay-verify="required" lay-reqtext="${field.comment}不能为空" placeholder="请输入${field.comment}" th:field="*{${field.propertyName}}" class="layui-input">
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
<th:block th:include="common/include :: footer" />

<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            <#list table.fields as field>
                <#if field.propertyName == 'status'>
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
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.close(index);
                    if(XMLHttpRequest.status==404){
                        window.location.href="404";
                    }else{
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