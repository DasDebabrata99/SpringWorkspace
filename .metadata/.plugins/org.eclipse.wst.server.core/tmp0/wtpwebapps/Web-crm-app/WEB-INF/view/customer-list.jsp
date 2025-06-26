<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- referencing the css file -->
<link type="text/css" rel="stylesheet"
	href="http://localhost:8080/${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM: Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">


		<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd';
		return false;"
			class="add-button" />


		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email address</th>
				<th>Action</th>
			</tr>

			<c:forEach var="theCustomer" items="${customerList}">
				<!-- construct an update link with customer id -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${theCustomer.id}"></c:param>
				</c:url>
				
				<!-- construct a delete link with customer id -->
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${theCustomer.id}"></c:param>
				</c:url>


				<tr>
					<td>${theCustomer.firstName}</td>
					<td>${theCustomer.lastName}</td>
					<td>${theCustomer.email}</td>
					<td><a href="${updateLink}">update</a>
					|
					<a href="${deleteLink}"
					onclick="if(!(confirm('sure you want to do this?'))) return false">delete</a></td>
				</tr>

			</c:forEach>
		</table>

	</div>

</body>
</html>