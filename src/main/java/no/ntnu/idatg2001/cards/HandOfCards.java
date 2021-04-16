package no.ntnu.idatg2001.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a hand of cards
 * The class has methods to check if the hand contains certain cards
 */
public class HandOfCards {

    private final ArrayList<PlayingCard> hand = new ArrayList<>();

    /**
     * Constructor for the hand of cards. Adds the cards from the deal hand method to an arraylist.
     * @param handToAdd from the dealHand method
     */
    public HandOfCards(ArrayList<PlayingCard> handToAdd) {

        hand.addAll(handToAdd);
    }

    /**
     * This method is used to return the current hand
     * @return the current hand of cards
     */
    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    /**
     * This method checks if the hand has 5 or more cards of the same suit
     * @return true if the hand has flush, false if not
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
