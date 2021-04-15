package no.ntnu.idatg2001;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {


        DeckOfCards deckOfCards = new DeckOfCards();

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
        @FXML
        private TextField flushTextField;
        @FXML
        private TextField s12TextField;
        @FXML
        private TextField heartsTextField;
        @FXML
        private TextField sumTextField;



        @FXML
        void showCard(ActionEvent event) {
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

        @FXML
        void checkHand(){
            flushTextField.setText(deckOfCards.flush() ? "Flush!" : "No flush");
            sumTextField.setText(String.valueOf(deckOfCards.calculateSumOfFaces()));
            s12TextField.setText(deckOfCards.hasQueenOfSpades() ? "Queen of spades on hand" : "No queen of spades");
            heartsTextField.setText(deckOfCards.amountOfHearts().size() > 0 ? deckOfCards.hearts(deckOfCards.amountOfHearts()) : "No hearts");
        }

        @FXML
        void newDeck(){

            flushTextField.clear();
            s12TextField.clear();
            sumTextField.clear();
            heartsTextField.clear();

            this.deckOfCards = new DeckOfCards();
            deckOfCards.shuffle();
        }

        public void initialize(){
            deckImageView.setImage(new Image("/images/cardBack.jpg"));
            deckOfCards.shuffle();
        }
    }

