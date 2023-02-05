<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<%@ page import="com.journaldev.first.*, java.util.*" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles/styles.css">
<link rel="icon" type="image/x-icon" href="images/favicon-16x16.png" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Oxygen:wght@700&family=Rubik:wght@500&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="scripts/button.js"></script>
<script type="text/javascript" src="scripts/screenSize.js"></script>
<script type="text/javascript" src="scripts/imageResize.js"></script>
<script type="text/javascript" src="scripts/ajax.js"></script>
<script type="text/javascript" src="scripts/betting.js"></script>
<title>Among Us Poker</title>
</head>
<body class="main-body">
	
	<!-- on start up  -->
	<div id="main-container"> 
		<div id="canvas">
			<div class="main-containter-for-game">
				<div class="table">
					<img class="table-image" src="images/poker-table.jpg" ondragstart="return false">
					<div class="seats">
						<div class="player1 player-seat">
							<p class="player-text">Player 1</p>
							<p class="player1-chips">Chips:</p>
						</div>
						<div class="player2 player-seat">
							<p class="player-text">Player 2</p>
							<p class="player2-chips">Chips:</p>

						</div>
						<div class="player3 player-seat">
							<p class="player-text">Player 3</p>
							<p class="player3-chips">Chips:</p>

						</div>
						<div class="player4 player-seat">
							<p class="player-text">Player 4</p>
							<p class="player4-chips">Chips:</p>

						</div>
						<div class="player5 player-seat">
							<p class="player-text">Player 5</p>
							<p class="player5-chips">Chips:</p>

						</div>
						<div class="player6 player-seat">
							<p class="player-text">Player 6</p>
							<p class="player6-chips">Chips:</p>

						</div>
						<div class="player7 player-seat">
							<p class="player-text">Player 7</p>
							<p class="player7-chips">Chips:</p>

						</div>

						<div class="player8 player-seat">
							<p class="player-text">Player 8</p>
							<p class="player8-chips">Chips:</p>

						</div>
						<div class="player9 player-seat">
							<p class="player-text">Player 9</p>
							<p class="player9-chips">Chips:</p>

						</div>
						<div class="player10 player-seat">
							<p class="player-text">Player 10</p>
							<p class="player10-chips">Chips:</p>

						</div>
					</div>
					<div class="player-cards">
						<div class="player1-cards">
							<div class="player1-card1 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player1-card2 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player1-bet-box bet-box"><p class="player1-bet-box-text bet-box-text"></p></div>
						</div>
						<div class="player2-cards">
							<div class="player2-card1 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player2-card2 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player2-bet-box bet-box"><p class="player2-bet-box-text bet-box-text"></p></div>
						</div>
						<div class="player3-cards">
							<div class="player3-card1 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player3-card2 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player3-bet-box bet-box"><p class="player3-bet-box-text bet-box-text"></p></div>
						</div>
						<div class="player4-cards">
							<div class="player4-card1 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player4-card2 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player4-bet-box bet-box"><p class="player4-bet-box-text bet-box-text"></p></div>
						</div>
						<div class="player5-cards">
							<div class="player5-card1 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player5-card2 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player5-bet-box bet-box"><p class="player5-bet-box-text bet-box-text"></p></div>
						</div>
						<div class="player6-cards">
							<div class="player6-card1 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player6-card2 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player6-bet-box bet-box"><p class="player6-bet-box-text bet-box-text"></p></div>
						</div>
						<div class="player7-cards">
							<div class="player7-card1 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player7-card2 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player7-bet-box bet-box"><p class="player7-bet-box-text bet-box-text"></p></div>
						</div>
						<div class="player8-cards">
							<div class="player8-card1 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player8-card2 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player8-bet-box bet-box"><p class="player8-bet-box-text bet-box-text"></p></div>
						</div>
						<div class="player9-cards">
							<div class="player9-card1 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player9-card2 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player9-bet-box bet-box"><p class="player9-bet-box-text bet-box-text"></p></div>
						</div>
						<div class="player10-cards">
							<div class="player10-card1 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player10-card2 card"><img class="card-image" src="" ondragstart="return false"></div>
							<div class="player10-bet-box bet-box"><p class="player10-bet-box-text bet-box-text"></p></div>
						</div>
					</div>
					<div class="board">
					
						<div class="board-card1 card"><img class="card-image" src=""></div>
						<div class="board-card2 card"><img class="card-image" src=""></div>
						<div class="board-card3 card"><img class="card-image" src=""></div>
						<div class="board-card4 card"><img class="card-image" src=""></div>
						<div class="board-card5 card"><img class="card-image" src=""></div>
					</div>
					<div class="money-to-call"><p class="pot"></p></div>
					</div>
				</div>
				<div class="game-info">
					<h3 class="chips-text inline-class">Starting Chips: </h3>
					<h3 class="numChips inline-class"><%= MySQLConfig.selectItem("starting_chips", "game_info", "game_id", UpdateRules.gameId) %></h3>
					<hr />
					<h3 class="bot-text inline-class">Number of Bots: </h3>
					<h3 class="numBots inline-class"><%= MySQLConfig.selectItem("num_bots", "game_info", "game_id", UpdateRules.gameId) %></h3>
					<hr />
					<h3 class="blind-text inline-class">Small/Big: </h3>
					<h3 class="small-blind inline-class"><%= MySQLConfig.selectItem("small_blind", "game_info", "game_id", UpdateRules.gameId) %></h3>
					<h3 class="inline-class">/</h3>
					<h3 class="big-blind inline-class"><%= MySQLConfig.selectItem("big_blind", "game_info", "game_id", UpdateRules.gameId) %></h3>
				</div>
				<button class="tip">Money Here :)</button>
				<form id="startGameForm">
					<input type="submit" class="start" name="button" value="Start"/>
				</form>
				<div class="in-game-buttons">
					<form id="player-decisions-form">
					<!--  
						<input type="button" class="in-game-button fold" name="gameButton" value="Fold" />
						<input type="button" class="in-game-button check" name="gameButton" value="Check" />
						<input type="button" class="in-game-button bet" name="gameButton" value="Bet" /> 
						-->
						<input type="button" class="in-game-button show-cards" name = gameButton value="Show Cards" />
						<input type="submit" class="in-game-button fold" name="gameButton" value="Fold" />
						<input type="submit" class="in-game-button check" name="gameButton" value="Check" />
						<input type="submit" class="in-game-button bet" name="gameButton" value="Bet" /> 
						<input type="text" class="betting-textbox" value="0" name="betting-textbox" />
						<input type="range" min="1" max="100" value="50" class="betting-slider">
					</form>
				</div>
				
				
					
				<div class="notices"></div>
				<button class="options"></button>
				<div class="option-dropdown">
					<button class="settings inner-button">Settings</button>
					<button class="login inner-button">Login/Logout</button>
					<button class="close-button inner-button">X</button>
					<a href="PokerCreate.jsp"><button>Go Back</button></a>
				</div>
			</div>
		</div>
</body>
</html>
