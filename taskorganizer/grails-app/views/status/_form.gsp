<%@ page import="taskorganizer.Status" %>

            <div class="form-group fieldcontain ${hasErrors(bean: statusInstance, field: 'name', 'error')} required">
                <label for="name" class="col-sm-2 control-label"><g:message code="status.name.label" default="Name" /><span class="required-indicator">*</span></label>
                <div class="col-sm-8">
                    <g:textField name="name" required="" value="${statusInstance?.name}" class="form-control"/>
                    <span class="help-inline">${hasErrors(bean: statusInstance, field: 'name', 'error')}</span>
                </div>
            </div>

            <div class="form-group fieldcontain ${hasErrors(bean: statusInstance, field: 'description', 'error')} ">
                <label for="description" class="col-sm-2 control-label"><g:message code="status.description.label" default="Description" /></label>
                <div class="col-sm-8">
                    <g:textField name="description" value="${statusInstance?.description}" class="form-control"/>
                    <span class="help-inline">${hasErrors(bean: statusInstance, field: 'description', 'error')}</span>
                </div>
            </div>
