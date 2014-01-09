
<%@ page import="taskorganizer.Project" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-project" class="first">

	<table class="table table-bordered margin-top-medium">
		<thead>
			<tr>
			
				<th><g:message code="project.cycle.label" default="Cycle" /></th>
			
				<g:sortableColumn property="name" title="${message(code: 'project.name.label', default: 'Name')}" />
			
				<g:sortableColumn property="image" title="${message(code: 'project.image.label', default: 'Image')}" />
			
				<g:sortableColumn property="dateCreated" title="${message(code: 'project.dateCreated.label', default: 'Date Created')}" />
			
				<g:sortableColumn property="description" title="${message(code: 'project.description.label', default: 'Description')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${projectInstanceList}" status="i" var="projectInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${projectInstance.id}">${fieldValue(bean: projectInstance, field: "cycle")}</g:link></td>
			
				<td>${fieldValue(bean: projectInstance, field: "name")}</td>
			
				<td>${fieldValue(bean: projectInstance, field: "image")}</td>
			
				<td><g:formatDate date="${projectInstance.dateCreated}" /></td>
			
				<td>${fieldValue(bean: projectInstance, field: "description")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="container">
		<bs:paginate total="${projectInstanceTotal}" />
	</div>
</section>

</body>

</html>
