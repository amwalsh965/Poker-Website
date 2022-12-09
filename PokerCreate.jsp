<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.journaldev.first.*, java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles/styles.css">
<link rel="icon" type="image/x-icon" href="images/favicon-16x16.png" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Oxygen:wght@700&family=Rubik:wght@500&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="scripts/button.js"></script>
<script type="text/javascript" src="scripts/screenSize.js"></script>
<script type="text/javascript" src="scripts/imageResize.js"></script>
<title>Among Us Poker</title>
</head>
<body class="create-body">
<form action="PokerServlet" method="get">
	<div class="column1">
		<h1 class="main-settings-heading">Game Info</h1>
		<div class="game-info-settings">
				<p class="settings-text">Starting Chips?<input type="text" class="" name="startingChips" value=""/></p>
				<p class="settings-text">Number of Bots?<input type="text" class="" name="numBots" value=""/></p>
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
	<a href="PokerMain.jsp"><input class="start-button" type="submit" name="button" value="Start Game"/></a>
	<button class="options"></button>
	<div class="option-dropdown">
		<button class="settings inner-button">Settings</button>
		<button class="login inner-button">Login/Logout</button>
		<button class="close-button inner-button">X</button>
	</div>
</form>
</body>
</html>
