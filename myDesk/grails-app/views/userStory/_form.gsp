<%@ page import="mydesk.UserStory" %>



			<div class="control-group fieldcontain ${hasErrors(bean: userStoryInstance, field: 'description', 'error')} ">
				<label for="description" class="control-label"><g:message code="userStory.description.label" default="Description" /></label>
				<div class="controls">
					<g:textField name="description" value="${userStoryInstance?.description}"/>
					<span class="help-inline">${hasErrors(bean: userStoryInstance, field: 'description', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: userStoryInstance, field: 'owner', 'error')} ">
				<label for="owner" class="control-label"><g:message code="userStory.owner.label" default="Owner" /></label>
				<div class="controls">
					<g:textField name="owner" value="${userStoryInstance?.owner}"/>
					<span class="help-inline">${hasErrors(bean: userStoryInstance, field: 'owner', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: userStoryInstance, field: 'point', 'error')} required">
				<label for="point" class="control-label"><g:message code="userStory.point.label" default="Point" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="point" required="" value="${userStoryInstance.point}"/>
					<span class="help-inline">${hasErrors(bean: userStoryInstance, field: 'point', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: userStoryInstance, field: 'state', 'error')} ">
				<label for="state" class="control-label"><g:message code="userStory.state.label" default="State" /></label>
				<div class="controls">
					<g:textField name="state" value="${userStoryInstance?.state}"/>
					<span class="help-inline">${hasErrors(bean: userStoryInstance, field: 'state', 'error')}</span>
				</div>
			</div>

