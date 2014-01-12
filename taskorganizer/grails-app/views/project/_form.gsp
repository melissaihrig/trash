<%@ page import="taskorganizer.Project" %>
<%@ page import="taskorganizer.Cycle" %>
<%@ page import="taskorganizer.Task" %>

        <div class="row">
            <div class="col-md-8">
                <div class="form-group fieldcontain ${hasErrors(bean: projectInstance, field: 'name', 'error')} required">
                    <g:textField name="name" required="" value="${projectInstance?.name}" class="form-control" placeholder="${message(code: 'project.name.label', default: 'Name')}*"/>
                    <span class="help-block">${hasErrors(bean: projectInstance, field: 'name', 'error')}</span>
                </div>

                <div class="from-group fieldcontain ${hasErrors(bean: projectInstance, field: 'description', 'error')} ">
                    <textarea name="description" value="${projectInstance?.description}" placeholder="${message(code: 'project.description.label', default: 'Description')}" class="form-control" rows="8"></textarea>
                    <span class="help-block">${hasErrors(bean: projectInstance, field: 'description', 'error')}</span>
                </div>
            </div>
            <div class="col-md-4">
                <div class="control-group fieldcontain ${hasErrors(bean: projectInstance, field: 'image', 'error')}">
                    <img src="${resource(dir: 'images', file: 'upload-icon.png')}" class="selector-image center-block"/>
                    <label id="selector-result" class="center-block"></label>
                    <div class="controls">
                        <input type="file" id="image" name="image" class="select-image" />
                        <span class="help-block">${hasErrors(bean: projectInstance, field: 'image', 'error')}</span>
                    </div>
                </div>

                <div class="form-group fieldcontain ${hasErrors(bean: projectInstance, field: 'cycle', 'error')} required">
                    <label for="cycle" class="col-sm-2 label-project"><g:message code="project.cycle.label" default="Cycle" /><span class="required-indicator">*</span></label>
                    <div class="col-sm-8">
                        <select id="cycle" name="cycle.id" class="form-control" required="" value="${projectInstance?.cycle?.id}">
                            <g:each in="${Cycle.list()}" var="cycle">
                               <option value="${cycle.id}"> ${cycle} </option>
                            </g:each>
                        </select>
                        <span class="help-block">${hasErrors(bean: projectInstance, field: 'cycle', 'error')}</span>
                    </div>
                    <div class="col-sm-2">
                        <span class="glyphicon glyphicon-question-sign"></span>
                    </div>
            </div>

            </div>
        </div>


            <div class="form-group fieldcontain ${hasErrors(bean: projectInstance, field: 'task', 'error')} ">
                <label for="task" class="label-project col-sm-2 "><g:message code="project.task.plural.label" default="Tasks" /></label>
            </div>

            <div class="panel panel-default">              
                <div class="tasks panel-body">
                    <a role="button" class="btn btn-primary center-block" id="add-task"> ${message(code: 'default.add.label', args: [message(code: 'task.label', default: 'Task')])} </a>
                    <span class="help-block">${hasErrors(bean: projectInstance, field: 'task', 'error')}</span>
                </div>
            </div>