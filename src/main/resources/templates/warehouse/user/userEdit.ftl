<#import "../../com/base-js.ftl" as commonJs>
<#import "../../com/base-css.ftl" as commonCss>
<!DOCTYPE html>
<html>
<head>
      <@commonCss.commonStyle />
</head>
<style>
    #form-section {
        min-width: 200px;
        min-height: 100px;
        padding-top: 20px;
        overflow: visible;
    }

    #form-footer {
        min-width: 200px;
        height: 50px;
        text-align: right;
        padding-right: 10px;
        margin-bottom: 0px;
    }

    .layui-form-select dl {
        max-height: 200px;
    }
</style>
<body class="childrenBody" style="overflow:visible ">
<input type="hidden" value="${type}" id="page_type_id"/>


<form class="layui-form">

    <div id="form-section">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名称</label>
            <div class="layui-input-inline">
                <input type="text" name="nickname" value="${(user.nickname)!''}" class="layui-input"
                       lay-verify="nickname"
                       placeholder="请输入用户名称" style="width: 300px;" autocomplete="off">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="text" name="mobile" value="${(user.mobile)!''}" class="layui-input"
                       lay-verify="required|phone"
                       placeholder="请输手机号" style="width: 300px;" autocomplete="off">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="text" name="pswd" value="${(user.pswd)!''}" class="layui-input"
                       lay-verify="required"
                       placeholder="请输入密码" style="width: 300px;" autocomplete="off">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">email</label>
            <div class="layui-input-inline">
                <input type="text" name="email" value="${(user.email)!''}" class="layui-input"
                       lay-verify="required|email"
                       placeholder="请输入email" style="width: 300px;" autocomplete="off">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">QQ</label>
            <div class="layui-input-inline">
                <input type="text" name="qq" value="${(user.qq)!''}" class="layui-input"
                       lay-verify="required|number"
                       placeholder="请输入QQ" style="width: 300px;" autocomplete="off">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">身份证号</label>
            <div class="layui-input-inline">
                <input type="text" name="idCard" value="${(user.idCard)!''}" class="layui-input"
                       lay-verify="identity"
                       placeholder="请输入身份证号" style="width: 300px;" autocomplete="off">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="1" title="男">
                <input type="radio" name="sex" value="2" title="女">
                <input type="radio" name="sex" value="3" title="保密" checked>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">禁用开关</label>
            <div class="layui-input-block">
                <input type="checkbox" name="status" lay-skin="switch" value="1" checked>
            </div>
        </div>

    </div>
    <fieldset class="layui-elem-field layui-field-title"></fieldset>
    <div id="form-footer">
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="userEdit">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                <button type="button" class="layui-btn layui-btn-primary" id="close_but_id">关闭</button>
            </div>
        </div>
    </div>
</form>
</body>
<@commonJs.userEditJs />
<script>
    $("#close_but_id").click(function () {
        closeAll();
    });
</script>
</html>