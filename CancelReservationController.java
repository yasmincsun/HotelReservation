package org.example.hotelreservations;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The CancelReservationController class controls the AboutUs scene and connects this portion of the Front End to the Back End of the program.
 * Includes every Button, Text Field, Text Area, and Label that is contained within the CancelReservation scene and all of their fxid's. The class is also responsible for changing
 * the scenes back and forth from one another depending on the requests of the user.
 *
 * @author Yasmin Zubair
 * @version 1.0
 */
public class CancelReservationController {
    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField cancelID;

    @FXML
    private Button cancelReservation;

    @FXML
    private Text cancelTitle;

    @FXML
    private Text confirmCancelLabel;

    @FXML
    private Button fromLoginToMain;

    @FXML
    private Text resIDLabel;

    @FXML
    private Text warningMessage;

    @FXML
    private Text resNotFound;

    /**
     * The cancelReservation method will call an object of the ManageReservation class to cancel the reservation and will change the appearance of the scene to reflect the cancelled reservation.
     *
     * @param event is the clicking of the button on the Front End of the program to change the information on the scene. .
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void cancelReservation(ActionEvent event) throws IOException {
        String reservationID = cancelID.getText();

        ReservationSearch search = new ReservationSearch(reservationID);
        if (search.resFound(reservationID)) {
            ManageReservation obj = new ManageReservation();
            obj.cancelRes(reservationID);
            cancelID.setVisible(false);
            cancelReservation.setVisible(false);
            warningMessage.setVisible(false);
            confirmCancelLabel.setVisible(false);
            resIDLabel.setVisible(false);
            cancelTitle.setText("Reservation Successfully Cancelled");
        } else {
            resNotFound.setVisible(true);
        }


    }

    /**
     * The switchToMainMenu method loads the HotelMain-View.fxml file to the system and displays the scene to the user through the stage.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void switchToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HotelMain-View.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
