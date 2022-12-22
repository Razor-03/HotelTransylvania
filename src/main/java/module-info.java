module com.example.hotel_transylvania {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires de.jensd.fx.glyphs.fontawesome;


    opens com.example.hotel_transylvania to javafx.fxml;
    exports com.example.hotel_transylvania;
}