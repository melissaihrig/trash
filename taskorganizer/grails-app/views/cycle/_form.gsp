<%@ page import="taskorganizer.Cycle" %>



			<div class="control-group fieldcontain ${hasErrors(bean: cycleInstance, field: 'name', 'error')} required">
				<label for="name" class="control-label"><g:message code="cycle.name.label" default="Name" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:textField name="name" required="" value="${cycleInstance?.name}"/>
					<span class="help-inline">${hasErrors(bean: cycleInstance, field: 'name', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: cycleInstance, field: 'status', 'error')} ">
				<label for="status" class="control-label"><g:message code="cycle.status.label" default="Status" /></label>
				<div class="controls">
					<g:select name="status" from="${taskorganizer.Status.list()}" multiple="multiple" optionKey="id" size="5" value="${cycleInstance?.status*.id}" class="many-to-many"/>
					<span class="help-inline">${hasErrors(bean: cycleInstance, field: 'status', 'error')}</span>
				</div>
			</div>

