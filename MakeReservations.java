
import java.util.*;
import java.io.*;

/**
* The class dedicated to making the Hotel reservations. Has a ConfirmCode method which generates a ReservationID when new reservations are created
*    and a makeRes method which writes all of the reservation information into the Reservations.txt file. 
* @author Iliana Madrigal 
* @version 1.3 
*/ 
public class MakeReservations {

    /**
    * Creates a Reservaton Confirmation Code after a reservation is created by the user to differentiate between different bookings. 
    *     The ConfirmaionCode is made up of a random sequence of alphanuermic characters and has a length of 6. 
    * @author Iliana Madrigal 
    * @param num serves as the length of the Reservation Confirmation code and is declared in the makeRes method's code that calls the ConfirmCode method
    * @return The confirmation code as a String type 
    */ 
    public static String ConfirmCode(int num){
        String AlphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder code = new StringBuilder(num);
        for (int i = 0; i< num; i++){
            int index = (int) (AlphabetString.length()* Math.random());
            code.append(AlphabetString.charAt(index));
        }
        return code.toString();
    }
  
    /**
    * Creates the reservation and writes the information into Reservations.txt in the order in which is it passed into the method,
    *     preceded by the code which is created by calling ConfirmCode(num). 
    * @author Iliana Madrigal 
    * @param firstName is the user's first name that they input while creating a reservation
    * @param lastName is the user's last name that they input while creating a reservation 
    * @param checkInDate is the date that the user will check into the hotel
    * @param checkOutDate is the date that the user will checkout of the hotel 
    * @param roomType is the bed type that the user selected when making a reservation. User had a choice between a King Bed Room and a Two Queen Bed Room
    * @exception if the information is unable to be written into the file for any reason, the exception is thrown and an error message is printed to the terminal
    */ 
    public void makeRes(String firstName, String lastName, LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
        try {
            int num = 6;
            //Account fname = getFirstName();
            //Account lname = getLastName();
            //Date resdate = getDate();
            //Room resroom = getRoom();

            String fname = firstName;
            String lname = lastName;
            LocalDate checkIn = checkInDate;
            LocalDate checkOut = checkOutDate;
            String room = roomType;




            String code = ConfirmCode(num);

            BufferedWriter writer = new BufferedWriter(new FileWriter("Reservations.txt", true));

            writer.write(code);
            writer.newLine();
            writer.write(fname);
            writer.newLine();
            writer.write(lname);
            writer.newLine();
            writer.write(checkIn.toString());
            writer.newLine();
            writer.write(checkOut.toString());
            writer.newLine();
            writer.write(room);
            writer.newLine();

            writer.newLine();
            writer.close();

        } catch (Exception e) {
            System.out.printf("\n\tError occurred in trying to write to the file. %s", e);
        }
    }
}
