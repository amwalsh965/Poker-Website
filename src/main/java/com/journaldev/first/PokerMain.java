package com.journaldev.first;
import java.util.*;


public class PokerMain {
   
   static Scanner scan = new Scanner(System.in);
   public static int startingChips;
   public static int numBots;
   public static ArrayList<PokerBot> b = new ArrayList<PokerBot>();
   //TODO create a better way to test methods quickly.
   //TODO create game mechanics (betting, checking, folding, raising), and turns.
   
      
   public static void main(String args[]) {
      
      Board b1 = Board.b1;
      b1.createAllCards();
      
      System.out.println("Starting Chips?");
      startingChips = 40000;//scan.nextInt();
      System.out.println("Number of bots?");
      numBots = 10;//scan.nextInt(); 

      PokerBot.makeBots();
      System.out.println(b.size());
      PokerBot.giveCards(b1);
      PokerBot.getAllBotCards();
      b1.pickCardsForGame(3);
      b1.pickCardsForGame(4);
      b1.pickCardsForGame(5);
      b1.emptyBoard();
      b1.board(3);
      b1.board(4);
      b1.board(5);

      System.out.println(b.get(0).getCard1());
      System.out.println(b.get(0).getCard2());
      System.out.println(b.get(0).getChips());
      
      System.out.println(b.size());
      System.out.println(PokerBot.getWinners(PokerBot.getBestHands()));
      
      
      
   }
}
