package org.example.hotelreservations;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The AboutUsController class controls the AboutUs scene and connects this portion of the Front End to the Back End of the program. 
 *     Includes every Button, Text Field, Text Area, and Label that is contained within the AboutUs scene and all of their fxid's. The class is also responsible for changing 
 *     the scenes back and forth from one another depending on the requests of the user. 
 * @author Yasmin Zubair 
 * @version 1.0 
 */
public class AboutUsController {
    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button MakeReservation;

    @FXML
    private Polygon logo;

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

}
