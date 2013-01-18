
<%@ page import="stakeholder.Customer" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
	<title><g:message code="Search Advance" args="[entityName]" /></title>
</head>

<body>
	
<section id="searchAdvance-customer" class="first">

<form class="form-horizontal">
  <fieldset>
	<legend>Search Advance</legend>
			<div class="control-group fieldcontain ${hasErrors(bean: customerInstance, field: 'companyName', 'error')} ">
				<label for="companyName" class="control-label"><g:message code="customer.companyName.label" default="Company Name" /></label>
				<div class="controls">
					<g:select name="companyName" class="input-xxlarge" noSelection="${['null':'-- All --']}" from='${Customer.list()}' class="range" required="" value="${fieldValue(bean: customerInstance, field: 'companyName')}"/>
					<span class="help-inline">${hasErrors(bean: customerInstance, field: 'companyName', 'error')}</span>
				</div>
			</div>
			
			<div class="control-group fieldcontain ${hasErrors(bean: customerInstance, field: 'ratingPoints', 'error')} required">
				<label for="ratingPoints" class="control-label"><g:message code="customer.ratingPoints.label" default="Rating Points" /></label>
				<div class="controls">
					<g:select name="ratingPoints" noSelection="${['null':'-- All --']}" from="${0..10}" class="range" required="" value="${fieldValue(bean: customerInstance, field: 'ratingPoints')}"/>
					<span class="help-inline">${hasErrors(bean: customerInstance, field: 'ratingPoints', 'error')}</span>
				</div>
			</div>
	<!---
		<button type="submit" class="btn" action="hola">Submit</button>
-->
		<span class="button"><g:actionSubmit action="hola" value="Search"/></span>
  </fieldset>
</form>
</section>

</body>

</html>
