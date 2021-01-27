<div class="layuimini-container layuimini-page-anim">
        <div class="layuimini-main">
                <fieldset class="table-search-fieldset">
                        <legend>搜索信息</legend>
                        <div style="margin: 10px 10px 10px 10px">
                                <form class="layui-form layui-form-pane" action="">
                                        <div class="layui-form-item">
                                                <div class="layui-inline">
                                                        <label class="layui-form-label">查询条件</label>
                                                        <div class="layui-input-inline">
                                                                <input type="text" name="name" autocomplete="off" class="layui-input" placeholder="请输入...">
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

<script>
        layui.use(['form', 'table','miniPage','element'], function () {
                var $ = layui.jquery,
                        form = layui.form,
                        table = layui.table,
                        miniPage = layui.miniPage;

                table.render({
                        elem: '#currentTableId',
                        url: '${table.entityPath}/pageList',
                        toolbar: '#toolbarDemo',
                        defaultToolbar: ['filter', 'exports', 'print', {
                                title: '提示',
                                layEvent: 'LAYTABLE_TIPS',
                                icon: 'layui-icon-tips'
                        }],
                        cols: [ [
                                {type: "checkbox", width: 50},
                                <#list table.fields as field>
                                {field: '${field.propertyName}', width: 80, title: '${field.comment}', sort: true},
                                </#list>
                                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
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
                 * toolbar事件监听
                 */
                table.on('toolbar(currentTableFilter)', function (obj) {
                        if (obj.event === 'add') {   // 监听添加操作
                                var content = miniPage.getHrefContent('page/table/add.html');
                                var openWH = miniPage.getOpenWidthHeight();

                                var index = layer.open({
                                        title: '添加',
                                        type: 1,
                                        shade: 0.2,
                                        maxmin:true,
                                        shadeClose: true,
                                        area: [openWH[0] + 'px', openWH[1] + 'px'],
                                        offset: [openWH[2] + 'px', openWH[3] + 'px'],
                                        content: content,
                                });
                                $(window).on("resize", function () {
                                        layer.full(index);
                                });
                        } else if (obj.event === 'delete') {  // 监听删除操作
                                var checkStatus = table.checkStatus('currentTableId')
                                        , data = checkStatus.data;
                                //TODO
                                layer.alert(JSON.stringify(data));
                        }
                });

                //监听表格复选框选择
                table.on('checkbox(currentTableFilter)', function (obj) {
                        console.log(obj)
                });

                table.on('tool(currentTableFilter)', function (obj) {
                        var data = obj.data;
                        if (obj.event === 'edit') {

                                var content = miniPage.getHrefContent('page/table/add.html');
                                var openWH = miniPage.getOpenWidthHeight();

                                var index = layer.open({
                                        title: '编辑用户',
                                        type: 1,
                                        shade: 0.2,
                                        maxmin:true,
                                        shadeClose: true,
                                        area: [openWH[0] + 'px', openWH[1] + 'px'],
                                        offset: [openWH[2] + 'px', openWH[3] + 'px'],
                                        content: content,
                                });
                                $(window).on("resize", function () {
                                        layer.full(index);
                                });
                                return false;
                        } else if (obj.event === 'delete') {
                                layer.confirm('真的删除行么', function (index) {
                                        obj.del();
                                        layer.close(index);
                                });
                        }
                });

        });
</script>