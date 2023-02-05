package com.journaldev.first;
import java.util.*;


public class PokerMain {
   
   static Scanner scan = new Scanner(System.in);
   public static int startingChips;
   public static int numBots;
   public static ArrayList<PokerBot> b = new ArrayList<PokerBot>();
   public static boolean playGame = true;
   public static ArrayList<String> imageSourceList = new ArrayList<String>();
   	public static ArrayList<PokerBot> botList = new ArrayList<PokerBot>();
   
   //TODO create a better way to test methods quickly.
   //TODO create game mechanics (betting, checking, folding, raising), and turns.
   Board b1 = Board.b1;
   
   public static void startGame() {
	   endRound();
	   Board b1 = Board.b1;
	   b1.createAllCards();
	   b1.pickCardsForGame();
       imageSourceList = b1.convertCard();
       ArrayList<Integer> tempArray = new ArrayList<Integer>();
       PokerBot.makeBots(5, (PokerServlet.numBots + 5));
       for(int i = 0; i < 5; i++) {
    	   System.out.print(b1.getBoardCards(i+1) + " ");
    	   if(i == 4) {
    		   System.out.println();
    	   }
       }
       for(int i = 0; i < PokerServlet.numBots; i++) {
    	   b.get(i).setCard1(PokerBot.convertToFaceCard(b1.boardCards.get((i*2)+5)));
    	   b.get(i).setCard2(PokerBot.convertToFaceCard(b1.boardCards.get((i*2)+6)));
    	   System.out.println(b.get(i).getCard1() + " " + b.get(i).getCard2());
       }
       PokerBot.getBestHands();
      
       Collections.sort(b, new Comparator<PokerBot>() {
    	    @Override
    	    public int compare(PokerBot bot1, PokerBot bot2) {
    	        int bestHandComparison = Integer.compare(bot2.getBestHand(), bot1.getBestHand());
    	        if (bestHandComparison != 0) {
    	            return bestHandComparison;
    	        }
    	        return Integer.compare(bot2.getHandId(), bot1.getHandId());
    	    }
    	});
       
       for(int i = 0; i < b.size(); i++) {
    	   System.out.println(b.get(i).getBestHand() + " " + b.get(i).getHandId() + " " + b.get(i).getName() + " " + b.get(i).getBestHandString());
       }
       
   }
   
   public static ArrayList<String> getImageSourceList() {
	   return imageSourceList;
   }
   
   public static ArrayList<PokerBot> getBotList() {
	   return b;
   }
   
   public static void endRound() {
	   Board.b1.resetAll();
	   b.clear();
   }
   
   public static void nextRound() {
	   
   }
  
}
