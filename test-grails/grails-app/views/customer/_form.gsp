<%@ page import="stakeholder.Customer" %>



			<div class="control-group fieldcontain ${hasErrors(bean: customerInstance, field: 'companyName', 'error')} required">
				<label for="companyName" class="control-label"><g:message code="customer.companyName.label" default="Company Name" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:textField name="companyName" required="" value="${customerInstance?.companyName}"/>
					<span class="help-inline">${hasErrors(bean: customerInstance, field: 'companyName', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: customerInstance, field: 'ratingPoints', 'error')} required">
				<label for="ratingPoints" class="control-label"><g:message code="customer.ratingPoints.label" default="Rating Points" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select name="ratingPoints" from="${0..10}" class="range" required="" value="${fieldValue(bean: customerInstance, field: 'ratingPoints')}"/>
					<span class="help-inline">${hasErrors(bean: customerInstance, field: 'ratingPoints', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: customerInstance, field: 'contact', 'error')} ">
				<label for="contact" class="control-label"><g:message code="customer.contact.label" default="Contact" /></label>
				<div class="controls">
					
<ul class="one-to-many">
<g:each in="${customerInstance?.contact?}" var="c">
    <li><g:link controller="contact" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="contact" action="create" params="['customer.id': customerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'contact.label', default: 'Contact')])}</g:link>
</li>
</ul>

					<span class="help-inline">${hasErrors(bean: customerInstance, field: 'contact', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: customerInstance, field: 'picture', 'error')} ">
				<label for="picture" class="control-label"><g:message code="customer.picture.label" default="Picture" /></label>
				<div class="controls">
					
<ul class="one-to-many">
<g:each in="${customerInstance?.picture?}" var="p">
    <li><g:link controller="picture" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="picture" action="create" params="['customer.id': customerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'picture.label', default: 'Picture')])}</g:link>
</li>
</ul>

					<span class="help-inline">${hasErrors(bean: customerInstance, field: 'picture', 'error')}</span>
				</div>
			</div>

