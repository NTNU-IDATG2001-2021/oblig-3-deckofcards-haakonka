package no.ntnu.idatg2001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean flush()
    {
        return hand.stream().filter(card -> card.getSuit() == 'S').count() >= 5 ||
                hand.stream().filter(card -> card.getSuit() == 'H').count() >= 5 ||
                hand.stream().filter(card -> card.getSuit() == 'C').count() >= 5 ||
                hand.stream().filter(card -> card.getSuit() == 'D').count() >= 5;
    }

    public List<PlayingCard> amountOfHearts()
    {

        return hand.stream().filter(card -> card.getSuit() == 'H').collect(Collectors.toList());

    }

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

    public int calculateSumOfFaces()
    {
        return hand.stream().map(PlayingCard::getFace).reduce(0, Integer::sum);
    }

    public boolean hasQueenOfSpades()
    {
        return hand.stream().anyMatch(card -> card.getAsString().equalsIgnoreCase("12S"));
    }



}
