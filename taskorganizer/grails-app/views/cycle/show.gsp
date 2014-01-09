
<%@ page import="taskorganizer.Cycle" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'cycle.label', default: 'Cycle')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-cycle" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="cycle.name.label" default="Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: cycleInstance, field: "name")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="cycle.status.label" default="Status" /></td>
				
				<td valign="top" style="text-align: left;" class="value">
					<ul>
					<g:each in="${cycleInstance.status}" var="s">
						<li><g:link controller="status" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
					</g:each>
					</ul>
				</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
