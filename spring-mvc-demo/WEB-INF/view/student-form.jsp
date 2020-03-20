<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
	
		Last name: <form:input path="lastName" />
		
		<br><br>
	
		Country :<form:select path="country">
		
			<form:options items="${student.countryOptions}"/>

		</form:select> 
		
		<br><br>
		
		Favorite Language :
		
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
	
		<!-- Java<form:radiobutton path="favoriteLanguage" value="Java"/>
		PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
		C<form:radiobutton path="favoriteLanguage" value="C"/>
		Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/> -->
		
		<br><br>
		
		Operating Systems :
		
		Linux <form:checkbox path="operatingSystem" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>
		Windows <form:checkbox path="operatingSystem" value="Windows"/>
		Android <form:checkbox path="operatingSystem" value="Android"/>
	
		<br><br>
		
		<input type="submit" value="Submit" />
	
	</form:form>


</body>

</html>

