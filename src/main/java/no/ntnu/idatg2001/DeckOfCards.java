package no.ntnu.idatg2001;

import java.util.ArrayList;
import java.util.Collections;

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
    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    //A method to deal a hand. Acquires randomness by having a shuffled deck
    public void dealHand(int i){
        //checks that there are enough cards in the deck
        if (i>deck.size()){
            throw new IllegalArgumentException("There are not enough cards in the deck!");
        }
        //clears the hand
        hand.clear();
        //moves the top 5 cards in the deck to hand
        for (i = 0; i<5; i++){
            hand.add(deck.get(i));
            deck.removeAll(hand);
        }
    }



}
