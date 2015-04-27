<%-- 
    Document   : home
    Created on : Apr 12, 2015, 6:43:59 PM
    Author     : betoesquivel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pick something to do: </h1>
        <a href="jeopardy.html">Play Jeopardy!</a><br>
        <a href="ManageAssets">Manage questions, categories, and classes (Create, Edit, Delete)</a><br>
        <a href="gameServlet?action=start">Play Jeopardy!</a><br>
        <a href="create_game_profile.jsp">Create game profile</a><br>
        <a href="#">See statistics</a><br>
        
        <a href="Logout">Logout</a>
    </body>
</html>
