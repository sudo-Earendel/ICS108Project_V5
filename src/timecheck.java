import java.util.ArrayList;
import java.util.Scanner;
import java.lang.NumberFormatException;
public class timecheck extends Event {
    // Lists to save info and check that there is no conflict
    protected ArrayList<String> names = new ArrayList<>();
    protected ArrayList<Integer> startDates = new ArrayList<>();
    protected ArrayList<Integer> endDates = new ArrayList<>();
    protected ArrayList<Integer> startTimes = new ArrayList<>();
    protected ArrayList<Integer> endTimes = new ArrayList<>();
    protected ArrayList<String> venues = new ArrayList<>();
    protected Scanner input = new Scanner(System.in);
    protected SetInformation set = new SetInformation();
    protected dataSaving data = new dataSaving();
    protected boolean valid = false;
    // This method will check time conflict if the dates hava a day in common
    // The method is not ready yet, it checks the time correctly, but it does not know
    // if the day is in common or not
    // The method that will handle conflicts
    public void checkConflict(String name, String eventType, String venue, int capacity, String startTime, String endTime){
        String response = checkTime(venue, startTime, endTime);
        if(response.equals("valid")){
            data.savings(name, eventType, venue, capacity, startTime, endTime);
            System.out.print("the venue now is booked");
        }
        else if(response.equals("time")){
            System.out.println("Enter new starting time");
            startTime = set.Time();
            System.out.println("Enter new ending time");
            endTime = set.Time();
            // Recursion to check everytime
            checkConflict(name, eventType, venue, capacity, startTime, endTime);
        }
        else if(response.equals("venue")){
            System.out.println("Enter a new venue");
            venue = set.choosingVenue(eventType);
            // Recursion to check everytime
            checkConflict(name, eventType, venue, capacity, startTime, endTime);
        }
        // The method needs to check the date also, So it should have an else if to change date

        // If the user typed anything other, the method (and recursion) will end.
        // The program will ask if the user wish to continue
        else{
            return;
        }
    }
    // This method will check if there is a conflict in time with another time
    public String checkTime(String venue, String start, String end){
        int startHour = Integer.parseInt(start.substring(0,2));
        int startMinute = Integer.parseInt(start.substring(3));
        int endHour = Integer.parseInt(end.substring(0,2));
        int endMinute = Integer.parseInt(end.substring(3));
        try {
            int startTime = (startHour*60)+startMinute;
            int endTime = (endHour*60)+endMinute;
            for(int i = 0; i<venues.size(); i++){
                if(venues.get(i).equals(venue)){
                    if(startTimes.get(i)<endTime && endTimes.get(i) > startTime){
                        int confStartMin = startTimes.get(i)%60;
                        int confStartHour = (startTimes.get(i)-confStartMin)/60;
                        int confEndMin = endTimes.get(i)%60;
                        int confEndHour = (endTimes.get(i)-confEndMin)/60;
                        System.out.println("You entered " + startHour + ":" + startMinute + " as a start time");
                        System.out.println("And "+endHour+":"+endMinute +" as an end time");
                        System.out.println("While there is an event start at " + confStartHour+":"+confStartMin);
                        System.out.println("And end at "+confEndHour +":"+confEndMin);
                        throw new Exception("There is a time conflict");
                    }
                }
            }
            // If there is no time conflict, add info into lists to make it reserved(booked)
            venues.add(venue);
            startTimes.add(startTime);
            endTimes.add(endTime);
            return "valid";
        }
        catch(Exception except){
            System.out.println(except.getMessage());
            System.out.println("type \"time\" to change time or\"venue\" to change venue, or type \"q\" to quit");
            // This value will help to know what is the info user want to change
            String change = input.next();
            while(!valid) {
                try {
                    if (((!change.equals("time")) && (!change.equals("venue"))) && (!change.equals("q"))) {
                        throw new Exception("Plese enter \"time\", \"venue\" or \"q\"");
                    }
                    valid = true;
                }
                catch (Exception except2) {
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
                    if(names.get(i)==name){
                        throw new Exception("Your name is used");
                    }
                }
                names.add(name);
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
    // This method will delete the event data reserved user want to remove
    public void delete(String name){
        for(int i =0; i<names.size(); i++){
            if(names.get(i).equals(name));{
                names.remove(i);
                startTimes.remove(i);
                endTimes.remove(i);
                venues.remove(i);
            }
        }
    }

}

