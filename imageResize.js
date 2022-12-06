$(document).ready(function() {
	$(document).ready(function() {
		var width = $(".player1-card1").css("width");
		var height = $(".player1-card1").css("height");
		
		$(".card-image").css("width", width);
		$(".card-image").css("height", height);
	});
	$(window).resize(function() {
		var width = $(".player1-card1").css("width");
		var height = $(".player1-card1").css("height");
		
		$(".card-image").css("width", width);
		$(".card-image").css("height", height);
	});
	
	document.getElementByClassName("card-image").addEventListener("dragstart", function() {
		return false;
	});
});
