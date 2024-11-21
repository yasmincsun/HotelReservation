public class Admin {
    private int availableDeluxe = 50;
    private int availableStandard = 50;
    private int reservCounter = 0;
    private int cancelCounter = 0;

    public boolean logIN(String accountID, String user){
        return accountID.equals("317895") && user.equals("admin");
    }

    public void reservationCounter(String roomType){
        if(roomType.equals("Deluxe")){
            availableDeluxe--;
        }else{
            availableStandard--;
        }
        reservCounter++;
    }
    public void changeRoomCounter(String newRoomType){
        if(newRoomType.equals("Deluxe")){
            availableStandard++;
            availableDeluxe--;
        }else{
            availableDeluxe++;
            availableStandard--;
        }
    }

    public void cancelCounter(String roomType){
        if(roomType.equals("Deluxe")){
            availableDeluxe++;
        }else{
            availableStandard++;
        }
        cancelCounter++;
    }

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
    public void cancelRate(){
        int rate = (cancelCounter/reservCounter) * 100;
    }

}
