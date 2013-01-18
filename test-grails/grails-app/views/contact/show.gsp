
<%@ page import="stakeholder.Contact" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'contact.label', default: 'Contact')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-contact" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="contact.nickname.label" default="Nickname" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: contactInstance, field: "nickname")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="contact.customer.label" default="Customer" /></td>
				
				<td valign="top" class="value"><g:link controller="customer" action="show" id="${contactInstance?.customer?.id}">${contactInstance?.customer?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="contact.dateCreated.label" default="Date Created" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${contactInstance?.dateCreated}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="contact.email.label" default="Email" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: contactInstance, field: "email")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="contact.firstName.label" default="First Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: contactInstance, field: "firstName")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="contact.lastName.label" default="Last Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: contactInstance, field: "lastName")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="contact.lastUpdated.label" default="Last Updated" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${contactInstance?.lastUpdated}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="contact.phoneNumber.label" default="Phone Number" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: contactInstance, field: "phoneNumber")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
