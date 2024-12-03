/**
* The Admin class stores methods which calculate the amount of reservations, the occupancy rate, the amount of each room type avaialble, and how many reservations have been cancelled. 
*     This class is used to compile Admin reports which they can view after logging in. The Admin class also verfies that the entered admin log in information is correct. 
* @author Iliana Madirgal 
* @version 1.1 
*/ 
public class Admin 
    private String cancellationRate;
    private String standardOccuRate;
    private String deluxeOccuRate;
    private String forecastStanOccuRate;
    private String forecastDelOccuRate;
    
    /**
    * Checks whether or not the Admin login information is correct, returning a boolean value if the user is granted permission to log into the Admin account. 
    * @author Iliana Madirgal 
    * @param accountID is the Admin's account code which allows them to log into the Admin account. 
    * @param user is the name on the account.
    * @return true if the login information matches the admin account ID and the name "user". Returns false if the inputted information does not match the Admin account information. 
    */ 
    public boolean logIN(String accountID, String user){
        return accountID.equals("329615") && user.equals("admin");
    }
    
    /**
    * The reservationCounter method decrements the amount of each room type available when a reservation is made requesting that room type, and increments
    *     the count of the reservation.
    * @author Iliana Madirgal 
    * @param roomType is the type of room that the user indicates they want while creating their reservation. They will enter "Deluxe" or "Standard".  
    */ 
    public void reservationCounter(String roomType){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            BufferedWriter writer = new BufferedWriter((new FileWriter("temp.txt")));
            String line;
            if (roomType.equals("Standard")) {
                line = reader.readLine();
                System.out.print(line);
                int availableStandard = Integer.parseInt(line);
                availableStandard--;
                line = line.replace(line, String.valueOf(availableStandard));
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
                int reservattionCounter = Integer.parseInt((reader.readLine()));
                reservattionCounter++;
                line = line.replace(line, String.valueOf(reservattionCounter));
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
               writer.write(line);
                writer.newLine();
            } else {
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
                int availableDeluxe = Integer.parseInt(reader.readLine());
                availableDeluxe--;
                line = line.replace(line, String.valueOf(availableDeluxe));
                writer.write(line);
                writer.newLine();
                int reservattionCounter = Integer.parseInt((reader.readLine()));
                reservattionCounter++;
                line = line.replace(line, String.valueOf(reservattionCounter));
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            reader.close();
        }catch(Exception e){System.out.printf("\n\tError occurred in trying to write to the file. %s", e);}
        try{
            File oldName = new File("Data.txt");
            boolean test = oldName.delete();
            File temp = new File("temp.txt");
            File newName = new File("Data.txt");
            boolean check = temp.renameTo(newName);
        }catch (Exception e){System.out.printf("\n\tError occurred in trying to rename and delete files. %s", e);}
    }
    
    /**
    * If a roomType is changed, the changeRoomCounter increments the number of the original room types remaining and decrements the number of 
    *     rooms available for the type that the reservation changed to. This method ensures that an accurate amount of each room type is always 
    *     visible to the Admin. 
    * @author Iliana Madirgal 
    * @param newRoomType is a string of the type of room that the reservation wants to change to. This information is provided by the user when they 
    *    are making changes to their reservation. 
    */ 
    public void changeRoomCounter(String newRoomType){
       try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            BufferedWriter writer = new BufferedWriter((new FileWriter("temp.txt")));
            String line;
            if (newRoomType.equals("Standard")) {
                line = reader.readLine();
                int availableStandard = Integer.parseInt(line);
                availableStandard--;
                line = line.replace(line, String.valueOf(availableStandard));
                writer.write(line);
                writer.newLine();
                int availableDeluxe = Integer.parseInt(reader.readLine());
                availableDeluxe++;
                line = line.replace(line, String.valueOf(availableDeluxe));
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
                writer.write(line);
                System.out.print(availableDeluxe);
                System.out.print(availableStandard);
            } else {
                line = reader.readLine();
                int availableStandard = Integer.parseInt(line);
                availableStandard++;
                line = line.replace(line, String.valueOf(availableStandard));
                writer.write(line);
                writer.newLine();
                int availableDeluxe = Integer.parseInt(reader.readLine());
                availableDeluxe--;
                line = line.replace(line, String.valueOf(availableDeluxe));
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
                writer.write(line);
                System.out.print(availableDeluxe);
                System.out.print(availableStandard);
            }
            writer.close();
            reader.close();

        }catch (Exception e){System.out.printf("\n\tError occurred in trying to read adn write to file. %s", e);}
        try{
            File oldName = new File("Data.txt");
            boolean test = oldName.delete();
            File temp = new File("temp.txt");
            File newName = new File("Data.txt");
            boolean check = temp.renameTo(newName);
        }catch (Exception e){System.out.printf("\n\tError occurred in trying to rename and delete files. %s", e);}
    }
    
    /**
    * This method increments the amount of each room type remaining after reservations for those room types are cancelled. If the room type is not "Deluxe" then the Standard room type is incrememted. 
    * @author Iliana Madirgal 
    * @param roomType is the name of the room that the user inputted while creating a reservation. This information is stored alongside the other reservation information in the Reservations.txt file. 
    */ 
    public void cancelCounter(String roomType){
       try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            BufferedWriter writer = new BufferedWriter((new FileWriter("temp.txt")));
            String line;
            if (roomType.equals("Standard")) {
                line = reader.readLine();
                int availableStandard = Integer.parseInt(line);
                availableStandard++;
                line = line.replace(line, String.valueOf(availableStandard));
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
                int cancelCounter = Integer.parseInt(reader.readLine());
                cancelCounter++;
                line = line.replace(line, String.valueOf(cancelCounter));
                writer.write(line);
            } else {
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
                int availableDeluxe = Integer.parseInt(reader.readLine());
                availableDeluxe++;
                line = line.replace(line, String.valueOf(availableDeluxe));
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
                int cancelCounter = Integer.parseInt(reader.readLine());
                cancelCounter++;
                line = line.replace(line, String.valueOf(cancelCounter));
                writer.write(line);
            }
            writer.close();
            reader.close();

        }catch (Exception e){System.out.printf("\n\tError occurred in trying to read and write to file. %s", e);}
        try{
            File oldName = new File("Data.txt");
            boolean test = oldName.delete();
            File temp = new File("temp.txt");
            File newName = new File("Data.txt");
            boolean check = temp.renameTo(newName);
        }catch (Exception e){System.out.printf("\n\tError occurred in trying to rename and delete files. %s", e);}
    }

    /**
    * A simple method which calculates how many of each room type are available, what the occupancy rate is for each of these rooms, and what the forecasted occupancy rate is for each of the room types based on the 
    *     reservations that are made in the program. Used to compile an Admin report. 
    * @author Iliana Madirgal 
    */ 
    public void occupancyRate(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String line;
            int availableStandard = Integer.parseInt(reader.readLine());
            int availableDeluxe = Integer.parseInt(reader.readLine());
            double occupDeluxeRoom;
            double occupStandardRoom;
            occupDeluxeRoom = 50 - availableDeluxe;
            occupStandardRoom = 50 - availableStandard;
            double deluxeRate = (occupDeluxeRoom / 50) * 100;
            double standardRate = (occupStandardRoom / 50) * 100;
            double forecastDeluxe = (occupDeluxeRoom / availableDeluxe) * 100;
            double forecastStandard = (occupStandardRoom / availableStandard) * 100;
            long roundfcStandard = Math.round(forecastStandard);
            long roundfcDeluxe = Math.round(forecastDeluxe);
            standardOccuRate = roundfcStandard +"";
            deluxeOccuRate = roundfcDeluxe +"";
            forecastStanOccuRate = forecastDeluxe +"";
            forecastDelOccuRate = forecastDeluxe + "";
        }catch(Exception e){System.out.printf("\n\tError occurred in trying to read from the file. %s", e);}
    }

    /**
    * A simple method which calculates the percentage of reservations that are cancelled. Used to compile an Admin report. 
    * @author Iliana Madirgal 
    */ 
    public void cancelRate(){
       try{
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String line;
            line = reader.readLine();
            line = reader.readLine();
            int reservCounter = Integer.parseInt((reader.readLine()));
            int cancelCounter = Integer.parseInt((reader.readLine()));
            Double reserv = Double.valueOf(reservCounter);
            double rate = (cancelCounter/reserv) * 100;
            long roundRate = Math.round(rate);
            cancellationRate = roundRate + "";
            reader.close();
        }catch(Exception e){System.out.printf("\n\tError occurred in trying to read from the file. %s", e);}
    }
    public String getRateDetails(){
        return String.format("Cancellation Rate: %s\n\nStandard Occupancy Rate: %s\n\nDeluxe Occupancy Rate: %s\n\nForecast Standard Rate: %s\n\n Forecast Deluxe Rate: %s\n\n" +
                                cancellationRate, standardOccuRate, deluxeOccuRate, forecastStanOccuRate, forecastDelOccuRate);
    }

}
