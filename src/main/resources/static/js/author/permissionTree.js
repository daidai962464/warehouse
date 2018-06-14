layui.use(['tree', 'layer', 'form'], function () {
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    getJson(_BASE_URL + "/permissionTree", "", loadTreeSuccess);

    function loadTreeSuccess(result) {
        var datas = result.data;
        layui.treeGird({
            elem: '#permissionTree'
            , drag: true
            , click: function (item) {
            }
            , nodes: datas
            , layout: layout
        });
    };

    var layout = [
        {
            name: '权限名称',
            treeNodes: true,
            headerClass: 'value_col',
            colClass: 'value_col',
            style: 'width: 40%;text-align:left',
        },
        {
            name: '操作',
            headerClass: 'value_col',
            colClass: 'value_col',
            style: 'width: 60%;text-align:left',
            render: function (row) {
                var object = row.object;
                var htmlmark = '';
                var title = object.title;
                var href = object.href;
                var icon = object.icon;
                var mark = object.mark;
                var locationNumber = object.locationNumber;
                var spread = object.spread;
                htmlmark += '<a class="layui-btn layui-bg-blue layui-btn-sm" onclick="checkPermission(\'' + title + '\',\'' + href + '\',\'' + icon + '\',\'' + mark + '\',\'' + locationNumber + '\',\'' + spread + '\')"> 查看</a>';
                htmlmark += '<a class="layui-btn layui-bg-gray layui-btn-sm" onclick="permissionDel(' + row.id + ')"><i class="layui-icon">&#xe640;</i> 删除</a>';
                htmlmark += '<a class="layui-btn layui-btn-warm layui-btn-sm" onclick="permissionUpdate(' + row.id + ')"><i class="layui-icon">&#xe642;</i> 修改权限</a>';
                if (object.level == 1) {
                    htmlmark += '<a class="layui-btn layui-bg-green layui-btn-sm" onclick="permissionAddChild(' + row.id + ')"><i class="layui-icon">&#xe608;</i>添加子级</a>';
                }
                return htmlmark;
            }
        },
    ];
    $("#permissionAddTop").click(function () {
        openWindow(_BASE_URL + "/permissionAdd?type=addTop", "添加权限", "500px", "530px");
    });
});

function permissionUpdate(permissionId) {
    openWindow(_BASE_URL + "/permissionUpdate?type=update&permissionId=" + permissionId, "修改权限", "500px", "530px");
}

function permissionAddChild(permissionId) {
    openWindow(_BASE_URL + "/permissionAddChild?type=addChild&permissionId=" + permissionId, "修改权限", "500px", "530px");
}

function permissionDel(permissionId) {
    layer.confirm("是否确认删除！", {
        time: 3000,
        btn: ['确定', '取消'] //按钮
    }, function () {
        getJson(_BASE_URL + "/permissionDel?permissionId=" + permissionId, "", delSuccess);
    }, function () {
        layer.close();
    });

}

function delSuccess(result) {
    if (result.data = "success") {
        location.reload();
    } else {
        alertError("删除异常！");
    }
}


function checkPermission(title, href, icon, mark, locationNumber, spread) {
    layui.use(['form'], function () {
        var form = layui.form;
        $("#permission_title_id").val(title);
        $("#permission_href_id").val(href);
        $("#permission_icon_id").val(icon);
        $("#permission_mark_id").val(mark);
        $("#permission_locationNumber_id").empty();
        $("#locationNumber_id").append("<option value></option>");
        var html1 = "<option value='" + locationNumber + "' selected>"
            + locationNumber + "</option>";
        $("#permission_locationNumber_id").append(html1);
        form.render("select", "locationNumberSelect");
        if (spread == 'on') {
            $('#permission_spread_id').attr('checked', true);
        } else {
            $('#permission_spread_id').attr('checked', false);
        }
        form.render('checkbox', 'spreadChoose');
    });
}
