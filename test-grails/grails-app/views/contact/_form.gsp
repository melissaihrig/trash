<%@ page import="stakeholder.Contact" %>



			<div class="control-group fieldcontain ${hasErrors(bean: contactInstance, field: 'nickname', 'error')} ">
				<label for="nickname" class="control-label"><g:message code="contact.nickname.label" default="Nickname" /></label>
				<div class="controls">
					<g:textField name="nickname" value="${contactInstance?.nickname}"/>
					<span class="help-inline">${hasErrors(bean: contactInstance, field: 'nickname', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: contactInstance, field: 'customer', 'error')} required">
				<label for="customer" class="control-label"><g:message code="contact.customer.label" default="Customer" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="customer" name="customer.id" from="${stakeholder.Customer.list()}" optionKey="id" required="" value="${contactInstance?.customer?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: contactInstance, field: 'customer', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: contactInstance, field: 'email', 'error')} ">
				<label for="email" class="control-label"><g:message code="contact.email.label" default="Email" /></label>
				<div class="controls">
					<g:textField name="email" value="${contactInstance?.email}"/>
					<span class="help-inline">${hasErrors(bean: contactInstance, field: 'email', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: contactInstance, field: 'firstName', 'error')} ">
				<label for="firstName" class="control-label"><g:message code="contact.firstName.label" default="First Name" /></label>
				<div class="controls">
					<g:textField name="firstName" value="${contactInstance?.firstName}"/>
					<span class="help-inline">${hasErrors(bean: contactInstance, field: 'firstName', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: contactInstance, field: 'lastName', 'error')} ">
				<label for="lastName" class="control-label"><g:message code="contact.lastName.label" default="Last Name" /></label>
				<div class="controls">
					<g:textField name="lastName" value="${contactInstance?.lastName}"/>
					<span class="help-inline">${hasErrors(bean: contactInstance, field: 'lastName', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: contactInstance, field: 'phoneNumber', 'error')} ">
				<label for="phoneNumber" class="control-label"><g:message code="contact.phoneNumber.label" default="Phone Number" /></label>
				<div class="controls">
					<g:textField name="phoneNumber" value="${contactInstance?.phoneNumber}"/>
					<span class="help-inline">${hasErrors(bean: contactInstance, field: 'phoneNumber', 'error')}</span>
				</div>
			</div>

