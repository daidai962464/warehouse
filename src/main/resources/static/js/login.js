layui.use(['form', 'layer'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;
    //video背景
    $(window).resize(function () {
        if ($(".video-player").width() > $(window).width()) {
            $(".video-player").css({
                "height": $(window).height(),
                "width": "auto",
                "left": -($(".video-player").width() - $(window).width()) / 2
            });
        } else {
            $(".video-player").css({
                "width": $(window).width(),
                "height": "auto",
                "left": -($(".video-player").width() - $(window).width()) / 2
            });
        }
    }).resize();
    //登录按钮事件
    form.on("submit(login)", function (data) {
        console.log(data);
        postJson(_BASE_URL + "/login", data.field, loginSuccess);
        return false;
    });
    refreshCheckCode();
});


function refreshCheckCode() {
    $('#checkCodeImg').click(function () {
        var timestamp = new Date().getTime();
        $(this).attr("src", _BASE_URL + "/checkCode/" + timestamp)
    })
}

function loginSuccess(result) {
    console.log("11111111111111111111111111");
    console.log(result);
    window.location.href = _BASE_URL + "/index";
}

