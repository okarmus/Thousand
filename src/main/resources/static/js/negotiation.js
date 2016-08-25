function negotiate() {
	createNegotiation();
}

function createNegotiationCallback(data) {
	negotiationId = data
	setTimeout(function(){ raise(100); }, 1000);
}

function performRaise() {
	var score = prompt("Raise or Pass")
	if (score != null) {
		raise(score);
	}else {
		pass();
	}
}

function raiseCallback(data){
	$('#playerBet').html(data.userBet)
	$('#cpu1Bet').html(data.cpusBet[0])
	$('#cpu2Bet').html(data.cpusBet[1])
	
	if (!data.finished) {
		setTimeout(function(){ performRaise(); }, 1000);
	}else {
		setTimeout(function(){ alert("negotiation are finished"); }, 1000);		//TODO next steps should be invoked here
	}
}

/*******************************/
/*****APPLICATION CALLBACKS*****/
/*******************************/
function createNegotiation() {
	url = "/negotiation/create/" + gameId;
	$.ajax({
		method: "GET",
		url: url,
		contentType:"application/json; charset=utf-8"
	})
	.done(function(data) {
		createNegotiationCallback(data);
	});
}

function raise(score) {
	url = "/negotiation/raise/" + negotiationId + "/" + score;
	$.ajax({
		method: "GET",
		url: url,
		contentType:"application/json; charset=utf-8"
	})
	.done(function(data) {
		raiseCallback(data);
	});
}

function pass() {
	url = "/negotiation/pass/" + negotiationId;
	$.ajax({
		method: "GET",
		url: url,
		contentType:"application/json; charset=utf-8"
	})
	.done(function(data) {
		raiseCallback(data);
	});
}