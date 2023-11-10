package pas.poker;

public class Main {
    
    public static void main(String[] args) {

        Deck deckOne = new Deck();
        PokerGame gameOne = new PokerGame(deckOne, 2);

        gameOne.runSimulation(100000);
        //gameOne.runGame();

    }

}
