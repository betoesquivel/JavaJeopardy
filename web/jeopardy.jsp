<%-- 
    Document   : jeopardy
    Created on : Apr 26, 2015, 9:33:05 AM
    Author     : LuisAlberto
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.GameProfile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Juego</title>
        <meta name="description" content=", Defines the number of pixels of space between a cell’s contents and the cell wall. , are useful when you want to arrange text and images in order to make the information straightforward and clear to the Web page visitor.
              , A heading cell displays text as bold and ____., There are ____ main HTML tags used to create a table." />
        <meta name="ROBOTS" content="NOODP" />
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" type="text/css" href="css/game.css"></link>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/game.js"></script>
    </head>

    <body>

        <form action="gameServlet" method="get">
            <input type="hidden" value="profile" name="action"/>
            <div id="options">
                <h1>Arma el equipo del juego</h1>

                <table style="width: 100%">
                    <th>Equipo 1</th>
                    <th>Equipo 2</th>
                    <tr>
                        <td><input type="text" name="team1Name" placeholder="Nombre del equipo 1"/></td>
                        <td><input type="text" name="team2Name" placeholder="Nombre del equipo 2"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><hr></hr></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="team1"/></td>
                        <td><input type="text" name="team2"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="team1"/></td>
                        <td><input type="text" name="team2"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="team1"/></td>
                        <td><input type="text" name="team2"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="team1"/></td>
                        <td><input type="text" name="team2"/></td>
                    </tr>
                </table>

                <select name="id">
                    <%
                        List<GameProfile> rec = (ArrayList<GameProfile>) request.getAttribute("profiles");
                   
                        for (int i = 0; i < rec.size(); i++) {
                            out.print("<option value=" + rec.get(i).getId() + ">" + rec.get(i).getName() + "</option>");
                        }
                    %>
                </select>
                <input class="submit" type="submit" id="submit" value="Start" />
                <div class="clear"></div>
            </div>
        </form>
    </body>
</html>

