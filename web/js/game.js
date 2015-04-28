/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validate() {
//	$('#game').fadeIn(1000);
//	$('#options').hide()
//	$('#stats').show()
//	game.team_cnt = $('#teams').val()
//	game.createScoreboard()
//        game.current_points = 0;
    return true;
}
var game = {}
game.init = function()
{
	$('#game').fadeIn(1000);
	$('#options').hide()
	$('#stats').show()
	game.team_cnt = 2
	game.createScoreboard()
        game.current_points = 0;
}

game.createScoreboard = function()
{
	var content = "<table cellspacing=10><tbody><tr>";
	for(var i = 1; i <= game.team_cnt; i++)
	{
		content += "<th><h3>Team " + $('#t'+i+'').val() + "</h3></th>";
	}
	content += "</tr><tr>";
	for(var i = 1; i <= game.team_cnt; i++)
	{
		//content += "<td><h3 id='team" + i +"'>0</h3><span class='add-points' onclick='addPoints(" + i +  ")'>+</span> <span class='remove-points' onclick='removePoints(" + i +  ")'>-</span></td>";
		content += "<td><h3 id='team" + i +"'>0</h3><input class='add-points' onclick='game.addPoints(" + i +  ")' value='+' type='button' /> <input class='subtract-points' onclick='game.subtractPoints(" + i +  ")' type='button' value='-' /></td>";
	}
	content += "</tr></tbody></table> <input type='image' onclick='alert()' src='img/icn_return.png' width='48' height='48'>";
	$('#stats').html(content);

}

game.addPoints = function(team)
{	
	var points = parseInt($('#team' + team).html()) + game.current_points;
	
	$('#team' + team).html(points);
	$(('#t' + game.current_questionID)).addClass("dirty");

	$(('#t' + game.current_questionID)).unbind('mouseover')
	$(('#t' + game.current_questionID)).unbind('mouseout')	
}

game.subtractPoints = function(team)
{
	var points = parseInt($('#team' + team).html()) - game.current_points;
	
	$('#team' + team).html(points);
	$(('#t' + game.current_questionID)).addClass("dirty");	
	$(('#t' + game.current_questionID)).unbind('mouseover')
	$(('#t' + game.current_questionID)).unbind('mouseout')	
}

function alert() {
    var team1 = $("#team1");
    var team2 = $('#team2');
    console.log(team1.html());
    console.log(team2.html());
    var winner = team1.html() > team2.html() ? $('#t1').val():$('#t2').val() ;
    var r = confirm("Are you sure you want to end the game? Winner is " + winner);
    if (r == true) {
        //top.location = "home.jsp";
        document.location.href="gameServlet?action=end&gameId="+ $('#gameId').val() + "&team1Id="+$('#team1Id').val()+"&team2Id="+$('#team2Id').val()+"&score1="+$('#team1').html()+"&score2="+$('#team2').html();
    } else {
        x = "You pressed Cancel!";
    }
}
var prompt = {}
prompt.show = function (questionID, points)
{
    game.current_points = points
    game.current_questionID = questionID
    $('#question').hide()
    $('#game').hide()
    $('#prompt').fadeIn(1000)
    $('#answer').html($('#' + questionID).html())
    $('#question').html($('#a' + questionID).html())
    if ($('#question').html().length == 0)
        $('#correct-response').hide()
    else
        $('#correct-response').show();
}
prompt.showQuestion = function()
{
	$('#question').fadeIn(1000)
}
prompt.hide = function()
{
	$('#prompt').hide();
	$('#game').show();
}