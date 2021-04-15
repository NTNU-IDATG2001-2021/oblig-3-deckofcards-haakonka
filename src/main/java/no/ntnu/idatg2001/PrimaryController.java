package no.ntnu.idatg2001;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.ntnu.idatg2001.cards.DeckOfCards;

/**
 * The controller class which is used to connect the fxml document with the gui
 */
public class PrimaryController {
    /**
     * Creates new deck of cards
     */

    DeckOfCards deckOfCards = new DeckOfCards();
    /**
     * Declaring ImageView variables where the cards as well as the card back is shown
     */
        @FXML
        private ImageView visibleCardImageView;
        @FXML
        private ImageView visibleCardImageView2;
        @FXML
        private ImageView visibleCardImageView3;
        @FXML
        private ImageView visibleCardImageView4;
        @FXML
        private ImageView visibleCardImageView5;
        @FXML
        private ImageView deckImageView;
    /**
     * Declaring TextFields where information about the current hand can be displayed with the checkHand method
     */
        @FXML
        private TextField flushTextField;
        @FXML
        private TextField s12TextField;
        @FXML
        private TextField heartsTextField;
        @FXML
        private TextField sumTextField;


    /**
     * Method to deal a new hand to the player
     * Clears all the text fields so there will not be confusion.
     * it then deals a hand to the player and sets the ImageViews to display the correct images.
     * if there are not enough cards left, a warning will pop up and provide information to the user
     * @param event
     */
        @FXML
        void dealHand(ActionEvent event) {
            clearTextFields();
            try{
                deckOfCards.dealHand(5);
                visibleCardImageView.setImage(deckOfCards.getHand().get(0).getImage());
                visibleCardImageView2.setImage(deckOfCards.getHand().get(1).getImage());
                visibleCardImageView3.setImage(deckOfCards.getHand().get(2).getImage());
                visibleCardImageView4.setImage(deckOfCards.getHand().get(3).getImage());
                visibleCardImageView5.setImage(deckOfCards.getHand().get(4).getImage()); }
            catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("The deck does not have enough cards left. Press new deck to get a new deck");
                alert.show();
            }
        }

    /**
     * Method to check different variables on the current hand of the player.
     * Sets the text fields according to those variables
     */
    @FXML
        void checkHand(){
            flushTextField.setText(deckOfCards.flush() ? "Flush!" : "No flush");
            sumTextField.setText(String.valueOf(deckOfCards.calculateSumOfFaces()));
            s12TextField.setText(deckOfCards.hasQueenOfSpades() ? "Queen of spades on hand" : "No queen of spades");
            heartsTextField.setText(deckOfCards.amountOfHearts().size() > 0 ? deckOfCards.hearts(deckOfCards.amountOfHearts()) : "No hearts");
        }

    /**
     * Creates a new deck. Used when the deck is empty. Also shuffles the new deck
     */
        @FXML
        void newDeck(){
            clearTextFields();
            this.deckOfCards = new DeckOfCards();
            deckOfCards.shuffle();
        }

    /**
     * Clears the text fields
     */
    @FXML void clearTextFields(){
            flushTextField.clear();
            s12TextField.clear();
            sumTextField.clear();
            heartsTextField.clear();
        }

    /**
     * Initializes the gui. Sets the image of the "deck" to a card back image and shuffles the deck
     */
        @FXML public void initialize(){
            deckImageView.setImage(new Image("/images/cardBack.jpg"));
            deckOfCards.shuffle();
        }
    }

