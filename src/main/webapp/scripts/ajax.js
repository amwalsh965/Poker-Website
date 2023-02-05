$(document).ready(function() {
	//list of all cards that are needed in a round
	var cards = [];
	//list of every players hand id
	var handIds = [];
	//list of every player
	var botList = [];
	//a counter that is for when cards are shown
	var showCard = 0;
	
	//function for when the update rules button is hit
	//Updates database in servlet
	$('#updateRulesButton').submit(function() {
		$.ajax({
			url: 'UpdateRules',
			type: 'POST',
			dataType: 'json',
			data: $('#updateRulesButton').serialize(),
			success: function(data) {
			}
		});
		return false;
	});
	
	//a count of total players based
	var totalPlayers = $(".numBots").html();
	//assigns currentPlayerIndex and person list to a value based on the number of total players
	//currentPlayerIndex tells what player has the turn
	//personList is used to hold what players have already taken a turn
	if(totalPlayers > 3) {
		var currentPlayerIndex = 3;
		var personList = [3];
	} else {
		var currentPlayerIndex = 0;
		var personList = [0];
	}
	
	//function for when the start game button is pressed
	//sets up the first hand in the game
	$('#startGameForm').submit(function() {
		$.ajax({
			url: 'PokerServlet',
			type: 'POST',
			dataType: 'json',
			data: $('#startGameForm').serialize(),
			cache: false,
			success: function(data) {
				//alert("start game");
				$(".player" + (currentPlayerIndex + 1)).css("border", "3px solid yellow");
				
				//hides start game button and displays the in game buttons
				$("#startGameForm").css("display", "hidden");
				$(".start").css("visibility", "hidden");
				$(".in-game-buttons").css("display", "block");
				$(".tip").css("bottom", "17.5%");
				
				//initalizes variables to values gotten from the backend code 
				cards = [data.c1,data.c2,data.c3,data.c4,data.c5,data.c6,data.c7,data.c8,data.c9,data.c10,data.c11,data.c12,data.c13,data.c14,data.c15,data.c16,data.c17,data.c18,data.c19,data.c20,data.c21,data.c22,data.c23,data.c24,data.c25];
				handIds = [data.hId1, data.hId2, data.hId3, data.hId4, data.hId5, data.hId6, data.hId7, data.hId8, data.hId9, data.hId10]
				botList = [data.b1, data.b2, data.b3, data.b4, data.b5, data.b6, data.b7, data.b8, data.b9, data.b10]
				
				for(var i = 1; i < 6; i++) {
					$('.board-card'+ i +' > .card-image').attr("src", "images/card-back.png");
				}
				for(var i = 1; i < 21; i++) {
					$('.player' + Math.trunc(((i+1)/2)) + '-card'+ (((i+1) % 2)+1) +' > .card-image').attr("src", "images/card-back.png");
				}
				for(var i = 1; i <= 10; i++) {
					$(".player" + i + "-chips").text("Chips: " + $(".numChips").text());
				}
					
			}
		});
		return false;
	});
	
	//variable for what stage the round is in
	var inRoundNum = 0;
	
	//variable for the pot
	var pot = 0;
	
	//variable for the previous bet
	var previousBet = 0;
	
	//variable for the previous raise
	var previousRaise = 0;
	
	//variable for dealer button position
	var dealerButton = 1;
	
	//list for the folded players
	var playersOut = [];
	
	//variable for the small blind amount
	var smallBlind = $(".small-blind").html();
	
	//variable for the big blind amount
	var bigBlind = $(".big-blind").html();
	
	//function that shows everyones cards at the end of the round	
	$(".show-cards").click(function() {
		if(showCard == 0) {
			$('.player' + Math.trunc((currentPlayerIndex%10)+1) + '-card1 > .card-image').attr("src", cards[7+((currentPlayerIndex*2)-2)]);
			$('.player' + Math.trunc((currentPlayerIndex%10)+1) + '-card2 > .card-image').attr("src", cards[8+((currentPlayerIndex*2)-2)]);
			showCard++;
		} else {
			$('.player' + Math.trunc((currentPlayerIndex%10)+1) + '-card1 > .card-image').attr("src", "images/card-back.png");
			$('.player' + Math.trunc((currentPlayerIndex%10)+1) + '-card2 > .card-image').attr("src", "images/card-back.png");
			showCard = 0;
		}
	});
	
	//function that makes the next round of the game. Very similar to the function for starting the game
	function nextRound() {
		$.ajax({
			url: 'PokerServlet',
			type: 'POST',
			dataType: 'json',
			data: $('#startGameForm').serialize(),
			cache: false,
			success: function(data) {
				//alert("start game");
				cards = [data.c1,data.c2,data.c3,data.c4,data.c5,data.c6,data.c7,data.c8,data.c9,data.c10,data.c11,data.c12,data.c13,data.c14,data.c15,data.c16,data.c17,data.c18,data.c19,data.c20,data.c21,data.c22,data.c23,data.c24,data.c25];
				handIds = [data.hId1, data.hId2, data.hId3, data.hId4, data.hId5, data.hId6, data.hId7, data.hId8, data.hId9, data.hId10]
				botList = [data.b1, data.b2, data.b3, data.b4, data.b5, data.b6, data.b7, data.b8, data.b9, data.b10]
				
				for(i = 1; i < 21; i++) {
					$('.player' + Math.trunc(((i+1)/2)) + '-card'+ (((i+1) % 2)+1) +' > .card-image').attr("src", "images/card-back.png");
				}
					
			}
		});
	}
	
	//determines which in game button was clicked
	$('.in-game-button.fold').on('click', function() {
    	$(this).data('clicked', true);
    	$('.in-game-button.check').data('clicked', false);
    	$('.in-game-button.bet').data('clicked', false);
    	$('.in-game-button.show-cards').data('clicked', false);
	});
	$('.in-game-button.check').on('click', function() {
	    $(this).data('clicked', true);
	    $('.in-game-button.bet').data('clicked', false);
	    $('.in-game-button.fold').data('clicked', false);
	    $('.in-game-button.show-cards').data('clicked', false);
	});
	$('.in-game-button.bet').on('click', function() {
	    $(this).data('clicked', true);
	    $('.in-game-button.check').data('clicked', false);
	    $('.in-game-button.fold').data('clicked', false);
	    $('.in-game-button.show-cards').data('clicked', false);
	});
	
	$('.in-game-button.show-cards').on('click', function() {
	    $(this).data('clicked', true);
	    $('.in-game-button.check').data('clicked', false);
	    $('.in-game-button.fold').data('clicked', false);
	    $('.in-game-button.bet').data('clicked', false);
	});
	
	//function for when an in game button is pressed
	$('#player-decisions-form').submit(function() {
		//goes up to the functions above and returns which button was clicked
	    var clickedButton = $('.in-game-button').filter(function() {
	        return $(this).data('clicked');
	    });
		
		//variable for the value of the clicked button
	    var buttonValueIs = clickedButton.val();
	    
	    //variabled for the number of people left in the hand
		var playersInHands = (totalPlayers).toString();
		$.ajax({
			url: 'PlayerDecisions',
			type: 'POST',
			contentType: 'application/json',
			dataType: 'json',
			data:  JSON.stringify({buttonValue: buttonValueIs, bettingAmount: $(".betting-textbox").val(), playersInHand: playersInHands}),
			cache: false,
			success: function(data) {
				//first condition runs if a legal bet, or check is made, or if the fold button is pressed
				if((data.decision == "Bet" && (data.betAmount >= (2*previousRaise) || data.betAmount == previousBet || (previousBet == 0 && data.betAmount > 0))) || (data.decision == "Fold") || (data.decision == "Check" && previousBet == 0)) {
				
				//runs at the very start of each round
				//resets everything that was changed, like the images and in game buttons
				//also changed the small blind and big blind positions, and their bet boxes
				if(personList.length == 0 && inRoundNum == 0) {
					console.log("work");
					$(".check").css("opacity", "100%");
					$(".check").css("disabled", false);
					nextRound();
					$(".pot").html("Pot: ");
					for(var j = 1; j < 6; j++) {
						$('.board-card'+ j +' > .card-image').attr("src", "images/card-back.png");
					}
					for(var j = 1; j <= totalPlayers; j++) {
							$(".player" + j).css("opacity", "100%");
					}
					for(var k = 1; k <= 10; k++) {
						$(".player" + k).css("border", "dashed 1px grey");
					}
					currentPlayerIndex = (dealerButton + 1)%totalPlayers;
					console.log(smallBlind + " " + bigBlind);
					previousBet = bigBlind;
					pot = Number(smallBlind) + Number(bigBlind);
					$(".player" + ((currentPlayerIndex +1)%totalPlayers)+ "-bet-box-text").html(bigBlind);
					$(".player" + (currentPlayerIndex + (totalPlayers%totalPlayers)) + "-bet-box-text").html(smallBlind);
					$(".player" + ((currentPlayerIndex + (totalPlayers - 1))%totalPlayers) + "-bet-box-text").html("D");
					console.log(".player" + ((currentPlayerIndex + (totalPlayers - 1))%totalPlayers) + "-bet-box-text");
					console.log(".player" + ((currentPlayerIndex + (totalPlayers - 2))%totalPlayers) + "-bet-box-text");
					console.log(".player" + ((currentPlayerIndex + (totalPlayers - 3))%totalPlayers) + "-bet-box-text");
					
					//was working on
				}
				//resets the legal bet, don't know if it is needed anymore 
				legalBet = false;
				  if(data.decision == "Bet") {
						console.log("Bet Amount: " + data.betAmount);
						
						//if the person legally raised the personList is reset because decisions now end at their index
						if(data.betAmount > (2*previousRaise)) {
							personList = [];
						}
						
						//adds teh currentPlayerIndex to the personList
						personList.push(currentPlayerIndex);
						
						//pot is updated based on the bet amount
						pot += Number(data.betAmount);
						
						//updates the players chips and displays the update on the screen
						//updates other variables like previous bet and raise
						let currentChips = $(".player" + ((currentPlayerIndex%10)+1) + "-chips").html().substring(7);
						let totalChips = Number(currentChips - data.betAmount);
						$(".player" + ((currentPlayerIndex+1)%11) + "-chips").html("Chips: " + totalChips);
						$(".player" + (currentPlayerIndex+1)%11 + "-bet-box-text").html(data.betAmount);
						
						$(".pot").html("Pot: " + pot);
						if(data.betAmount > (2*previousRaise)) {
							previousRaise = data.betAmount - previousBet;
						}
						previousBet = data.betAmount;
						legalBet = true;
					
					} 
					
					
					//disables the check button if someone has bet, becuase now checking is not an option
					if(previousBet != 0) {
						$(".check").css("opacity", "50%");
						$(".check").css("disabled", true);
					}
					
					//makes the player who folded go out, and adds them to the folded list, and updates the player list
					if(data.decision == "Fold") {
						$(".player" + ((currentPlayerIndex%totalPlayers) + 1)).css("opacity", "50%");
						playersOut.push((currentPlayerIndex%totalPlayers) + 1);
						personList.push((currentPlayerIndex%totalPlayers)+1);
						$(".player" + (currentPlayerIndex + 1)%11 + "-bet-box-text").html("Fold");
					} else {
						//if player checked, they get pushed into the personList
						personList.push((currentPlayerIndex%totalPlayers)+1);
					}
					//sorts the folded list in asending order
					playersOut.sort(function(a, b) {
						return a - b;
					});
				//increases the currentPlayerIndex whenever an ingameButton is pressed (not including the temporary show cards button)
			    currentPlayerIndex = ((currentPlayerIndex%totalPlayers) + 1) % totalPlayers;
			    var previousIndex = currentPlayerIndex;
			    for(var p = 0; p < 4; p++) {
					//increases the currentPlayerIndex more if there are any folded people in the betting order
					//increments the currentPlayerIndex until it gets to a person who is still in the game
				    for(var i = 0; i < playersOut.length; i++) {
						if(((currentPlayerIndex%totalPlayers) + 1) == playersOut[i]) {
							personList.push((currentPlayerIndex%totalPlayers) + 1);
							if(currentPlayerIndex == totalPlayers) {
								currentPlayerIndex = 0;
							} else {
								currentPlayerIndex = (currentPlayerIndex%totalPlayers) + 1;
							}
						}
					}
				}
				
				//made a random for loop because I don't know how many times I have to loop this code before it works
				//all I know is that I have to loop it because if there are people folded it won't work everytime
				//have to look over this code eventually, it works for now though
				for(var i = 1; i < personList.length; i++) {
					//if there are two of the same number in personList (which means it is before someone has a decision twice withough any raises)
					//Then the roundNumber will increase, it will show the next card(s) in the game sequence
					//currentPlayerIndex will be updated, and variables will be resent for the next stage of the round
					if((personList[0] % totalPlayers) == personList[i] || (personList[0] == totalPlayers) && (totalPlayers == personList[i])) {
						inRoundNum++;
						for(var j = 0; j < totalPlayers; j++) {
							$(".player" + (j + 1) + "-bet-box-text").html("");
						}
						if(inRoundNum == 1) {
							$('.board-card1 > .card-image').attr("src", cards[0]);
							$('.board-card2 > .card-image').attr("src", cards[1]);
							$('.board-card3 > .card-image').attr("src", cards[2]);
							currentPlayerIndex = dealerButton;
							for(var j = 0; j < 2; j++) {
								for(var i = 0; i < playersOut.length; i++) {
									if((currentPlayerIndex%10)+1 == playersOut[i]) {
										currentPlayerIndex++;
									}
								}
							}
							personList = [];
							previousBet = 0;
							previousRaise = 0;
							$(".check").css("opacity", "100%");
							$(".check").css("disabled", false);
							personList.push(currentPlayerIndex);
						}
						if(inRoundNum == 2) {
							$('.board-card4 > .card-image').attr("src", cards[3]);
							$('.player'+ (currentPlayerIndex%totalPlayers)+1).css("border", "dashed 1px grey");
							currentPlayerIndex = dealerButton;
							for(var j = 0; j < 2; j++) {
								for(var i = 0; i < playersOut.length; i++) {
									if((currentPlayerIndex%totalPlayers)+1 == playersOut[i]) {
										currentPlayerIndex++;
									}
								}
							}
							personList = [];
							previousBet = 0;
							previousRaise = 0;
							$(".check").css("opacity", "100%");
							$(".check").css("disabled", false);
							personList.push(currentPlayerIndex);
						}
						if(inRoundNum == 3) {
							$('.board-card5 > .card-image').attr("src", cards[4]);
							$('.player'+ (currentPlayerIndex%totalPlayers)+1).css("border", "dashed 1px grey");
							currentPlayerIndex = dealerButton;
							for(var j = 0; j < 2; j++) {
								for(var i = 0; i < playersOut.length; i++) {
									if((currentPlayerIndex%totalPlayers)+1 == playersOut[i]) {
										currentPlayerIndex++;
									}
								}
							}
							personList = [];
							previousBet = 0;
							previousRaise = 0;
							$(".check").css("opacity", "100%");
							$(".check").css("disabled", false);
							personList.push(currentPlayerIndex);
						}
						//if the round number is 4, this means that it is the end of the round
						//all cards are shown and the winner is determined from the backend code
						//chips get transfered from the pot to the winner
						//and most variables get reset for the next round
						if(inRoundNum == 4) {
							var b = false;
							//work on this more
							for(var j = 1; j < 21; j++) {
								$('.player' + Math.trunc(((j+1)/2)) + '-card'+ (((j+1) % 2)+1) +' > .card-image').attr("src", cards[j+4]);
							}

							for(var l = 0; l < playersOut.length; l++) {
								for(var m = botList.length - 1; m >= 0; m--) {
									console.log(botList);
									if(botList[m].length == 5) {
										if(playersOut[l] == botList[m].substring(3, 5)) {
											botList.splice(m, 1);
										}
									} else {
										if(playersOut[l] == botList[m].substring(3, 4)) {
											botList.splice(m, 1);
										}
									}
								}
							}
							console.log(botList);
							console.log(playersOut);
							
							$(".pot").html(botList[0] + " Has Won: $" + pot);
							
							if(botList[0].length == 4) {
								let currentChips = $(".player" + botList[0].substring(3, 4) + "-chips").html().substring(7);
								console.log(currentChips);
								let totalChips = Number(currentChips) + Number(pot);
								$(".player" + botList[0].substring(3, 4) + "-chips").text("Chips: " + totalChips);
							} else {
								let currentChips = $(".player" + botList[0].substring(3, 5) + "-chips").html().substring(7);
								console.log(currentChips);
								let totalChips = Number(currentChips) + Number(pot);
								$(".player" + botList[0].substring(3, 5) + "-chips").text("Chips: " + totalChips);
							}
							
							personList = [];
							playersOut = [];
							inRoundNum = 0;
							previousBet = 0;
							previousRaise = 0;	
							pot = 0;
							dealerButton = (dealerButton % totalPlayers) + 1;
							currentPlayerIndex = dealerButton;
							console.log("end");
							console.log(personList);
							console.log(inRoundNum);
						}
					}
				}
				
				console.log("Player " + ((currentPlayerIndex%totalPlayers) + 1) + " has the turn.");
			    
			    //the border of the next player in the betting order gets highlighted to signify that it is their turn
			    if(previousIndex == 0) {
					$(".player" + totalPlayers).css("border", "dashed 1px grey");
				} else {
					$(".player" + (previousIndex)).css("border", "dashed 1px grey");
				}
			    $(".player" + (currentPlayerIndex%totalPlayers + 1)).css("border", "3px solid yellow");
				
				console.log("\n");
				console.log("Person List First Index: " + personList[0]);
				console.log("Current Player Index: " + currentPlayerIndex);
				console.log("Players Out: " + playersOut);
				console.log("Person List: " + personList);
				} else if(data.decision == "Check") {
					console.log("Can't check");
				} else if(data.decision == "Bet") {
					console.log("Invalid Bet");
				}
			  } 
				});
		
		return false;
	});
	
});
