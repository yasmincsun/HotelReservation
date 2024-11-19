import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class AccountSearch {
    private String accountID;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private boolean found = false;

    public AccountSearch(String accountID) {
        this.accountID = accountID;
        searchAccount();
    }

    public void searchAccount() {
        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;


            while ((line = reader.readLine()) != null) {
                if (line.equals(accountID)) {
                    found = true;
                    firstName = reader.readLine();
                    lastName = reader.readLine();
                     phone= reader.readLine();
                     email = reader.readLine();

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
    public String getlname(){
        return lastName;
    }
    public boolean getResult(){
        return found;
    }
}
