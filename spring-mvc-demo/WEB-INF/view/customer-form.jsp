<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>

<html>
<head>

	<title>Customer Registration form</title>
	
	<style>
		.error {
			color:red;	
		}	
	</style>

</head>

<body>

	<form:form action="processForm" modelAttribute="customer">
	
		First Name : <form:input path="firstName" />
		
		<br><br>
		
		Last Name (*required) :<form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/><!-- This line is to display error messages -->
		
		<br><br>
		
		Free passes :<form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"/><!-- This line is to display error messages -->
		
		<br><br>
		
		Postal Code :<form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/><!-- This line is to display error messages -->
		
		<br><br>
		
		Course Code :<form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/><!-- This line is to display error messages -->
		
		<br><br>
		
		<input type="submit" value="Submit"/>
	</form:form>

</body>

</html>