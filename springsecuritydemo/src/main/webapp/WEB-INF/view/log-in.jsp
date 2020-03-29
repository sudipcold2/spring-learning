<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Spring Security Login</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
        <style>
            .error{
                color : red;
            }

            .success{
                color :green;
            }
        </style>
    </head>
    <body>
	 <div class="container">

	 	<div class="jumbotron">
		  <h1 class="display-4">Welcome to Spring Security Demo App</h1>
		  <hr class="my-4">
		</div>

		<h3>Log in</h3>

        <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

          <!-- If you use form tags not from spring <form></form> then send csrf tokens manually
            <form ..>
              <input type="hidden"
                     name=${_csrf.parameterName}"
                     value=${_csrf.token}" />

            </form>
  
           -->


          <c:if test ="${param.error != null}">
            <i class="error">Sorry! You entered wrong username/password </i>
          </c:if>

          <c:if test ="${param.logout != null}">
             <i class="success">You have been logged out successfully ! </i>
          </c:if>

          <div class="form-group">
            <label>UserName</label>
            <input placeholder="UserName" type="text" name="username" class="form-control"/>
          </div>

          <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" class="form-control"
                placeholder="Password"/>
          </div>

          <input type="submit" value="Login" class="btn btn-primary" name="Submit">

        </form:form>
     </div>
    </body>
</html>