/**
* Des 
* @author Iliana Madirgal 
* @version 1.1 
*/ 
public class Admin {
    private int availableDeluxe = 50;
    private int availableStandard = 50;
    private int reservCounter = 0;
    private int cancelCounter = 0;

    /**
    * Checks whether or not t 
    * @author Iliana Madirgal 
    * @param accountID
    * @param user
    * @return true if the login information matches the admin account ID and the name "user". Returns false if the inputted information does not match the Admin account information. 
    */ 
    public boolean logIN(String accountID, String user){
        return accountID.equals("317895") && user.equals("admin");
    }
    
    /**
    * Des 
    * @author Iliana Madirgal 
    * @param roomType
    */ 
    public void reservationCounter(String roomType){
        if(roomType.equals("Deluxe")){
            availableDeluxe--;
        }else{
            availableStandard--;
        }
        reservCounter++;
    }
    
    /**
    * Des 
    * @author Iliana Madirgal 
    * @param newRoomType
    */ 
    public void changeRoomCounter(String newRoomType){
        if(newRoomType.equals("Deluxe")){
            availableStandard++;
            availableDeluxe--;
        }else{
            availableDeluxe++;
            availableStandard--;
        }
    }
    
    /**
    * This method increments the amount of each room type remaining after reservations for those room types are cancelled. If the room type is not "Deluxe" then the Standard room type is incrememted. 
    * @author Iliana Madirgal 
    * @param roomType is the name of the room that the user inputted while creating a reservation. This information is stored alongside the other reservation information in the Reservations.txt file. 
    */ 
    public void cancelCounter(String roomType){
        if(roomType.equals("Deluxe")){
            availableDeluxe++;
        }else{
            availableStandard++;
        }
        cancelCounter++;
    }

    /**
    * A simple method which calculates how many of each room type are available, what the occupancy rate is for each of these rooms, and what the forecasted occupancy rate is for each of the room types based on the 
    *     reservations that are made in the program. Used to compile an Admin report. 
    * @author Iliana Madirgal 
    */ 
    public void occupancyRate(){
        int occupDeluxeRoom;
        int occupStandardRoom;
        occupDeluxeRoom = 50 - availableDeluxe;
        occupStandardRoom = 50 - availableStandard;
        int deluxeRate = (occupDeluxeRoom /50) *100;
        int standardRate = (occupStandardRoom/50) * 100;

        int forecastDeluxe =(occupDeluxeRoom /availableDeluxe) *100;
        int forecastStandard = (occupStandardRoom/availableStandard) * 100;
    }

    /**
    * A simple method which calculates the percentage of reservations are cancelled. Used to compile an Admin report. 
    * @author Iliana Madirgal 
    */ 
    public void cancelRate(){
        int rate = (cancelCounter/reservCounter) * 100;
    }

}
