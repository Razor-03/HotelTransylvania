package com.example.hotel_transylvania;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private FontAwesomeIconView back;

    @FXML
    public Label signInLabel;

    @FXML
    private AnchorPane background;

    @FXML
    private FontAwesomeIconView close;

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void backClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        /*alert.setHeaderText("Exit");*/
        alert.setContentText("Do you want to logout?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            try {
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                // stage.initStyle(StageStyle.DECORATED);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void signedIn(String username){
        signInLabel.setText("Signed in as:   " + username);
    }
    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);
    }

    public void bookRoomBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Bookings.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void bookingBtn(ActionEvent event){
        try{
            root = FXMLLoader.load(getClass().getResource("Bookings.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        } catch(IOException e){
            e.getMessage();
        }
    }

    public void servicesBtn(ActionEvent event){
        try{
            root = FXMLLoader.load(getClass().getResource("Services.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        } catch(IOException e){
            e.getMessage();
        }
    }
}
