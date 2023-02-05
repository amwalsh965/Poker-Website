<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
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
<title>Among Us Poker</title>
</head>
<body class="create-body">
<div class="main-create">
	<form id="updateRulesButton">
		<div class="column1">
			<h1 class="main-settings-heading">Game Info</h1>
			<div class="game-info-settings">
					<p class="settings-text ">Starting Chips?<input type="text" class="chips" name="startingChips" value="1000"/></p>
					<p class="settings-text ">Number of Bots?<input type="text" class="bots" name="numBots" value="10"/></p>
					<p class="settings-text ">Small Blind?<input type="text" class="smallBlind" name="smallBlind" value="5"/></p>
					<p class="settings-text ">Big Blind?<input type="text" class="BigBlind" name="bigBlind" value="10"/></p>
			</div>
			<div class="game-settings-settings">
					<p class="settings-text">amoungus1<input type="text" class="" name="amoungus" value=""/></p>
					<p class="settings-text">amoungus2<input type="text" class="" name="amoungus1" value=""/></p>
			</div>
			<div class="special-settings">
					<p class="settings-text">amoungus3<input type="text" class="" name="amoungus2" value=""/></p>
					<p class="settings-text">amoungus4<input type="text" class="" name="amoungus3" value=""/></p>
			</div>
		</div> 
		<div class="column2">
			<h2 class="create-settings-button create-game-settings-button1">Game Info</h2>
			<h2 class="create-settings-button create-game-settings-button2">Game Settings</h2>
			<h2 class="create-settings-button create-game-settings-button3">Special Settings</h2>
		</div>
		<a href="PokerMain.jsp" class="to-game">To Game</a>
		
			<input class="update-rules" type="submit" name="button" value="Update Rules"/>
		</form>
		<button class="options"></button>
		<div class="option-dropdown">
			<button class="settings inner-button">Settings</button>
			<button class="login inner-button">Login/Logout</button>
			<button class="close-button inner-button">X</button>
		</div>
</div>
</body>
</html>
