
<%@ page import="mydesk.UserStory" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-userStory" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="description" title="${message(code: 'userStory.description.label', default: 'Description')}" />
			
				<g:sortableColumn property="owner" title="${message(code: 'userStory.owner.label', default: 'Owner')}" />
			
				<g:sortableColumn property="point" title="${message(code: 'userStory.point.label', default: 'Point')}" />
			
				<g:sortableColumn property="state" title="${message(code: 'userStory.state.label', default: 'State')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${userStoryInstanceList}" status="i" var="userStoryInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${userStoryInstance.id}">${fieldValue(bean: userStoryInstance, field: "description")}</g:link></td>
			
				<td>${fieldValue(bean: userStoryInstance, field: "owner")}</td>
			
				<td>${fieldValue(bean: userStoryInstance, field: "point")}</td>
			
				<td>${fieldValue(bean: userStoryInstance, field: "state")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${userStoryInstanceTotal}" />
	</div>
</section>

</body>

</html>
