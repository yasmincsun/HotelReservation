package org.example.hotelreservations;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The AdminLoggedInController class controls the AdminLoggedIn scene and connects this portion of the Front End to the Back End of the program.
 * Includes every Button, Text Field, Text Area, and Label that is contained within the AdminLoggedIn scene and all of their fxid's. The class is also responsible for changing
 * the scenes back and forth from one another depending on the requests of the user. This class implements Initializable which allows this class to create an instance of the main class and set values to the text boxes.
 *
 * @author Yasmin Zubair
 * @version 1.0
 */
public class AdminLoggedInController implements Initializable {
    /**
     * The initialize method is called to set the accFile and resFile text area in this specific instance of the scene.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Admin admin = new Admin();
        admin.cancelRate();
        admin.occupancyRate();
        adminDetails.setText(admin.getRateDetails());
        accFile.setText("Accounts: \n----------------- \n");
        resFile.setText("Reservations: \n------------------\n");

        try (BufferedReader br = new BufferedReader(new FileReader("Accounts.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                accFile.appendText(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("Reservations.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                resFile.appendText(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea accFile;

    @FXML
    private TextArea resFile;

    @FXML
    private Text adminDetails;


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
