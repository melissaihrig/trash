<%@ page import="taskorganizer.Project" %>
<%@ page import="taskorganizer.Cycle" %>
<%@ page import="taskorganizer.Task" %>

        <div class="row">
            <div class="col-md-8">
                <div class="form-group fieldcontain ${hasErrors(bean: projectInstance, field: 'name', 'error')} required">
                    <g:textField name="name" required="" value="${projectInstance?.name}" class="form-control" placeholder="${message(code: 'project.name.label', default: 'Name')}*"/>
                    <span class="help-inline">${hasErrors(bean: projectInstance, field: 'name', 'error')}</span>
                </div>

                <div class="from-group fieldcontain ${hasErrors(bean: projectInstance, field: 'description', 'error')} ">
                    <textarea name="description" value="${projectInstance?.description}" placeholder="${message(code: 'project.description.label', default: 'Description')}" class="form-control" rows="10"></textarea>
                    <span class="help-inline">${hasErrors(bean: projectInstance, field: 'description', 'error')}</span>
                </div>
            </div>
            <div class="col-md-4">
                <div class="control-group fieldcontain ${hasErrors(bean: projectInstance, field: 'image', 'error')}">
                    <img src="${resource(dir: 'images', file: 'upload-icon.png')}" class="selector-image center-block"/>
                    <label id="selector-result" class="center-block"></label>
                    <div class="controls">
                        <input type="file" id="image" name="image" class="select-image" />
                        <span class="help-inline">${hasErrors(bean: projectInstance, field: 'image', 'error')}</span>
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
                        <span class="help-inline">${hasErrors(bean: projectInstance, field: 'cycle', 'error')}</span>
                    </div>
                    <div class="col-sm-2">
                        ?
                    </div>
            </div>

            </div>
        </div>


            <div class="form-group fieldcontain ${hasErrors(bean: projectInstance, field: 'task', 'error')} ">
                <label for="task" class="label-project col-sm-2 "><g:message code="project.task.label" default="Task" /></label>
            </div>

            <div class="panel panel-default">              
                <div class="tasks panel-body">
                    <a role="button" class="btn btn-default" id="add-task"> ${message(code: 'default.add.label', args: [message(code: 'task.label', default: 'Task')])} </a>
                    
                    <ul class="one-to-many">
                        <g:each in="${projectInstance?.task?}" var="t">
                            <li><g:link controller="task" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
                        </g:each>
                        <li class="add">
                        <g:link controller="task" action="create" params="['project.id': projectInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'task.label', default: 'Task')])}</g:link>
                        </li>
                    </ul>

                    <span class="help-inline">${hasErrors(bean: projectInstance, field: 'task', 'error')}</span>
                </div>
            </div>


<div class="task-form hidden">

    <div class="panel panel-default">              
        <div class="panel-body">

            <div class="form-group fieldcontain ${hasErrors(bean: taskInstance, field: 'description', 'error')} required">
                <g:textField name="task[0].description" required="" value="" class="form-control" placeholder="${message(code: 'task.description.label', default: 'Description')}*"/>
                <span class="help-inline">${hasErrors(bean: taskInstance, field: 'description', 'error')}</span>
            </div>

            <div class="form-group fieldcontain ${hasErrors(bean: taskInstance, field: 'detail', 'error')} ">
                <textarea name="task[0].detail" value="" class="form-control" placeholder="${message(code: 'task.detail.label', default: 'Detail')}" rows="3"></textarea>
                <span class="help-inline">${hasErrors(bean: taskInstance, field: 'detail', 'error')}</span>
            </div>

            <div class="form-group fieldcontain ${hasErrors(bean: taskInstance, field: 'weight', 'error')} required">
                <label for="weight" class="col-sm-2"><g:message code="task.weight.label" default="Weight" /><span class="required-indicator">*</span></label>
                <div class="col-sm-10">
                    <g:field type="number" name="task[0].weight" min="0" required="" value="" class="form-control"/>
                    <span class="help-inline">${hasErrors(bean: taskInstance, field: 'weight', 'error')}</span>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {

        var counter = 0;
        $('.selector-image').on('click', function() {
            $( "input:file" ).click();
        });

        $('input[type=file]').on('change', function () {
            var path = $(this).val();
            $("#selector-result").text(path.split('\\').pop());
        });

        $("#add-task").on('click', function() {
            var body = $(".task-form").clone().removeClass("hidden task-form");
            body.prependTo(".tasks");
            counter++;
            console.log(counter);
        });
    });
</script>