<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<title>Customer Registration Form</title>
<style>
.error {
	color: red
}
</style>
</head>
<body>

	Fill out the form. Asterisk fields are mandatory
	<form:form action="processForm" modelAttribute="customer">

		First Name : <form:input path="firstname" />
		<br>
		<br>
		Last Name(*) : <form:input path="lastname" />
		<form:errors path="lastname" cssClass="error" />
		<br>
		<br>
	
		Postal Code : <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />
		<br>
		<br>
		
		Free Passes : <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />
		<br>
		<br>
		
		Course Code : <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error" />
		<input type="submit" value="submit" />
	</form:form>
</body>

</html>