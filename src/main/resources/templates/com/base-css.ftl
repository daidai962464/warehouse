<#macro baseStyle>
	<meta charset="utf-8">
<#--<title>进销存后台管理系统</title>-->
<title>xxxxxxxxxxxxxx</title>
	<link rel="icon" href="favicon.ico">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${request.contextPath}/layui/css/layui.css" media="all"/>
	<link rel="stylesheet" href="${request.contextPath}/css/base.css" media="all"/>
</#macro>

<#macro baseFontStyle>
<link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all"/>
</#macro>

<#macro commonStyle>
    <@baseStyle />
    <@baseFontStyle />
</#macro>

<#macro loginStyle>
    <@baseStyle />
<link rel="stylesheet" href="${request.contextPath}/css/login.css" media="all"/>
</#macro>

<#macro indexStyle>
    <@commonStyle />
<link rel="stylesheet" href="${request.contextPath}/css/main.css" media="all"/>
</#macro>
<#macro errorStyle>
<link rel="stylesheet" href="${request.contextPath}/css/error/cyrillic.css" media="all"/>
<link rel="stylesheet" href="${request.contextPath}/css/error/error.css" media="all"/>
<link rel="stylesheet" href="${request.contextPath}/css/error/latin.css" media="all"/>
</#macro>