<%@ page import="mydesk.Project" %>



			<div class="control-group fieldcontain ${hasErrors(bean: projectInstance, field: 'name', 'error')} ">
				<label for="name" class="control-label"><g:message code="project.name.label" default="Name" /></label>
				<div class="controls">
					<g:textField name="name" value="${projectInstance?.name}"/>
					<span class="help-inline">${hasErrors(bean: projectInstance, field: 'name', 'error')}</span>
				</div>
			</div>

