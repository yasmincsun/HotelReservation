package org.example.hotelreservations;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * The MakeReservationController class controls the AccountCreated scene and connects this portion of the Front End to the Back End of the program.
 * Includes every Button, Text Field, Text Area, and Label that is contained within the AccountCreated scene and all of their fxid's. The class is also responsible for changing
 * the scenes back and forth from one another depending on the requests of the user. This class implements Initializable which allows this class to create an instance of the main class and set values to the text boxes.
 *
 * @author Yasmin Zubair
 * @version 1.0
 */
public class MakeReservationController implements Initializable {
    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    /**
     * The initialize method delares the values of the choice box options.
     *
     * @param location       is the scene that is loaded.
     * @param resourceBundle are the imported resources that allow the program to declare the value of the variables.
     * @author Yasmin Zubair
     */
    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        roomTypeChoice.getItems().addAll("Standard", "Deluxe");
    }

    @FXML
    private Button browseRooms;

    @FXML
    private DatePicker checkInDatePicker;

    @FXML
    private DatePicker checkOutDatePicker;

    @FXML
    private TextField firstNameIn;

    @FXML
    private Button fromMakeToMain;

    @FXML
    private Text invalidRoomType;

    @FXML
    private TextField lastNameIn;

    @FXML
    private Button nameButton;

    @FXML
    private Text emptyFields;

    @FXML
    private ChoiceBox<String> roomTypeChoice;

    MainController main = MainController.getInstance();

    /**
     * The getRoomTypeChoice method collects retrieves the value of the choice box as a string, and prints it to the user through the terminal.
     *
     * @return roomType is the type of room that the user selected as a String
     * @author Yasmin Zubair
     */
    @FXML
    public String getRoomTypeChoice() throws IOException {
        String roomType = "null";
        if (roomTypeChoice.getValue() == null) {
            roomTypeChoice.setValue("Select a Room Type");
        } else {
            roomType = roomTypeChoice.getValue();
            System.out.println(roomType);
        }
        return roomType;
    }

    /**
     * The reservationCreationInforamation method collects all the reservation information from the user. When the information is typed into the text fields, and a button is clicked,
     * this method gets all the information and calls the makeRes method from the MakeReservations class to have the information written to the Reservations.txt file. The method
     * will then load the ReservationMade.fxml file to the stage to display to the user.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void reservationCreationInformation(ActionEvent event) throws IOException {
        String firstName = firstNameIn.getText();
        String lastName = lastNameIn.getText();
        LocalDate checkInDate = checkInDatePicker.getValue();
        LocalDate checkOutDate = checkOutDatePicker.getValue();
        String roomType = getRoomTypeChoice();


        if ((roomType.equals("Standard")) || (roomType.equals("Deluxe"))) {
            MakeReservations obj = new MakeReservations();
            ManageReservation obj2 = new ManageReservation();
            if (obj2.validation(firstName) && obj2.validation(lastName)) {
                obj.makeRes(firstName, lastName, checkInDate, checkOutDate, roomType);
                main.setResCreatedFirst(firstName);
                main.setResCreatedLast(lastName);
                main.setResCreatedCheckIn(checkInDate.toString());
                main.setResCreatedCheckOut(checkOutDate.toString());
                main.setResCreatedRoomType(roomType);
                String resID = obj.getCode();
                main.setReservationCreatedID(resID);
                switchToResMade(event);
            } else {
                emptyFields.setVisible(true);
            }
        } else {
            invalidRoomType.setVisible(true);
        }

    }

    /**
     * The switchToResMade method loads the ReservationMade.fxml file to the system and displays the scene to the user through the stage.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void switchToResMade(ActionEvent event) throws IOException {
        Parent resMadeParent = FXMLLoader.load(getClass().getResource("ReservationMade.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(resMadeParent);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.show();
    }

    /**
     * The switchToBrowseRooms method loads the BrowseRooms.fxml file to the system and displays the scene to the user through the stage.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void switchToBrowseRooms(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BrowseRooms.fxml"));
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

}
