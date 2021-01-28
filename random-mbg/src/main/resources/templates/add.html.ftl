<div class="layuimini-main">

    <div class="layui-form layuimini-form">
    <#list table.fields as field>
        <#if field.propertyName != 'id' && field.propertyName != 'gmtCreate'
            && field.propertyName != 'gmtModified' && field.propertyName != 'isDeleted'>

            <div class="layui-form-item">
                <label class="layui-form-label required">${field.comment}</label>
                <div class="layui-input-block">
                    <input type="text" name="${field.propertyName}" lay-verify="required" lay-reqtext="${field.comment}不能为空" placeholder="请输入${field.comment}" value="" class="layui-input">
                </div>
            </div>

        </#if>
    </#list>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use(['form', 'table'], function () {
        var form = layui.form,
            layer = layui.layer,
            table = layui.table,
            $ = layui.$;

        /**
         * 初始化表单，要加上，不然刷新部分组件可能会不加载
         */
        form.render();

        // 当前弹出层，防止ID被覆盖
        var parentIndex = layer.index;

        //监听提交
        form.on('submit(saveBtn)', function (data) {

            $.ajax({
                url: '${table.entityPath}/insert',
                type: 'GET',
                async: false,
                contentType: 'application/json; charset=UTF-8',
                dataType: "json",
                data:JSON.stringify(data.field),
                success: function (res) {
                    var index = layer.alert(res.msg, {
                        title: '提示信息'
                    }, function () {
                        // 关闭弹出层
                        layer.close(index);
                        layer.close(parentIndex);
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