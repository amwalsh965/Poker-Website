package com.journaldev.first;
import java.util.*;


public class PokerBot implements Comparable<PokerBot>{
   private String firstCard;
   private String secondCard;
   private int chips;
   private int bestHand;
   private String bestHandString;
   private String name;
   private int handId;
   private ArrayList<Integer> cardList = new ArrayList<Integer>();
   public static ArrayList<Integer> emptyArray1 = new ArrayList<Integer>();

   //public ArrayList<Integer> cardListList = new ArrayList<Integer>();
   //TODO work on getting ace to act as high and low card
   public PokerBot() {
      firstCard = "0";
      secondCard = "0";
      chips = PokerMain.startingChips;
      bestHand = 0;
      bestHandString = "";
      handId = 0;
      name = "bot";
      cardList = emptyArray1;
   }
   
   public PokerBot(int i) {
      firstCard = "0";
      secondCard = "0";
      chips = PokerMain.startingChips;
      bestHand = 0;
      bestHandString = "";
      handId = 0;
      name = "bot"+(i);
      cardList = emptyArray1;
   }
   
   /* hands are written as integers, with the best hands having higher integers, and worse hands having lower integers
   1st: identifies the hand type ex. 0 is high card, 9 is royalFlush
   2nd and 3rd: identifies what highest card type is (for every hand)
   4th and 5th: is next highest card type if necessary
   6th and 7th: final highest card type if necessary 
   8th and 9th: more
   10th and 11th: more 
   */
   
//methods for bot data

   //returns bots first card
   
   @Override
   public String toString() {
       // TODO Auto-generated method stub
       return this.name;
   }
   
   @Override
   public int compareTo(PokerBot other) {
       if (this.getBestHand() < other.getBestHand()) return -1;
       if (this.getBestHand() > other.getBestHand()) return 1;
       return 0;
   }

   public void printHandId() {
      System.out.println(this.handId);
   }
   
   public Integer getHandId() {
	   return this.handId;
   }

   public String getBestHandString() {
	   return this.bestHandString;
   }
   
   public void setBestHandString(String a) {
	   this.bestHandString = a;
   }
   
   public void setCardList(ArrayList<Integer> a) {
      this.cardList = a;
   }

   public ArrayList<Integer> getCardList() {
      return this.cardList;
   }

   public static void makeBots(int start, int end) {
      System.out.println();
	   for(int i = start; i < end; i++) {
         PokerBot pB = new PokerBot(i-4);
         PokerMain.b.add(pB);
      }      
      System.out.println(PokerMain.b);
   } 
   
   public static int getNumBots() {
      return PokerMain.b.size();
   }
   
   public String getCard1() {
      return this.firstCard;
   }
   
   //gets bots second card
   public String getCard2() {
      return this.secondCard;
   }
   
   public static ArrayList<String> getAllBotCards() {
      ArrayList<String> tempList = new ArrayList<String>();
      for(int i = 0; i < PokerMain.numBots; i++) {
         System.out.println(PokerMain.b.get(i).getCard1() + " " + PokerMain.b.get(i).getCard2());
      }
      return tempList;
   }
   
   //returns the bots best hand in combination with the board
   public Integer getBestHand() {
      return this.bestHand;
   }
   
   //sets the best hade for a player. is only meant to be used in other functions
   private void setBestHand(int num) {
      this.bestHand = num;
   }
   
   //returns the chips a bot has
   public int getChips() {
      return chips;
   }
   
   //sets a bots cards
   public void setCard1(String fC) {
      this.firstCard = fC;
   }
   
   public void setCard2(String sC) {
      this.secondCard = sC;
   }
   
   //sets a bots chip amount
   public void setChips(int c) {
      chips = c;
   }
   
   public String getName() {
	   return this.name;
   }
   
//seeing what peoples highest hands are  
   public int counter = 0;
   public static ArrayList<Integer> tempList = new ArrayList<Integer>();
   ArrayList<Integer> list = new ArrayList<Integer>(); 

   private void junk(ArrayList<Integer> cardListList) {
      this.createHandId(getNthDigits(cardListList.get(0), 'c'), getNthDigits(cardListList.get(1), 'c'), getNthDigits(cardListList.get(2), 'c'), getNthDigits(cardListList.get(3), 'c'), getNthDigits(cardListList.get(4), 'c'));
   }
   
   //Need to make this more efficient. I think there is a way to do it with one method, and only looking at pairs, straights, and flushes.
   //At the very least I can scale them down to two methods, one for the pair hands, and one with the run hands
  
