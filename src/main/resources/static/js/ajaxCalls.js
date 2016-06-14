

function createGame(player, callback){
	$.ajax({
		method: "POST",
		url: "/game/create",
		data: JSON.stringify(player),
		contentType:"application/json; charset=utf-8"
	})
	.then(function(data) {
		callback(data)
	});
}