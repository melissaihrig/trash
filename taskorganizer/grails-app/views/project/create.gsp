<%@ page import="taskorganizer.Project" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="user_layout" />
	<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
	<title><g:message code="default.create.label" args="[entityName]" /></title>
</head>

<body>

<section id="create-project" class="first">

	<g:hasErrors bean="${projectInstance}">
	<div class="alert alert-danger">
		<g:renderErrors bean="${projectInstance}" as="list" />
	</div>
	</g:hasErrors>
	
	<g:form action="save" class="form-horizontal"  enctype="multipart/form-data" role="form">
		<fieldset class="form">
			<g:render template="form"/>
		</fieldset>
		
		<div class="row form-actions">
			<div class="col-md-2 col-md-offset-5">
	  			<g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
	            <button class="btn" type="reset"><g:message code="default.button.reset.label" default="Reset" /></button>
			</div>
		</div>

		
	</g:form>

<div class=" task-form hidden panel panel-default">              
    <div class="panel-body">
        <div class="row">
            <div class="col-md-8">
                <div class="form-group fieldcontain ${hasErrors(bean: taskInstance, field: 'description', 'error')} required">
                     <input type="text" name="task[numberTask].description" required="" value="" class="form-control" placeholder="${message(code: 'task.description.label', default: 'Description')}*" id="task-description-numberTask">

                    <span class="help-block">${hasErrors(bean: taskInstance, field: 'description', 'error')}</span>
                </div>

                <div class="form-group fieldcontain ${hasErrors(bean: taskInstance, field: 'detail', 'error')} ">
                    <textarea name="task[numberTask].detail" value="" class="form-control" placeholder="${message(code: 'task.detail.label', default: 'Detail')}" rows="3" id="task-detail-numberTask" ></textarea>
                    <span class="help-block">${hasErrors(bean: taskInstance, field: 'detail', 'error')}</span>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group fieldcontain ${hasErrors(bean: taskInstance, field: 'weight', 'error')} required">
                    <label for="weight" class="col-sm-3"><g:message code="task.weight.label" default="Weight" /><span class="required-indicator">*</span></label>
                    <div class="col-sm-9">
                        <input type="number" name="task[numberTask].weight" min="0" required="" value="1" class="form-control" id="task-weight-numberTask">
                        <span class="help-block">${hasErrors(bean: taskInstance, field: 'weight', 'error')}</span>
                    </div>
                </div>
                <a role="button" class="col-md-4 col-md-offset-4 btn btn-danger delete-task" id="delete-task-numberTask"><g:message code="default.button.delete.label" default="Delete"/></a>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {

        var currentTask = ${projectInstance?.task?.length} + 0;

        $('.selector-image').on('click', function() {
            $( "input:file" ).click();
        });

        $('input[type=file]').on('change', function () {
            var path = $(this).val();
            $("#selector-result").text(path.split('\\').pop());
        });

        $('#add-task').on('click', function() {
            var body = $(".task-form").clone().removeClass("hidden task-form");
            changeNamesTask(body);
            changeIdsTask(body);
            body.insertBefore("#add-task");
            currentTask++;
        });

        $('.form').on('click', '.delete-task' ,function() {
            $(this).closest(".panel-default").remove();
            currentTask--;
        });

        function changeNamesTask(body) {
            body.find("#task-description-numberTask").attr('name', 'task['+ currentTask +'].description');
            body.find("#task-detail-numberTask").attr('name', 'task['+ currentTask +'].detail');
            body.find("#task-weight-numberTask").attr('name', 'task['+ currentTask +'].weight');
        };

        function changeIdsTask(body) {
            body.find("#task-description-numberTask").attr('id', 'task-description-'+ currentTask);
            body.find("#task-detail-numberTask").attr('id', 'task-detail-'+ currentTask);
            body.find("#task-weight-numberTask").attr('id', 'task-weight-'+ currentTask); 
            body.find("#delete-task-numberTask").attr('id', 'delete-task-'+ currentTask);
        };

    });
</script>

</section>
		
</body>

</html>
