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

    public String getReservationDetails() {
        return String.format("Reservation ID: %s\nFirst Name: %s\nLast Name: %s\nStay Dates: %s\nRoom Type: %s",
                reservationID, firstName, lastName, stayDates, roomType);
    }
}
