package org.example.hotelreservations;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * The AccountCreatedController class controls the AccountCreated scene and connects this portion of the Front End to the Back End of the program.
 * Includes every Button, Text Field, Text Area, and Label that is contained within the AccountCreated scene and all of their fxid's. The class is also responsible for changing
 * the scenes back and forth from one another depending on the requests of the user. This class implements Initializable which allows this class to create an instance of the main class and set values to the text boxes.
 *
 * @author Yasmin Zubair
 * @version 1.0
 */
public class AccountCreatedController implements Initializable {
    MainController main = MainController.getInstance();

    /**
     * The initialize method is called to set the accID text field in this specific instance of the scene.
     *
     * @param location  is the scene that is loaded.
     * @param resources are the imported resources that allow the program to declare the value of the variables.
     * @author Yasmin Zubair
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accID.setText(main.getAccountCreatedID());
    }

    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text accID;

    @FXML
    private Button createdToMain;

    @FXML
    private Button MakeReservation;

    @FXML
    private Polygon logo;

    @FXML
    private Button toLoginFromMain;


    /**
     * The switchToLogin method loads the Login.fxml file to the system and displays the scene to the user through the stage.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The switchToMakeReservation method loads the MakeReservation.fxml file to the system and displays the scene to the user through the stage.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void switchToMakeReservation(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MakeReservation.fxml"));
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
    public void switchToMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HotelMain-View.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
