
<%@ page import="taskorganizer.Project" %>
<!doctype html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="user_layout" />
    <g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-project" class="first">
    <div class="row">
        <div class="col-md-8">
            <h1>${fieldValue(bean: projectInstance, field: "name")}</h1>
                <p> 
                    ${fieldValue(bean: projectInstance, field: "description")}
                </p>
        </div>
        <div class="col-md-4">

            <g:if test="${projectInstance.hasImage()}">
                <img class="img-rounded center-block image-project" src="${createLink(controller:'project', action:'viewImage', id:projectInstance.id)}" />
            </g:if>
            <g:else>
                <g:img dir="images" file="no_image.jpg" class="img-rounded center-block image-project"/>
            </g:else>

            <p><strong> <g:message code="project.cycle.label" default="Cycle" />: </strong> ${projectInstance?.cycle}</p>

            <p><strong><g:message code="project.dateCreated.label" default="Date Created" />: </strong><g:formatDate format="dd-MM-yyyy" date="${projectInstance?.dateCreated}" /></p>
        </div>
    </div>

    <div class="row">
        <div class="col-md-8">
            <h3></h3>
            <div class="progress">
                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: ${projectProgress}%"> 
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <h3><strong> ${projectProgress}%</strong></h3>
        </div>              
    </div>

    <g:if test="${projectInstance?.tasks?.size() == 0}">
        <div class="alert alert-warning"> <g:message code="project.nottask.label" default="No task was assigned to the project" /> </div>
    </g:if>

    <div class="tasks">
        <g:each in="${projectInstance?.tasks}" var="t">
            <div class="row">
                <div class="col-md-8">
                    <div class="alert alert-success"><g:link controller="task" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></div>
                </div>
                <div class="col-md-4">

                    <g:link action="changeStatus" id="${t?.id}" params="[projectId: projectInstance?.id]"> DE PRUEBA </g:link>
                    <a role="button" class="btn btn-primary change-task"> ${t?.status} 
                        <span class="hidden"> <g:createLink controller="project" action="changeStatus" id="${t?.id}" params="[projectId: projectInstance?.id]"/> </span>
                    </a>
                    <a role="button" class="btn btn-danger delete-task"> <g:message code="default.button.delete.label" default="Delete"/>
                        <span class="hidden"> <g:createLink controller="project" action="deleteTask" id="${t?.id}"/> </span></a>
                </div>
            </div>

        </g:each>
    </div>

    <script>
        $("document").ready(function() {
            $(".change-task").on('click', function() {

                var urlTask = $(this).children().text();
                var button = $(this);
                console.log("url: " + urlTask);

                $.ajax({
                    type: 'POST',
                    url: urlTask,
                    beforeSend: function( xhr ) {
                        // $('#currentProject').append('<img class="spinner_style" src="${createLinkTo(dir:'images',file:'spinner_lines.gif')}" />');
                        console.log("empieza el envio");
                    },
                    success: function(data, textStatus) {
                       button.text(data);
                        console.log(data);
                    },
                    error: function(request, status, error) {
                        console.log("error al actualizar el estado de la tarea");
                    },
                });
                console.log("cambiar");
            });

            $(".delete-task").on('click', function() {

                console.log("delete");
            });
        });
    </script>

</section>

</body>

</html>
