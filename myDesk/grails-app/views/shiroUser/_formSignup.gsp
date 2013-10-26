<%@ page import="security.ShiroUser" %>

			<div class="control-group fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'firstname', 'error')} ">
				<label for="firstname" class="control-label"><g:message code="shiroUser.firstname.label" default="Firstname" /></label>
				<div class="controls">
					<g:textField name="firstname" value="${shiroUserInstance?.firstname}"/>
					<span class="help-inline">${hasErrors(bean: shiroUserInstance, field: 'firstname', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'lastname', 'error')} ">
				<label for="lastname" class="control-label"><g:message code="shiroUser.lastname.label" default="Lastname" /></label>
				<div class="controls">
					<g:textField name="lastname" value="${shiroUserInstance?.lastname}"/>
					<span class="help-inline">${hasErrors(bean: shiroUserInstance, field: 'lastname', 'error')}</span>
				</div>
			</div>
			
			<div class="control-group fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'username', 'error')} required">
				<label for="username" class="control-label"><g:message code="shiroUser.username.label" default="Username" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:textField name="username" required="" value="${shiroUserInstance?.username}"/>
					<span class="help-inline">${hasErrors(bean: shiroUserInstance, field: 'username', 'error')}</span>
				</div>
			</div>
			
			<div class="control-group fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'passwordHash', 'error')} ">
				<label for="passwordHash" class="control-label"><g:message code="shiroUser.passwordHash.label" default="Password" /></label>
				<div class="controls">
					<g:passwordField name="passwordHash" value="${shiroUserInstance?.passwordHash}"/>
					<span class="help-inline">${hasErrors(bean: shiroUserInstance, field: 'passwordHash', 'error')}</span>
				</div>
			</div>
			
			<div class="control-group fieldcontain>
				<label for="passwordHash2" class="control-label"><g:message code="shiroUser.passwordHash2.label" default="Password confirmation" /></label>
				<div class="controls">
					<g:passwordField name="passwordHash2" value="${shiroUserInstance?.passwordHash}"/>
				</div>
			</div>
			
