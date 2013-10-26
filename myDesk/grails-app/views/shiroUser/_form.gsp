<%@ page import="security.ShiroUser" %>

			<div class="control-group fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'username', 'error')} required">
				<label for="username" class="control-label"><g:message code="shiroUser.username.label" default="Username" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:textField name="username" required="" value="${shiroUserInstance?.username}"/>
					<span class="help-inline">${hasErrors(bean: shiroUserInstance, field: 'username', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'firstname', 'error')} ">
				<label for="firstname" class="control-label"><g:message code="shiroUser.firstname.label" default="Firstname" /></label>
				<div class="controls">
					<g:textField name="firstname" value="${shiroUserInstance?.firstname}"/>
					<span class="help-inline">${hasErrors(bean: shiroUserInstance, field: 'firstname', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'lastname', 'error')} required">
				<label for="lastname" class="control-label"><g:message code="shiroUser.lastname.label" default="Lastname" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:textField name="lastname" value="${shiroUserInstance?.lastname}"/>
					<span class="help-inline">${hasErrors(bean: shiroUserInstance, field: 'lastname', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'passwordHash', 'error')} ">
				<label for="passwordHash" class="control-label"><g:message code="shiroUser.passwordHash.label" default="Password Hash" /></label>
				<div class="controls">
					<g:textField name="passwordHash" value="${shiroUserInstance?.passwordHash}"/>
					<span class="help-inline">${hasErrors(bean: shiroUserInstance, field: 'passwordHash', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'permissions', 'error')} ">
				<label for="permissions" class="control-label"><g:message code="shiroUser.permissions.label" default="Permissions" /></label>
				<div class="controls">
					
					<span class="help-inline">${hasErrors(bean: shiroUserInstance, field: 'permissions', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'roles', 'error')} ">
				<label for="roles" class="control-label"><g:message code="shiroUser.roles.label" default="Roles" /></label>
				<div class="controls">
					<g:select name="roles" from="${security.ShiroRole.list()}" multiple="multiple" optionKey="id" size="5" value="${shiroUserInstance?.roles*.id}" class="many-to-many"/>
					<span class="help-inline">${hasErrors(bean: shiroUserInstance, field: 'roles', 'error')}</span>
				</div>
			</div>

