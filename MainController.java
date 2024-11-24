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

/**
* The MainController class is the sole class responsible for connecting the Frontend of the program, with all of the JavaFX files, to the Backend of the program. 
*     Includes every Button, Text Field, Text Area, and Label that is contained within the Front End and all of their fxid's. The class is also responsible for changing 
*     the scenes back and forth from one another depending on the requests of the user. 
* @author Yasmin Zubair 
* @version 1.4
*/ 
public class MainController {

    private Stage primaryStage;
    private Scene scene;
    private Parent root;

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



    /**
    * The switchToMainMenu method loads the HotelMain-View.fxml file to the system and displays the scene to the user through the stage. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void switchToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HotelMain-View.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
    * The switchToLogin method loads the Login.fxml file to the system and displays the scene to the user through the stage. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
    * The switchToMakeReservation method loads the MakeReservation.fxml file to the system and displays the scene to the user through the stage. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void switchToMakeReservation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MakeReservation.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
    * The switchToAbout method loads the About Us.fxml file to the system and displays the scene to the user through the stage. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void switchToAbout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("About Us.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
    * The switchToBrowseRooms method loads the BrowseRooms.fxml file to the system and displays the scene to the user through the stage. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void switchToBrowseRooms(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BrowseRooms.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    /**
    * The switchToReview method loads the ReviewReservation.fxml file to the system and displays the scene to the user through the stage. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void switchToReview(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ReviewReservation.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
    * The switchToCreate method loads the CreateAccount.fxml file to the system and displays the scene to the user through the stage. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void switchToCreate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
    * The switchToCreated method loads the AccountCreated.fxml file to the system and displays the scene to the user through the stage. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void switchToCreated(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AccountCreated.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
    * The switchToChangeReservation method loads the ChangeReservation.fxml file to the system and displays the scene to the user through the stage. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void switchToChangeReservation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChangeReservation.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
    * The getRoomTypeChoice method collects retrieves the value of the choice box as a string, and prints it to the user through the terminal. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to take the input from the Choice Box. 
    * @thorws IOException if there is any issues with receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void getRoomTypeChoice(ActionEvent event) throws IOException {
        String roomType = roomTypeChoice.getValue();
        System.out.println(roomType);
    }
    

    /**
    * The printHelloWorld method is a general test case that is included in the program temporarily to ensure that all the scenes are able to load correctly and that the buttons are 
    *     functional.  
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to print the information 
    */ 
    @FXML
    public void printHelloWorld(MouseEvent event) { // Test method
        System.out.println("Hello World!");
    }

    /**
    * The reservationCreationInforamation method collects all of the reservation information from the user. When the information is typed into the text fields, and a button is clicked, 
    *     this method gets all of the information and calls the makeRes method from the MakeReservations class to have the information written to the Reservations.txt file. The method
    *     will then load the ReservationMade.fxml file to the stage to display to the user. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
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

        Parent root = FXMLLoader.load(getClass().getResource("ReservationMade.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    /**
    * The accountCreationInformation method collects all of the account information from the user. When the information is typed into the text fields, and a button is clicked, 
    *     this method gets all of the information and calls the createAccount method from the Accounts class to have the information written to the Accounts.txt file. The button that
    *     allows the user to create their account is set to no longer be visible to ensure that the user doesn't accidentally create multiple accounts with the same information. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
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

    /**
    * The checkresExist method collects the reservationID from the information inputted by the user into the text field. If the reservation exists, the reservation information is 
    *     displayed, and if not the user does not see any change in their program. The method creates an object of the ReservationSearch class which calls the searchReservation method. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void checkResExist(ActionEvent event) throws IOException {
        String reservationID = searchReservationID.getText();
        ReservationSearch obj = new ReservationSearch(reservationID);
        obj.searchReservation();
        reservationInformation.setText(obj.getReservationDetails(reservationID));
    }

    /**
    * The accountFound method collects the accountID and lastName from the information inputted by the user into the text field. Creating an object of the Accounts class, the 
    *     verifyAccount metjod is called ensuring that all of the information inputted by the user exists. If it does, then the LoggedIn.fxml file is loaded and the new scene is 
    *     displayed. Else, the user will be prompted to reenter their infomration or create an account. 
    * @author Yasmin Zubair
    * @param event is the clicking of the button on the Front End of the program to view the new scene. 
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
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

    /**
    * The displayOriginalInformation method is a simple setter method which displays the orginal reservation information to the user. This method is called when the the user
    *     is trying to change their reservation information, so they have the ability to view their orginal reservation before making any changes. 
    * @author Yasmin Zubair
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void displayOriginalInformation() throws IOException {
        displayFirstName.setText(firstNameIn.getText());
        displayLastName.setText(lastNameIn.getText());
        displayCheckIn.setText(checkInDatePicker.getValue().toString());
        displayCheckout.setText(checkOutDatePicker.getValue().toString());
        displayRoomType.setText(roomTypeBox.getText());
    }

    public void changeReservationDetails(ActionEvent event) throws IOException { 
        ManageReservation obj = new ManageReservation(); 

    } 

    /** 
    * This class verifies the admin log in information, and if it correct will load the logged in scene. If not, it will 
    * display an error message to the user asking them to try again. 
    * @author Yasmin Zubair 
    * @param event is the clicking of the button on the Front End of the program to view the new scene.
    * @throws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
    */ 
    public void adminLoggingIn(ActionEvent event) throws IOException{ 
        String adminAccountID = adminAccountCode.getText(); 
        String user = adminName.getText(); 
        Admin obj = new Admin();
        boolean adminAccess; 
        adminAccess = obj.logIN(adminAccountID, user); 
        if(adminAccess){ 
            Parent root = FXMLLoader.load(getClass().getResource("AdminLoggedIn.fxml"));
            primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            adminAccessDenied.setText("Log in failed. Try again or go to the standard Log in page.");
        }
    } 

    /**
    * The onHelloButtonClick method is a general test case that is included in the program temporarily to ensure that all the scenes are able to load correctly and that the buttons are 
    *     functional. If the button is working as intended, and the front end and back end are properly connected, the user should see a message stating "You clicked a button!" 
    * @author Yasmin Zubair
    */ 
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("You clicked a button!");
    }
}
