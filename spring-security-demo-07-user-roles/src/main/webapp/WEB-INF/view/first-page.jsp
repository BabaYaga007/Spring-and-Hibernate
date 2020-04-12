<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri ="http://www.springframework.org/security/tags" %>


<html>

<head>
	<title>Front Page</title>
</head>

<body>
	<h2>Ministry of Awesomeness Home Page </h2>
	<hr>
	
	<!-- display username and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s) : <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	
	<p>Welcome to the luv2code company home page!</p>

	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout"/>
	
	</form:form>



</body>

</html>