<html>

<head>
    <title><g:message code="default.app.name"/> </title>
    <meta name="layout" content="presentation" />
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'spinner.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'header.css')}" type="text/css">

    <script type="text/javascript">

    $("document").ready(function() {

        $.ajax({
            type: 'GET',
            url: "${createLink(action:'ajaxProject', controller:'project')}",
            beforeSend: function( xhr ) {
                $('#currentProject').append('<img class="spinner_style" src="${createLinkTo(dir:'images',file:'spinner_lines.gif')}" />');

            },
            success: function(data, textStatus) {
                $('#currentProject').html(data);
            },
            error: function(request, status, error) {
                console.log("error al obtener los proyectos");
            },
        });
    });
</script>
</head>

<body>
    <section id="currentProject">
        <!-- acá van los proyectos en curso-->
    </section>

    <section id="menuOption">
        <g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
        <g:link class="btn btn-primary btn-lg buttonVeryBig" role="button" controller="project" action="list"> <g:message code="project.list.all" /> </g:link>
        <g:link class="btn btn-primary btn-lg buttonVeryBig" role="button" controller="project" action="progress"> <g:message code="project.show.progress" /> </g:link>

    </section>

</body>
</html>
