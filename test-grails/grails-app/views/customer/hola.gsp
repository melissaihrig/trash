
<%@ page import="stakeholder.Customer" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
	<title><g:message code="Results" args="[entityName]" /></title>
</head>

<body>

Total: ${customerInstanceTotal}	
<section id="hola-customer" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="companyName" title="${message(code: 'customer.companyName.label', default: 'Company Name')}" />
			
				<g:sortableColumn property="ratingPoints" title="${message(code: 'customer.ratingPoints.label', default: 'Rating Points')}" />			
			</tr>
		</thead>
		<tbody>
		<g:each in="${customerInstanceList}" status="i" var="customerInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${customerInstance.id}">${fieldValue(bean: customerInstance, field: "companyName")}</g:link></td>
			
				<td>${fieldValue(bean: customerInstance, field: "ratingPoints")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${customerInstanceTotal}" />
	</div>
</section>

</body>

</html>
