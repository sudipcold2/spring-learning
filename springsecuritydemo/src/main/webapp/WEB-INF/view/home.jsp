<%@page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Spring MVC Home</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    </head>
    <body>
	 <div class="container">

	 	<div class="jumbotron">
		  <h1 class="display-4">Welcome to Spring Security Demo App</h1>
		  <hr class="my-4">
		</div>

		 <h2 class="display-4">Home</h2>

		 <div class="row my-2">
		 	User : <security:authentication property="principal.username"/>
		 </div>

         <div class="row my-2">
            Role(s) : <security:authentication property="principal.authorities"/>
         </div>

         <!-- view on based of roles -->
        <security:authorize access="hasRole('MANAGER')">
	          <div class="row my-3">
	         	<a href="${pageContext.request.contextPath}/leaders">
	            	Open Leaders News Page (Only for leaders)
	         	</a>
	         </div>
     	</security:authorize>
       
        <security:authorize access="hasRole('ADMIN')">
	       	 <div class="row my-3">
	       	 	<a href="${pageContext.request.contextPath}/admin">
	            	Open Administrator News Page (Only for Admins)
	          	</a>
	         </div>
       	</security:authorize>

		 <form:form action="${pageContext.request.contextPath}/logout" method="POST">
		    <input type="submit" value="Logout" class="btn btn-primary" name="Submit">
		 </form:form>

     </div>
    </body>
</html>