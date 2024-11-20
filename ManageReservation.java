import java.io.*;
import java.util.*;

/**
* DESCRIPTION OF CLASS HERE 
* @author Iliana Madrigal 
* @version 1.2
*/ 

public class ManageReservation {

    /**
    * DESCRIPTION OF changeReservatiom method here
    * @author Iliana Madrigal 
    * @param ID 
    * @param oldValue
    * @param newValue
    * @exception 
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
    * DESCRIPTION OF THE CANCELRES CLASS HERE 
    * 
    

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
