import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        String name;
        String eventType;
        int capacity;
        Scanner input = new Scanner(System.in);
        DataSaving data = new DataSaving();
        // The reason we put an argument is to make the input shared with all objects
        // and would prevent stealing from other classes with argument(input)
        // (AI helped us in this)
        ConflictChecking check = new ConflictChecking(input, data);
        // To prevent stealing inputs from other classes
        // (AI helped us in this)
        SetInformation set = new SetInformation(input, check);
        boolean endProgram = false;
        String orderNum;
        //String so the user can input the ( / ) or ( : )
        // The dates are assigned since they would be assigned inside a loop
        String startDate = "";
        String endDate = "";
        String startTime;
        String endTime;
        String answer;
        String venue;
        String department;
        String person;
        System.out.println("Welcome to KFUPM Event Booking platform");
        //while loop so the program continue
        while(!endProgram) {
            //checking if the input is valid
            try {
                System.out.println("Type 1 to book an event");
                System.out.println("Type 2 to delete an event");
                System.out.println("Type 3 to show events\n");
                // The number the user will enter
                orderNum = input.next();
                // Booking an event
                if (orderNum.equals("1")) {
                    // This object call would prevent stealing from other classes with argument(input)
                    //(AI helped us in this)
                    Event event = new Event(input);
                    // These are the methods to set every event information
                    name = set.eventName();
                    eventType = set.eventType();
                    venue = event.venueSelection(eventType);
                    int maxCapacity = event.getCurrentVenueMaxCapacity();
                    capacity = set.capacityChecking(venue, maxCapacity);
                    boolean dateValid = false;
                    // This loop will check the date if it is ok or has a conflict
                    while(!dateValid) {
                        System.out.println("Enter the starting date as 1/01");
                        startDate = set.Date();
                        System.out.println("Enter the ending date as 1/01");
                        endDate = set.Date();
                        dateValid = check.checkDate(venue ,startDate, endDate);
                    }
                    System.out.println("Enter starting time as 1:05");
                    startTime = set.Time();
                    System.out.println("Enter ending time 1:05");
                    endTime = set.Time();
                    department = set.setDepartment();
                    person = set.setPerson();
                    // This method will check the conflict and handle it.
                    // If everything was ok, it will save the data
                    check.checkConflict(name, eventType, venue, capacity,startDate, endDate, startTime, endTime, department, person );
                }
                // This will delete an event by its name
                else if (orderNum.equals("2")) {
                    System.out.println("Type the name of the event you want to delete.");
                    String delName = input.next();
                    // This object will call delete to remove all info in dataSaving
                    boolean operation = data.delete(delName, check);
                    // If the user entered an event that does not exist, an error will be thrown
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
                answer = input.next();
                if (answer.equals("no")) {
                    endProgram = true;
                }
            }
            catch(Exception except){
                System.out.println(except.getMessage());
            }
        }
    }
}









