package pas.poker;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cardDeck;
    private Random randNum;
	
	public Deck() {
        randNum = new Random();
		cardDeck = createDeck();
        shuffleDeck();
	}
	
    public ArrayList<Card> shuffleDeck() {

        ArrayList<Card> tempDeck = this.getDeck();

        for (int i = 0; i < tempDeck.size(); i++) {
            Card tempCard = tempDeck.get(randNum.nextInt(tempDeck.size()-1));
            getDeck().set(randNum.nextInt(tempDeck.size()-1), tempCard);
        }

        return tempDeck;

    }

    public void addCard(Card addCard) {
        this.getDeck().add(addCard);
    }

    public ArrayList<Card> removeCards(int numRemove) {

        ArrayList<Card> tempDeck = new ArrayList<>();

        if (this.getDeck().size() > 0) {
            for (int i = 0; i < numRemove; i++) {
                tempDeck.add(this.getDeck().remove(i));
            }
        }

        return tempDeck;

    }

    private ArrayList<Card> createDeck() {

        ArrayList<Card> tempDeck = new ArrayList<>();

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                Card tempCard = new Card(j, i);
                tempDeck.add(tempCard);
            }
        }
        return tempDeck;
    }

	public ArrayList<Card> getDeck() {
		return cardDeck;
	}
    
}

