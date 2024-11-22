import java.io.*;
import java.util.*;

public class ReservationSearch {
    private String reservationID;
    private String firstName;
    private String lastName;
    private String stayDates;
    private String roomType;

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
    public String getfname(){
        return firstName;
    }
    public String getlname(){
        return lastName;
    }

    public String getReservationDetails() {
        return String.format("Reservation ID: %s\nFirst Name: %s\nLast Name: %s\nStay Dates: %s\nRoom Type: %s",
                reservationID, firstName, lastName, stayDates, roomType);
    }
}
