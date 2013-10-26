
<%@ page import="security.ShiroUser" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'shiroUser.label', default: 'ShiroUser')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-shiroUser" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="username" title="${message(code: 'shiroUser.username.label', default: 'Username')}" />
			
				<g:sortableColumn property="firstname" title="${message(code: 'shiroUser.firstname.label', default: 'Firstname')}" />
			
				<g:sortableColumn property="lastname" title="${message(code: 'shiroUser.lastname.label', default: 'Lastname')}" />
			
				<g:sortableColumn property="passwordHash" title="${message(code: 'shiroUser.passwordHash.label', default: 'Password Hash')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${shiroUserInstanceList}" status="i" var="shiroUserInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${shiroUserInstance.id}">${fieldValue(bean: shiroUserInstance, field: "username")}</g:link></td>
			
				<td>${fieldValue(bean: shiroUserInstance, field: "firstname")}</td>
			
				<td>${fieldValue(bean: shiroUserInstance, field: "lastname")}</td>
			
				<td>${fieldValue(bean: shiroUserInstance, field: "passwordHash")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${shiroUserInstanceTotal}" />
	</div>
</section>

</body>

</html>
