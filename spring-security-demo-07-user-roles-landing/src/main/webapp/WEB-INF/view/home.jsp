<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri ="http://www.springframework.org/security/tags" %>


<html>

<head>
	<title>MOA Home Page</title>
</head>

<body>
	<h2>Ministry Of Awesomeness Home Page - Bitch ass</h2>
	<hr>
	
	<!-- display username and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s) : <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	
	<p>Welcome to the Ministry Of Awesomeness home page!</p>

	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout"/>
	
	</form:form>



</body>

</html>