layui.use(['table', 'element', 'form', 'jquery', 'layer'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.jquery;
    var element = layui.element;

    /**
     * 查询
     */
    form.on("submit(userQueryButton)", function (data) {
        loadUserTale(table, data.field)
        return false;
    });
    /**
     * 加载列表
     */
    loadUserTale(table, '');


    $("#userAdd").click(function () {
        openWindow(_BASE_URL + "/userAdd?type=add", "添加用户", "500px", "570px");
    });


});


function loadUserTale(table, field) {
    table.render({
        elem: '#user_list_id'
        , loading: true
        , url: _BASE_URL + "/userList"
        , cellMinWidth: 80
        , height: 'full-100'
        , page: true
        , text: {
            none: '暂无相关数据'
        }
        , where: field
        , cols: [[
            {field: 'jobNumber', width: 100, title: '工号'}
            , {field: 'nickname', width: 120, title: '昵称'}
            , {field: 'mobile', width: 120, title: '手机'}
            , {field: 'email', title: '邮箱'}
            , {
                field: 'sex', width: 60, title: '性别', align: 'center', templet: function (row) {
                    if (row.sex == 1) {
                        return '男';
                    }
                    if (row.sex == 2) {
                        return '女';
                    }
                    return "其他";
                }
            }, {
                field: 'status', width: 80, title: '状态', templet: function (row) {
                    if (row.status == 0) {
                        return "禁止登录";
                    }
                    if (row.status == 1) {
                        return "正常";
                    }
                    return "其他";
                }
            }, {
                field: 'isDel', width: 80, title: '删除', align: 'center', templet: function (row) {
                    if (row.isDel == '0') {
                        return "未删除";
                    }
                    if (row.isDel == '1') {
                        return "已删除";
                    }
                    return "其他";
                }
            }
            , {
                field: 'addTime', title: '添加时间', templet: function (row) {
                    return row.addTime;
                }
            }, {field: 'lastLoginTime', title: '最后登录时间'}
            , {
                title: '操作', templet:
                    function (row) {
                        var htmlmark = '';
                        htmlmark += '<a class="layui-btn layui-bg-gray layui-btn-sm" onclick="permissionDel(' + row.id + ')"><i class="layui-icon">&#xe640;</i> 删除</a>';
                        htmlmark += '<a class="layui-btn layui-btn-warm layui-btn-sm" onclick="permissionUpdate(' + row.id + ')"><i class="layui-icon">&#xe642;</i> 修改</a>';
                        return htmlmark;
                    }
            }
        ]]
    })
    ;
}