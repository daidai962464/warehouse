function getJson(url, parame, success) {
    $.getJSON(url, parame, success);
}

function postJson(url, parame, success) {
    $.post(url, parame, success, "json");
}

function closeAll() {
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
    parent.location.reload();
}

function openWindow(url, title, width, height) {
    layer.open({
        type: 2
        , skin: 'layui-layer-molv'
        , title: title
        , area: [width, height]
        , maxmin: false
        , content: url
        , resize: false
        , zIndex: layer.zIndex
        , success: function (layero, index) {
        }
    });
}


function alertError(mes) {
    layer.msg(mes, {icon: 5});
}

function alertError(mes) {
    layer.msg(mes, {icon: 5});
}

function queryPanelOpen(queryPanelId, queryButtonId, closeButtonId) {
    $("#" + queryPanelId).fadeIn();
    $("#" + queryButtonId).hide();
    $("#" + closeButtonId).show();
}

function queryPanelClose(queryPanelId, queryButtonId, closeButtonId) {
    $("#" + queryPanelId).fadeOut();
    $("#" + queryButtonId).show();
    $("#" + closeButtonId).hide();
}

$(function () {
    var availHeight = window.innerHeight;
    availHeight = availHeight - 120;
    $(".white_content").height(availHeight);
    $(".white_content_top").height(availHeight - 120);
    $(".white_content_bottom").height(70);
});


function formatDateTime(inputTime) {
    var date = new Date(inputTime);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    h = h < 10 ? ('0' + h) : h;
    var minute = date.getMinutes();
    var second = date.getSeconds();
    minute = minute < 10 ? ('0' + minute) : minute;
    second = second < 10 ? ('0' + second) : second;
    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;
};