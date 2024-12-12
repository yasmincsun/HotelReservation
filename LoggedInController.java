package org.example.hotelreservations;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * The LoggedInController class controls the AccountCreated scene and connects this portion of the Front End to the Back End of the program.
 * Includes every Button, Text Field, Text Area, and Label that is contained within the LoggedIn scene and all of their fxid's. The class is also responsible for changing
 * the scenes back and forth from one another depending on the requests of the user. This class implements Initializable which allows this class to create an instance of the main class and set values to the text boxes.
 *
 * @author Yasmin Zubair
 * @version 1.0
 */
public class LoggedInController implements Initializable {
    MainController main = MainController.getInstance();

    /**
     * The initialize method is called to set the firstNameDisplay and accountInformation text area in this specific instance of the scene.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstNameDisplay.setText(main.getFirstNameLoggedIn() + "!");

        String accountIDSearch = main.getAccountLoggedInID();
        AccountSearch obj = new AccountSearch(accountIDSearch);
        obj.searchAccount();
        accountInformation.setText(obj.getAccountDetails(accountIDSearch));
    }

    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text accountInformation;

    @FXML
    private Text firstNameDisplay;

    @FXML
    private Button makeFromLogged;

    @FXML
    private Button reviewFromLogged;

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
