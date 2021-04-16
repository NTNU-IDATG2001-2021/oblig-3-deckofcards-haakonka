package no.ntnu.idatg2001.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {
    DeckOfCards deckOfCards = new DeckOfCards();
    HandOfCards hand;

    /**
     * Method to add all the cards from a deck to hand before all tests. Useful for checking for flush and so forth.
     */
    @BeforeEach
    void beforeEach(){
        hand = deckOfCards.dealHand(52);
    }


    @Test
    @DisplayName("Testing that the deal hand and get hand method works as intended")
    void getHand() {
        assertEquals(52,hand.getHand().size());
    }


    @Test
    @DisplayName("Testing that the method returns true if the player has 5 or more cards of the same suit")
    void flush() {
        assertTrue(hand.flush());
        hand.getHand().clear();
        assertFalse(hand.flush());
    }

    @Test
    @DisplayName("Testing that the method gets the correct amount of heart cards")
    void amountOfHearts() {
        assertEquals(13,hand.amountOfHearts().size());
        hand.getHand().clear();
        assertEquals(0,hand.amountOfHearts().size());
    }


    @Test
    @DisplayName("Testing that the method gets the right sum")
    void calculateSumOfFaces() {
        assertEquals(364,hand.calculateSumOfFaces());
        hand.getHand().clear();
        assertEquals(0,hand.calculateSumOfFaces());
    }

    @Test
    @DisplayName("Testing that method returns true if queen of spades is on hand")
    void hasQueenOfSpades() {
        assertTrue(hand.hasQueenOfSpades());
        hand.getHand().clear();
        assertFalse(hand.hasQueenOfSpades());

    }
}