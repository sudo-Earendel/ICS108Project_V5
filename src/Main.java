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
        SetInformation set = new SetInformation();
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
                    name = set.eventName();
                    eventType = set.eventType();
                    venue = set.choosingVenue(eventType);
                    capacity = set.capacityChecking(venue);
                    boolean dateValid = false;
                    System.out.println("Enter the starting date");
                    startDate = set.Date();
                    System.out.println("Enter the ending date");
                    endDate = set.Date();
                    System.out.println("Enter starting time ");
                    startTime = set.Time();
                    System.out.println("Enter ending time ");
                    endTime = set.Time();
                    // This method will check the conflict and handle it.
                    // If everything was ok, it will save the data
                    timeCheck.checkConflict(name, eventType, venue, capacity, startTime, endTime );
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
}









