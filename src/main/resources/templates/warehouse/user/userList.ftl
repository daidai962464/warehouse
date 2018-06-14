<#import "../../com/base-js.ftl" as commonJs>
<#import "../../com/base-css.ftl" as commonCss>
<!DOCTYPE html>
<html>
<head>
 <@commonCss.commonStyle />
</head>
<body style="overflow: hidden">
<div id="user_query_panel" class="white_content">
    <form class="layui-form" action="javascript:void(0);">
        <div class="white_content_top">
            <div class="layui-form-item">
                <label class="layui-form-label">工号</label>
                <div class="layui-input-inline">
                    <input type="text" name="jobNumber" class="layui-input"
                           autocomplete="off">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">手机号</label>
                <div class="layui-input-inline">
                    <input type="text" name="mobile" class="layui-input"
                           autocomplete="off">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                    <input type="text" name="email" class="layui-input"
                            autocomplete="off">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <input name="status" title="禁用" type="checkbox" value="1" >
                    <input name="isDel" title="删除" type="checkbox" value="1">
                </div>
            </div>
        </div>
        <div class="clearfloat"></div>
        <div class="white_content_bottom">
            <fieldset class="layui-elem-field layui-field-title"></fieldset>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="userQueryButton"><i
                            class="layui-icon">&#xe615;</i>查询
                    </button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </div>
    </form>
</div>


<blockquote class="layui-elem-quote">
    <div class="clearfix">
        <div style="display:inline;" class="f-l">
            <div class="layui-inline">
                <a  id="userAdd" href="javascript:void(0);" class="layui-btn layui-btn-normal">添加用户</a>
            </div>
        </div>
        <div style="display:inline;" class="f-r">
            <div class="layui-inline">
                <button id="user_query_button" class="layui-btn layui-btn-sm"
                        onclick="queryPanelOpen('user_query_panel','user_query_button','user_close_button');"><i
                        class="layui-icon">&#xe615;</i></button>
            </div>
            <div class="layui-inline">
                <button id="user_close_button" class="layui-btn layui-btn-sm" style="display: none"
                        onclick="queryPanelClose('user_query_panel','user_query_button','user_close_button');"><i
                        class="layui-icon">&#xe65c;</i></button>
            </div>
        </div>
    </div>


</blockquote>
<fieldset class="layui-elem-field layui-field-title">
    <div class="layui-form" style="margin: 10px">
        <table class="layui-hide" id="user_list_id"></table>
    </div>

    <@commonJs.userListJs />
</body>
</html>