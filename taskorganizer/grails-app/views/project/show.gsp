
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

            <p><strong><g:message code="project.dateCreated.label" default="Date Created" />: </strong><g:formatDate date="${projectInstance?.dateCreated}" /></p>
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

    <g:if test="${projectProgress == 0}">
        <div class="alert alert-warning"> <g:message code="project.nottask.label" default="No task was assigned to the project" /> </div>
    </g:if>

    <div class="tasks">
        <g:each in="${projectInstance.task}" var="t">
            <div class="alert alert-success"><g:link controller="task" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></div>
        </g:each>
    </div>

</section>

</body>

</html>
