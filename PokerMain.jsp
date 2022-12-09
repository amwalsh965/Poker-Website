<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  
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
<body>
	
	<%				
	String word ="";
	int chips = 0;
	int numBots = 0;
	word = (String)request.getAttribute("us");
	/*chips = (int)request.getAttribute("chips"); 
	numBots = (int)request.getAttribute("numBots"); */
	
	ArrayList<String> cardImages = new ArrayList<String>();
	for(int i = 0; i < 5; i++) {
		String card = "";
		card = (String)request.getAttribute("card"+(1+i));
		cardImages.add(card);	
	 } 
     %>
	<!-- on start up  -->
	<div id="main-container"> 
		<div id="canvas">
			<div class="main-containter-for-game">
				<div class="table">
					<img class="table-image" src="images/poker-table.jpg" ondragstart="return false">
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
						<div class="player1-cards">
							<div class="player1-card1"><img class="card-image" src="<%=cardImages.get(0)%>" ondragstart="return false"></div>
							<div class="player1-card2"><img class="card-image" src="images/10_of_clubs.png" ondragstart="return false"></div>
						</div>
						<div class="player2-cards">
							<div class="player2-card1"><img class="card-image" src="images/10_of_clubs.png" ondragstart="return false"></div>
							<div class="player2-card2"><img class="card-image" src="<%=cardImages.get(0)%>" ondragstart="return false"></div>
						</div>
						<div class="player3-cards">
							<div class="player3-card1"><img class="card-image" src="images/10_of_clubs.png" ondragstart="return false"></div>
							<div class="player3-card2"><img class="card-image" src="<%=cardImages.get(3)%>" ondragstart="return false"></div>
						</div>
						<div class="player4-cards">
							<div class="player4-card1"><img class="card-image" src="images/10_of_clubs.png" ondragstart="return false"></div>
							<div class="player4-card2"><img class="card-image" src="<%=cardImages.get(0)%>" ondragstart="return false"></div>
						</div>
						<div class="player5-cards">
							<div class="player5-card1"><img class="card-image" src="images/10_of_clubs.png" ondragstart="return false"></div>
							<div class="player5-card2"><img class="card-image" src="<%=cardImages.get(3)%>" ondragstart="return false"></div>
						</div>
						<div class="player6-cards">
							<div class="player6-card1"><img class="card-image" src="images/10_of_clubs.png" ondragstart="return false"></div>
							<div class="player6-card2"><img class="card-image" src="<%=cardImages.get(4)%>" ondragstart="return false"></div>
						</div>
						<div class="player7-cards">
							<div class="player7-card1"><img class="card-image" src="<%=cardImages.get(2)%>" ondragstart="return false"></div>
							<div class="player7-card2"><img class="card-image" src="images/10_of_clubs.png" ondragstart="return false"></div>
						</div>
						<div class="player8-cards">
							<div class="player8-card1"><img class="card-image" src="images/10_of_clubs.png" ondragstart="return false"></div>
							<div class="player8-card2"><img class="card-image" src="<%=cardImages.get(2)%>" ondragstart="return false"></div>
						</div>
						<div class="player9-cards">
							<div class="player9-card1"><img class="card-image" src="<%=cardImages.get(1)%>" ondragstart="return false"></div>
							<div class="player9-card2"><img class="card-image" src="images/10_of_clubs.png" ondragstart="return false"></div>
						</div>
						<div class="player10-cards">
							<div class="player10-card1"><img class="card-image" src="images/10_of_clubs.png" ondragstart="return false"></div>
							<div class="player10-card2"><img class="card-image" src="<%=cardImages.get(1)%>" ondragstart="return false"></div>
						</div>
					</div>
					<div class="board">
					
						<div class="board-card1"><img class="card-image" src="<%=cardImages.get(0)%>"></div>
						<div class="board-card2"><img class="card-image" src="<%=cardImages.get(1)%>"></div>
						<div class="board-card3"><img class="card-image" src="<%=cardImages.get(2)%>"></div>
						<div class="board-card4"><img class="card-image" src="<%=cardImages.get(3)%>"></div>
						<div class="board-card5"><img class="card-image" src="<%=cardImages.get(4)%>"></div>
					</div>
					<div class="current-call"><p class="current-call-text">Call: </p></div>
					</div>
				</div>
				<div class="game-info">
					<h3>Starting Chips = <%=chips %></h3>
					<h3>Number of bots = <%=numBots %></h3>
				</div>
				<button class="tip">Money Here :)</button>
				<form action="PokerServlet" method="get">
					<input type="submit" class="start" name="button" value="Start"/>
				</form>
				<!--  a test for changing an input with java. Led to being able to run java code through servlet
				<form action="PokerServlet" method="get">
					<input type="submit" class=start name="startButton" value="Start"/>
				</form>
        		<input class="test1" type="text" value="<%=word%>" /> -->
				<!--  <button class="start" onclick="startButtonClick();">Start</button>-->
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
		<!-- currently working on trying to run the poker game through java methods. Stuck on how to keep the game running, and send users new
		hands and change the board continuously, since I dont want to have to call the entire get method everytime I want the board to change.
		This would also restart the game instead of keeping it going. Also can call two different conditoinals in the get method, since the
		variables wont be declared in the main jsp file. Thinking of tryin gto use json or ajax (was already planning on using ajax) Very close
		to having a working poker game on the web. -->
</body>
</html>
