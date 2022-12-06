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
	<div class="column1"><h1 class="main-settings-heading"></h1></div>
	<div class="column2">
		<h2 class="create-settings-button create-game-settings-button1">Game Info</h2>
		<h2 class="create-settings-button create-game-settings-button2">Game Settings</h2>
		<h2 class="create-settings-button create-game-settings-button3">Special Settings</h2>
	</div>
	<a href="PokerMain.jsp"><button class="start-button" onclick=<%=/* PokerServlet.writeString() */%>>Start Game</button></a>
	<button type="button" class="options"></button>
	<div class="option-dropdown">
		<button class="settings inner-button">Settings</button>
		<button class="login inner-button">Login/Logout</button>
		<button class="close-button inner-button">X</button>
		<%= /*PokerServlet.writeString() */%>  -->
		<p class="test">aaaaaaa</p>
		
	</div>
</body>
</html>