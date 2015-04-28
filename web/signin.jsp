<%-- 
    Document   : signup
    Created on : Apr 12, 2015, 6:25:04 PM
    Author     : hlg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in to JavaJeopardy</title>
    </head>
    <body>
        <h1>Sign in</h1>
        <br>
        <form action="Signin" method="POST">
            Enter a User ID:   <input type="text" name="username" value="" />
            <br><br>
            Enter your email:  <input type="email" name="email" value="" />
            <br><br>
            <input type="submit" name="signin" value="Sign Up">
        </form>
    </body>
</html>
