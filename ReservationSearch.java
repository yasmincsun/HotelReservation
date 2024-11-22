import java.io.*;
import java.util.*;

/** 
* The ReservationSearch class is used to traverse the Reservations.txt file and determine whether or not the intended reservation information inputted by the user exists. The reservationID 
*     is the differentiating value within the Reservations.txt file. 
* @author Yasmin Zubair 
* @author Iliana Madrigal 
* @version 1.2
*/ 
public class ReservationSearch {
    private String reservationID;
    private String firstName;
    private String lastName;
    private String stayDates;
    private String roomType;

    /**
    * The ReservationSearch method calls the searchReservation() method using the reservationID string that the user provides to the program. 
    * @author Yasmin Zubair 
    * @author Iliana Madrigal 
    * @param reservationID is the unique value associated which each reservation. This value is displayed to the user after they create their reservation. 
    */ 
    public ReservationSearch(String reservationID) {
        this.reservationID = reservationID;
        searchReservation();
    }

    /**
    * The searchReservation method traverses through the Reservations.txt file using the reservationID as the search term. The searchReservation method is meant to find the reservationID 
    *     using the value provided by the user to read through the file to find the reservation information associated with that specific reservationID. 
    * @author Yasmin Zubair
    * @author Iliana Madrigal 
    * @exception e is used to catch any issues with reading or writing to the Reservations.txt file. An error message is printed to the user through the terminal if this exception is called. 
    * @exception is thrown if the accountID is not found within the Reservations.txt file. An error message is printed to the user through the terminal if this exception is called. 
    */ 
    private void searchReservation() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Reservations.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.equals(reservationID)) {
                    found = true;
                    firstName = reader.readLine();
                    lastName = reader.readLine();
                    stayDates = reader.readLine();
                    roomType = reader.readLine();
                    break;
                }
                // Skip the next lines if not found
                if (line.isEmpty()) {
                    continue;
                }
            }

            if (!found) {
                throw new Exception("Reservation ID not found.");
            }
        } catch (Exception e) {
            System.out.printf("\n\tError occurred while searching for the reservation: %s", e);
        }
    }
    
    /**
    * A simple getter method which returns the user's first name as it is written in the Reservations.txt.
    * @author Iliana Madrigal 
    * @return firstName is the string value within the Reservations.txt file which is associated with the reservationID that the user inputs. 
    */
    public String getfname(){
        return firstName;
    }
    
    /**
    * A simple getter method which returns the user's last name as it is written in the Reservations.txt.
    * @author Iliana Madrigal 
    * @return lastName is the string value within the Reservations.txt file which is associated with the reservationID that the user inputs. 
    */
    public String getlname(){
        return lastName;
    }

    /**
    * A simple getter method which returns the entirety of the user's reservation information as it is written in the Reservations.txt file.
    * @author Iliana Madrigal 
    * @return the user's reservation information as a string type with descriptors before each value indicating what they are to the user. 
    */
    public String getReservationDetails() {
        return String.format("Reservation ID: %s\nFirst Name: %s\nLast Name: %s\nStay Dates: %s\nRoom Type: %s",
                reservationID, firstName, lastName, stayDates, roomType);
    }
}
