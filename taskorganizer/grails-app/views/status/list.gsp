
<%@ page import="taskorganizer.Status" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'status.label', default: 'Status')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-status" class="first">

	<table class="table table-bordered margin-top-medium">
		<thead>
			<tr>
			
				<g:sortableColumn property="name" title="${message(code: 'status.name.label', default: 'Name')}" />
			
				<g:sortableColumn property="description" title="${message(code: 'status.description.label', default: 'Description')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${statusInstanceList}" status="i" var="statusInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${statusInstance.id}">${fieldValue(bean: statusInstance, field: "name")}</g:link></td>
			
				<td>${fieldValue(bean: statusInstance, field: "description")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="container">
		<bs:paginate total="${statusInstanceTotal}" />
	</div>
</section>

</body>

</html>
