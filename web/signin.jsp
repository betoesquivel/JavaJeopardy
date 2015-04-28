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
        <link rel="stylesheet" href="css/foundation.css"/>
    </head>
    <body>
        <div class="row">
            <h1 class="large-6 large-offset-3 end columns">Sign in</h1>
        </div>
        <div class="row">
            <form class="large-6 large-offset-3 end columns" action="Signin" method="POST">
                Enter a User ID:   <input type="text" name="username" value="" />
                <br>
                Enter your email:  <input type="email" name="email" value="" />
                <br>
                <input class="button" type="submit" name="signin" value="Sign Up">
            </form>    
        </div>
        
        <script src="js/vendor/jquery.js"></script>
        <script src="js/foundation.min.js"></script>
    </body>
</html>
