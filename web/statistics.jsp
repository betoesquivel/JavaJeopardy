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
    </head>
    <body>
        <h1>Resultados!</h1>
        <table>
            <th>Equipo</th>
            <th>Puntos</th>
            <th>Ganados</th>
            <%
            List<Team> result = (ArrayList<Team>) request.getAttribute("results");
                for(Team t:result )
                    out.print("<tr><td>"+t.getName()+"</td><td>"+t.getScore()+"</td><td>"+t.getWins()+"</td></tr>");
            %>
        </table>
    </body>
</html>
