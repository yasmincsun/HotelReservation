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
 * The CreateAccountController class controls the AboutUs scene and connects this portion of the Front End to the Back End of the program.
 * Includes every Button, Text Field, Text Area, and Label that is contained within the CreateAccount scene and all of their fxid's. The class is also responsible for changing
 * the scenes back and forth from one another depending on the requests of the user.
 *
 * @author Yasmin Zubair
 * @version 1.0
 */
public class CreateAccountController {
    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button accountCreator;

    @FXML
    private TextField emailInCA;

    @FXML
    private TextField firstNameInCA;

    @FXML
    private Text invalidCreate;

    @FXML
    private TextField lastNameInCA;

    @FXML
    private TextField phoneInCA;

    MainController main = MainController.getInstance();

    /**
     * The accountCreationInformation method collects all of the account information from the user. When the information is typed into the text fields, and a button is clicked,
     * this method gets all of the information and calls the createAccount method from the Accounts class to have the information written to the Accounts.txt file. The button that
     * allows the user to create their account is set to no longer be visible to ensure that the user doesn't accidentally create multiple accounts with the same information.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void accountCreationInformation(ActionEvent event) throws IOException {
        String firstName = firstNameInCA.getText();
        String lastName = lastNameInCA.getText();
        String phoneNumber = phoneInCA.getText();
        String email = emailInCA.getText();
        Accounts obj = new Accounts();

        if (obj.validation(firstName) && obj.validation(lastName) && obj.validation(phoneNumber) && obj.validation(email)) {
            obj.createAccount(firstName, lastName, phoneNumber, email);
            String accountID = obj.getAccountCode();
            System.out.print("TEST" + accountID);
            main.setAccountCreatedID(accountID);
            accountCreator.setVisible(false);
            switchToCreated(event);
        } else {
            invalidCreate.setVisible(true);
        }
    }

    /**
     * The switchToCreated method loads the AccountCreated.fxml file to the system and displays the scene to the user through the stage.
     *
     * @param event is the clicking of the button on the Front End of the program to view the new scene.
     * @author Yasmin Zubair
     * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function.
     */
    @FXML
    public void switchToCreated(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AccountCreated.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
