<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
        <th:block th:include="common/include :: header('${table.comment!}列表')" />
</head>
<body>
<div class="layuimini-container">
        <div class="layuimini-main">

                <fieldset class="table-search-fieldset">
                        <legend>搜索信息</legend>
                        <div style="margin: 10px 10px 10px 10px">
                                <form class="layui-form layui-form-pane" action="">
                                        <div class="layui-form-item">
                                                <div class="layui-inline">
                                                        <label class="layui-form-label">查询条件</label>
                                                        <div class="layui-input-inline">
                                                                <input type="text" name="name" autocomplete="off" class="layui-input">
                                                        </div>
                                                </div>
                                                <div class="layui-inline">
                                                        <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>
                                                </div>
                                        </div>
                                </form>
                        </div>
                </fieldset>

                <script type="text/html" id="toolbarDemo">
                        <div class="layui-btn-container">
                                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加 </button>
                                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除 </button>
                        </div>
                </script>

                <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

                <script type="text/html" id="currentTableBar">
                        <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
                        <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
                </script>

        </div>
</div>
<th:block th:include="common/include :: footer" />

<#list table.fields as field>
    <#if field.propertyName == 'status'>
            <script type="text/html" id="statusTpl">
                    <input type="checkbox" lay-filter="status" value="{{d.id}}" lay-skin="switch" lay-text="启用|禁用" {{d.status=='1'?'':'checked'}} />
            </script>
    </#if>
</#list>

<script>
        layui.use(['form', 'table'], function () {
                var $ = layui.jquery,
                        form = layui.form,
                        table = layui.table;

                table.render({
                        elem: '#currentTableId',
                        url: ctx + '${table.entityPath}/pageList',
                        toolbar: '#toolbarDemo',
                        defaultToolbar: ['filter', 'exports', 'print', {
                                title: '提示',
                                layEvent: 'LAYTABLE_TIPS',
                                icon: 'layui-icon-tips'
                        }],
                        parseData: function(res){
                                return res.data;
                        },
                        cols: [ [
                                {type: "checkbox"},
                                <#list table.fields as field>
                                  <#if field.propertyName != 'id' && field.propertyName != 'gmtCreate'
                                        && field.propertyName != 'isDeleted' && field.propertyName != 'remark'>
                                    <#if field.propertyName == 'status'>
                                {field: 'status', title: '启用状态', templet: '#statusTpl'},
                                    <#else>
                                {field: '${field.propertyName}', title: '${field.comment}', sort: true},
                                    </#if>
                                  </#if>
                                </#list>
                                {title: '操作', toolbar: '#currentTableBar', align: "center"}
                        ] ],
                        limits: [10, 15, 20, 25, 50, 100],
                        limit: 15,
                        page: true,
                        skin: 'line'
                });

                // 监听搜索操作
                form.on('submit(data-search-btn)', function (data) {
                        var result = JSON.stringify(data.field);
                        /*layer.alert(result, {
                                title: '最终的搜索信息'
                        });*/

                        //执行搜索重载
                        table.reload('currentTableId', {
                                page: {
                                        curr: 1
                                }
                                , where: {
                                        searchParams: result
                                }
                        }, 'data');

                        return false;
                });

                /**
                 * toolbar监听事件
                 */
                table.on('toolbar(currentTableFilter)', function (obj) {
                        if (obj.event === 'add') {  // 监听添加操作
                                var index = layer.open({
                                        title: '添加',
                                        type: 2,
                                        shade: 0.2,
                                        maxmin:true,
                                        shadeClose: true,
                                        area: ['100%', '100%'],
                                        content: ctx + '${table.entityPath}/add',
                                });
                                $(window).on("resize", function () {
                                        layer.full(index);
                                });
                        } else if (obj.event === 'delete') {  // 监听删除操作
                                var checkStatus = table.checkStatus('currentTableId')
                                        , data = checkStatus.data;
                                if(data != null && data.length>0){
                                        layer.confirm('真的删除行么', function (index) {
                                                layer.close(index);

                                                var ids = [];
                                                for(var i=0; i < data.length; i++){
                                                        ids[i] = data[i].id;
                                                }

                                                $.ajax({
                                                        url: ctx + '${table.entityPath}/batchDelete',
                                                        type: 'POST',
                                                        async: false,
                                                        data: JSON.stringify(ids),
                                                        contentType: 'application/json; charset=UTF-8',
                                                        dataType: "json",
                                                        success: function (res) {
                                                                layer.msg(res.msg);
                                                                table.reload('currentTableId');
                                                        },
                                                        error:function (XMLHttpRequest, textStatus, errorThrown) {
                                                                layer.close(index);
                                                                if(XMLHttpRequest.status==404){
                                                                        window.location.href = ctx + "/404";
                                                                }else{
                                                                        layer.msg("服务器好像出了点问题！请稍后试试");
                                                                }
                                                        }
                                                });
                                        });
                                }else{
                                        layer.alert("请先选择行");
                                }
                        }
                });

                //监听表格复选框选择
                table.on('checkbox(currentTableFilter)', function (obj) {
                        // console.log(obj)
                });

                table.on('tool(currentTableFilter)', function (obj) {
                        var data = obj.data;
                        if (obj.event === 'edit') {

                                var index = layer.open({
                                        title: '编辑',
                                        type: 2,
                                        shade: 0.2,
                                        maxmin:true,
                                        shadeClose: true,
                                        area: ['100%', '100%'],
                                        content: ctx + '${table.entityPath}/edit/'+data.id,
                                });
                                $(window).on("resize", function () {
                                        layer.full(index);
                                });
                                return false;
                        } else if (obj.event === 'delete') {
                                layer.confirm('真的删除行么', function (index) {
                                        layer.close(index);
                                        $.ajax({
                                                url: ctx + '${table.entityPath}/delete/'+data.id,
                                                type: 'GET',
                                                async: false,
                                                contentType: 'application/json; charset=UTF-8',
                                                dataType: "json",
                                                success: function (res) {
                                                        layer.msg(res.msg);
                                                        obj.del();
                                                },
                                                error:function (XMLHttpRequest, textStatus, errorThrown) {
                                                        layer.close(index);
                                                        if(XMLHttpRequest.status==404){
                                                                window.location.href = ctx + "404";
                                                        }else{
                                                                layer.msg("服务器好像出了点问题！请稍后试试");
                                                        }
                                                }
                                        });
                                });
                        }
                });

                <#list table.fields as field>
                <#if field.propertyName == 'status'>
                form.on('switch(status)', function (obj) {
                        var checked = this.checked ? "0" : "1";
                        $.ajax({
                                url: ctx + '${table.entityPath}/switchStatus',
                                type: 'POST',
                                async: false,
                                data: {
                                        "id" : obj.value,
                                        "status" : checked
                                },
                                dataType: "json",
                                success: function (res) {
                                        layer.msg(res.msg);
                                        table.reload('currentTableId');
                                },
                                error:function (XMLHttpRequest, textStatus, errorThrown) {
                                        if(XMLHttpRequest.status==404){
                                                window.location.href = ctx + "404";
                                        }else{
                                                layer.msg("服务器好像出了点问题！请稍后试试");
                                        }
                                }
                        });
                });
                </#if>
                </#list>
        });
</script>