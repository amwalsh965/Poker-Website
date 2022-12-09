$(document).ready(function(){
	
	$(".options").click(function() {
		$(".option-dropdown").toggleClass("dropdown-open-click", true);
		$(".settings").toggleClass("dropdown-opened", true);
		$(".login").toggleClass("dropdown-opened", true);
		$(".close-button").toggleClass("dropdown-opened", true);
		$(".options").css("visibility", "hidden");
	});
	
	$(".close-button").click(function() {
		$(".option-dropdown").toggleClass("dropdown-open-click", false);
		setTimeout(() => { $(".options").css("visibility", "visible"); }, 300);
	});
	
	function keyPress (e) {
    	if(e.key === "Escape") {
        	$(".option-dropdown").toggleClass("dropdown-open-click", false);
			$(".options").css("visibility", "visible");
    	}
	}
	
	$(document).on("keydown", keyPress);
	
	$(".player1").click(function() {
		$(".player1").toggleClass("activated", true);
		$(".player2, .player3, .player4, .player5, .player6, .player7, .player8, .player9, .player10").css("visibility", "hidden");
	});
	
	$(".player2").click(function() {
		$(".player2").toggleClass("activated", true); 
		$(".player1, .player3, .player4, .player5, .player6, .player7, .player8, .player9, .player10").css("visibility", "hidden");
	});
	
	$(".player3").click(function() {
		$(".player3").toggleClass("activated", true); 
		$(".player2, .player1, .player4, .player5, .player6, .player7, .player8, .player9, .player10").css("visibility", "hidden");
	});
	
	$(".player4").click(function() {
		$(".player4").toggleClass("activated", true); 
		$(".player2, .player3, .player1, .player5, .player6, .player7, .player8, .player9, .player10").css("visibility", "hidden");
	});
	
	$(".player5").click(function() {
		$(".player5").toggleClass("activated", true); 
		$(".player2, .player3, .player4, .player1, .player6, .player7, .player8, .player9, .player10").css("visibility", "hidden");
	});
	
	$(".player6").click(function() {
		$(".player6").toggleClass("activated", true); 
		$(".player2, .player3, .player4, .player5, .player1, .player7, .player8, .player9, .player10").css("visibility", "hidden");
	});
	
	$(".player7").click(function() {
		$(".player7").toggleClass("activated", true); 
		$(".player2, .player3, .player4, .player5, .player6, .player1, .player8, .player9, .player10").css("visibility", "hidden");
	});
	
	$(".player8").click(function() {
		$(".player8").toggleClass("activated", true); 
		$(".player2, .player3, .player4, .player5, .player6, .player7, .player1, .player9, .player10").css("visibility", "hidden");
	});
	
	$(".player9").click(function() {
		$(".player9").toggleClass("activated", true); 
		$(".player2, .player3, .player4, .player5, .player6, .player7, .player8, .player1, .player10").css("visibility", "hidden");
	});
	
	$(".player10").click(function() {
		$(".player10").toggleClass("activated", true); 
		$(".player2, .player3, .player4, .player5, .player6, .player7, .player8, .player9, .player1").css("visibility", "hidden");
	});
	
	$(".create-game-settings-button1").click(function() {
		var text = $(".create-game-settings-button1").html();
		$(".main-settings-heading").text(text);
		$(".game-info-settings").css("display", "block");
		$(".game-settings-settings").css("display", "none");
		$(".special-settings").css("display", "none");
	});
	
	$(".create-game-settings-button2").click(function() {
		var text = $(".create-game-settings-button2").html();
		$(".main-settings-heading").text(text);
		$(".game-info-settings").css("display", "none");
		$(".game-settings-settings").css("display", "block");
		$(".special-settings").css("display", "none");
	});
	
	$(".create-game-settings-button3").click(function() {
		var text = $(".create-game-settings-button3").html();
		$(".main-settings-heading").text(text);
		$(".game-info-settings").css("display", "none");
		$(".game-settings-settings").css("display", "none");
		$(".special-settings").css("display", "block");
	});
	
	
	$(".start").click(function() {
		
	});
	
	
});
