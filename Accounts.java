package org.example.hotelreservations;

import java.util.*;
import java.io.*;

/**
* This class creates accounts, generates the AccountCode, verifies whether the account information is correct when a user is trying to login, and has a getter method which 
*     returns the accountCode to the class that is calling the method. 
* @author Iliana Madirgal 
* @version 1.2 
*/ 

public class Accounts {

    /**
    * The AccountCode method is used to generate the user's unique accountID. When a user is creating an account, the AccountCode method will be called which will differentiates between all of the account
    *     in the Accounts.txt file. Using a string of random numbers, the accountCode will be initialized as an int type before being returned as a string to the user. 
    * @author Iliana Madrigal 
    * @param num is the length of the generated AccountCode string. 
    * @return code passes the AccountID as a String back to the method that called AccountCode(). 
    */ 
    public String AccountCode(int num) {
        String NumbString = "0123456789";
        StringBuilder code = new StringBuilder(num);
        for (int i = 0; i < num; i++) {
            int index = (int) (NumbString.length() * Math.random());
            code.append(NumbString.charAt(index));
        }
        return code.toString();
    }
    
    public boolean validation(String value){
        if(value == null || value.equals(" ") || value.equals("")){
            return false;
        }else{
            return true;
        }
    }
    
    /**
    * The verifyAccount method is used to ensure that the user who is logging into the program is the one who is meant to. It calls the AccountSearch method to verify that the 
    *     accountID and the last name associated with the account are the same. Returns true if the account information is verified and false if it is not. 
    * @author Iliana Madrigal 
    * @param accountID is the unique identifier that differentiates every account form one another. This is used to search through the Accounts.txt file when used as a parameter 
    *     in the AccountSearch method.
    * @param lname is the user's last name that they input into the program. The lname value should be the same as the one associated with the accountID to verify the account or not. 
    * @return boolean value is returned to the class or method that calls verifyAccount() that is either true or false depending on whether or not the accountID and the lname
    *     values that the user inputs into the system match what is in the Accounts.txt file. 
    */ 
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

     /**
    *The createAccount method creates the account with information inputted by the user, and writes the information into Accounts.txt. 
    *    The createAccount method also calls the AccountCode method to generate the accountID which is used to differentiate all of the accounts from one another. 
    * @author Iliana Madrigal 
    * @param firsName is the user's first name that they input into the program.
    * @param lastName is the user's last name that they input into the program
    * @param phoneNumber is the user's phone number that they input into the program
    * @param email is the user's email address that they input into the program. 
    * @exception if the information is unable to be written to the Accounts.txt file for any reason, the exception catches the issue and prints the error to the terminal. 
    */ 

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

    /** 
    * A simple getter method which returns the value of the code to the class which calls the method. 
    * @author Iliana Madrigal
    * @return code is the accountCode which is used to separate all of the accounts within the Accounts.txt file. 
    */ 
    public String getAccountCode(){
        return code;
    }

}
