package com.example.hotel_transylvania;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.cell.MFXDateCell;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Booking {

    @FXML
    private FontAwesomeIconView back;

    @FXML
    private MFXButton bookNow;

    @FXML
    private MFXTextField card;

    @FXML
    private FontAwesomeIconView close;

    @FXML
    private MFXTextField code;

    @FXML
    private MFXDatePicker inDate;

    @FXML
    private MFXTextField month;

    @FXML
    private MFXButton next;

    @FXML
    private MFXTextField nights;

    @FXML
    private AnchorPane payment;

    @FXML
    private ImageView paymentImg;

    @FXML
    private Text roomName;

    @FXML
    private MFXScrollPane scroll;

    @FXML
    private Text text;

    @FXML
    private Text totalPayment;

    @FXML
    private MFXTextField year;

    String price;

    static String username;

    @FXML
    void backClicked(MouseEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Bookings.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);
    }

    @FXML
    void book1Clicked(MouseEvent event) {
        Image img = new Image("file:src/main/resources/com/example/hotel_transylvania/room1.jpg");
        paymentImg.setImage(img);
        roomName.setText("Deluxe King Room");
//        totalPayment.setText(String.valueOf(155*Integer.parseInt(nights.getText())));
        price = "155";
        changeToPayment(event);
    }

    @FXML
    void book2Clicked(MouseEvent event) {
        Image img = new Image("file:src/main/resources/com/example/hotel_transylvania/room2.jpg");
        paymentImg.setImage(img);
        roomName.setText("Deluxe Twin");
        price = "155";
        changeToPayment(event);
    }

    @FXML
    void book3Clicked(MouseEvent event) {
        Image img = new Image("file:src/main/resources/com/example/hotel_transylvania/room3.jpg");
        paymentImg.setImage(img);
        roomName.setText("Executive King Room");
        totalPayment.setText("170");
        price = "170";
        changeToPayment(event);
    }

    @FXML
    void book4Clicked(MouseEvent event) {
        Image img = new Image("file:src/main/resources/com/example/hotel_transylvania/room4.jpg");
        paymentImg.setImage(img);
        roomName.setText("Platinum King Room");
        price = "185";
        changeToPayment(event);
    }

    @FXML
    void book5Clicked(MouseEvent event) {
        Image img = new Image("file:src/main/resources/com/example/hotel_transylvania/room5.jpg");
        paymentImg.setImage(img);
        roomName.setText("Executive Twin");
        price = "170";
        changeToPayment(event);

    }

    @FXML
    void book6Clicked(MouseEvent event) {
        Image img = new Image("file:src/main/resources/com/example/hotel_transylvania/room6.jpg");
        paymentImg.setImage(img);
        roomName.setText("3 Bed Apartments");
        price = "310";
        changeToPayment(event);
    }



    void changeToPayment(MouseEvent event){
        scroll.setVisible(false);
        payment.setVisible(true);
    }

    @FXML
    void calculate(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)) {
            totalPayment.setText(String.valueOf(Integer.parseInt(price) * Integer.parseInt(nights.getText())));
        }
    }

    @FXML
    void nextClicked(MouseEvent event) {
        if(!(card.getText().isEmpty()&&month.getText().isEmpty()&&year.getText().isEmpty()&&code.getText().isEmpty()) ){
            text.setVisible(true);

            RoomFile file = new RoomFile(username, roomName.getText(), inDate.getText(), nights.getText(), String.valueOf(totalPayment.getText()));
            file.writeFile();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Main.changeScene(event, "Homepage.fxml");
        }else {
            text.setText("Fields are empty");
            text.setStyle("-fx-text-fill: red;");
            text.setVisible(true);
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
