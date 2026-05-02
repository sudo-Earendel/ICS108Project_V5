import java.util.Scanner;
public class SetInformation {
    protected Scanner input;
    protected timecheck check;
    // We made this as a field since many methods use it
    protected boolean valid = false;

    // A constructor to assign variables
    // AI helped us in this
    public SetInformation(Scanner input, timecheck check) {
        this.input = input;
        this.check = check;
    }
    // This method is to set the name
    public String eventName(){
        String name;
        System.out.println("Enter event name ");
        name = input.next();
        // This will check if the name is used
        name = check.checkName(name);
        return name;
    }

    // This method to set the type
    public String eventType(){
        valid = false;
        System.out.print("Enter the Event type");
        System.out.print("Religious, Social, Sports, Academic.");
        String eventType = input.next();
        //while loop to check everytime that the type is valid
        while(!valid) {
            if((!eventType.equals("Academic")&&!eventType.equals("Sports"))&&(!eventType.equals("Social")&&(!eventType.equals("Religious")))){
                System.out.println("Enter a valid type");
                eventType = input.next();
                continue;
            }
            valid = true;
        }
        return eventType;
    }
    //This method needs some work. It should return the venue as a String
    public String choosingVenue(String eventType){
        String venue;
        System.out.print("Select the desired venue");
        Event event = new Event(input);
        venue = event.venueSelection(eventType);
        return venue;
    }

    // This method needs some work. It should return capacity as an int
    public int capacityChecking(String venue, int maxCapacity){
        int capacity;
        //change the things in the print
        System.out.print("Please enter the predicted amount of comers to the Event");
        capacity = input.nextInt();
        valid = false;
        // This loop will check if the capacity is ok
        while (!valid) {
            if (capacity < 1) {
                System.out.println("You can not enter a number less than one");
                capacity = input.nextInt();
            } else if (capacity > maxCapacity) {
                System.out.println("Venue cannot handle this number!\n" + maxCapacity + " is the maximum number.");
                capacity = input.nextInt();
            } else {
                valid = true;
            }
        }
        return capacity;
    }

    // This method to set a valid date
    // It "ONLY" check if the date is valid (month/day)
    public String Date(){
        String date;
        date = input.next();
        valid = false;
        while(!valid){
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
                valid = true;
            }
            catch(Exception except){
                System.out.println(except.getMessage());
                System.out.println("Enter a new date");
                date = input.next();
            }
        }
        return date;
    }

    // This method is to set a valid time
    // It "ONLY" checks if the time is valid(Hour:Minute)
    public String Time(){
        String time = input.next();
        while(!valid) {
            try {
                if((time.length()!=4) && (time.length()!=5)){
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
                if((Hour < 0) || (Hour > 23)){
                    throw new Error("The hour is not valid");
                }
                if((Minute < 0) || (Minute > 59)){
                    throw new Error("The minute is not valid");
                }
                valid = true;
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Enter a new time");
                time = input.next();
            }
        }
        return time;
    }
}
