package pas.poker;

import java.util.ArrayList;
import java.util.Scanner;

public class PokerGame {

	private Dealer dealer;
	
	public PokerGame() {
		dealer = new Dealer();
	}
	
	public void runGame() {
		
		ArrayList<Card> handOne = dealer.drawFiveCards();
		ArrayList<Card> handTwo = dealer.drawFiveCards();
		Scanner pInput = new Scanner(System.in);
		
		System.out.println("Player 1 Hand");
		for (Card x : handOne) System.out.println(x.getSuit() + " " + x.getRank());
		System.out.println("\nPlayer 2 Hand");
		for (Card x : handTwo) System.out.println(x.getSuit() + " " + x.getRank());
		
		System.out.println("(P1) How many cards would you like to remove? ");
		int p1Remove = pInput.nextInt();
		
		System.out.println("(P2) How many cards would you like to remove? ");
		int p2Remove = pInput.nextInt();
		
		handOne = playerRemoveCard(handOne, p1Remove);
		handTwo = playerRemoveCard(handTwo, p2Remove);
		
		refillHand(handOne);
		
		refillHand(handTwo);
		
		System.out.println("Player 1 Hand");
		for (Card x : handOne) System.out.println(x.getSuit() + " " + x.getRank());
		System.out.println("\nPlayer 2 Hand");
		for (Card x : handTwo) System.out.println(x.getSuit() + " " + x.getRank());
		
		compareHands(dealer.evaluateHand(handOne), dealer.evaluateHand(handTwo));
		
	}
	
	public void compareHands(int caseOne, int caseTwo) {
		
		if (caseOne < caseTwo) {
			System.out.println("Player 2 wins.");
		} else if (caseOne > caseTwo) {
			System.out.println("Player 1 wins.");
		} else {
			System.out.println("Tie.");
		}
		
	}

	public ArrayList<Card> playerRemoveCard(ArrayList<Card> cardHand, int numRemove) {
		
		for (int i = 0; i < numRemove; i++) {
			cardHand.remove(0);
		}
		
		return cardHand;
		
	}
	
	public ArrayList<Card> refillHand(ArrayList<Card> cardHand) {
		
		while (cardHand.size() < 5) {
			cardHand.add(dealer.drawCard());
		}
		return cardHand;
		
	}
	
}
