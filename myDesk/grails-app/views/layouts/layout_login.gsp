<!DOCTYPE html>
<html lang="${session.'org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'}">
<head>
	<title><g:message code="app.name" default="MyDesk"/></title>
    <meta charset="utf-8">
    <meta name="viewport"		content="width=device-width, initial-scale=1.0">
    <meta name="description"	content="MyDesk">
	<!-- link rel="shortcut icon"	href= {resource(dir:'images',file:'logo.jpg')} type="image/x-icon" />  -->

	<link rel="shortcut icon"		href="${resource(plugin: 'kickstart-with-bootstrap', dir:'images',file:'favicon.ico')}" type="image/x-icon" />
<%-- Manual switch for the skin can be found in /view/_menu/_config.gsp --%>
	<r:require modules="jquery"/>
	<r:require modules="bootstrap"/>
	<r:require modules="bootstrap_utils"/>
	<r:layoutResources />
	<g:layoutHead />
</head>

<body>
	<div class="login">
		<g:layoutBody />
		<g:pageProperty name="page.body" />
	</div>														
	<r:layoutResources />
	<script src="${resource(dir:'js', file:'application.js')}"></script>
	
</body>
</html>