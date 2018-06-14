<#import "../../com/base-js.ftl" as commonJs>
<#import "../../com/base-css.ftl" as commonCss>
<!DOCTYPE html>
<html>
<head>
      <@commonCss.commonStyle />
      <@commonJs.permissionEditJs />
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
 <#if type!='addTop'>
<input type="hidden" value="${(permission.spread)!''}" id="spread_flag_id"/>
 </#if>

<form class="layui-form">

     <#if type!='addTop'>
    <input type="hidden" name="permissionId" value="${(permission.permissionId)!''}" id="permissionId_id"/>
    <input type="hidden" name="parentPermissionId" value="${(permission.parentPermissionId)!''}"
           id="parentPermissionId_id"/>
    <input type="hidden" name="level" value="${(permission.level)!''}" id="level_id"/>
     </#if>

    <div id="form-section">
        <div class="layui-form-item">
            <label class="layui-form-label">权限名称</label>
            <div class="layui-input-inline">
                <input type="text" name="title" value="${(permission.title)!''}" class="layui-input"
                       lay-verify="title"
                       placeholder="请输入权限名称" style="width: 300px;" autocomplete="off">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">权限url</label>
            <div class="layui-input-inline">
                <input type="text" name="href" value="${(permission.href)!''}" class="layui-input"
                       lay-verify="required"
                       placeholder="请输入权限url" style="width: 300px;" autocomplete="off">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">权限图标</label>
            <div class="layui-input-inline">
                <input type="text" name="icon" value="${(permission.icon)!''}" class="layui-input"
                       lay-verify="required"
                       placeholder="请输入权限图标" style="width: 300px;" autocomplete="off">
            </div>
        </div>
        <div lay-filter="locationNumberSelect" class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">显示排序</label>
                <div class="layui-input-block" style="width: 300px;">
                    <select id="locationNumber_id" name="locationNumber" lay-verify="required"
                            lay-search>
                    </select>
                </div>
            </div>
        </div>
        <div lay-filter="spreadChoose" class="layui-form">
            <div class="layui-inline">
                <label class="layui-form-label">是否展开</label>
                <div class="layui-input-block">
                    <input type="checkbox" id="spread_id" name="spread" title="展开"
                           style="width: 300px;">
                </div>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">内容摘要</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容摘要" name="mark" class="layui-textarea"
                          style="width: 300px;height: 100px" autocomplete="off">${(permission.mark)!''}</textarea>
            </div>
        </div>
    </div>
    <br style="clear:both;"/>
    <fieldset class="layui-elem-field layui-field-title"></fieldset>
    <div id="form-footer">
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="permissionEdit">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                <button type="button" class="layui-btn layui-btn-primary" id="close_but_id">关闭</button>
            </div>
        </div>
    </div>

</form>

<script>
    $("#close_but_id").click(function () {
        closeAll();
    });
</script>

</body>
</html>