
<%@ page import="taskorganizer.Task" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'task.label', default: 'Task')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-task" class="first">

	<table class="table table-bordered margin-top-medium">
		<thead>
			<tr>
			
				<g:sortableColumn property="description" title="${message(code: 'task.description.label', default: 'Description')}" />
			
				<th><g:message code="task.status.label" default="Status" /></th>
			
				<g:sortableColumn property="weight" title="${message(code: 'task.weight.label', default: 'Weight')}" />
			
				<g:sortableColumn property="dateCreated" title="${message(code: 'task.dateCreated.label', default: 'Date Created')}" />
			
				<g:sortableColumn property="detail" title="${message(code: 'task.detail.label', default: 'Detail')}" />
			
				<th><g:message code="task.project.label" default="Project" /></th>
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${taskInstanceList}" status="i" var="taskInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${taskInstance.id}">${fieldValue(bean: taskInstance, field: "description")}</g:link></td>
			
				<td>${fieldValue(bean: taskInstance, field: "status")}</td>
			
				<td>${fieldValue(bean: taskInstance, field: "weight")}</td>
			
				<td><g:formatDate date="${taskInstance.dateCreated}" /></td>
			
				<td>${fieldValue(bean: taskInstance, field: "detail")}</td>
			
				<td>${fieldValue(bean: taskInstance, field: "project")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="container">
		<bs:paginate total="${taskInstanceTotal}" />
	</div>
</section>

</body>

</html>
