
<%@ page import="taskorganizer.Task" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'task.label', default: 'Task')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-task" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="task.description.label" default="Description" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: taskInstance, field: "description")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="task.status.label" default="Status" /></td>
				
				<td valign="top" class="value"><g:link controller="status" action="show" id="${taskInstance?.status?.id}">${taskInstance?.status?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="task.weight.label" default="Weight" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: taskInstance, field: "weight")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="task.dateCreated.label" default="Date Created" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${taskInstance?.dateCreated}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="task.detail.label" default="Detail" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: taskInstance, field: "detail")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="task.project.label" default="Project" /></td>
				
				<td valign="top" class="value"><g:link controller="project" action="show" id="${taskInstance?.project?.id}">${taskInstance?.project?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
