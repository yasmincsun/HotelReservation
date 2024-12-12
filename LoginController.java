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
 * The LoginController class controls the AboutUs scene and connects this portion of the Front End to the Back End of the program.
 * Includes every Button, Text Field, Text Area, and Label that is contained within the Login scene and all of their fxid's. The class is also responsible for changing
 * the scenes back and forth from one another depending on the requests of the user.
 *
 * @author Yasmin Zubair
 * @version 1.0
 */
public class LoginController {
    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField accountIDonLogin;

    @FXML
    private Button createFromLogIn;

    @FXML
    private Button fromLoginToMain;

    @FXML
    private TextField lastNameOnLogin;

    @FXML
    private Button logging;

    @FXML
    private Text noAccountFound;

    MainController main = MainController.getInstance();

    /**
     * The accountFound method collects the accountID and lastName from the information inputted by the user into the text field. Creating an object of the Accounts class, the
     * verifyAccount metjod is called ensuring that all of the information inputted by the user exists. If it does, then the LoggedIn.fxml file is loaded and the new scene is
     * displayed. Else, the user will be prompted to reenter their infomration or create an account.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void accountFound(ActionEvent event) throws IOException {
        String accountIDSearch = accountIDonLogin.getText();
        String lastNameSearch = lastNameOnLogin.getText();
        Accounts obj = new Accounts();
        boolean isAccountFound;
        isAccountFound = obj.verifyAccount(accountIDSearch, lastNameSearch);
        if (isAccountFound) {
            main.setAccountLoggedInID(accountIDSearch);
            switchToLoggedIn(event);

        } else {
            noAccountFound.setText("No account found. Try again or create an account.");
        }
    }

    /**
     * The switchToLoggedIn method loads the LoggedIn.fxml file to the system and displays the scene to the user through the stage.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void switchToLoggedIn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * The switchToCreate method loads the CreateAccount.fxml file to the system and displays the scene to the user through the stage.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void switchToCreate(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
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
        root = FXMLLoader.load(getClass().getResource("HotelMain-View.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
