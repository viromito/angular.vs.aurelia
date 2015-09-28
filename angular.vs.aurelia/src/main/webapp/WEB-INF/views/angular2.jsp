<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!doctype html>
<html>
  <head>
    <title>Angular 2 Quickstart</title>
    <script src="https://github.jspm.io/jmcriffey/bower-traceur-runtime@0.0.87/traceur-runtime.js"></script>
	<script src="https://jspm.io/system@0.16.js"></script>
	<script src="https://code.angularjs.org/2.0.0-alpha.28/angular2.dev.js"></script>
</head>
  <body>
    <!-- The app component created in app.ts -->
    <h1>
		Hello, my dear Aurelia!=*
	</h1>
	<h2>
		..and new ECMA Script syntax!=/
	</h2>
	
	<P>  The time on the server is ${serverTime}. </P>
    <my-app></my-app>
	<script>System.import('${scriptsPath}app');</script>
  </body>
</html>