   private boolean pair(ArrayList<Integer> cardListList) {
      counter = 0;
      ArrayList<Integer> tempList = new ArrayList<Integer>(cardListList);
      int pairCard = 0;
      for(int i = 0; i < 7-1; i++) {
         if(getNthDigits(tempList.get(i), 'c') == getNthDigits(tempList.get(i+1), 'c')) {
            if(counter == 0) {
               counter++;
            }
            counter++;
            if(counter == 2) {
               pairCard = tempList.get(i);
               tempList.remove(i+1);
               tempList.remove(i);
               this.createHandId(0, getNthDigits(pairCard, 'c'), getNthDigits(tempList.get(0), 'c'), getNthDigits(tempList.get(1), 'c'), getNthDigits(tempList.get(2), 'c'));
               return true;
            }
         } else {
            counter = 0;
         }
      }
      
      return false;
   }
   
   private boolean twoPair(ArrayList<Integer> cardListList) {
      tempList = cardListList;
      list.clear();
      ArrayList<Integer> list2 = new ArrayList<Integer>();
      for(int i = 0; i < 6; i++) {
         if(getNthDigits(tempList.get(i), 'c') == getNthDigits(tempList.get(i+1), 'c')) {
        	 list.add(i);
        	 list.add(i+1);
             list2.add(getNthDigits(tempList.get(i), 'c'));
        } 
      }
      
         if(list2.size() >= 2) {
            tempList.remove(list.get(3) + 0);
            tempList.remove(list.get(2) + 0);
            tempList.remove(list.get(1) + 0);
            tempList.remove(list.get(0) + 0);
            System.out.println(tempList);
            this.createHandId(0, 0, list2.get(0), list2.get(1), getNthDigits(tempList.get(0), 'c'));
            return true;
         }

      return false;
   }
   
   private boolean threeOfKind(ArrayList<Integer> cardListList) {
      counter = 0;
      tempList = cardListList;
      int threeOfKindCard = 0;
      for(int i = 0; i < 7-1; i++) {
         if(getNthDigits(tempList.get(i), 'c') == getNthDigits(tempList.get(i+1), 'c')) {
            if(counter == 0) {
               counter++;
            }
            counter++;
            if(counter == 3) {
               threeOfKindCard = tempList.get(i);
               tempList.remove(i+1);
               tempList.remove(i);
               tempList.remove(i-1);
               this.createHandId(0, 0, threeOfKindCard, getNthDigits(tempList.get(0), 'c'), getNthDigits(tempList.get(1), 'c'));
               return true;
            }
         } else {
            counter = 0;
         }
      }
      return false;
   }
   
   private boolean straight(ArrayList<Integer> cardListList) {
      counter = 0;
      
      ArrayList<Integer > tempListDif = new ArrayList<Integer>(cardListList);
      for(int i = tempListDif.size()-1; i >= 1; i--) {
    	  if((getNthDigits(tempListDif.get(i), 'c')) == (getNthDigits(tempListDif.get(i-1), 'c'))) {
    		  tempListDif.remove(i);
    	  }
      }
      for(int i = 0; i < tempListDif.size()-1; i++) {
            if(getNthDigits(tempListDif.get(i), 'c') == (getNthDigits(tempListDif.get(i+1), 'c') + 1)) {
               if(counter == 0) {
                  counter++;
               }
               counter++;
               if(counter == 5) {
                  this.createHandId(getNthDigits(tempListDif.get(i-3), 'c'));
                  return true;
               }
            } else {
               counter = 0;
            }
         } 
      return false;
   }
   
   private int forFlush(int suite, ArrayList<Integer> list) {
      for(int j = 0; j < 7; j++) {
         if(getNthDigits(list.get(j), 's') == suite) {
            this.createHandId(getNthDigits(list.get(j), 'c'));
            return -1;
         }
      }
      return -1;
   }

   private boolean flush(ArrayList<Integer> cardListList) {
   int counterH = 0;
   int counterS = 0;
   int counterD = 0;
   int counterC = 0;
      for(int i = 0; i < 7; i++) {
         if(getNthDigits(cardListList.get(i), 's') == 0) {
            counterH++;
         } else if(getNthDigits(cardListList.get(i), 's') == 1) {
            counterS++;
         } else if(getNthDigits(cardListList.get(i), 's') == 2) {
            counterD++;
         } else if(getNthDigits(cardListList.get(i), 's') == 3) {
            counterC++;
         }
         if(counterH >= 5) {
            this.forFlush(0, cardListList);
            return true;
         } else if(counterS >= 5) {
            this.forFlush(1, cardListList);
            return true;
         } else if(counterD >= 5) {
            this.forFlush(2, cardListList);
            return true;
         } else if(counterC >= 5) {
            this.forFlush(3, cardListList);
            return true;
         }
      }
      return false;
   } 
   
