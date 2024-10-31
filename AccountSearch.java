import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class AccountSearch {
    private String accountID;

    public AccountSearch(String accountID) {
        this.accountID = accountID;
    }

    public String searchAccount() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
        String line;
        StringBuilder result = new StringBuilder();
        boolean accountFound = false;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith(accountID)) {
                String[] details = line.split(",");
                result.append("First Name: ").append(details[1]).append("\n")
                      .append("Last Name: ").append(details[2]).append("\n")
                      .append("Nights Stayed: ").append(details[3]).append("\n");
                accountFound = true;
            } else if (accountFound) {
                break;
            }
        }
        reader.close();

        if (!accountFound) {
            throw new IllegalArgumentException("The accountID does not exist.");
        }

        return result.toString();
    }
}

class AccountSearchCaller {
    public static void main(String[] args) {
        // String accountID = "12345"; // This should be provided dynamically
        AccountSearch accountSearch = new AccountSearch(accountID);

        try {
            String accountDetails = accountSearch.searchAccount();
            System.out.println(accountDetails);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
