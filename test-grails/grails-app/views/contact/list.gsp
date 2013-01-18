
<%@ page import="stakeholder.Contact" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'contact.label', default: 'Contact')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-contact" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="nickname" title="${message(code: 'contact.nickname.label', default: 'Nickname')}" />
			
				<th><g:message code="contact.customer.label" default="Customer" /></th>
			
				<g:sortableColumn property="dateCreated" title="${message(code: 'contact.dateCreated.label', default: 'Date Created')}" />
			
				<g:sortableColumn property="email" title="${message(code: 'contact.email.label', default: 'Email')}" />
			
				<g:sortableColumn property="firstName" title="${message(code: 'contact.firstName.label', default: 'First Name')}" />
			
				<g:sortableColumn property="lastName" title="${message(code: 'contact.lastName.label', default: 'Last Name')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${contactInstanceList}" status="i" var="contactInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${contactInstance.id}">${fieldValue(bean: contactInstance, field: "nickname")}</g:link></td>
			
				<td>${fieldValue(bean: contactInstance, field: "customer")}</td>
			
				<td><g:formatDate date="${contactInstance.dateCreated}" /></td>
			
				<td>${fieldValue(bean: contactInstance, field: "email")}</td>
			
				<td>${fieldValue(bean: contactInstance, field: "firstName")}</td>
			
				<td>${fieldValue(bean: contactInstance, field: "lastName")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${contactInstanceTotal}" />
	</div>
</section>

</body>

</html>
