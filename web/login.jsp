<%-- 
    Document   : login
    Created on : Apr 12, 2015, 6:24:52 PM
    Author     : hlg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/foundation.css"/>
    </head>
    <body>
        <div class="row">
            <h1 class="large-6 large-offset-3 end columns">Log In</h1>
        </div>
        <div class="row">
            
            
        <%
          if(session.getAttribute("statusLoginAttempt") != null) {
              
              if( ((String)session.getAttribute("statusLoginAttempt")).equalsIgnoreCase("fail")) {
                  %>
                  <div class="alert-box warning large-6 large-offset-3 end columns">
                  <%int i = 3 - ((int)session.getAttribute("loginAttempts"));
                  out.println("<h6>Wrong password, try again. You have " + i + " left </h6>");
                  %>
                  </div>
               <%
              } else if (session.getAttribute("statusLoginAttempt").equals("invalidAccount")) {
                  %>
                  <div class="alert-box warning large-6 large-offset-3 end columns">
                  <%
                  out.println("<h6>The account is blocked for too many failed login attempts </h6>");
                  %>
                  </div>
                  <%
              } else {
                  out.println("<h3> </h3>");
              }
          }  
        %>
            </div>
        </div>
        
        <div class="row">
            <form action="Login" method="POST" class="large-6 large-offset-3 end columns">
                Enter Username:  <input type="text" name="username" value="" />
                <br><br>
                Enter Password: <input type="password" name="password" value="" />
                <br><br>
                <input class="button" type="submit" name="login" value="Log In">
            </form>    
        </div>
        <div class="row">
            <div class="large-6 large-offset-3 end columns">
                Not registered yet? <a class="" href="signin.jsp">Sign in.</a>    
            </div>
            
        </div>
        
        <script src="js/vendor/jquery.js"></script>
        <script src="js/foundation.min.js"></script>
    </body>
</html>
