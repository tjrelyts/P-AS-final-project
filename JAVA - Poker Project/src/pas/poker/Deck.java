package pas.poker;

import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> cardDeck;
	
	public Deck() {
		cardDeck = new ArrayList<>();
		
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                Card tempCard = new Card(j, i);
                cardDeck.add(tempCard);
            }
        }
	}
	
	public ArrayList<Card> shuffleDeck() {

		cardDeck = new ArrayList<>();
		
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                Card tempCard = new Card(j, i);
                cardDeck.add(tempCard);
            }
        }
		
        return cardDeck;
	}
	
	public ArrayList<Card> removeCard(int cardPos) {
		
		cardDeck.remove(cardPos);
		return cardDeck;
		
	}
	
	public ArrayList<Card> getDeck() {
		return cardDeck;
	}
	
}
