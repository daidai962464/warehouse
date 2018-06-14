<#import "../../com/base-js.ftl" as commonJs>
<#import "../../com/base-css.ftl" as commonCss>
<!DOCTYPE html>
<html>
<head>
 <@commonCss.commonStyle />
 <@commonJs.permissionTreeJs />
</head>
<style>
    .layui-table, .layui-table-view {
        margin: 0px;
    }
</style>
<body class="childrenBody">
<blockquote class="layui-elem-quote">
    <div class="layui-inline">
        <button class="layui-btn" id="permissionAddTop">
            <i class="layui-icon">&#xe608;</i> 添加顶级
        </button>
    </div>
    <div class="layui-inline">
        <div class="layui-form-mid layui-word-aux">本页面刷新后除新添加的数据外所有操作无效，关闭页面所有数据重置</div>
    </div>
</blockquote>
<fieldset class="layui-elem-field layui-field-title">
</fieldset>

<div class="layui-row">
    <div class="layui-col-xs6">
        <div id="permissionTree" style="margin-left: 10px"></div>
    </div>
    <div class="layui-col-xs6">
        <form class="layui-form">
            <div id="form-section">
                <div class="layui-form-item">
                    <label class="layui-form-label">权限名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="title" id="permission_title_id" class="layui-input"
                               lay-verify="required" style="width: 300px;" autocomplete="off" disabled>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">权限url</label>
                    <div class="layui-input-inline">
                        <input type="text" name="href" class="layui-input" id="permission_href_id"
                               lay-verify="required" style="width: 300px;" autocomplete="off" disabled>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">权限图标</label>
                    <div class="layui-input-inline">
                        <input type="text" name="icon" class="layui-input" id="permission_icon_id"
                               lay-verify="required" style="width: 300px;" autocomplete="off" disabled>
                    </div>
                </div>
                <div lay-filter="locationNumberSelect" class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label">选择框</label>
                        <div class="layui-input-block" style="width: 300px;">
                            <select id="permission_locationNumber_id" name="locationNumber" lay-verify="required"
                                    disabled>
                            </select>
                        </div>
                    </div>
                </div>
                <div lay-filter="spreadChoose" class="layui-form">
                    <div class="layui-inline">
                        <label class="layui-form-label">是否展开</label>
                        <div class="layui-input-block">
                            <input type="checkbox" id="permission_spread_id" name="spread" title="展开"
                                   style="width: 300px;" disabled>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">内容摘要</label>
                    <div class="layui-input-block">
                <textarea name="mark" class="layui-textarea" id="permission_mark_id"
                          style="width: 300px;height: 100px" autocomplete="off" disabled></textarea>
                    </div>
                </div>
            </div>
            <br style="clear:both;"/>
        </form>
    </div>
</div>
</body>
</html>