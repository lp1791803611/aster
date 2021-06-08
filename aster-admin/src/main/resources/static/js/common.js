/** common.js 通用js方法 */

// 获取ztree被选中的id值
var zTreeCheckedNodes = function (zTreeId) {
    var zTree = $.fn.zTree.getZTreeObj(zTreeId);
    var nodes = zTree.getCheckedNodes();
    var ids = "";
    for (var i = 0, l = nodes.length; i < l; i++) {
        ids += "," + nodes[i].id;
    }
    return ids.substring(1);
};

(function ($) {
    $.extend({
        // 操作封装处理
        operate: {
            // 提交数据
            submit: function(url, type, dataType, data, callback) {
                var config = {
                    url: url,
                    type: type,
                    dataType: dataType,
                    data: data,
                    success: function(result) {
                        if (typeof callback == "function") {
                            callback(result);
                        }
                        layer.msg(result.msg);
                    }
                };
                $.ajax(config)
            },
            // post请求传输
            post: function(url, data, callback) {
                $.operate.submit(url, "post", "json", data, callback);
            },
            // get请求传输
            get: function(url, callback) {
                $.operate.submit(url, "get", "json", "", callback);
            }
        }
    });
})(jQuery);