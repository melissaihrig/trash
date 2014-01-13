<%@ page import="taskorganizer.Project" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="user_layout" />
	<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
	<title><g:message code="default.create.label" args="[entityName]" /></title>
</head>

<body>

<section id="create-project" class="first">

	<g:hasErrors bean="${projectInstance}">
	<div class="alert alert-danger">
		<g:renderErrors bean="${projectInstance}" as="list" />
	</div>
	</g:hasErrors>
	
	<g:form action="save" class="form-horizontal"  enctype="multipart/form-data" role="form">
		<fieldset class="form">
			<g:render template="form"/>
		</fieldset>
		
		<div class="row form-actions">
			<div class="col-md-2 col-md-offset-5">
	  			<g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
	            <button class="btn" type="reset"><g:message code="default.button.reset.label" default="Reset" /></button>
			</div>
		</div>

	</g:form>

</section>
        
<g:render template="form_task" />

</body>

</html>