   private boolean fullHouse(ArrayList<Integer> cardListList) {
      boolean a = false;
      boolean b = false;
      int indexa = 0;
      int indexb = 0;
      counter = 0;
      list.clear();
      ArrayList<Integer> list2 = new ArrayList<Integer>();
      for(int i = 0; i < 7 - 1; i++) {
         if(getNthDigits(cardListList.get(i), 'c') == getNthDigits(cardListList.get(i+1), 'c')) {
            if(counter == 0) {
               counter++;
            }
            counter++;
            } else {
                 list.add(counter);
                 list2.add(i);
                 counter = 0;
            } 
      }
      for(int i = list.size() - 1; i > 0; i--) {
    	  if(list.get(i) < 2) {
    		  list.remove(i);
    		  list2.remove(i);
    	  }
      }
      for(int i = 0; i < list.size(); i++) {
    	  if(list.get(i) == 3) {
    		  a = true;
    		  indexa = list2.get(i);
    		  break;
    	  }
      }
      for(int i = 0; i < list.size(); i++) {
    	  if(list.get(i) == 2) {
    		  b = true;
    		  indexb = list2.get(i);
    		  break;
    	  }
      }
      
      if(a == false || b == false) {
    	  return false;
      }
	    this.createHandId(0, 0, 0, getNthDigits(cardListList.get(indexa), 'c'), getNthDigits(cardListList.get(indexb), 'c'));
	    return true;
   }
   
   private boolean straightFlush(ArrayList<Integer> cardListList) {
      counter = 0;
      
      ArrayList<Integer > tempListDif = new ArrayList<Integer>(cardListList);
      for(int i = tempListDif.size()-1; i >= 1; i--) {
    	  if((getNthDigits(tempListDif.get(i), 'c')) == (getNthDigits(tempListDif.get(i-1), 'c'))) {
    		  tempListDif.remove(i);
    	  }
      }
      for(int i = 0; i < tempListDif.size() - 1; i++) {
            if((getNthDigits(tempListDif.get(i), 'c') == getNthDigits(tempListDif.get(i+1), 'c') + 1 && (getNthDigits(tempListDif.get(i), 's') == getNthDigits(tempListDif.get(i+1), 's')))) {
               if(counter == 0) {
                  counter++;
               }
               counter++;
               if(counter == 5) {
                  this.createHandId(getNthDigits(tempListDif.get(i-3), 'c'));
                  return true;
            } 
         } 
      } 
      return false;
   }
   
   private boolean fourOfKind(ArrayList<Integer> cardListList) {
      counter = 0;
      tempList = cardListList;
      int fourOfKindCard = 0;
      for(int i = 0; i < 7-1; i++) {
         if(getNthDigits(tempList.get(i), 'c') == getNthDigits(tempList.get(i+1), 'c')) {
            if(counter == 0) {
               counter++;
            }
            counter++;
            if(counter == 4) {
               fourOfKindCard = getNthDigits(tempList.get(i), 'c');
               tempList.remove(i+1);
               tempList.remove(i);
               tempList.remove(i-1); 
               tempList.remove(i-2); 
               this.createHandId(fourOfKindCard, getNthDigits(tempList.get(0), 'c'), 0, 0, 0);
               return true;
            }
         } else {
            counter = 0;
         }
      }
      return false;
   }
   
   private boolean royalFlush(ArrayList<Integer> cardListList) {
      counter = 0;
      if((getNthDigits(cardListList.get(0), 'c') == 1) && (getNthDigits(cardListList.get(0), 's') == getNthDigits(cardListList.get(1), 's'))) {
         counter++;
         for(int i = 1; i < 7-2; i++) {
            if((getNthDigits(cardListList.get(i), 'c') == getNthDigits(cardListList.get(i+1) - 1, 'c') && (getNthDigits(cardListList.get(i), 's') == getNthDigits(cardListList.get(i+1), 's')))) {
               counter++;
               if(counter == 5) {
                  this.createHandId(14);
                  return true;
               } else {
                  return false;
               }
            } 
         }
      } else {
      return false;
      }
      return false;
   }
   
