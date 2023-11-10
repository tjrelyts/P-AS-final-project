package pas.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dealer {
	
	private Deck cardDeck;
	private Random randNum;	
	
	public Dealer() {
		cardDeck = new Deck();
		randNum = new Random();
	}
	
	public ArrayList<Card> drawFiveCards() {
		
		ArrayList<Card> newDeck = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			int r = randNum.nextInt(cardDeck.getDeck().size()-i);
			newDeck.add(cardDeck.getDeck().get(r));
			cardDeck.removeCard(r);
		}
		
		return newDeck;
		
	}
	
	public Card drawCard() {
		
		int r = randNum.nextInt(cardDeck.getDeck().size()-1);
		Card newCard = cardDeck.getDeck().get(r);
		cardDeck.removeCard(r);
		
		return newCard;
		
	}
	
	public void runSimulation(int numTrials) {
		
		double noWin = 0;
		double pairWin = 0;
		double threeWin = 0;
		double fourWin = 0;
		double flushWin = 0;
		double pairThreeWin = 0;
		double twoPairWin = 0;
		double straightWin = 0;
		
		for (int i = 0; i < numTrials; i++) {
			
			int result = evaluateHand(drawFiveCards());
			
			if (result == 1) {
				pairWin++;
			} else if (result == 3) {
				threeWin++;
			} else if (result == 7) {
				fourWin++;
			} else if (result == 5) {
				flushWin++;
			} else if (result == 6) {
				pairThreeWin++;
			} else if (result == 2) {
				twoPairWin++;
			} else if (result == 4) {
				straightWin++;
			} else {
				noWin++;
			}
			
			cardDeck.shuffleDeck();
		}		
		
		System.out.println("No Case Win Rate: " + noWin/numTrials);
		System.out.println("Pair Win Rate: " + pairWin/numTrials);
		System.out.println("Three of a Kind Win Rate: " + threeWin/numTrials);
		System.out.println("Four of a Kind Win Rate: " + fourWin/numTrials);
		System.out.println("Flush Win Rate: " + flushWin/numTrials);
		System.out.println("Pair and Three of a Kind Win Rate: " + pairThreeWin/numTrials);
		System.out.println("Two Pair Win Rate: " + twoPairWin/numTrials);
		System.out.println("Straight Win Rate: " + straightWin/numTrials);
			
	}
	
	public Deck getDeck() {
		return cardDeck;
	}
	
	public int evaluateHand(ArrayList<Card> cardHand) {
		
		if (evaluateAnyPair(cardHand)) {
			System.out.println("Has pair.");
			return 1;
		} else if (evaluateThreeOfKind(cardHand)) {
			System.out.println("Has Three of a Kind.");
			return 3;
		} else if (evaluateFourOfKind(cardHand)) {
			System.out.println("Has Four of a Kind.");
			return 7;
		} else if (evaluateFlush(cardHand)) {
			System.out.println("Has Flush.");
			return 5;
		} else if (evaluatePairAndThreeOfKind(cardHand)) {
			System.out.println("Has Pair and Three of a Kind.");
			return 6;
		} else if (evaluateTwoPairs(cardHand)) {
			System.out.println("Has Two Pairs.");
			return 2;
		} else if (evaluateStraight(cardHand)) {
			System.out.println("Has Straight.");
			return 4;
		} else {
			System.out.println("Has High Card.");
			return 0;
		}


	}
	
	private boolean evaluateAnyPair(ArrayList<Card> cardHand) {	
    	int cardCount = 0;
    	for (int i = 0; i < cardHand.size(); i++) {
			for (int j = i+1; j < cardHand.size(); j++) {				
				if (cardHand.get(i).getRank() == cardHand.get(j).getRank()) {
					cardCount++;
				}			
			}
		}
    	if (cardCount == 1) {
    		return true;
    	}
    	return false;	
    }

	private boolean evaluateThreeOfKind(ArrayList<Card> cardHand) {
    	int cardCount = 0;
    	for (int i = 0; i < cardHand.size(); i++) {
			for (int j = i+1; j < cardHand.size(); j++) {				
				if (cardHand.get(i).getRank() == cardHand.get(j).getRank()) {
					cardCount++;
				}			
			}
		}
    	if (cardCount == 3) {
    		return true;
    	}
    	return false;	
    }
    
	private boolean evaluateFourOfKind(ArrayList<Card> cardHand) {
    	int cardCount = 0;
    	for (int i = 0; i < cardHand.size(); i++) {
			for (int j = i+1; j < cardHand.size(); j++) {				
				if (cardHand.get(i).getRank() == cardHand.get(j).getRank()) {
					cardCount++;
				}			
			}
		}
    	if (cardCount == 6) {
    		return true;
    	}
    	return false;	
    }
    
	private boolean evaluateFlush(ArrayList<Card> cardHand) {
    	int cardCount = 0;
    	for (int i = 0; i < cardHand.size(); i++) {
			for (int j = i+1; j < cardHand.size(); j++) {				
				if (cardHand.get(i).getSuit() == cardHand.get(j).getSuit()) {
					cardCount++;
				}						
			}
		}
    	if (cardCount == 10) {
    		return true;
    	}
    	return false;	
    }
    
	private boolean evaluatePairAndThreeOfKind(ArrayList<Card> cardHand) {
    	int cardCount = 0;
    	for (int i = 0; i < cardHand.size(); i++) {
			for (int j = i+1; j < cardHand.size(); j++) {				
				if (cardHand.get(i).getRank() == cardHand.get(j).getRank()) {
					cardCount++;
				}			
			}
		}
    	if (cardCount == 4) {
    		return true;
    	}
    	return false;	
    }
	
	private boolean evaluateTwoPairs(ArrayList<Card> cardHand) {
    	int cardCount = 0;
    	for (int i = 0; i < cardHand.size(); i++) {
			for (int j = i+1; j < cardHand.size(); j++) {				
				if (cardHand.get(i).getRank() == cardHand.get(j).getRank()) {
					cardCount++;
				}			
			}
		}
    	if (cardCount == 2) {
    		return true;
    	}
    	return false;	
    }
    
	private boolean evaluateStraight(ArrayList<Card> cardHand) {
    	int cardCount = 0;
    	ArrayList<Integer> cardRanks = new ArrayList<Integer>();
    	for (int i = 0; i < cardHand.size(); i++) {
    		cardRanks.add(cardHand.get(i).getRank());
    	}
    	Collections.sort(cardRanks);
    	for (int i = 1; i < cardRanks.size(); i++) {
    		if (cardRanks.get(i) - cardRanks.get(i-1) == 1) {
    			cardCount++;
    		}
    	}
    	if (cardCount == 4) {
    		return true;
    	}
    	return false;	
	}
   
   /* 
    public boolean evaluateStraightFlush(ArrayList<PokerCard> hand) {
    	int counter = 0;
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	for (int i = 0; i < hand.size(); i++) {
    		temp.add(hand.get(i).getNumber());	
    		for (int p = 0; p < hand.size();p++) {
    			if(hand.get(i).getSuite()!= hand.get(p).getSuite()){
    				return false;
    			}
    		}
    	}
    	
    	Collections.sort(temp);
    	
    	for (int j = 1; j < temp.size(); j++) {
    		if(temp.get(j)- temp.get(j-1)==1) {
    			counter++; 			
    		}
    	}
    
    	if (counter == 4) {
    		return true;
    	}
    	return false;
    }
    
    public boolean evaluateFullHouse(ArrayList<PokerCard> hand) {
    	boolean threeOfKind = false;
    	boolean pair = false;
    	int count = 0;
    	int tempNum = 0;
    	for (int i = 0; i < hand.size(); i++) {
    		for (int j = i + 1; j < hand.size(); j++) {
    			if (hand.get(i).getNumber() == hand.get(j).getNumber() && pair == false) {
    				pair = true;
    				tempNum = hand.get(i).getNumber();
    			}
    		}	
    	}
    	
    	for (int i = 0; i < hand.size(); i++) {
    		for (int j = i + 1; j < hand.size(); j++) {
	    		if (hand.get(i).getNumber() == hand.get(j).getNumber()) {
	    			if (hand.get(i).getNumber() != tempNum) {
	    				count++;
	    			}
	    		}  	
    		}
    	}
    	if (count == 3) {
        	threeOfKind = true;
        }
    	if (threeOfKind && pair) {
    		return true;
    	}
    	return false;
    }
	*/
	
}
