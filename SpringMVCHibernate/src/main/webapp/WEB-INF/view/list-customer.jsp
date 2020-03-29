<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

	
		<input type="button" class="btn btn-outline-secondary" value="Add Customer"
			onclick="window.location.href='showFormForAdd'"; return false;>
		

		<div>
			<table class="my-5 table table-hover">
	            <thead>
	                <tr>
	                    <th style="text-align: center;">First Name</th>
	                    <th style="text-align: center;">Last Name</th>
	                    <th style="text-align: center;">Email</th>
	                    <th style="text-align: center;">Action</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="tempCustomer" items="${customers}">
	                	<c:url var="updateLink" value="/customer/showFormForUpdate">
	                		<c:param name="customerId" value="${tempCustomer.id}"/>
	                	</c:url>

	                	<c:url var="deleteLink" value="/customer/processDelete">
	                		<c:param name="customerId" value="${tempCustomer.id}"/>
	                	</c:url>
		                <tr>
		                    <td style="text-align: center;">${tempCustomer.firstName}</td>
		                    <td style="text-align: center;">${tempCustomer.lastName}</td>
		                    <td style="text-align: center;">${tempCustomer.email}</td>
		                    <td style="text-align: center;">
		                    	<a class="btn btn-outline-primary" href="${updateLink}" role="button">	Update
		                    	</a> | 
		                    	<a class="btn btn-outline-warning" href="${deleteLink}" role="button"
									onclick="
									if (!confirm('Are you sure you want to delete this customer ?'))return false;
									">Delete
		                    	</a> 
		                    </td>
		                </tr>
	            	</c:forEach>
	            </tbody>
	        </table>
		</div>

	 </div>
    </body>
</html>