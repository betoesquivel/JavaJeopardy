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

        <table id="game" cellspacing="5" cellpadding="0" class="hide">
            <thead>
                <tr>

                    <th>Tables</th>

                    <th>Image Maps</th>

                    <th>Forms</th>

                    <th>CSS</th>

                    <th>Multimedia</th>

                </tr>		
            </thead>
            <tbody>

                <tr>


                    <td id="tq00" class="cell clean" onclick="prompt.show('q00', 100)">
                        <h3>100</h3>
                        <div class="hide">
                            <div id="q00">What is cell padding</div>
                            <div id="aq00">Defines the number of pixels of space between a cell’s contents and the cell wall. </div>
                        </div>
                    </td>



                    <td id="tq01" class="cell clean" onclick="prompt.show('q01', 100)">
                        <h3>100</h3>
                        <div class="hide">
                            <div id="q01">What is HTML</div>
                            <div id="aq01">You insert the coordinates for the various map shapes in the <area> tag in the _________________________ code.</div>
                        </div>
                    </td>



                    <td id="tq02" class="cell clean" onclick="prompt.show('q02', 100)">
                        <h3>100</h3>
                        <div class="hide">
                            <div id="q02">What is a text area</div>
                            <div id="aq02">In a(n) ____________________ box, a visitor may enter larger amounts of data.</div>
                        </div>
                    </td>



                    <td id="tq03" class="cell clean" onclick="prompt.show('q03', 100)">
                        <h3>100</h3>
                        <div class="hide">
                            <div id="q03">What is .css</div>
                            <div id="aq03">An external style sheet must be saved as a(n) ____ file.</div>
                        </div>
                    </td>



                    <td id="tq04" class="cell clean" onclick="prompt.show('q04', 100)">
                        <h3>100</h3>
                        <div class="hide">
                            <div id="q04">What is multimedia</div>
                            <div id="aq04">____________________ is defined as the combination of text, sound, and video to express an idea or convey a message.</div>
                        </div>
                    </td>


                </tr>

                <tr>


                    <td id="tq10" class="cell clean" onclick="prompt.show('q10', 200)">
                        <h3>200</h3>
                        <div class="hide">
                            <div id="q10">What are tables</div>
                            <div id="aq10">are useful when you want to arrange text and images in order to make the information straightforward and clear to the Web page visitor.
                            </div>
                        </div>
                    </td>



                    <td id="tq11" class="cell clean" onclick="prompt.show('q11', 200)">
                        <h3>200</h3>
                        <div class="hide">
                            <div id="q11">What is <area></div>
                            <div id="aq11">A(n) _________________________ tag is used to define the clickable areas within a <map> element, as well as links and anchors.</div>
                        </div>
                    </td>



                    <td id="tq12" class="cell clean" onclick="prompt.show('q12', 200)">
                        <h3>200</h3>
                        <div class="hide">
                            <div id="q12">What is a checkbox</div>
                            <div id="aq12">A(n) ____________________ control creates a list item in a list from which more than one item can be chosen.</div>
                        </div>
                    </td>



                    <td id="tq13" class="cell clean" onclick="prompt.show('q13', 200)">
                        <h3>200</h3>
                        <div class="hide">
                            <div id="q13">What is inline</div>
                            <div id="aq13">A(n) ____ style sheet is used to change the style within an individual HTML tag.</div>
                        </div>
                    </td>



                    <td id="tq14" class="cell clean" onclick="prompt.show('q14', 200)">
                        <h3>200</h3>
                        <div class="hide">
                            <div id="q14">What is compression</div>
                            <div id="aq14">File ____________________ can result in smaller file size.</div>
                        </div>
                    </td>


                </tr>

                <tr>


                    <td id="tq20" class="cell clean" onclick="prompt.show('q20', 300)">
                        <h3>300</h3>
                        <div class="hide">
                            <div id="q20">What is centered</div>
                            <div id="aq20">A heading cell displays text as bold and ____.</div>
                        </div>
                    </td>



                    <td id="tq21" class="cell clean" onclick="prompt.show('q21', 300)">
                        <h3>300</h3>
                        <div class="hide">
                            <div id="q21">What are coordinates</div>
                            <div id="aq21">Before coding the image map, you must map the image ____ for each </div>
                        </div>
                    </td>



                    <td id="tq22" class="cell clean" onclick="prompt.show('q22', 300)">
                        <h3>300</h3>
                        <div class="hide">
                            <div id="q22">What is submit</div>
                            <div id="aq22">The ____________________ button sends the information to the appropriate location for processing.</div>
                        </div>
                    </td>



                    <td id="tq23" class="cell clean" onclick="prompt.show('q23', 300)">
                        <h3>300</h3>
                        <div class="hide">
                            <div id="q23">What is stylesheet</div>
                            <div id="aq23">To link a style sheet to a Web page, the <link> tag must use "____________________" as the value for the rel property.</div>
                        </div>
                    </td>



                    <td id="tq24" class="cell clean" onclick="prompt.show('q24', 300)">
                        <h3>300</h3>
                        <div class="hide">
                            <div id="q24">What is mp3</div>
                            <div id="aq24">One of the most popular formats for music storage</div>
                        </div>
                    </td>


                </tr>

                <tr>


                    <td id="tq30" class="cell clean" onclick="prompt.show('q30', 400)">
                        <h3>400</h3>
                        <div class="hide">
                            <div id="q30">What is four</div>
                            <div id="aq30">There are ____ main HTML tags used to create a table.</div>
                        </div>
                    </td>



                    <td id="tq31" class="cell clean" onclick="prompt.show('q31', 400)">
                        <h3>400</h3>
                        <div class="hide">
                            <div id="q31">What is the y axis</div>
                            <div id="aq31">The __ -axis runs vertically on the image.</div>
                        </div>
                    </td>



                    <td id="tq32" class="cell clean" onclick="prompt.show('q32', 400)">
                        <h3>400</h3>
                        <div class="hide">
                            <div id="q32">What is a password</div>
                            <div id="aq32">The use of asterisks, for example, to mark the entered text in this kind of field is designed to help protect text from being observed as it is being entered</div>
                        </div>
                    </td>



                    <td id="tq33" class="cell clean" onclick="prompt.show('q33', 400)">
                        <h3>400</h3>
                        <div class="hide">
                            <div id="q33">What is a margin</div>
                            <div id="aq33">The ____________________ area surrounds the page area, and is transparent.</div>
                        </div>
                    </td>



                    <td id="tq34" class="cell clean" onclick="prompt.show('q34', 400)">
                        <h3>400</h3>
                        <div class="hide">
                            <div id="q34">What is Real Audio</div>
                            <div id="aq34">Its sound quality is not as good as other formats</div>
                        </div>
                    </td>


                </tr>

                <tr>


                    <td id="tq40" class="cell clean" onclick="prompt.show('q40', 500)">
                        <h3>500</h3>
                        <div class="hide">
                            <div id="q40">What is a row</div>
                            <div id="aq40">A ____ is a horizontal line of information. </div>
                        </div>
                    </td>



                    <td id="tq41" class="cell clean" onclick="prompt.show('q41', 500)">
                        <h3>500</h3>
                        <div class="hide">
                            <div id="q41">What is a clickable area or clickable element</div>
                            <div id="aq41">When an image is used as a link, the entire image becomes the ____ area, also called the hotspot.</div>
                        </div>
                    </td>



                    <td id="tq42" class="cell clean" onclick="prompt.show('q42', 500)">
                        <h3>500</h3>
                        <div class="hide">
                            <div id="q42">What is an attribute</div>
                            <div id="aq42">Nearly all of the HTML tags used to create forms have at most one of these each</div>
                        </div>
                    </td>



                    <td id="tq43" class="cell clean" onclick="prompt.show('q43', 500)">
                        <h3>500</h3>
                        <div class="hide">
                            <div id="q43">What is a pseudoclass</div>
                            <div id="aq43">Used to add special effects to some selectors</div>
                        </div>
                    </td>



                    <td id="tq44" class="cell clean" onclick="prompt.show('q44', 500)">
                        <h3>500</h3>
                        <div class="hide">
                            <div id="q44">What is an applet</div>
                            <div id="aq44">A Java ____ is a program written in the Java programming language that can be included in a Web page.</div>
                        </div>
                    </td>


                </tr>

            </tbody>
        </table>

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
            <select>
                <%
            List<GameProfile> rec = (ArrayList<GameProfile>) request.getAttribute("profiles");            
           %>
           <%
                for(int i=0; i<rec.size();i++){
                    out.print("<option value="+rec.get(i).getId()+">"+rec.get(i).getName()+"</option>");
                }
            %>
              </select>
            <input class="submit" type="button" id="submit" value="Start" onclick="validate()" />

            <div class="clear"></div>
        </div>

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
<div id="stats" class="hide">
    <input type="image" onclick="alert()" src="img/icn_return.png" width="48" height="48">
</div>
    </body>
</html>

