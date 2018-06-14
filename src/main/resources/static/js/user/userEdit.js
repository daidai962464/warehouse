layui.use(['jquery', 'form', 'layer', 'element'], function () {
    var form = layui.form;
    var layer = layui.layer;
    var elemen = layui.elemen;
    var type = $("#page_type_id").val();

    form.verify({
        nickname: function (value) {
            if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                return '用户名称不能有特殊字符';
            }
            if(/(^\_)|(\__)|(\_+$)/.test(value)){
                return '用户名称首尾不能出现下划线\'_\'';
            }
        }
    });
    form.on("submit(userEdit)", function (data) {
        console.log(data.field)

        return false;
    });

});