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
 * The AdminLoginController class controls the AboutUs scene and connects this portion of the Front End to the Back End of the program.
 * Includes every Button, Text Field, Text Area, and Label that is contained within the AdminLogin scene and all of their fxid's. The class is also responsible for changing
 * the scenes back and forth from one another depending on the requests of the user.
 *
 * @author Yasmin Zubair
 * @version 1.0
 */
public class AdminLoginController {
    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text adminAccessDenied;

    @FXML
    private TextField adminAccountCode;

    @FXML
    private Button adminIn;

    @FXML
    private TextField adminName;

    @FXML
    private Button fromLoginToMain;

    @FXML
    private Button guestLogin;

    /**
     * This class verifies the admin log in information, and if it correct will load the logged in scene. If not, it will
     * display an error message to the user asking them to try again.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @throws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     * @author Yasmin Zubair
     */
    @FXML
    public void adminLoggingIn(ActionEvent event) throws IOException {
        String adminAccountID = adminAccountCode.getText();
        String user = adminName.getText();
        Admin obj = new Admin();
        boolean adminAccess;
        adminAccess = obj.logIN(adminAccountID, user);
        if (adminAccess) {
            Parent root = FXMLLoader.load(getClass().getResource("AdminLoggedIn.fxml"));
            primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        } else {
            adminAccessDenied.setText("Log in failed. Try again or go to the Guest Login page.");
            guestLogin.setVisible(true);
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


}
