<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles/styles.css">
<link rel="icon" type="image/x-icon" href="images/favicon.ico" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="scripts/pageLoader.js"></script>
<title>Steel Rivets Poker</title>
</head>
<body>
	<div id="main-container">
		<div id="canvas">
			<div class="main-containter-for-game">
				<div class="table">
					<div class="seats">
						<div class="player1 player-seat"><p class="player-text">1</p></div>
						<div class="player2 player-seat"><p class="player-text">2</p></div>
						<div class="player3 player-seat"><p class="player-text">3</p></div>
						<div class="player4 player-seat"><p class="player-text">4</p></div>
						<div class="player5 player-seat"><p class="player-text">5</p></div>
						<div class="player6 player-seat"><p class="player-text">6</p></div>
						<div class="player7 player-seat"><p class="player-text">7</p></div>
						<div class="player8 player-seat"><p class="player-text">8</p></div>
						<div class="player9 player-seat"><p class="player-text">9</p></div>
						<div class="player10 player-seat"><p class="player-text">10</p></div>
					</div>
					<div class="player-cards">
						<div class="player1-cards"><div class="player1-card1"></div><div class="player1-card2"></div></div>
						<div class="player2-cards"><div class="player2-card1"></div><div class="player2-card2"></div></div>
						<div class="player3-cards"><div class="player3-card1"></div><div class="player3-card2"></div></div>
						<div class="player4-cards"><div class="player4-card1"></div><div class="player4-card2"></div></div>
						<div class="player5-cards"><div class="player5-card1"></div><div class="player5-card2"></div></div>
						<div class="player6-cards"><div class="player6-card1"></div><div class="player6-card2"></div></div>
						<div class="player7-cards"><div class="player7-card1"></div><div class="player7-card2"></div></div>
						<div class="player8-cards"><div class="player8-card1"></div><div class="player8-card2"></div></div>
						<div class="player9-cards"><div class="player9-card1"></div><div class="player9-card2"></div></div>
						<div class="player10-cards"><div class="player10-card1"></div><div class="player10-card2"></div></div>
					</div>
					<div class="board">
						<div class="board-card1"></div>
						<div class="board-card2"></div>
						<div class="board-card3"></div>
						<div class="board-card4"></div>
						<div class="board-card5"></div>
					</div>
					<div class="game-info"></div>
					<button class="tip">Money Here :)</button>
				</div>
				<div class="notices"></div>
				<button type="button" class="options"></button>
				<div id="option-dropdown">
					<button class="settings">Settings</button>
					<button class="login">Login/Logout</button>
					<button class="close-button">X</button>
				</div>
				<div class="donation"></div>
			</div>
			
		</div>
	</div>
</body>
</html>