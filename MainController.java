package org.example.hotelreservations;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The MainController class is the sole class responsible for connecting the Front End of the program, with all  the JavaFX files, to the Back End of the program.
 * Includes every Button, Text Field, Text Area, and Label that is contained within the Front End and all of their fxid's. The class is also responsible for changing
 * the scenes back and forth from one another depending on the requests of the user.
 *
 * @author Yasmin Zubair
 * @version Created on October 16th, 2024 and last edited on December 4th, 2024.
 */
public class MainController {
    private static final MainController instance = new MainController();

    private String accountCreatedID;
    private String firstNameLoggedIn;
    private String accountLoggedInID;

    private String reservationCreatedID;
    private String reservationReviewID;

    private String resCreatedFirst;
    private String resCreatedLast;
    private String resCreatedCheckIn;
    private String resCreatedCheckOut;
    private String resCreatedRoomType;

    private MainController() {
    }

    public static MainController getInstance() {
        return instance;
    }

    public String getAccountCreatedID() {
        return accountCreatedID;
    }

    public void setAccountCreatedID(String accountCreatedID) {
        this.accountCreatedID = accountCreatedID;
    }

    public String getFirstNameLoggedIn() {
        AccountSearch search = new AccountSearch(accountLoggedInID);
        firstNameLoggedIn = search.getFirstName();
        return firstNameLoggedIn;
    }

    public void setFirstNameLoggedIn(String firstNameLoggedIn) {
        this.firstNameLoggedIn = firstNameLoggedIn;
    }

    public String getAccountLoggedInID() {
        return accountLoggedInID;
    }

    public void setAccountLoggedInID(String accountLoggedInID) {
        this.accountLoggedInID = accountLoggedInID;
    }

    public String getReservationCreatedID() {
        return reservationCreatedID;
    }

    public void setReservationCreatedID(String reservationCreatedID) {
        this.reservationCreatedID = reservationCreatedID;
    }

    public String getReservationReviewID() {
        return reservationReviewID;
    }

    public void setReservationReviewID(String reservationReviewID) {
        this.reservationReviewID = reservationReviewID;
    }

    public String getResCreatedFirst() {
        return resCreatedFirst;
    }

    public void setResCreatedFirst(String resCreatedFirst) {
        this.resCreatedFirst = resCreatedFirst;
    }

    public String getResCreatedLast() {
        return resCreatedLast;
    }

    public void setResCreatedLast(String resCreatedLast) {
        this.resCreatedLast = resCreatedLast;
    }

    public String getResCreatedCheckIn() {
        return resCreatedCheckIn;
    }

    public void setResCreatedCheckIn(String resCreatedCheckIn) {
        this.resCreatedCheckIn = resCreatedCheckIn;
    }

    public String getResCreatedCheckOut() {
        return resCreatedCheckOut;
    }

    public void setResCreatedCheckOut(String resCreatedCheckOut) {
        this.resCreatedCheckOut = resCreatedCheckOut;
    }

    public String getResCreatedRoomType() {
        return resCreatedRoomType;
    }

    public void setResCreatedRoomType(String resCreatedRoomType) {
        this.resCreatedRoomType = resCreatedRoomType;
    }


    private Stage primaryStage;
    private Scene scene;
    private Parent root;


}
