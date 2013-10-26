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

	<section id="create-shiroUser" class="first">
	
		<g:hasErrors bean="${shiroUserInstance}">
		<div class="alert alert-error">
			<g:renderErrors bean="${shiroUserInstance}" as="list" />
		</div>
		</g:hasErrors>
		
		<g:form action="save" class="form-horizontal" >
			<fieldset class="form">
				<g:render template="form"/>
			</fieldset>
			<div class="form-actions">
				<g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
	            <button class="btn" type="reset"><g:message code="default.button.reset.label" default="Reset" /></button>
			</div>
		</g:form>
		
	</section>
  
</body>
</html>
