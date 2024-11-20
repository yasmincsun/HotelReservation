package org.example.hotelreservations;

import java.util.*;
import java.io.*;

public class Accounts {

    public String AccountCode(int num) {
        String NumbString = "0123456789";
        StringBuilder code = new StringBuilder(num);
        for (int i = 0; i < num; i++) {
            int index = (int) (NumbString.length() * Math.random());
            code.append(NumbString.charAt(index));
        }
        return code.toString();
    }

    public boolean verifyAccount(String accountID, String lname) {
        AccountSearch obj = new AccountSearch(accountID);
        String lastname = obj.getlname();
        boolean result = obj.getResult();
        if (result == true && lname.equals(lastname)) {
            return true;
        } else {
            return false;
        }
    }

    public void createAccount(String firstName, String lastName, String phoneNumber, String email) {
        try {
            int num = 6;

            String fname = firstName;
            String lname = lastName;
            String phone = phoneNumber;
            String emailAddress = email;

            String code = AccountCode(num);

            BufferedWriter writer = new BufferedWriter(new FileWriter("Accounts.txt", true));


            writer.write(code);
            writer.newLine();
            writer.write(fname);
            writer.newLine();
            writer.write(lname);
            writer.newLine();
            writer.write(phone);
            writer.newLine();
            writer.write(emailAddress);
            writer.newLine();

            writer.newLine();

            writer.close();


        } catch (Exception e) {
            System.out.printf("\n\tError occurred in trying to write to the file. %s", e);
        }
    }

}
