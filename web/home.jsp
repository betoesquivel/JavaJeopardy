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
        <title>Home Page</title>
        <link rel="stylesheet" href="css/foundation.css"/>
    </head>
    <body>
        <div class="row">
            <h1 class="large-6 large-offset-3 end columns">Pick something to do: </h1>
        </div>
        <div class="row">
            <ul class="side-nav large-6 large-offset-3 end columns" role="navigation" title="Menu">
                <li>
                    <a href="gameServlet?action=start">Play Jeopardy!</a>
                </li>
                <li>
                    <a href="GameProfile">Create game profile</a>
                </li>
                <li>
                    <a href="ManageAssets">Create, edit, delete assets (questions, categories, classes)</a>
                </li>
                <li>
                    <a href="results">See statistics</a>
                </li>
                <li>
                    <a class="button" href="Logout">Logout</a>
                </li>
            </ul>    
        </div>
        
        
        <script src="js/vendor/jquery.js"></script>
        <script src="js/foundation.min.js"></script>
    </body>
</html>
