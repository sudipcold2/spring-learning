<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Spring MVC Home</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    </head>
    <body>
	 <div class="container">
	 	
	 	<div class="jumbotron">
		  <h1 class="display-4">Welcome to CRM - Customer Relationship Management</h1>
		  <hr class="my-4">
		</div>

		<h3>Save Customer</h3>

		<form:form action="saveCustomer" modelAttribute="customer" method="POST">

		need to associate this data with customer id
		<form:hidden path="id" />

		  <div class="form-group">
		    <label>Email address</label>
		    <form:input placeholder="Enter email" type="email" class="form-control" path="email"/>
		  </div>

		  <div class="form-group">
		    <label>First Name</label>
		    <form:input type="text" class="form-control" placeholder="First Name" path="firstName"/>
		  </div>

		  <div class="form-group">
		    <label>Last Name</label>
		    <form:input type="text" class="form-control" placeholder="Last Name" path="lastName"/>
		  </div>

		  <input type="submit" value="submit" class="btn btn-primary" name="Submit">
		
		</form:form>


		<div style="clear; both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>

	 </div>
    </body>
</html>