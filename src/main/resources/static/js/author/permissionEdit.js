layui.use(['jquery', 'form', 'layer', 'element'], function () {
    var form = layui.form;
    var layer = layui.layer;
    var elemen = layui.elemen;
    var type = $("#page_type_id").val();
    //各种基于事件的操作，下面会有进一步介绍

    form.verify({
        title: function (value) {
            if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                return '权限名称不能有特殊字符';
            }
            if(/(^\_)|(\__)|(\_+$)/.test(value)){
                return '权限名称首尾不能出现下划线\'_\'';
            }
            if(!/^\d+\d+\d$/.test(value)){
                return '权限名称不能全为数字';
            }
        }
    });

    if (type == 'update' || type == 'addChild') {
        var permissionId = $("#permissionId_id").val();
        var parentPermissionId = $("#parentPermissionId_id").val();
        var level = $("#level_id").val();
        var url = _BASE_URL + "/permissionLocationNumber";
        url += "?permissionId=" + permissionId;
        url += "&parentPermissionId=" + parentPermissionId;
        url += "&level=" + level;
        getJson(url, "", selectSuccess);
    } else {
        getJson(_BASE_URL + "/permissionLocationNumber", "", selectSuccess);
    }

    var spread_flag = $("#spread_flag_id").val();
    if (spread_flag == 'on') {
        $('#spread_id').attr('checked', true);
        form.render('checkbox', 'spreadChoose');
    }

    function selectSuccess(result) {
        $("#locationNumber_id").empty();
        $("#locationNumber_id").append("<option value></option>");
        var datas = result.data;
        var html1 = "";
        for (var i = 0; i < datas.length; i++) {
            var data = datas[i];
            if (data.check == 1) {
                html1 += "<option value='" + data.value + "' selected>"
                    + data.name + "</option>";
            } else {
                html1 += "<option value='" + data.value + "'>"
                    + data.name + "</option>";
            }
        }
        $("#locationNumber_id").append(html1);
        form.render("select", "locationNumberSelect");
    }

    form.on("submit(permissionEdit)", function (data) {
        if (type == 'addTop' || type == 'addChild') {
            postJson(_BASE_URL + "/permissionAdd", data.field, permissionAddSuccess);
        }
        if (type == 'update') {
            postJson(_BASE_URL + "/permissionUpdate", data.field, permissionAddSuccess);
        }
        return false;
    });
});

function permissionAddSuccess(result) {
    if (result.data = "success") {
        closeAll();
    } else {
        alertError("添加异常！");
    }
}





