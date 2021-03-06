layui.define(['jquery'], function (exports) {

    var $ = layui.$,
        layer = layui.layer;

    var $ZTree = function(id, url) {
        this.id = id;
        this.url = url;
        this.onClick = null;
        this.settings = null;
        this.ondblclick=null;
    };

    $ZTree.prototype = {
        /**
         * 初始化ztree的设置
         */
        initSetting : function() {
            var settings = {
                view : {
                    dblClickExpand : true,
                    selectedMulti : false
                },
                data : {
                    simpleData : {
                        enable : true,
                        idKey: "id",
                        pIdKey: "pid",
                        rootPId: "0"
                    }
                },
                callback : {
                    onClick : this.onClick,
                    onDblClick:this.ondblclick
                }
            };
            return settings;
        },

        /**
         * 手动设置ztree的设置
         */
        setSettings : function(val) {
            this.settings = val;
        },

        /**
         * 初始化ztree
         */
        init : function() {
            var zNodeSeting = null;
            if(this.settings != null){
                zNodeSeting = this.settings;
            }else{
                zNodeSeting = this.initSetting();
            }
            var zNodes = this.loadNodes();
            $.fn.zTree.init($("#" + this.id), zNodeSeting, zNodes);
        },

        /**
         * 绑定onclick事件
         */
        bindOnClick : function(func) {
            this.onClick = func;
        },
        /**
         * 绑定双击事件
         */
        bindOnDblClick : function(func) {
            this.ondblclick=func;
        },


        /**
         * 加载节点
         */
        loadNodes : function() {
            var zNodes = null;
            $.ajax({
                type: 'POST',
                url: this.url,
                dataType: 'json',
                async: false,
                success: function (res) {
                    zNodes = res.data;
                },
                error: function (res) {
                    layer.msg(res.msg);
                }
            });
            return zNodes;
        },

        /**
         * 获取选中的值
         */
        getSelectedVal : function(){
            var zTree = $.fn.zTree.getZTreeObj(this.id);
            var nodes = zTree.getSelectedNodes();
            return nodes[0].name;
        }
    };

    exports('ztree', $ZTree);

});