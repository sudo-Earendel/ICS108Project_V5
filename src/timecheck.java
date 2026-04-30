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
    protected ArrayList<Venue> venues = new ArrayList<>();
    // This method will check time conflict if the dates hava a day in common
    // The method is not ready yet, it checks the time correctly, but it does not know
    // if the day is in common or not
    public String checkTime(Venue venue, String start, String end){
        int startHour = Integer.parseInt(start.substring(0,2));
        int startMinute = Integer.parseInt(start.substring(3));
        int endHour = Integer.parseInt(start.substring(0,2));
        int endMinute = Integer.parseInt(start.substring(3));
        Scanner scnr = new Scanner(System.in);
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
            boolean changeValue = false;
            while(!changeValue) {
                try {
                    System.out.println("type \"time\" to change time or\"venue\" to change venue, or type \"q\" to quit");
                    String change = scnr.next();
                    if (((!change.equals("time")) && (!change.equals("venue"))) && (!change.equals("q"))) {
                        throw new Exception("Plese enter \"time\", \"venue\" or \"q\"");
                    }
                    //changeValue = true;
                    return change;
                } catch (Exception except2) {
                    System.out.println(except2.getMessage());
                }
            }
        }
    }
    // This method will check if the name is uesd
    public String checkName(String name){
        Scanner scnr = new Scanner(System.in);
        boolean valid = false;
        while(!valid) {
            try {
                for (int i = 0; i<name.size(); i++ ){
                    if(names.get(i)==name){
                        throw new Exception("Your name is used");
                    }
                }
                names.add(name);
                valid = true;
                return name;
            }
            catch(Exception except){
                System.out.println(except.getMessage());
                System.out.println("Enter another name ");
                name = scnr.next();
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

