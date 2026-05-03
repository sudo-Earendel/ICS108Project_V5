import java.util.Scanner;
public class Event {
    // This is the method that will give the information of the venue
    Scanner input;
    publicSpace space = new publicSpace();
    lectureHall lect = new lectureHall();
    SportArea sprt = new SportArea();
    // This variable will help to get maximum capacity
     Venue currentVenue;
    // A constructor
    public Event(Scanner input){
        this.input = input;
    }
    // syed here
    public String venueSelection(String eventType){
        String venue = "";
        boolean valid = false;
        while(!valid) {
            // This will give the information of religious evet venue
            if (eventType.equals("Religious")) {
                venue = space.typeOne();
                currentVenue = space;
                valid = true;
            }
            // This will give the information of Social event venues
            else if (eventType.equals("Social")) {
                System.out.println("Choose between University cafe and Student mall");
                // if the user typed something other than the choices, an error will be thrown
                try {
                    input.nextLine(); // This will clear leftovers from previous input (AI helped us in this)
                    String place = input.nextLine();
                    if ((!place.equals("Student mall")) && (!place.equals("University cafe"))) {
                        throw new Exception("You should choose between Student mall and University Cafe");
                    }
                    if (place.equals("University cafe")) {
                        venue = space.typeTwo();
                        currentVenue = space;
                    } else {
                        venue = space.typeThree();
                        currentVenue = space;
                    }
                    valid = true;
                } catch (Exception except) {
                    System.out.println(except.getMessage());
                }
            }
            // This will give the information of Sports event venues
            else if (eventType.equals("Sports")) {
                System.out.println("Choose between\n1- building 39\n2- building 11\n3- sport area");
                System.out.println("Choose a number");
                // if the user typed something other than the choices, an error will be thrown
                try {
                    int building = input.nextInt();
                    if (building == 1) {
                        venue = sprt.buildingOne();
                        currentVenue = sprt;
                    } else if (building == 2) {
                        venue = sprt.buildingTwo();
                        currentVenue = sprt;
                    } else if (building == 3) {
                        venue = sprt.buildingThree();
                        currentVenue = sprt;
                    } else {
                        throw new Exception("You should choose between 1, 2 and 3 as a building:" +
                                "\n1- building 39\n2- building 11\n 3- The playing ground");
                    }
                    valid = true;
                } catch (Exception except) {
                    System.out.println(except.getMessage());
                    input.nextLine();
                }
            }
            // This will give the information of Academic event venues
            else if (eventType.equals("Academic")) {
                System.out.println("Choose between\n1- building 22\n2- building 63\n3- building 57");
                System.out.println("Choose a number");
                // if the user entered something other than the choice, an error will be thrown
                try {
                    int building = input.nextInt();
                    if (building == 1) {
                        venue = lect.buildingOne();
                        currentVenue = lect;
                    } else if (building == 2) {
                        venue = lect.buildingTwo();
                        currentVenue = lect;
                    } else if (building == 3) {
                        venue = lect.buildingThree();
                        currentVenue = lect;
                    } else {
                        throw new Exception("You should choose between 1, 2 and 3 as a building.");
                    }
                    valid = true;
                } catch (Exception except) {
                    System.out.println(except.getMessage());
                    input.nextLine();
                }
            }
        }
        return venue;
    }
    public int getCurrentVenueMaxCapacity() {
        return currentVenue.maxCapacity;
    }

}