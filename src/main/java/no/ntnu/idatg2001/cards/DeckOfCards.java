package no.ntnu.idatg2001.cards;

import java.util.ArrayList;
import java.util.Collections;
/**
 * This class represents a deck of cards without jokers.
 */
public class DeckOfCards {

    private final ArrayList<PlayingCard> deck = new ArrayList<>();
    private final ArrayList<PlayingCard> hand = new ArrayList<>();
    private final char[] suit = { 'S', 'H', 'D', 'C' };

    /**
     * Creates a deck with 52 cards.
     * 13 cards of each of the 4 suits using a nested for loop
     */
    public DeckOfCards() {
        for (int i=0; i<4; i++){

            for (int j=1; j<14; j++){

                deck.add(new PlayingCard(suit[i],j));
            }

        }
    }

    /**
     * This method is used to shuffle the deck
     */
    public void shuffle(){
        Collections.shuffle(deck);
    }

     /**
     * Method to deal a hand. Acquires randomness by having a shuffled deck
     * The method receives the number of cards it should draw from the deck as a parameter
     * Firstly it checks that there are enough cards in the deck
     * then it removes the cards on hand before it draws new cards to the hand
     * It then removes the cards that are drawn from the deck
     *
     * @param numberOfCards that will be dealt to the hand
     */

    public HandOfCards dealHand(int numberOfCards){

        if (numberOfCards>deck.size()){
            throw new IllegalArgumentException("There are not enough cards in the deck!");
        }
        hand.clear();
        for (int i = 0; i<numberOfCards; i++){
            hand.add(deck.get(i));
        }
        deck.removeAll(hand);

        return new HandOfCards(hand);
    }


}