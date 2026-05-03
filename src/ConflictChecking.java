import java.util.ArrayList;
import java.util.Scanner;

public class ConflictChecking {
    // Lists to save info and check that there is no conflict
    protected ArrayList<String> names = new ArrayList<>();
    protected ArrayList<Integer> startDates = new ArrayList<>();
    protected ArrayList<Integer> endDates = new ArrayList<>();
    protected ArrayList<Integer> startTimes = new ArrayList<>();
    protected ArrayList<Integer> endTimes = new ArrayList<>();
    protected ArrayList<String> venues = new ArrayList<>();
    protected Scanner input;
    protected SetInformation set;
    protected DataSaving data;
    protected boolean valid = false;

    public ConflictChecking(Scanner input, DataSaving data) {
        this.input = input;
        this.data = data;
        // SetInformation created here with shared Scanner
        // AI helped us in this
        this.set = new SetInformation(input, this);
    }
    // This method will check time conflict if the dates have a day in common
    // The method is not ready yet, it checks the time correctly, but it does not know
    // if the day is in common or not
    // The method that will handle conflicts
    public boolean checkConflict(String name, String eventType, String venue, int capacity,String startDate, String endDate, String startTime, String endTime, String department, String person){
        String response = checkTime(venue, startDate, endDate, startTime, endTime);
        if(response.equals("valid")){
            data.savings(name, eventType, venue, capacity, startDate, endDate, startTime, endTime, department, person);
            names.add(name);
            System.out.println("the venue now is booked");
            return true;
        }
        else if(response.equals("time")){
            System.out.println("Enter new starting time");
            startTime = set.Time();
            System.out.println("Enter new ending time");
            endTime = set.Time();
            // Recursion to check everytime
            return checkConflict(name, eventType, venue, capacity, startDate, endDate, startTime, endTime, department, person);
        }
        else if(response.equals("venue")){
            System.out.println("Enter a new venue");
            venue = set.choosingVenue(eventType);
            // Recursion to check everytime
            return checkConflict(name, eventType, venue, capacity, startDate, endDate, startTime, endTime, department, person);
        }
        // The method needs to check the date also, So it should have an else if to change date

        // If the user typed anything other, the method (and recursion) will end.
        // The program will ask if the user wish to continue
        else{
            return false;
        }
    }
    // This method will check if there is a conflict in time with another time
    public String checkTime(String venue, String startDate, String endDate, String startTime, String endTime){
        int newStartTime = toMinutes(startTime);
        int newEndTime = toMinutes(endTime);
        int newStartDate = toDay(startDate);
        int newEndDate = toDay(endDate);

        try {
            for (int i = 0; i < venues.size(); i++) {
                if (venues.get(i).equals(venue)) {

                    // First check if there is a day in common
                    if (newStartDate <= endDates.get(i) && newEndDate >= startDates.get(i)) {

                        // Then check if times conflict
                        if (startTimes.get(i) < newEndTime && endTimes.get(i) > newStartTime) {
                            // Convert back to HH:mm for display
                            int confStartMin = startTimes.get(i) % 60;
                            int confStartHour = (startTimes.get(i) - confStartMin) / 60;
                            int confEndMin = endTimes.get(i) % 60;
                            int confEndHour = (endTimes.get(i) - confEndMin) / 60;
                            System.out.println("You entered " + startTime + " as a start time");
                            System.out.println("And " + endTime + " as an end time");
                            System.out.println("While there is an event starting at "
                                    + confStartHour + ":" + confStartMin);
                            System.out.println("And ending at "
                                    + confEndHour + ":" + confEndMin);
                            throw new Exception("There is a conflict!");
                        }
                    }
                }
            }
            // If there is no conflict, add values
            venues.add(venue);
            startDates.add(newStartDate);
            endDates.add(newEndDate);
            startTimes.add(newStartTime);
            endTimes.add(newEndTime);
            return "valid";
        } catch (Exception except) {
            System.out.println(except.getMessage());
            System.out.println("Type \"time\" to change time");
            System.out.println("Type \"venue\" to change venue");
            System.out.println("Type \"q\" to quit");
            String change = input.next();
            boolean valid = false;
            while (!valid) {
                try {
                    if ((!change.equals("time")) && (!change.equals("venue"))
                            && (!change.equals("q"))) {
                        throw new Exception("Please enter \"time\", \"venue\" or \"q\"");
                    }
                    valid = true;
                } catch (Exception except2) {
                    System.out.println(except2.getMessage());
                    change = input.next();
                }
            }
            return change;
        }
    }
    // This method will check if the name is uesd
    public String checkName(String name){
        boolean valid = false;
        while(!valid) {
            try {
                for (int i = 0; i<names.size(); i++ ){
                    if(names.get(i).equals(name)){
                        throw new Exception("Your name is used");
                    }
                }
                valid = true;
            }
            catch(Exception except){
                System.out.println(except.getMessage());
                System.out.println("Enter another name ");
                name = input.next();
            }
        }
        return name;
    }

    public boolean checkDate(String venue, String startDate, String endDate){
        int start = toDay(startDate);
        int end = toDay(endDate);
        if (end<start){
            System.out.println("Ending Date cannot start after starting date.");
            return false;
        }
        return true;
    }
    // This method will return days number
    public int toDay(String date){
            int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int month = Integer.parseInt(date.substring(0, 2));
            int day = Integer.parseInt(date.substring(3));
            int total = 0;
            // This loop to add all months days
            for (int m = 1; m < month; m++) {
                total += daysInMonth[m];
            }
            return total + day;
        }
    // This method will return minutes as a number
    public int toMinutes(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        return hour * 60 + minute;
    }
    // This method will delete the event data reserved user want to remove
    public void delete(String name){
        for(int i =0; i<names.size(); i++){
            if(names.get(i).equals(name)){
                names.remove(i);
                startDates.remove(i);
                endDates.remove(i);
                startTimes.remove(i);
                endTimes.remove(i);
                venues.remove(i);
            }
        }
    }

}

