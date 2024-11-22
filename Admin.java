/**
* The Admin class stores methods which calculate the amount of reservations, the occupancy rate, the amount of each room type avaialble, and how many reservations have been cancelled. 
*     This class is used to compile Admin reports which they can view after logging in. The Admin class also verfies that the entered admin log in information is correct. 
* @author Iliana Madirgal 
* @version 1.1 
*/ 
public class Admin {
    private int availableDeluxe = 50;
    private int availableStandard = 50;
    private int reservCounter = 0;
    private int cancelCounter = 0;

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
        if(roomType.equals("Deluxe")){
            availableDeluxe--;
        }else{
            availableStandard--;
        }
        reservCounter++;
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
    * A simple method which calculates the percentage of reservations that are cancelled. Used to compile an Admin report. 
    * @author Iliana Madirgal 
    */ 
    public void cancelRate(){
        int rate = (cancelCounter/reservCounter) * 100;
    }

}
