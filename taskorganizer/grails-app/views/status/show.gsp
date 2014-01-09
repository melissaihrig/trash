
<%@ page import="taskorganizer.Status" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'status.label', default: 'Status')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-status" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="status.name.label" default="Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: statusInstance, field: "name")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="status.description.label" default="Description" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: statusInstance, field: "description")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
