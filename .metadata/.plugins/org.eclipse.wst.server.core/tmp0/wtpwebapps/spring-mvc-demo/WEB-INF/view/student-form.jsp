<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>Student Registration Form</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		First name <form:input path="firstName" />
		<br> <br>
		Last name <form:input path="lastName" />
		<br> <br>
		Country <form:select path="country">
					<form:options items="${student.countryOptions}"/>
				</form:select>
		<br> <br>
		Favourite Language:
		<%-- Java <form:radiobutton path="favouriteLanguage" value="Java"/>
		C# <form:radiobutton path="favouriteLanguage" value="C#"/>
		Ruby <form:radiobutton path="favouriteLanguage" value="Ruby"/> --%>
		<form:radiobuttons path="favouriteLanguage" items="${student.languageOptions}"/>		
		<br> <br>
		
		<form:checkboxes path="operatingSystems" items="${student.osOptions}"/>
		
		<br> <br>
		<input type="submit" value="submit"/>
		
	</form:form>
</body>
</html>