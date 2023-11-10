package pas.poker;

import java.util.ArrayList;

public class PokerHand {
    
    private ArrayList<Card> hand;
    private Deck cardDeck;
    private String handName;

    public PokerHand(Deck cardDeck, String handName) {
        this.cardDeck = cardDeck;
        this.handName = handName;
        hand = drawCards(5);
        sortHand();
        printDeck();
    }

    public ArrayList<Card> drawCards(int numDrawn) {
        return cardDeck.removeCards(numDrawn);
    }

    public void drawOne() {
        this.hand.add(this.cardDeck.removeCards(1).get(0));
    }

    public void removeCards(int numRemove) {

        Card tempCard; 

        for (int i = 0; i < numRemove; i++) {
            tempCard = this.hand.remove(0);
            this.cardDeck.addCard(tempCard);
            printDeck();
        }

        refillHand();

    }

    public void refillHand() {

        if (hand.size() < 5) {
            for (int i = 0; i < 5; i++) {
                drawOne();
            }
        }

    }

    public void compareHands(PokerHand handTwo) {

        int resultOne = this.evaluateHand();
        int resultTwo = handTwo.evaluateHand();
        
        if (resultOne > resultTwo) {
            System.out.println(this.getHandName() + " beats " + handTwo.getHandName());
        } else if (resultOne < resultTwo) {
            System.out.println(this.getHandName() + " beats " + handTwo.getHandName());
        } else {
            System.out.println("No win.");
        }

    }

    public int evaluateHand() {

        ArrayList<Card> tempHand = this.hand;
        int rank = 0;
        sortHand();

        int cardCount = 0;
        int straightCount = 0;
        boolean straightFlush = false;

        for (int i = 1; i < tempHand.size(); i++) {
            if (tempHand.get(i).getRank() - tempHand.get(i-1).getRank() == 1) {
                straightCount++;
            }
        }

    	for (int i = 0; i < tempHand.size(); i++) {
			for (int j = i+1; j < tempHand.size(); j++) {				
				if (tempHand.get(i).getRank() == tempHand.get(j).getRank()) {
					cardCount++;
				}			
                if (tempHand.get(i).getSuit() == tempHand.get(j).getSuit() && straightCount == 4) {
                    straightFlush = true;
                }
			}
		}

        // Evaluates for Royal Flush (ACE = 12 and 10 = 8)
        if (straightFlush == true && tempHand.get(4).getRank() == 12 && tempHand.get(0).getRank() == 8) {
            rank = 9;
            System.out.println(getHandName() + " has Royal Flush");
        }

        // Evaluates for Straight Flush
        if (straightFlush == true) {
            rank = 8;
            System.out.println(getHandName() + " has Straight Flush");
        }

        // Evaluates for high card
        if (cardCount == 0) {
            rank = 0;
            System.out.println(getHandName() + " has High Card");
        }
        // Evaluates for a pair
    	if (cardCount == 1) {
            rank = 1;
            System.out.println(getHandName() + " has Pair");
        }         
        // Evaluates for Two Pair
        else if (cardCount == 2) {
            rank = 2;
            System.out.println(getHandName() + " has Two Pair");
        }
        // Evaluates for Three of a Kind 
        else if (cardCount == 3) {
            rank = 3;
            System.out.println(getHandName() + " has Three of a Kind");
        } 
        // Evaluates for Straight
        else if (straightCount == 4) {
            rank = 4;
            System.out.println(getHandName() + " has Straight");
        }
        // Evaluates for Flush
        else if (cardCount == 10) {
            rank = 5;
            System.out.println(getHandName() + " has Flush");
        }
        // Evaluates for Full House
        else if (cardCount == 4) {
            rank = 6;
            System.out.println(getHandName() + " has Full House");
        }
        // Evaluates for Four of a Kind
        else if (cardCount == 6) {
            rank = 7;
            System.out.println(getHandName() + " has Four of a Kind");
        }
            
        return rank;
    }

    private ArrayList<Card> sortHand() {

        ArrayList<Card> tempHand = this.hand;
        Card tempCard;
        int minIndex;

        for (int i = 0; i < tempHand.size(); i++) {
            minIndex = i;
            for (int j = i; j < tempHand.size(); j++) {
                if (tempHand.get(minIndex).getRank() > tempHand.get(j).getRank()) {
                    minIndex = j;
                }
            }
            tempCard = tempHand.get(minIndex);
            tempHand.set(minIndex, tempHand.get(i));
            tempHand.set(i, tempCard);
        }

        return tempHand;
    }

    public void printDeck() {
        System.out.println(handName);
        for (int i = 0; i < hand.size(); i++) {
            if (i == hand.size() - 1) {
                System.out.print(hand.get(i).getSuit() + " " + hand.get(i).getRank());
            }else {
                System.out.print(hand.get(i).getSuit() + " " + hand.get(i).getRank() + ", ");
            }
        }
    }

    public String getHandName() {
        return handName;
    }

}
