<%@ page import="security.ShiroUser" %>
<!doctype html>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="layout_login" />
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'login.css')}" type="text/css">
  <title><g:message code="signup.title" default="Sign up"/></title>
  <g:set var="entityName" value="${message(code: 'shiroUser.label', default: 'ShiroUser')}" />
  
</head>

<body>
		<g:form action="save" class="form-horizontal" >
		
			<h1><g:message code="app.Name" default="MyDesk"/></h1>
		
			<g:hasErrors bean="${shiroUserInstance}">
				<div class="alert alert-error">
					<g:renderErrors bean="${shiroUserInstance}" as="list" />
				</div>
			</g:hasErrors>
		
			<fieldset class="form">
				<g:render template="formSignup"/>
			</fieldset>

			<g:submitButton name="create" value="${message(code: 'login.signup', default: 'Signup')}" />
		</g:form>
</body>
</html>
