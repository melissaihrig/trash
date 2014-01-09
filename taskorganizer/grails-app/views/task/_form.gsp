<%@ page import="taskorganizer.Task" %>



			<div class="control-group fieldcontain ${hasErrors(bean: taskInstance, field: 'description', 'error')} required">
				<label for="description" class="control-label"><g:message code="task.description.label" default="Description" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:textField name="description" required="" value="${taskInstance?.description}"/>
					<span class="help-inline">${hasErrors(bean: taskInstance, field: 'description', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: taskInstance, field: 'status', 'error')} required">
				<label for="status" class="control-label"><g:message code="task.status.label" default="Status" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="status" name="status.id" from="${taskorganizer.Status.list()}" optionKey="id" required="" value="${taskInstance?.status?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: taskInstance, field: 'status', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: taskInstance, field: 'weight', 'error')} required">
				<label for="weight" class="control-label"><g:message code="task.weight.label" default="Weight" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="weight" min="0" required="" value="${taskInstance.weight}"/>
					<span class="help-inline">${hasErrors(bean: taskInstance, field: 'weight', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: taskInstance, field: 'detail', 'error')} ">
				<label for="detail" class="control-label"><g:message code="task.detail.label" default="Detail" /></label>
				<div class="controls">
					<g:textField name="detail" value="${taskInstance?.detail}"/>
					<span class="help-inline">${hasErrors(bean: taskInstance, field: 'detail', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: taskInstance, field: 'project', 'error')} required">
				<label for="project" class="control-label"><g:message code="task.project.label" default="Project" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="project" name="project.id" from="${taskorganizer.Project.list()}" optionKey="id" required="" value="${taskInstance?.project?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: taskInstance, field: 'project', 'error')}</span>
				</div>
			</div>

