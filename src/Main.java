import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        String name;
        String eventType;
        int capacity;
        Scanner input = new Scanner(System.in);
        SportArea sportArea = new SportArea();
        lectureHall lH = new lectureHall();
        publicSpace pS = new publicSpace();
        Event event = new Event();
        timecheck timeCheck = new timecheck();
        dataSaving data = new dataSaving();
        boolean endProgram = false;
        // This
        String orderNum;
        //String so the user can input the ( : )
        String startDate;
        String endDate;
        String startTime;
        String endTime;
        String answer;
        String venue;
        System.out.println("Welcome to KFUPM Event Booking platform");
        //while loop so the program continue
        while(!endProgram) {
            //checking if the input is valid
            try {
                System.out.println("Type 1 to book an event");
                System.out.println("Type 2 to delete an event");
                System.out.println("Type 3 to show events");
                // The number the user will enter
                orderNum = input.next();
                if (orderNum.equals("1")) {
                    // These are the methods to set every event information
                        name = eventName();
                        eventType = eventType();
                        venue = choosingVenue(eventType);
                        capacity = capacityChecking(venue);
                        boolean dateValid = false;
                        System.out.println("Enter the starting date");
                        startDate = Date();
                        System.out.println("Enter the ending date");
                        endDate = Date();
                        System.out.println("Enter starting time ");
                        startTime = Time();
                        System.out.println("Enter ending time ");
                        endTime = Time();
                        // This method will check the conflict and handle it.
                        // If everything was ok, it will save the data
                        checkConflict(name, eventType, vanue, capacity, startTime, endTime );

                }
                // This will delete an event by its name
                else if (orderNum.equals("2")) {
                    System.out.println("Type the name of the event you want to delete.");
                    String delName = input.next();
                    // This object will call delete to remove all info in dataSaving
                    boolean operation = data.delete(delName);
                    if(!operation){
                        throw new Exception("There is no event with this name");
                    }
                }
                // This will show all booked events
                else if (orderNum.equals("3")) {
                    data.showInfo();
                }
                // If the user entered order that is not 1, 2 or 3
                else {
                    throw new Exception("Enter a valid value");
                }
                System.out.print("Do u wish  to continue? (yes, no)");
                answer = input.nextLine();
                if (answer == "yes") {
                    endProgram = true;
                }
            }
            catch(Exception except){
                System.out.println(except.getMessage());
            }
        }
    }
    // This method is to set the name
    public static String eventName(){
        Scanner scnr = new Scanner(System.in);
        timecheck check = new timecheck();
        String name;
        System.out.println("Enter event name ");
        name = scnr.next();
        // This wil check if the name is used
        name = check.checkName(name);
        return name;
    }
    // This method to set the type
    public static String eventType(){
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        System.out.print("Enter the Event type");
        System.out.print("Religious, Social, Sports, Academic.");
        String eventType = input.next();
        while(!valid) {
            if((!eventType.equals("Academic")||!eventType.equals("Sports"))||(!eventType.equals("Social")||(!eventType.equals("Religious")))){
                System.out.println("Enter a valid type");
                eventType = input.next();
                continue;
            }
            valid = true;
        }
        return eventType;
    }
    public static String choosingVenue(String eventType){
        Event event = new Event();
        String venue;
        System.out.print("Select the desired venue");
        venue = event.venueSelection(eventType);
        return venue;
    }
    public int capacityChecking(String venue){
        Scanner input = new Scanner(System.in);
        Event event = new Event();
        int capacity;
        //change the things in the print
        System.out.print("Please enter the predected amount of comeers to the Event");
        capacity = input.nextInt();
        capacity = event.capacityHandling(capacity);
        return capacity;
    }
    // This method to set a valid date
    public static String Date(){
        Scanner scnr = new Scanner(System.in);
        boolean dateManage = false;
        String date;
        date = scnr.next();
        while(!dateManage){
             try{
                 if((date.length()<4)||(date.length()>5)){
                     throw new Exception("Your date is not valid");
                 }
                 if(date.length() == 4){
                     date = "0" + date;
                 }
                 if (date.charAt(2)!=('/')){
                     throw new Exception("Your date is not valid");
                 }
                 int month = Integer.parseInt(date.substring(0,2));
                 int day = Integer.parseInt(date.substring(3));
                 if (month<1 || month>12){
                     throw new Exception("The month is not valid");
                 }
                 if(month<8){
                     if(month%2 == 1){
                         if(day>31 || day < 1){
                             throw new Exception("The day is not valid");
                         }
                     }
                     else if(month == 2){
                         if(day>29 || day<1){
                             throw new Exception("The day is not valid");
                         }
                     }
                     else{
                         if(day>30 || day<1){
                             throw new Exception("The day is not valid");
                         }
                     }
                 }
                 else{
                     if(month%2 == 0){
                         if(day>31 || day<1){
                             throw new Exception("The day is not valid");
                         }
                     }
                     else{
                         if(day>30 || day<1){
                             throw new Exception("The day is not valid");
                         }
                     }
                 }
                 dateManage = true;
             }
             catch(Exception except){
                 System.out.println(except.getMessage());
                 System.out.println("Enter a new date");
                 date = scnr.next();
             }
         }
    return date;
    }
    // This method is to set a valid time
    public static String Time(){
        Scanner input = new Scanner(System.in);
        String time = input.next();
        boolean timeManage = false;
        while(!timeManage) {
            try {
                if((time.length()!=4) || (time.length()!=5)){
                    throw new Exception("Enter a valid time as 1:30");
                }
                if (time.length() == 4) {
                    time = "0" + time;
                }
                if(time.charAt(2)!=':'){
                    throw new Exception("Enter a valid time. For example 1:30");
                }
                int Hour = Integer.parseInt(time.substring(0,2));
                int Minute = Integer.parseInt(time.substring(3));
                if((Hour < 0) || (Hour > 24)){
                    throw new Error("The hour is not valid");
                }
                if((Minute < 0) || (Minute > 60)){
                    throw new Error("The minute is not valid");
                }
                timeManage = true;
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Enter a new time");
                time = input.next();
            }
        }
        return time;
    }
    // The method that will handle conflict
    public static void checkConflict(String name, String eventType, String venue, int capacity, String startTime, String endTime){
        timecheck timeCheck = new timecheck();
        dataSaving data = new dataSaving();
        String response = timeCheck.checkTime(venue, startTime, endTime);
        if(response.equals("valid")){
            data.savings(name, eventType, vanue, capacity, startTime, endTime );
            System.out.print("the venue now is booked");
        }
        else if(response.equals("time")){
            System.out.println("Enter new starting time");
            startTime = Time();
            System.out.println("Enter new ending time");
            endTime = Time();
            // Recursion to check everytime
            checkConflict(name, eventType, venue, capacity, startTime, endTime);
        }
        else if(response.equals("venue")){
            System.out.println("Enter a new venue");
            venue = choosingVenue(eventType);
            // Recursion to check everytime
            checkConflict(name, eventType, venue, capacity, startTime, endTime);
        }
        else{
            return;
        }
    }
}









