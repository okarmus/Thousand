
var gameId;

function submitName() {
	var name = $("#playerName")[0].value;
	createGame(name);
	hidePopup();
}

function hidePopup() {
	$("#abc").hide();
}

function createGameCallback(data) {
	gameId = data;
	createGameDistribution();
}

function createGameDistribution() {
	createDistribution();
}

function createDistributionCallback (data) {
	var cardImages = createCardImages(data.cards);
	var cardsDiv = $('#myCards');
	for (var index in cardImages) {
		var imagePath = "img/cards/" + cardImages[index];
		var img = document.createElement('img');
		img.src = imagePath;
		img.width="150";
		img.height="250";
		$(cardsDiv).append(img);
	}
}

function createCardImages(playerCards) {
	var images = []
	
	for (var index in playerCards) {
		var card = playerCards[index];
		
		var image = card.figure.toLowerCase() + "_of_" + card.color.toLowerCase() + ".png";
		images.push(image);
	}
	return images;
}


/*******************************/
/*****APPLICATION CALLBACKS*****/
/*******************************/
function createGame(player){
	$.ajax({
		method: "POST",
		url: "/game/create",
		//data: JSON.stringify(player),
		data: player,
		contentType:"application/json; charset=utf-8"
	})
	.done(function(data) {
		createGameCallback(data);
	});
}

function createDistribution() {
	url = "/distribution/" + gameId + "/create"; 
	$.ajax({
		method: "GET",
		url: url,
		contentType:"application/json; charset=utf-8"
	})
	.done(function(data) {
		createDistributionCallback(data)
	});
}

