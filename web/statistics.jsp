<%-- 
    Document   : statistics
    Created on : Apr 27, 2015, 10:11:32 PM
    Author     : LuisAlberto
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Team"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistics</title>
        <link rel="stylesheet" href="css/foundation.css"/>

    </head>
    <body>
        <div class="row">
            <h1 class="columns">Resultados!</h1>
        </div>
        
        <div class="row">
            <table class="columns">
            <th>Equipo</th>
            <th>Puntos</th>
            <th>Ganados</th>
            <%
            List<Team> result = (ArrayList<Team>) request.getAttribute("results");
                for(Team t:result )
                    out.print("<tr><td>"+t.getName()+"</td><td>"+t.getScore()+"</td><td>"+t.getWins()+"</td></tr>");
            %>
            </table>
        </div>
        
        <script src="js/vendor/jquery.js"></script>
        <script src="js/foundation.min.js"></script>
    </body>
</html>
