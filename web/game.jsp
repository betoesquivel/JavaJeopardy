<%-- 
    Document   : jeopardy
    Created on : Apr 26, 2015, 9:33:05 AM
    Author     : LuisAlberto
--%>

<%@page import="beans.Question"%>
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
        <script type="text/javascript">
            $(document).ready(function () {
                game.init();
            });
        </script>

    </head>

    <body>
        <% String t1 = request.getParameter("team1Name");
        String t2 = request.getParameter("team2Name"); 
        
        int t1I = (Integer)(request.getAttribute("t1I"));
        int t2I =(Integer) (request.getAttribute("t2I"));
        
        
        int gId = (Integer)(request.getAttribute("gI"));
            
        
        %>
        
        <input id="t1" type="hidden" value="<%= t1 %>" />
        <input id="t2" type="hidden" value="<%= t2 %>" />
        <input id="gameId" type="hidden" value="<%= gId %>" />
        <input id="team1Id" type="hidden" value="<%= t1I %>" />
        <input id="team2Id" type="hidden" value="<%= t2I %>" />
        <%
            List<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
            int i = 0;

        %>
        <table id="game" cellspacing="5" cellpadding="0">
            <thead>
                <tr>

                    <th><%  out.print(questions.get(1).getCategory());%></th>

                    <th><%  out.print(questions.get(6).getCategory());%></th>

                    <th><%  out.print(questions.get(11).getCategory());%></th>

                    <th><%  out.print(questions.get(16).getCategory());%></th>

                    <th><%  out.print(questions.get(21).getCategory());%></th>

                </tr>		
            </thead>
            <tbody>

                <tr>


                    <td id="tq00" class="cell clean" onclick="prompt.show('q00', 100)">
                        <h3><%  out.print(questions.get(i).getLevel());%></h3>
                        <div class="hide">
                            <div id="q00"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq00"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq01" class="cell clean" onclick="prompt.show('q01', 100)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q01">What is HTML</div>
                            <div id="aq01"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq02" class="cell clean" onclick="prompt.show('q02', 100)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q02"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq02"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq03" class="cell clean" onclick="prompt.show('q03', 100)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q03"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq03"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq04" class="cell clean" onclick="prompt.show('q04', 100)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q04"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq04"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>


                </tr>

                <tr>


                    <td id="tq10" class="cell clean" onclick="prompt.show('q10', 200)">
                        <h3><%  i++;
                            out.print(questions.get(i).getLevel());%></h3>
                        <div class="hide">
                            <div id="q10"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq10"><%  out.print(questions.get(i).getAnswer());%>
                            </div>
                        </div>
                    </td>



                    <td id="tq11" class="cell clean" onclick="prompt.show('q11', 200)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q11"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq11"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq12" class="cell clean" onclick="prompt.show('q12', 200)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q12"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq12"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq13" class="cell clean" onclick="prompt.show('q13', 200)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q13"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq13"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq14" class="cell clean" onclick="prompt.show('q14', 200)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q14"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq14"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>


                </tr>

                <tr>


                    <td id="tq20" class="cell clean" onclick="prompt.show('q20', 300)">
                        <h3><%  i++;
                            out.print(questions.get(i).getLevel());%></h3>
                        <div class="hide">
                            <div id="q20"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq20"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq21" class="cell clean" onclick="prompt.show('q21', 300)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q21"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq21"><%  out.print(questions.get(i).getAnswer());%> </div>
                        </div>
                    </td>



                    <td id="tq22" class="cell clean" onclick="prompt.show('q22', 300)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q22"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq22"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq23" class="cell clean" onclick="prompt.show('q23', 300)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q23"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq23"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq24" class="cell clean" onclick="prompt.show('q24', 300)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q24"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq24"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>


                </tr>

                <tr>


                    <td id="tq30" class="cell clean" onclick="prompt.show('q30', 400)">
                        <h3><%  i++;
                            out.print(questions.get(i).getLevel());%></h3>
                        <div class="hide">
                            <div id="q30"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq30"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq31" class="cell clean" onclick="prompt.show('q31', 400)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q31"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq31"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq32" class="cell clean" onclick="prompt.show('q32', 400)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q32"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq32"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq33" class="cell clean" onclick="prompt.show('q33', 400)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q33"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq33"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq34" class="cell clean" onclick="prompt.show('q34', 400)">
                        <h3><%  i++;
                            out.print(questions.get(i + 5).getLevel());%></h3>
                        <div class="hide">
                            <div id="q34"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq34"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>


                </tr>

                <tr>


                    <td id="tq40" class="cell clean" onclick="prompt.show('q40', 500)">
                        <h3><%  i++;
                            out.print(questions.get(i).getLevel());%></h3>
                        <div class="hide">
                            <div id="q40"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq40"><%  out.print(questions.get(i).getAnswer());%> </div>
                        </div>
                    </td>



                    <td id="tq41" class="cell clean" onclick="prompt.show('q41', 500)">
                        <h3><%  i++;
                            out.print(questions.get(i).getLevel());%></h3>
                        <div class="hide">
                            <div id="q41"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq41"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq42" class="cell clean" onclick="prompt.show('q42', 500)">
                        <h3><%  i++;
                            out.print(questions.get(i).getLevel());%></h3>
                        <div class="hide">
                            <div id="q42"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq42"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq43" class="cell clean" onclick="prompt.show('q43', 500)">
                        <h3><%  i++;
                            out.print(questions.get(i).getLevel());%></h3>
                        <div class="hide">
                            <div id="q43"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq43"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>



                    <td id="tq44" class="cell clean" onclick="prompt.show('q44', 500)">
                        <h3><%  i++;
                            out.print(questions.get(i).getLevel());%></h3>
                        <div class="hide">
                            <div id="q44"><%  out.print(questions.get(i).getQuestion());%></div>
                            <div id="aq44"><%  out.print(questions.get(i).getAnswer());%></div>
                        </div>
                    </td>


                </tr>

            </tbody>
        </table>
        <!--        <div id="stats">
                </div>-->

        <div id="prompt">
            <h2 id="answer"></h2>
            <p><span id="correct-response"><a href="javascript:prompt.showQuestion()">Correct Response</a> &nbsp;&nbsp;&nbsp;&nbsp; </span><a href="javascript:prompt.hide()">Continue</a></p>
            <h2 id="question"></h2>
        </div>


        <!--
                <script type="text/javascript">
                    var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
                    document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
                </script>
                <script type="text/javascript">
                    try {
                        var pageTracker = _gat._getTracker("UA-6553843-3");
                        pageTracker._trackPageview();
                    } catch (err) {
            }</script>-->
        <div id="stats" style="display: block">
            <input type="image" onclick="alert()" src="img/icn_return.png" width="48" height="48">
        </div>
    </body>
</html>

