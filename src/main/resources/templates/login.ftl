<#import "com/base-js.ftl" as commonJs>
<#import "com/base-css.ftl" as commonCss>
<!DOCTYPE html>
<html>
<head>
    <@commonCss.loginStyle />
</head>
<body>
<#--<video class="video-player" preload="auto" autoplay="autoplay" loop="loop" data-height="1080" data-width="1920"-->
       <#--height="1080" width="1920">-->
    <#--<source src="${request.contextPath}/images/login.mp4" type="video/mp4">-->
<#--</video>-->
<div class="video_mask"></div>
<div class="login">
    <h1>管理员登录</h1>
    <form class="layui-form">
        <div class="layui-form-item">
            <input class="layui-input" id="mobile_id" name="username" placeholder="用户名" lay-verify="required" type="text"
                   autocomplete="off">
        </div>
        <div class="layui-form-item">
            <input class="layui-input" id="pswd_id" name="pwssword" placeholder="密码" lay-verify="required" type="password"
                   autocomplete="off">
        </div>
        <div class="layui-form-item form_code">
            <input class="layui-input" name="code" placeholder="验证码" lay-verify="required" type="text"
                   autocomplete="off">
            <div class="code"><img id="checkCodeImg" src="${request.contextPath}/checkCode/100" width="116" height="36">
            </div>
        </div>
        <button class="layui-btn login_btn" lay-submit lay-filter="login">登录</button>
    </form>
</div>
<@commonJs.loginJs />
</body>
</html>