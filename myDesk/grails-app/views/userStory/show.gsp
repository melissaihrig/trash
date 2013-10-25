
<%@ page import="mydesk.UserStory" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-userStory" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="userStory.description.label" default="Description" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: userStoryInstance, field: "description")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="userStory.owner.label" default="Owner" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: userStoryInstance, field: "owner")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="userStory.point.label" default="Point" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: userStoryInstance, field: "point")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="userStory.state.label" default="State" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: userStoryInstance, field: "state")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
