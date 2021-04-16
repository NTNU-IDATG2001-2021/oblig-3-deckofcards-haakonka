module no.ntnu.idatg2001 {
    requires javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.idatg2001 to javafx.fxml;
    opens no.ntnu.idatg2001.cards;
    exports no.ntnu.idatg2001;
    exports no.ntnu.idatg2001.cards;
}