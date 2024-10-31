import java.util.*;
import java.io.*;

public class Accounts {

    public static String AccountCode(int num){
        String NumbString = "0123456789";
        StringBuilder code = new StringBuilder(num);
        for(int i = 0; i < num; i++){
            int index = (int) (NumbString.length()* Math.random());
            code.append(NumbString.charAt(index));
        }
        return code.toString();
    }


public static void main(String[] args) {
    try{
        int num = 6;


        String fname = "John";
        String lname = "Smith";

        String code = AccountCode(num);

        BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt",true));


        writer.write(code);
        writer.newLine();
        writer.write(fname);
        writer.newLine();
        writer.write(lname);
        writer.newLine();
        writer.newLine();

        writer.close();

    }catch (Exception e){System.out.printf("\n\tError occurred in trying to write to the file. %s", e);}
    }

}
