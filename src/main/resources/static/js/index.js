$(document).ready(init());

var gameId;

function init() {
	var name = prompt("Initialization has started");
	createGame(name);
}

function createGame(player){
	$.ajax({
		method: "POST",
		url: "/game/create",
		data: JSON.stringify(player),
		contentType:"application/json; charset=utf-8"
	})
	.done(function(data) {
		createGameCallback(data);
	});
}

function createGameCallback(data) {
	gameId = data;
	alert(gameId);
}
