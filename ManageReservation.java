import java.io.*;
import java.util.*;

/**
* The ManageReservation class contains two methods, one that changes information about the reservation and one that cancels the reservation in its entirety. 
* @author Iliana Madrigal 
* @version 1.2
*/ 

public class ManageReservation {

    /**
    * The changeReservation method uses the reservationID to find the reservation within the Reservations.txt file and replace the orginal information with the new information
    *     provided by the user. A temporary file is created to store the orginal reservation information while the new information is writing it over in the Reservations.txt file
    *     to ensure that no information is lost. 
    * @author Iliana Madrigal 
    * @param ID is the ReservationID that each reservation had. Each ID is unique which is why it is the search term used to traverse the Reservations.txt file. 
    * @param oldValue is the original piece of information within the reservation that the user is trying to change. 
    * @param newValue is the new information that the user is trying have replace the original value of their reservation. 
    * @exception if the information is unable to be read or written to the file, and exception catches the error and displays to the terminal what the issue was. 
    */ 
    public void changeReservation(String ID, String oldValue, String newValue){
    try{
        BufferedReader reader = new BufferedReader(new FileReader("Reservations.txt"));
        BufferedWriter writer = new BufferedWriter((new FileWriter("temp.txt")));
        String line;
        while((line = reader.readLine()) != null){
            if(line.equals(ID)){
                writer.write(line);
                writer.newLine();
                for(int i =0; i< 6; i++) {
                    line= reader.readLine();
                    line = line.replace(oldValue, newValue);
                    writer.write(line);
                    writer.newLine();
                }
            }else{
                writer.write(line);
                writer.newLine();
            }
        }
        writer.close();
        reader.close();

    }catch (Exception e){System.out.printf("\n\tError occurred in trying to write to the file. %s", e);}
    try{
        File oldName = new File("Reservations.txt");
        boolean test = oldName.delete();
        File temp = new File("temp.txt");
        File newName = new File("Reservations.txt");
        boolean check = temp.renameTo(newName);
    }catch (Exception e){System.out.printf("\n\tError occurred in trying to rename and delete files. %s", e);}

    }

    /**
    * The cancelRes class searches through the Reservations.txt file and will delete all of the information associated with that specific reservationID.  
    * @author Iliana Madrigal 
    * @param ID is the unique piece of information associated with every reservation, which is why it is used as the search term to traverse the entirety of the Reservations.txt file.
    * @exception if the information is unable to read or written to the file, and exception catches the error and displays to the terminal what the issue was.
    */ 
    public void cancelRes(String ID){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Reservations.txt"));
            BufferedWriter writer = new BufferedWriter((new FileWriter("temp.txt")));
            String line;
            while((line = reader.readLine()) != null){
                if(line.equals(ID)){
                    for(int i = 0; i < 6; i++){
                        line = reader.readLine();
                    }
                }else{
                    writer.write(line);
                    writer.newLine();;
                }
            }
            reader.close();
            writer.close();

        }catch (Exception e){System.out.printf("\n\tError occurred in trying to write to the file. %s", e);}
        try{
            File oldName = new File("Reservations.txt");
            boolean test = oldName.delete();
            File temp = new File("temp.txt");
            File newName = new File("Reservations.txt");
            boolean check = temp.renameTo(newName);
        }catch (Exception e){System.out.printf("\n\tError occurred in trying to rename and delete files. %s", e);}

    }

}
