<%-- 
    Document   : change_password
    Created on : Apr 27, 2015, 7:30:56 PM
    Author     : hlg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password Page</title>
    </head>
    <body>
        <center>
            <h1>Change your password</h1>
            <br>
            <h3>For security reason we request you to change your password. Thank you.</h3>
            <br>
            <form action="Signin" method="POST">
                New Password:   <input type="password" name="newPass" value="" />
                <br><br>
                Confirm Password:  <input type="password" name="confirmPass" value="" />
                <br><br>
                <input type="submit" name="signin" value="Change Password">
            </form>
        </center>
    </body>
</html>
