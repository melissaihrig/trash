<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1>Application Status</h1>
			<ul>
				<li>App version: <g:meta name="app.version"/></li>
				<li>Grails version: <g:meta name="app.grails.version"/></li>
				<li>Groovy version: ${GroovySystem.getVersion()}</li>
				<li>JVM version: ${System.getProperty('java.version')}</li>
				<li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
				<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
				<li>Domains: ${grailsApplication.domainClasses.size()}</li>
				<li>Services: ${grailsApplication.serviceClasses.size()}</li>
				<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
			</ul>
			<h1>Installed Plugins</h1>
			<ul>
				<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
					<li>${plugin.name} - ${plugin.version}</li>
				</g:each>
			</ul>
		</div>
		<div id="page-body" role="main">
			<h1>Welcome to Grails</h1>
			<p>Congratulations, you have successfully started your first Grails application! At the moment
			   this is the default page, feel free to modify it to either redirect to a controller or display whatever
			   content you may choose. Below is a list of controllers that are currently deployed in this application,
			   click on each to execute its default action:</p>

			<div id="controller-list" role="navigation">
				<h2>Available Controllers:</h2>
				<ul>
					<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
					</g:each>
				</ul>
			</div>
		</div>
	</body>




		<g:link class="btn btn-large btn-primary" controller="nextSteps">Next Steps</g:link>
	<section id="info">
		<div class="row">
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="frontpageImage" src="${resource(plugin: 'kickstart-with-bootstrap', dir: 'images/frontpage',file: 'bs-docs-twitter-github.png')}" />
					<h3>Bootstrap 3.0.2</h3>
				</div>
				<p>Kickstart uses <a href ="http://twitter.github.com/bootstrap/">Bootstrap</a> to render the web pages. 
				Bootstrap is made by Mark Otto (<a href="http://twitter.com/mdo">@mdo</a>) and Billy Gates (<a href="http://twitter.com/fat">@fat</a>).
				Bootstrap is designed to help people of all skill levels as a complete kit or to start something more complex.
				</p>
			</div>
	    	<div class="col-md-4">
		    	<div class="center">
					<i class="icon-flag icon-7x" style="font-size: 7em;"></i>
					<h3>Font Awesome 3.2.1</h3>
				</div>
				<p>Kickstart uses <a href ="http://fortawesome.github.com/Font-Awesome">Font Awesome</a> to render scalable icons using a vector font. 
				Font Awesome is a pictographic language of web-related actions by Dave Gandy.
				Font Awesome icons are vectors, which mean they're gorgeous on high-resolution displays.  
				</p>
			</div>
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="frontpageImage" src="${resource(plugin: 'kickstart-with-bootstrap', dir: 'images/frontpage',file: 'html5css3js8.png')}"/>
					<h3>Tech Foundation</h3>
				</div>
				<p>Bootstrap is based on elements of HTML 5, CSS 3, Javascript 1.8, and jQuery 1.7 with progressively enhanced 
				components to enable a responsive design of the website.
				Kickstart is built using Groovy 2.0 and Java 7 integrated into the Grails 2.1 framework. 
				</p>
<!-- 	                <li>Less 1.3</li> -->
			</div>
	    </div>
	</section>

	<section id="info2">
		<div class="row">
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="" src="${resource(plugin: 'kickstart-with-bootstrap', dir: 'images/frontpage',file: 'Datepicker.png')}" />
					<h3>Datepicker</h3>
				</div>
				<p>Kickstart uses the <a href ="https://github.com/eternicode/bootstrap-datepicker">Datepicker for Bootstrap</a> by Stefan Petre and Andrew Rowls</p>
			</div>
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="" src="${resource(plugin: 'kickstart-with-bootstrap', dir: 'images/frontpage',file: 'flags_preview_large.png')}" />
					<h3>Language Selector</h3>
				</div>
				<p>Kickstart contains a language selector that uses the <a href="http://www.famfamfam.com/lab/icons/flags/">FamFamFam flag icons</a> by Mark James.
				It automatically detects which languages are available and offers them in a dropdown menu.</p>
			</div>
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="frontpageImage" src="${resource(plugin: 'kickstart-with-bootstrap', dir: 'images/frontpage',file: 'browser_logos.png')}" />
					<h3>Browser support</h3>
				</div>
				<p>Bootstrap is tested and supported in major modern browsers like Chrome 14, Safari 5+, Opera 11, Internet Explorer 7, and Firefox 5.</p>
			</div>
	    </div>
	</section>

	<section id="info3">
		<div class="row">
	    	<div class="col-md-4">
		    	<div class="center">
					<h3>Other Features</h3>
				</div>
				<p>Kickstart contains several pages as starting points for the average website such as an About Page, Contact Page, 404, etc.</p>
			</div>
	    	<div class="col-md-4">
		    	<div class="center">
					<h3>Usage</h3>
				</div>
				<p>After installation you can call the script "grails
					kickstartWithBootstrap" which will copy some files into your
					project. It will overwrite only few files (e.g., in conf, src, and
					views) - <b>you should use it only on fresh new Grails projects</b>.
				</p>
			</div>
	    	<div class="col-md-4">
		    	<div class="center">
					<h3>Notes</h3>
				</div>
				<p></p>
				<ul>
					<li>Currently, Kickstart works with Grails 2.x!</li>
					<li>Kickstart does NOT use the Bootstrap plugin.</li>
					<li>I18N is only available for English and German!</li>
				</ul>
			</div>
<%--	    	<div class="col-md-4">--%>
<%--		    	<div class="center">--%>
<%--					<h3>Terms of Use</h3>--%>
<%--				</div>--%>
<%--				<p></p>--%>
<%--				<ul>--%>
<%--					<li>Bootstrap (from Twitter): Code licensed under the Apache--%>
<%--						License v2.0. Documentation licensed under CC BY 3.0.--%>
<%--						(<a href="http://twitter.com/TwBootstrap">@TwBootstrap</a> , <a href="http://twitter.github.com/bootstrap/">http://twitter.github.com/bootstrap/</a>)</li>--%>
<%--					<li>Kickstart Plugins: Code licensed under the Apache License--%>
<%--						v2.0. Documentation licensed under CC BY 3.0. Copyright 2011 Jörg--%>
<%--						Rech (<a href="http://twitter.com/JoergRech">@JoergRech</a>, <a href="http://joerg-rech.com">http://joerg-rech.com</a>)</li>--%>
<%--				</ul>--%>
<%--			</div>--%>
	    </div>

	</section>
</html>
