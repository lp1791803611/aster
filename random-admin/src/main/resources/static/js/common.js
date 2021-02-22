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