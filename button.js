$(document).ready(function(){
	//lots of different functions for the buttons on the screen
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
	});
	
	$(".player2").click(function() {
		$(".player2").toggleClass("activated", true); 
	});
	
	$(".player3").click(function() {
		$(".player3").toggleClass("activated", true); 
	});
	
	$(".player4").click(function() {
		$(".player4").toggleClass("activated", true); 

	});
	
	$(".player5").click(function() {
		$(".player5").toggleClass("activated", true); 

	});
	
	$(".player6").click(function() {
		$(".player6").toggleClass("activated", true); 
	});
	
	$(".player7").click(function() {
		$(".player7").toggleClass("activated", true); 
	});
	
	$(".player8").click(function() {
		$(".player8").toggleClass("activated", true); 
	});
	
	$(".player9").click(function() {
		$(".player9").toggleClass("activated", true); 
	});
	
	$(".player10").click(function() {
		$(".player10").toggleClass("activated", true); 
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
	
	
	//$(".update-rules").click(function() {
	//	window.location.href = "http://localhost:8080/PokerServlet/PokerCreate.jsp";
	//});
	
});
