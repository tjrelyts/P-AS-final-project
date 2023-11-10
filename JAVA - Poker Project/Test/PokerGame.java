package pas.poker;

import java.util.ArrayList;
import java.util.Scanner;

public class PokerGame {
    
    private Deck deckOne;
    private ArrayList<PokerHand> playerHands;

    public PokerGame(Deck deckOne, int numHands) {
        this.deckOne = deckOne;
        this.playerHands = createHands(numHands);
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
		
        PokerHand evalHand = playerHands.get(0);

		for (int i = 0; i < numTrials; i++) {
			
			int result = evalHand.evaluateHand();
			
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
			
            evalHand.removeCards(5);
			deckOne.shuffleDeck();
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

    public void runGame() {

        Scanner pInput = new Scanner(System.in);
        int tempInt = 0;


        for (int i = 0; i < playerHands.size(); i++) {
            System.out.println(playerHands.get(i).getHandName() + " how many cards to remove?");
            tempInt = pInput.nextInt();
            if (tempInt > 5) {
                System.out.println("Cannot remove that many.");
            }
            playerHands.get(i).removeCards(tempInt);
        }

        
        playerHands.get(0).printDeck();
        playerHands.get(1).printDeck();

        playerHands.get(0).compareHands(playerHands.get(1));

    }

    private ArrayList<PokerHand> createHands(int numHands) {
        
        ArrayList<PokerHand> hands = new ArrayList<>();

        // Temporarily 2 players max
        if (numHands > 2) {
            System.out.println("Too many players.");
            System.exit(1);
        }

        for (int i = 0; i < numHands; i++) {
            hands.add(new PokerHand(deckOne, "\nHand " + i ));
        }

        return hands;
    }


}
