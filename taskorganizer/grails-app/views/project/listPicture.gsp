<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />

<div class="list-project">
    
    <g:link class="project" controller="project" action="create">
        <g:img dir="images" file="apple-touch-icon-retina.png"/>
        <span class="name"><g:message code="default.create.label" args="[entityName]" /> </span>
    </g:link>

    <g:each var="project" in="${projectsIntances}">
         <g:link class="project" controller="project" action="show" id="${project.id}">
            <g:img dir="images" file="apple-touch-icon-retina.png"/>
            <span class="name">${project.name} </span>
        </g:link>       
    </g:each>

    <div class="project">
        <g:img dir="images" file="apple-touch-icon-retina.png"/>
        <span class="name">Nombre Proyecto </span>
    </div>
    <div class="project">
        <g:img dir="images" file="apple-touch-icon-retina.png"/>
        <span class="name">Nombre Proyecto </span>
    </div>
    <div class="project">
        <g:img dir="images" file="apple-touch-icon-retina.png"/>
        <span class="name">Nombre Proyecto </span>
    </div>    
</div>