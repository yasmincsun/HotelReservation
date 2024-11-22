import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** 
* The AccountSearch class is used to traverse the Accounts.txt file and determine whether or not the intended account information inputted by the user exists. The accountID is the differentiating value within
*    the Accounts.txt file. 
* @author Yasmin Zubair 
* @author Iliana Madrigal 
* @version 1.2
*/ 

public class AccountSearch {
    private String accountID;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private boolean found = false;

    /**
    * The AccountSearch method calls the searchAccount() method using the accountID string that the user provides to the program. 
    * @author Yasmin Zubair 
    * @author Iliana Madrigal 
    * @param accountID is the unique value associated which each account. This value is displayed to the user after they make their account. 
    */ 
    public AccountSearch(String accountID) {
        this.accountID = accountID;
        searchAccount();
    }

    /**
    * The searchAccount method traverses through the Accounts.txt file using the accountID as the search term. The searchAccount method is meant to find the accountID using the value provided by the user 
    *     to read through the file to find the account information associated with that specific accountID. 
    * @author Yasmin Zubair
    * @author Iliana Madrigal 
    * @exception e is used to catch any issues with reading or writing to the Accounts.txt file. An error message is printed to the user through the terminal if this exception is called. 
    * @exception is thrown if the accountID is not found within the Accounts.txt file. An error message is printed to the user through the terminal if this exception is called. 
    */ 
    public void searchAccount() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Accounts.txt"))) {
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
                throw new Exception("Account ID not found.");
            }
        } catch (Exception e) {
            System.out.printf("\n\tError occurred while searching for the account: %s", e);
        }
    }

    /**
    * A simple getter method which returns the user's last name as it is written in the Accounts.txt.
    * @author Iliana Madrigal 
    * @return lastName is the string value within the Accounts.txt file which is associated with the accountID that the user inputs. 
    */
    public String getlname(){
        return lastName;
    }
    
    /**
    * A simple getter method which returns whether or not the account that the user is trying to access exists or not. 
    * @author Iliana Madrigal 
    * @return found which is a boolean value determining whether or not the account information provided by the user matches the account information available on the Accounts.txt file.
    */
    public boolean getResult(){
        return found;
    }
}