   private static int getNthDigits(int number, char cardOrSuite) {    
      if(cardOrSuite == 'c') {
         return (number - (number % 10))/10;
      } else if (cardOrSuite == 's') {
         return number % 10;
      } else {
         return 000000;
      }
   }

   //checks a bots best hand
   public static void checkHand(int i, ArrayList<Integer> cardListList) {
      if(PokerMain.b.get(i).royalFlush(cardListList) == true) {
         PokerMain.b.get(i).setBestHand(9);
         PokerMain.b.get(i).setBestHandString("Royal Flush");
         System.out.println("Bot has royal flush");
      } else if (PokerMain.b.get(i).fourOfKind(cardListList) == true) {
         PokerMain.b.get(i).setBestHand(8);
         PokerMain.b.get(i).setBestHandString("Four Of A Kind");
         System.out.println("Bot has four of a kind");
      } else if (PokerMain.b.get(i).straightFlush(cardListList) == true) {
         PokerMain.b.get(i).setBestHand(7);
         PokerMain.b.get(i).setBestHandString("Straight Flush");
         System.out.println("Bot has straight flush");
      } else if (PokerMain.b.get(i).fullHouse(cardListList) == true) {
         PokerMain.b.get(i).setBestHand(6);
         PokerMain.b.get(i).setBestHandString("Full House");
         System.out.println("Bot has full house");
      } else if (PokerMain.b.get(i).flush(cardListList) == true) {
         PokerMain.b.get(i).setBestHand(5);
         PokerMain.b.get(i).setBestHandString("Flush");
         System.out.println("Bot has flush");
      } else if (PokerMain.b.get(i).straight(cardListList) == true) {
         PokerMain.b.get(i).setBestHand(4);
         PokerMain.b.get(i).setBestHandString("Straight");
         System.out.println("Bot has straight");
      } else if (PokerMain.b.get(i).threeOfKind(cardListList) == true) {
         PokerMain.b.get(i).setBestHand(3);
         PokerMain.b.get(i).setBestHandString("Three Of A Kind");
         System.out.println("Bot has three of a kind");
      } else if (PokerMain.b.get(i).twoPair(cardListList) == true) {
         PokerMain.b.get(i).setBestHand(2);
         PokerMain.b.get(i).setBestHandString("Two Pair");
         System.out.println("Bot has two pair");
      }else if (PokerMain.b.get(i).pair(cardListList) == true) {
         PokerMain.b.get(i).setBestHand(1);
         PokerMain.b.get(i).setBestHandString("Pair");
         System.out.println("Bot has pair");
      } else {
         PokerMain.b.get(i).junk(cardListList);
         PokerMain.b.get(i).setBestHand(0);
         PokerMain.b.get(i).setBestHandString("Junk");
         System.out.println("Bot has junk");
      }
   }
  
   private static int convertSuitToNum(char a) {
      if(a == 'h') {
         return 0;
      } else if(a == 's') {
         return 1;
      } else if(a == 'c') {
         return 2;
      } else if(a == 'd') {
         return 3;
      } 
      System.out.println(a);
      return -1;
   }
   
   
   //takes a bots cards and the boards cards and sorts them in descending order
   public ArrayList<Integer> sortCards(Board b1) {
      ArrayList<Integer> activeCards = new ArrayList<Integer>();
      ArrayList<String> totalCardList = new ArrayList<String>();
      totalCardList.addAll(b1.getAllBoardCards());
      totalCardList.add(this.getCard1());
      totalCardList.add(this.getCard2());
      for(int j = 0; j < 7; j++) {
         if((totalCardList.get(j).substring(0, 1).equals("1")) && !(totalCardList.get(j).substring(0, 2).equals("10"))) {
            totalCardList.set(j, "14" + totalCardList.get(j).substring(1, 2));
         } else if(totalCardList.get(j).substring(0,1).equals("J")) {
            totalCardList.set(j, "11" + totalCardList.get(j).substring(1,2));
         } else if (totalCardList.get(j).substring(0,1).equals("Q")) {
            totalCardList.set(j, "12" + totalCardList.get(j).substring(1,2));
         } else if (totalCardList.get(j).substring(0,1).equals("K")) {
            totalCardList.set(j, "13" + totalCardList.get(j).substring(1,2));
         }
         
      }
      int a;
      int b;
      String c;
      for(int i = 0; i < 7; i++) {
         if(totalCardList.get(i).length() == 3) {
            c = totalCardList.get(i);
            b = Integer.valueOf(c.substring(0, 2));
            a = convertSuitToNum(c.charAt(2));
            c = "" + b + a;
            a = Integer.parseInt(c);
            activeCards.add(a);
         } else {
            c  = totalCardList.get(i);
            b = Integer.valueOf(c.substring(0, 1));
            a = convertSuitToNum(c.charAt(1));
            c = "" + b + a;
            a = Integer.parseInt(c);
            activeCards.add(a);
         }
      }
      Collections.sort(activeCards, Collections.reverseOrder());
      System.out.println("For " + this.name + "\n" + activeCards);
      this.setCardList(activeCards);
      return activeCards;
   }
 
