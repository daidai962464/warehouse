<#macro commonJs>
	<script type="text/javascript">
        var _BASE_URL = "${request.contextPath}";
    </script>
	<script type="text/javascript" src="${request.contextPath}/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${request.contextPath}/layui/layui.js"></script>
	<script type="text/javascript" src="${request.contextPath}/js/base.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
  <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
  <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</#macro>

<#macro indexJs>
    <@commonJs />
	<script type="text/javascript" src="${request.contextPath}/js/index/leftNav.js"></script>
	<script type="text/javascript" src="${request.contextPath}/js/index/index.js"></script>
</#macro>

<#macro loginJs>
    <@commonJs />
	<script type="text/javascript" src="${request.contextPath}/js/login.js"></script>
</#macro>

<#macro permissionTreeJs>
    <@commonJs />
	<script type="text/javascript" src="${request.contextPath}/js/author/permissionTree.js"></script>
</#macro>

<#macro permissionEditJs>
    <@commonJs />
	<script type="text/javascript" src="${request.contextPath}/js/author/permissionEdit.js"></script>
</#macro>

<#macro userListJs>
    <@commonJs />
	<script type="text/javascript" src="${request.contextPath}/js/user/userList.js"></script>
</#macro>

<#macro userEditJs>
	<@commonJs />
	<script type="text/javascript" src="${request.contextPath}/js/user/userEdit.js"></script>
</#macro>