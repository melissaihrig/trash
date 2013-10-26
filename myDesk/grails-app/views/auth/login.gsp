<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="layout_login" />
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'login.css')}" type="text/css">
  <title><g:message code="login.title" default="Sign in"/></title>
</head>

<body>
  
  <g:form action="signIn">
    <input type="hidden" name="targetUri" value="${targetUri}" />
    	
	<h1><g:message code="app.Name" default="MyDesk"/></h1>
	
	<g:if test="${flash.message}">
		<div class="message">${flash.message}</div>
	</g:if>
 		
    <table>
      <tbody>
        <tr>
          <td class="labelLogin"><g:message code="login.user" default="User"/></td>
          <td><input type="text" name="username" value="${username}" /></td>
        </tr>
        <tr>
          <td class="labelLogin"><g:message code="login.password" default="Password"/></td>
          <td><input type="password" name="password" value="" /></td>
        </tr>
      </tbody>
    </table>
    
    <div class="containerBig">
    	<span class="minLabel"><g:message code="login.rememberMe" default="Remember me?"/></span>
        <g:checkBox name="rememberMe" value="${rememberMe}" />
       </div>

    <div class="containerBig">
    	<g:link controller="shiroUser" action="create"><span class="minLabel"><g:message code="login.signup" default="Sign up"/></span></g:link>
       </div>
       
   	<input type="submit" value="${message(code: 'login.signIn', default: 'Sign in')}"/>
   	
  </g:form>
</body>
</html>
