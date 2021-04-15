package no.ntnu.idatg2001.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/**
 * This class represents a deck of cards without jokers.
 * The class also contains methods to check if the hand contains certain cards
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
     * This method is used to return the current hand
     * @return the current hand of cards
     */
    public ArrayList<PlayingCard> getHand() {
        return hand;
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
     *
     * @param numberOfCards that will be dealt to the hand
     */

    public void dealHand(int numberOfCards){

        if (numberOfCards>deck.size()){
            throw new IllegalArgumentException("There are not enough cards in the deck!");
        }
        hand.clear();
        for (int i = 0; i<numberOfCards; i++){
            hand.add(deck.get(i));
            deck.removeAll(hand);
        }
    }

    /**
     *  Checks if the hand contains a flush (5 cards of the same suit)
     * @return true if player has 5 cards of the same suit, false if not
     */
    public boolean flush()
    {
        return  hand.stream().filter(card -> card.getSuit() == 'S').count() >= 5 ||
                hand.stream().filter(card -> card.getSuit() == 'H').count() >= 5 ||
                hand.stream().filter(card -> card.getSuit() == 'C').count() >= 5 ||
                hand.stream().filter(card -> card.getSuit() == 'D').count() >= 5;
    }

    /**
     * Checks how many hearts there is on the current hand and adds the cards to a list
     * @return list with the cards of the hearts suit
     */
    public List<PlayingCard> amountOfHearts()
    {

        return hand.stream().filter(card -> card.getSuit() == 'H').collect(Collectors.toList());

    }

    /**
     * This method returns the heart cards on the hand in a String
     * @param cardsToCheck
     * @return String with the cards of the heart suit
     */
    public String hearts(List<PlayingCard> cardsToCheck)
    {

        StringBuilder stringBuilder = new StringBuilder();

        for (PlayingCard playingCard : cardsToCheck)
        {
            stringBuilder.append(playingCard.getAsString()).append(" ");
        }

        if (cardsToCheck.size()==0){
            stringBuilder.append("No hearts in sight!");}


        return stringBuilder.toString();
    }

    /**
     * This method calculates the sum of the cards on hand. From Ace = 1 to King = 13
     * @return the sum of cards
     */
    public int calculateSumOfFaces()
    {
        return hand.stream().map(PlayingCard::getFace).reduce(0, Integer::sum);
    }

    /**
     * This method checks if the hand contains the card Queen of spades
     * @return true if hand has Queen of spades, false if not
     */
    public boolean hasQueenOfSpades()
    {
        return hand.stream().anyMatch(card -> card.getAsString().equalsIgnoreCase("12S"));
    }



}
