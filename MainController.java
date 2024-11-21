package org.example.hotelreservations;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.*;


import java.io.IOException;

public class MainController {

    private Stage primaryStage;
    private Scene scene;
    private Parent root;


    public void switchToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HotelMain-View.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void switchToMakeReservation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MakeReservation.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void switchToAbout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("About Us.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void switchToBrowseRooms(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BrowseRooms.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * public void switchToLoggedIn(ActionEvent event) throws IOException {
     * <p>
     * Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
     * primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     * scene = new Scene(root);
     * primaryStage.setScene(scene);
     * primaryStage.show();
     * <p>
     * <p>
     * }
     */

    public void switchToReview(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ReviewReservation.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void switchToCreate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void switchToCreated(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AccountCreated.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void switchToChangeReservation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChangeReservation.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public void getRoomTypeChoice(ActionEvent event) throws IOException {
        String roomType = roomTypeChoice.getValue();
        System.out.println(roomType);
    }


    @FXML
    private Label welcomeText;
    public TextField nameIn;
    public Label answer;

    @FXML
    private TextField firstNameIn;

    @FXML
    private TextField lastNameIn;

    @FXML
    private TextArea displayReservationID;

    @FXML
    private Text displayReservationIDonChange;

    @FXML
    private Text accountIDDisplay;

    @FXML
    private Text firstName;

    @FXML
    private Text firstNameDisplay;

    @FXML
    private Text lastName;

    @FXML
    private Button makeFromLogged;

    @FXML
    private Button reviewFromLogged;

    @FXML
    private Button accountCreator;

    @FXML
    private DatePicker checkInDatePicker;

    @FXML
    private DatePicker checkOutDatePicker;

    @FXML
    private TextField roomTypeBox;

    @FXML
    private TextField searchReservationID;

    @FXML
    private Text reservationInformation;

    @FXML
    private Text noAccountFound;

    @FXML
    private ChoiceBox<String> roomTypeChoice;

    @FXML
    private Button switchToChangeReservation;


    @FXML
    private Text displayCheckIn;

    @FXML
    private Text displayCheckout;

    @FXML
    private Text displayFirstName;

    @FXML
    private Text displayLastName;


    @FXML
    private Text displayRoomType;

    @FXML
    private Button makeChangeToReservation;


    @FXML
    private TextField emailInCA;

    @FXML
    private TextField firstNameInCA;

    @FXML
    private TextField lastNameInCA;

    @FXML
    private TextField phoneInCA;

    @FXML
    private Button switchToCreated;

    @FXML
    private Button createdToMain;

    @FXML
    public Text displayAccountID;

    @FXML
    private TextField accountIDonLogin;

    @FXML
    private TextField lastNameOnLogin;


    @FXML
    public void printHelloWorld(MouseEvent event) { // Test method
        System.out.println("Hello World!");
    }


    @FXML
    public void reservationCreationInformation(MouseEvent event) throws IOException {
        String firstName = firstNameIn.getText();
        String lastName = lastNameIn.getText();
        LocalDate checkInDate = checkInDatePicker.getValue();
        LocalDate checkOutDate = checkOutDatePicker.getValue();
        String roomType = roomTypeBox.getText();
        displayReservationID.setText("Reservation ID will be displayed here (for now) ");
        MakeReservations obj = new MakeReservations();
        obj.makeRes(firstName, lastName, checkInDate, checkOutDate, roomType);
        System.out.println(firstName);

        Parent root = FXMLLoader.load(getClass().getResource("ReservationMade.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    public void accountCreationInformation(MouseEvent event) {
        String firstName = firstNameInCA.getText();
        String lastName = lastNameInCA.getText();
        String phoneNumber = phoneInCA.getText();
        String email = emailInCA.getText();
        Accounts obj = new Accounts();
        obj.createAccount(firstName, lastName, phoneNumber, email);
        accountCreator.setVisible(false);
        this.displayAccountID.setText(obj.getAccountCode());


    }

    public void checkResExist(ActionEvent event) throws IOException {
        String reservationID = searchReservationID.getText();
        ReservationSearch obj = new ReservationSearch(reservationID);
        obj.searchReservation();
        reservationInformation.setText(obj.getReservationDetails(reservationID));


    }


    public void accountFound(ActionEvent event) throws IOException {
        String accountIDSearch = accountIDonLogin.getText();
        String lastNameSearch = lastNameOnLogin.getText();
        Accounts obj = new Accounts();
        boolean isAccountFound;
        isAccountFound = obj.verifyAccount(accountIDSearch, lastNameSearch);
        if (isAccountFound) {
            Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
            primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            noAccountFound.setText("No account found. Try again or create an account.");
        }

    }

    public void displayOriginalInformation() throws IOException {
        displayFirstName.setText(firstNameIn.getText());
        displayLastName.setText(lastNameIn.getText());
        displayCheckIn.setText(checkInDatePicker.getValue().toString());
        displayCheckout.setText(checkOutDatePicker.getValue().toString());
        displayRoomType.setText(roomTypeBox.getText());

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("You clicked a button!");
    }
}
