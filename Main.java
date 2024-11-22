package org.example.hotelreservations;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
* This class simply sets the Stage for the JavaFX files to be displayed. All of the scenes are loaded onto this stage for the entire program. 
* @author Yasmin Zubair 
* @version 1.4
*/ 
public class Main extends Application {
    @Override

    /**
    * The start method loads the HotelMain-View.fxml file to the system and displays the scene to the user through the stage. The stage title is also set, which is displayed to the user
    *     at the top of the stage. 
    * @author Yasmin Zubair
    * @param primaryStage is the necessary background in which all of the scenes need to be loaded through.
    * @thorws IOException if there is any issues with loading the scene or receiving the input from the user, the exception is thrown to ensure that the program can continue to function. 
    */ 
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HotelMain-View.fxml"));
        primaryStage.setTitle("Tree Hotel Reservation App");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
