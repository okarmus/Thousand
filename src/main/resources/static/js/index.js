var gameId;

window.onload = function() { init(); };

function init() {
	var name = prompt("What is your name?", "Andrzej");
	displayName(name)
	createGame(name);
}

function displayName(name) {
	$('#playerName').html(name);
}

function createGameCallback(data) {
	gameId = data;
	createGameDistribution();
}

function createGameDistribution() {
	createDistribution();
}

function createDistributionCallback (data) {
	createCardsReverse("#cpu1Cards", 7)
	createCardsReverse("#cpu2Cards", 7)
	createCardsReverse("#boardCards", 3)
	
	var cardsDiv = $('#myCards');
	var playerCards = data.cards;
	for (var index in playerCards/*cardImages*/) {
		var card = playerCards[index];
		var imagePath = "img/cards/" + card.figure.toLowerCase() + "_of_" + card.color.toLowerCase() + ".png";
		insertCard(cardsDiv, imagePath)
	}
}

function createCardsReverse(element, cardsNbr) {
	var cardsDiv = $(element);
	var reversePath = "img/cards_back.png";
	for (i = 0; i < cardsNbr; i++) { 
		insertCard(cardsDiv, reversePath);
	}
}

function insertCard(cardsDiv, cardsImg) {
	var img = document.createElement('img');
	img.src = cardsImg;	
	$(cardsDiv).append(img)
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

