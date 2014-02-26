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

    <div class="row">

        <div class="col-md-2">
            <img src="${resource(dir: 'images', file: 'logo.png')}" alt="TaskOrganizer" style="width:100%">

            <ul class="nav nav-pills nav-stacked">
                <li><a href="#">Listas</a></li>
                <li class="active"><a href="#">Proyectos</a></li>
                <li> <g:link controller="project" action="list"> <g:message code="project.list.all" /> </g:link> </li>
            </ul>
        </div>

        <div class="col-md-10">

            <ul class="nav nav-pills center">
                <li class="active"><a href="#">Vista ícono</a></li>
                <li><g:link controller="project" action="progress"> <g:message code="project.show.progress" /> </g:link></li>
                <li><a href="#">Vista detalle</a></li>
            </ul>

            <section id="currentProject">
                <!-- acá van los proyectos en curso-->
            </section>

            <section id="menuOption">
                <g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />

                

            </section>
        </div>
    </div>
</body>
</html>
