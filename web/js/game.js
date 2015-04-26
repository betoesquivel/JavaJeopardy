/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validate(){
	$('#game').fadeIn(1000);
	$('#options').hide()
	$('#stats').show()
	game.team_cnt = $('#teams').val()
	game.createScoreboard()
        game.current_points = 0;
    
}

function alert(){
    var r = confirm("¿Estás seguro? se borrara el juego");
if (r == true) {
    top.location="home.jsp";

} else {
    x = "You pressed Cancel!";
}
}