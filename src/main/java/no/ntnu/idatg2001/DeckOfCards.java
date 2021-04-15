package no.ntnu.idatg2001;

import java.util.ArrayList;

public class DeckOfCards {
    private final ArrayList<PlayingCard> deck = new ArrayList<>();
    private final ArrayList<PlayingCard> hand = new ArrayList<>();
    private final char[] suit = { 'S', 'H', 'D', 'C' };

    public DeckOfCards() {
        //This number sets the suit of the cards, 0 = Spades and so forth.
        for (int i=0; i<4; i++){
            //This creates 13 cards of each suit
            for (int j=1; j<14; j++){
                deck.add(new PlayingCard(suit[i],j));
            }

        }
    }
}