   public static void getBestHands() {
      ArrayList<ArrayList<Integer>> sortedCards = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> handNumList = new ArrayList<Integer>();
      ArrayList<PokerBot> bestHandsList = new ArrayList<PokerBot>();
      int bestHand = 0;
      for(int i = 0; i < PokerServlet.numBots; i++) {
         sortedCards.add(PokerMain.b.get(i).sortCards(Board.b1));
         checkHand(i, sortedCards.get(i));
         handNumList.add(PokerMain.b.get(i).getBestHand());
      }
      for(int i = 0; i < handNumList.size(); i++) {
         if(handNumList.get(i) == bestHand) {
            bestHandsList.add(PokerMain.b.get(i));
         } else if(handNumList.get(i) > bestHand) {
            bestHand = handNumList.get(i);
            bestHandsList.clear();
            bestHandsList.add(PokerMain.b.get(i));
         } 
      }

      //return bestHandsList;
   }


   public static String convertToFaceCard(String card) {
      if(card.charAt(0) == '1' && card.charAt(1) == '1')  {
         return "J" + card.charAt(2);
      } else if (card.charAt(0) == '1' && card.charAt(1) == '2') {
         return "Q" + card.charAt(2);
      } else if (card.charAt(0) == '1' && card.charAt(1) == '3') {
         return "K" + card.charAt(2);
      }
      return card;
   }
  /* 
   public static void giveCards(Board b1) {
      for(int i = 0; i < PokerMain.numBots; i++){
         int num = (int)(Math.random() * (52 - Board.cardsInPlay));
         String card = b1.deck.get(num);
         PokerMain.b.get(i).setCard1(convertToFaceCard(card));
         b1.deck.remove(num);
         Board.cardsInPlay += 1;
         
         num = (int)(Math.random() * (52 - Board.cardsInPlay));
         card = b1.deck.get(num);
         PokerMain.b.get(i).setCard2(convertToFaceCard(card));
         b1.deck.remove(num);
         Board.cardsInPlay += 1;
      }
   }
   */
   
   private void createHandId(int highCard, int secondHighCard, int thirdHighCard, int fourthHighCard, int fifthHighCard) {
      int id = 0;
      id = (highCard*100000000)+(secondHighCard*1000000)+(thirdHighCard*10000)+(fourthHighCard*100)+(fifthHighCard);
      System.out.print(id + " ");
      this.handId = id;
   }

   private void createHandId(int highCard) {
      int id = 0;
      id = highCard;
      System.out.print(id + " ");
      this.handId = id;
   }

   public static ArrayList<PokerBot> getWinners(ArrayList<PokerBot> temp) {
      ArrayList<PokerBot> winners = new ArrayList<PokerBot>();
      int bestId = 0;
      for(int i = 0; i < temp.size(); i++) {
         if(temp.get(i).handId == bestId) {
            winners.add(temp.get(i));
         } else if(temp.get(i).handId > bestId) {
            bestId = temp.get(i).handId;
            winners.clear();
            winners.add(temp.get(i));
         }
      }
      System.out.println();
      return winners;

   }

   //actions
   public void check() {

   }

   public void fold() {

   }

   public int previousBet = 0;

   public int bet(int betAmount) {
      if(betAmount > (2*previousBet)) {
         if(betAmount > this.chips) {
            betAmount = this.chips;
            this.chips = 0;
            return betAmount;
         } else if(betAmount < 0) { 
            this.check();
            return -1;
         } else {
            this.chips -= betAmount;
            return betAmount;
         }
      } else {
         System.out.println("Can't raise less than 2 times previous bet");
      }
      return -1;
   }
}
