
import java.util.*;
import java.io.*;
//This code will gather all of the users information and information about the reservation
//and create the reservation and put it into the Reservations.txt file

public class MakeReservations {

    public static String ConfirmCode(int num){
        String AlphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder code = new StringBuilder(num);
        for (int i = 0; i< num; i++){
            int index = (int) (AlphabetString.length()* Math.random());
            code.append(AlphabetString.charAt(index));
        }
        return code.toString();
    }
  

    public void makeRes(String firstName, String lastName) {
        try{
            int num = 6;
            //if the have account get from search
            //Account fname = getFirstName();
            //Account lname = getLastName();

            //input resdate = getDate();
            //input resroom = getRoom();
            //check for errors in errors in the name and date and room

            String fname = firstName;
            String lname = lastName;

            String code = ConfirmCode(num);
            //String accCode = AccountCode(num);

            BufferedWriter writer = new BufferedWriter(new FileWriter("Reservations.txt",true));

            writer.write(code);
            writer.newLine();
            //writer.write(accCode);
            writer.newLine();
            writer.write(fname);
            writer.newLine();
            writer.write(lname);
            writer.newLine();

            //writer.write(resdate)
            //writer.newLine();
            //writer.write: number of nights
            //writer.newLine();
            //writer.write(resroom);
            //writer.newLine();
            
            writer.newLine();
            writer.close();

        }catch (Exception e){System.out.printf("\n\tError occurred in trying to write to the file. %s", e);}
    }
}
