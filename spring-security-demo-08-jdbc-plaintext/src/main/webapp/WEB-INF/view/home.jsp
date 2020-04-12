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
	
	<hr>
	
	<security:authorize access="hasRole('MANAGER')">
		<!-- A link for Leaders  page , only for leaders -->
		<p><a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>(Only for leaders)</p>
		
		<hr>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<!-- A link for Systems  page , only for admin -->
		<p><a href="${pageContext.request.contextPath}/systems">IT Meeting</a>(Only for Admins)</p>
		
		<hr>
	</security:authorize>

	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout"/>
	
	</form:form>



</body>

</html>