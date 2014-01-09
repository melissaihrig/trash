
<%@ page import="taskorganizer.Project" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-project" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="project.cycle.label" default="Cycle" /></td>
				
				<td valign="top" class="value"><g:link controller="cycle" action="show" id="${projectInstance?.cycle?.id}">${projectInstance?.cycle?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="project.name.label" default="Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: projectInstance, field: "name")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="project.image.label" default="Image" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="project.dateCreated.label" default="Date Created" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${projectInstance?.dateCreated}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="project.description.label" default="Description" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: projectInstance, field: "description")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="project.task.label" default="Task" /></td>
				
				<td valign="top" style="text-align: left;" class="value">
					<ul>
					<g:each in="${projectInstance.task}" var="t">
						<li><g:link controller="task" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
					</g:each>
					</ul>
				</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
