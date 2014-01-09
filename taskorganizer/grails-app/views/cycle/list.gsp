
<%@ page import="taskorganizer.Cycle" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'cycle.label', default: 'Cycle')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-cycle" class="first">

	<table class="table table-bordered margin-top-medium">
		<thead>
			<tr>
			
				<g:sortableColumn property="name" title="${message(code: 'cycle.name.label', default: 'Name')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${cycleInstanceList}" status="i" var="cycleInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${cycleInstance.id}">${fieldValue(bean: cycleInstance, field: "name")}</g:link></td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="container">
		<bs:paginate total="${cycleInstanceTotal}" />
	</div>
</section>

</body>

</html>
