
<%@ page import="security.ShiroUser" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'shiroUser.label', default: 'ShiroUser')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-shiroUser" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="shiroUser.username.label" default="Username" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: shiroUserInstance, field: "username")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="shiroUser.firstname.label" default="Firstname" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: shiroUserInstance, field: "firstname")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="shiroUser.lastname.label" default="Lastname" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: shiroUserInstance, field: "lastname")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="shiroUser.passwordHash.label" default="Password Hash" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: shiroUserInstance, field: "passwordHash")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="shiroUser.permissions.label" default="Permissions" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: shiroUserInstance, field: "permissions")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="shiroUser.roles.label" default="Roles" /></td>
				
				<td valign="top" style="text-align: left;" class="value">
					<ul>
					<g:each in="${shiroUserInstance.roles}" var="r">
						<li><g:link controller="shiroRole" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
					</g:each>
					</ul>
				</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
