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
 * The ChangeReservationController class controls the AboutUs scene and connects this portion of the Front End to the Back End of the program.
 * Includes every Button, Text Field, Text Area, and Label that is contained within the ChangeReservation scene and all of their fxid's. The class is also responsible for changing
 * the scenes back and forth from one another depending on the requests of the user.
 *
 * @author Yasmin Zubair
 * @version 1.0
 */
public class ChangeReservationController {
    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField changeResID;

    @FXML
    private TextField checkInChange;

    @FXML
    private TextField checkOutChange;

    @FXML
    private TextField firstNameChange;

    @FXML
    private Button fromLoginToMain;

    @FXML
    private Text invalidChangeRoom;

    @FXML
    private TextField lastNameChange;

    @FXML
    private Button makeChangeToReservation;

    @FXML
    private Text origDetails;

    @FXML
    private TextField roomTypeChange;

    @FXML
    private Button toCancel;

    /**
     * The changeDetails method takes in the new information of the reservation and calls the change reservation method by creating an object from the ManageReservation class.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void changeDetails(ActionEvent event) throws IOException {
        invalidChangeRoom.setVisible(false);
        String reservationID = changeResID.getText();
        ReservationSearch obj = new ReservationSearch(reservationID);
        ManageReservation obj2 = new ManageReservation();

        String originalFirstName = obj.getfname();
        String originalLastName = obj.getlname();
        String originalCheckIn = obj.getcheckInDate();
        String originalCheckOut = obj.getCheckOutDate();
        String originalRoomType = obj.getRoomType();

        String newFirstName = firstNameChange.getText();
        String newLastName = lastNameChange.getText();
        String newCheckIn = checkInChange.getText();
        String newCheckOut = checkOutChange.getText();
        String newRoomType = roomTypeChange.getText();

        Admin admin = new Admin();

        if (newRoomType.equals("Standard") || newRoomType.equals("Deluxe")) {
            obj2.changeReservation(reservationID, originalFirstName, newFirstName);
            obj2.changeReservation(reservationID, originalLastName, newLastName);
            obj2.changeReservation(reservationID, originalCheckIn, newCheckIn);
            obj2.changeReservation(reservationID, originalCheckOut, newCheckOut);
            obj2.changeReservation(reservationID, originalRoomType, newRoomType);

            if (originalRoomType.equals(newRoomType)) {
                System.out.println("SAME ROOM TYPE");
            } else {
                admin.changeRoomCounter(newRoomType);
            }
        } else {
            invalidChangeRoom.setVisible(true);
        }

    }

    /**
     * The changing method sets all the values of the text fields to the original values of the reservation.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void changing(ActionEvent event) throws IOException {
        String reservationID = changeResID.getText();
        ReservationSearch obj = new ReservationSearch(reservationID);
        origDetails.setText(obj.getReservationDetails(reservationID));

        firstNameChange.setText(obj.getfname());
        lastNameChange.setText(obj.getlname());
        checkInChange.setText(obj.getcheckInDate());
        checkOutChange.setText(obj.getCheckOutDate());
        roomTypeChange.setText(obj.getRoomType());
        origDetails.setText(obj.getReservationDetails(reservationID));
    }

    /**
     * The switchToCancel method loads the CancelReservation.fxml file to the system and displays the scene to the user through the stage.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void switchToCancel(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CancelReservation.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
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

    /**
     * The switchToReview method loads the ReviewReservation.fxml file to the system and displays the scene to the user through the stage.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void switchToReview(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ReviewReservation.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
