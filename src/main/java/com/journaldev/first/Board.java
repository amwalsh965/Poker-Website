package com.journaldev.first;
import java.util.*;

public class Board {
   public ArrayList<String> boardCards = new ArrayList<String>();
   public ArrayList<String> deck;
   
   public static int cardsInPlay = 0;
   private static int arrayNum = 0;
   private static String cardToUse = "";
   public static Board b1 = new Board();
   
   public Board() {
      deck = new ArrayList<String>();
   }
  
   //card creation

      //Creates cards in each suit        
           
     //creates all cards in deck
   public void createAllCards() {
      ArrayList<String> hearts = createCardsForSuit('h');
      ArrayList<String> spades = createCardsForSuit('s');
      ArrayList<String> clubs = createCardsForSuit('c');
      ArrayList<String> diamonds = createCardsForSuit('d');
      
      ArrayList<String> allCards= new ArrayList<String>();
      allCards.addAll(hearts);
      allCards.addAll(spades);
      allCards.addAll(clubs);
      allCards.addAll(diamonds);
      
      deck = allCards;
   }
   
      //prints all cards in the deck
  /* public void printCards() {
      System.out.println(this.deck);
   }
   */
      
      //resets the deck, the used cards arrayList, and the board
   public void resetAll() {
      this.createAllCards();
      cardsInPlay = 0;
      this.boardCards.clear();
      //this.emptyBoard();
   }

//game logic
   //picks the next card for the board. Is used three cards for the flop. After card is picked, it is deleted from the temporary ArrayList************************************
      
   //picks the cards that will be used in the game
   
   private static void pickCards(Board b1) {
      arrayNum = (int)(Math.random() * (52 - cardsInPlay));
      cardToUse = b1.deck.get(arrayNum);
      if(cardToUse.charAt(0) == '1' && cardToUse.charAt(1) == '1')  {
         cardToUse = "J" + cardToUse.charAt(2);
      } else if (cardToUse.charAt(0) == '1' && cardToUse.charAt(1) == '2') {
         cardToUse = "Q" + cardToUse.charAt(2);
      } else if (cardToUse.charAt(0) == '1' && cardToUse.charAt(1) == '3') {
         cardToUse = "K" + cardToUse.charAt(2);
      }
      b1.boardCards.add(cardToUse);
      b1.deck.remove(arrayNum);
      cardsInPlay += 1;
   }
   
   public void pickCardsForGame() {
       for(int i = 1; i <= 25; i++) {
            pickCards(this);
       } 
   }
   
   /* public void pickCardsForGame(int c) {
         if (c == 3) {
             for(int i = 0; i <= 2; i++) {
                  pickCards(this);
              } 
         } else if (c == 4) {
            pickCards(this);
         } else if (c == 5) {
            pickCards(this);
         } else {
            System.out.println("invalid Entry");
         }
   }    
   */
   //returns a specific card on the board
   public String getBoardCards(int i) { 
    return boardCards.get(i-1);
   }
   
   //returns all of the cards on the board in an arraylist
   public ArrayList<String> getAllBoardCards() {
	   ArrayList<String> trueBoardCards = new ArrayList<String>();
	   for(int i = 0; i < 5; i++) {
		   trueBoardCards.add(boardCards.get(i));
	   }
	   return trueBoardCards;
   }
   
   /*public void setBoard(String a, String b, String c, String d, String e) {
      this.boardCards.add(a);
      this.boardCards.add(b);
      this.boardCards.add(c);
      this.boardCards.add(d);
      this.boardCards.add(e);
   } */
   
   private static ArrayList<String> createCardsForSuit(char s) {
      ArrayList<String> temp = new ArrayList<String>();
   
      for(int i = 1; i <= 13; i++) {
         temp.add("" + i + s);
      }
      return temp;
   }
   
