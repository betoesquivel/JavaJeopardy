<%-- 
    Document   : create_game_profile
    Created on : Apr 23, 2015, 8:23:48 PM
    Author     : betoesquivel
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="beans.Category"%>
<%@page import="dbhandlers.GameProfileDBHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a game profile</title>
        <style>
            fieldset {
                width: 50%;
                border: 2px solid black;
            }
        </style>
    </head>
    <body>
        <center>
            <fieldset>
                <legend>Select the class for the game profile</legend>
                
                <%
                    GameProfileDBHandler accessDB = new GameProfileDBHandler();
                    ArrayList<Category> categoriesList;
                    String cat = accessDB.getCategoryByName("TCP").getName();
                    categoriesList = accessDB.getAllCategories();
                    out.println("<h1>"+categoriesList.size()+"</h1>");
                    out.println("<select>");
                    out.println("<option selected=\"selected\" disabled=\"disabled\"> Select a class </option>");
                    
                    for(int i=0; i<categoriesList.size(); i++) {
                        String name = categoriesList.get(i).getName();
                        out.println("<option value=\"" + name + "\">" + name +"</option>");
                           
                    }
                    out.println("</select>");
                %>

            </fieldset>
            <br><br>
            <fieldset>
                <legend>Select category and questions for first column</legend>
                
            </fieldset>
            <br><br>
            <fieldset>
                <legend>Select category and questions for second column</legend>
                
            </fieldset>
            <br><br>
            <fieldset>
                <legend>Select category and questions for third column</legend>
                
            </fieldset>
            <br><br>
            <fieldset>
                <legend>Select category and questions for fourth column</legend>
                
            </fieldset>
            <br><br>
            <fieldset>
                <legend>Select category and questions for fifth column</legend>
                
            </fieldset>
        </center>
    </body>
</html>
