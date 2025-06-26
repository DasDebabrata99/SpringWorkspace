<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet" 
	href="http://localhost:8080/${pageContext.request.contextPath}/resources/css/style.css"/>

<link type="text/css" rel="stylesheet" 
	href="http://localhost:8080/${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>


<meta charset="UTF-8">
<title>Save Customer</title>
</head>
<body>

	<div id ="wrapper">
		<div id="header">
			<h2> CRM - Customer Relationship Manager
			
			</h2>
		</div>
	
	</div>
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="post">
		
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><form:input path="firstName" /></td>	
					
					</tr>
					
					<tr>
						<td><label>Last Name</label></td>
						<td><form:input path="lastName" /></td>	
					
					</tr>
					
					<tr>
						<td><label>Email address</label></td>
						<td><form:input path="email" /></td>	
					
					</tr>
					
					<tr>
						
						<td><input type="submit" value="Save" class="save" /></td>	
					
					</tr>
				</tbody>			
			</table>			
		</form:form>
		
		<div style="clear;both;">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">back to customer list</a>
			</p>
		</div>
	</div>


</body>
</html>