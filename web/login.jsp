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
        
        <style>
            h3 {
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Log In</h1>
        <br>
        <%
          if(session.getAttribute("statusLoginAttempt") != null) {
              
              if( ((String)session.getAttribute("statusLoginAttempt")).equalsIgnoreCase("fail")) {
                  int i = 3 - ((int)session.getAttribute("loginAttempts"));
                  out.println("<h3>Wrong password, try again. You have " + i + " left </h3>");
              } else if (session.getAttribute("statusLoginAttempt").equals("invalidAccount")) {
                  out.println("<h3>The account is blocked for too many failed login attempts </h3>");
              }
          }  
        %>
        <br>
        <form action="Login" method="POST">
            Enter Username:  <input type="text" name="username" value="" />
            <br><br>
            Enter Password: <input type="password" name="password" value="" />
            <br><br>
            <input type="submit" name="login" value="Log In">
        </form>
        Not registered yet? <a href="signin.jsp">Sign in.</a>
    </body>
</html>