   public ArrayList<String> convertCard() {
	   ArrayList<String> temp = new ArrayList<String>();
	   String tempString = "";
	   for(int i = 1; i <= ((PokerServlet.numBots * 2)+5); i++) {
		   if(this.getBoardCards(i).length() == 3) {
			   tempString += this.getBoardCards(i).substring(0, 2);
		   } else {
			   if(this.getBoardCards(i).substring(0, 1).equals("1")) {
				   tempString += "ace";
			   } else if(this.getBoardCards(i).substring(0, 1).equals("J")) {
				   tempString += "jack";
			   } else if(this.getBoardCards(i).substring(0, 1).equals("Q")) {
				   tempString += "queen";
			   } else if(this.getBoardCards(i).substring(0, 1).equals("K")) {
				   tempString += "king";
			   } else {
			   tempString += this.getBoardCards(i).substring(0, 1);
			   }
		   }
		   
		   tempString += "_of_";
		   
		   if(this.getBoardCards(i).length() == 3) {
			   if(this.getBoardCards(i).substring(2, 3).equals("h")) {
				   tempString += "hearts";
			   } else if(this.getBoardCards(i).substring(2, 3).equals("s")) {
				   tempString += "spades";
			   } else if(this.getBoardCards(i).substring(2, 3).equals("c")) {
				   tempString += "clubs";
			   } else if(this.getBoardCards(i).substring(2, 3).equals("d")) {
				   tempString += "diamonds";
			   }
		   } else if(this.getBoardCards(i).length() == 2){
			   if(this.getBoardCards(i).substring(1, 2).equals("h")) {
				   tempString += "hearts";
			   } else if(this.getBoardCards(i).substring(1, 2).equals("s")) {
				   tempString += "spades";
			   } else if(this.getBoardCards(i).substring(1, 2).equals("c")) {
				   tempString += "clubs";
			   } else if(this.getBoardCards(i).substring(1, 2).equals("d")) {
				   tempString += "diamonds";
			   }
		   }
		   tempString += ".png";
		   tempString = "images/" + tempString;
		   temp.add(tempString);
		   tempString = "";
	   }
	   return temp;
   }
   
 //methods for board creation 
   
   //creates the board at different stages in the game identified with c
  /* public void board(int c) {  
      burnCard('_');
      makeShape('_', c, this);
      burnCard('|');
      makeShape('?', c, this);
      burnCard('|');
      makeShape('|', c, this);
      burnCard('!');
      makeShape('!', c, this);
      System.out.println("\n");
   } */
   
   //prints an empty board to the console
  /*
   public void emptyBoard() {
      burnCard('_');
      burnCard('|');
      burnCard('|');
      burnCard('!');
      System.out.println();
   }
   */
 /*  
   private static void makeShape(char a, int c, Board b1) {
      if (a == '_') {
         for(int i = 1; i <= c; i++) {
            if(b1.getBoardCards(i).length() == 2) {
               System.out.print("  __   ");
            } else if(b1.getBoardCards(i).length() == 3) {
               System.out.print("  ___   ");
            }
         }
      } else if(a == '?') {
         for(int i = 1; i <= c; i++) {
            if(b1.getBoardCards(i).length() == 2) {   
               System.out.print("|    | ");
            } else if(b1.getBoardCards(i).length() == 3) {
               System.out.print("|     | ");
            }
         } 
      } else if (a == '|') {
         for(int i = 1; i <= c; i++) {
            System.out.print("| " + b1.getBoardCards(i) + " | ");
         } 
      } else if (a == '!') {
         for(int i = 1; i <= c; i++) {
            if(b1.getBoardCards(i).length() == 2) {   
               System.out.print("| __ | ");
            } else if(b1.getBoardCards(i).length() == 3) {
               System.out.print("| ___ | ");
            }
         }
      }
   }
*/
  /*
   private static void burnCard(char a) {
      if (a == '_') {
         System.out.print("\t  __      ");
      } else if (a == '|') {
         System.out.print("\n\t|    |    ");
      } else if (a == '!') {
         System.out.print("\n\t| __ |    ");
      }
   }
   */
 }
