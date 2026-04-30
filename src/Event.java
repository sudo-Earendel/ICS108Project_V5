import java.util.Scanner;
public class Event {
    // This is the method that will give the information of the venue
    Scanner scar = new Scanner(System.in);
    publicSpace space = new publicSpace();
    lectureHall lect = new lectureHall();
    SportArea sprt = new SportArea();
    // syed here
    public String venueSelection(String eventType){
        String venue;
        boolean valid = false;
        while(!valid) {
            // This will give the information of religious evet venue
            if (eventType.equals("Religious")) {
                venue = space.typeOne();
                valid = true;
            }
            // This will give the information of Social event venues
            else if (eventType.equals("Social")) {
                System.out.println("Choose between University cafe and Student mall");
                // if the user typed something other than the choices, an error will be thrown
                try {
                    String place = scar.nextLine();
                    if ((!place.equals("Student mall")) && (!place.equals("University cafe"))) {
                        throw new Exception("You should choose between Student mall and University Cafe");
                    }
                    if (place.equals("University cafe")) {
                        venue = space.typeTwo();
                    } else {
                        venue = space.typeThree();
                    }
                    valid = true;
                } catch (Exception except) {
                    System.out.println(except.getMessage());

                }
            }
            // This will give the information of Sports event venues
            else if (eventType.equals("Sports")) {
                System.out.println("Choose between building 1, building 2 and building 3");
                System.out.println("Choose a number");
                // if the user typed something other than the choices, an error will be thrown
                try {
                    int building = scar.nextInt();
                    if (building == 1) {
                        venue = sprt.buildingOneVenue();
                    } else if (building == 2) {
                        venue = sprt.buildingTwoVenue();
                    } else if (building == 3) {
                        venue = sprt.buildingThreeVenue();
                    } else {
                        throw new Exception("You should choose between 1, 2 and 3 as a building:" +
                                "\n1- building 39\n2- building 11\n 3- The playing ground");
                    }
                    valid = true;
                } catch (Exception except) {
                    System.out.println(except.getMessage());
                }
            }
            // This will give the information of Academic event venues
            else if (eventType.equals("Academic")) {
                System.out.println("Choose between building 1, building 2 and building 3:" +
                        "\n1- building 22\n2- building 63\n3- building 57");
                System.out.println("Choose a number");
                // if the user entered something other than the choice, an error will be thrown
                try {
                    int building = scar.nextInt();
                    if (building == 1) {
                        venue = lect.buildingOne();
                    } else if (building == 2) {
                        venue = lect.buildingTwo();
                    } else if (building == 3) {
                        venue = sprt.buildingThree();
                    } else {
                        throw new Exception("You should choose between 1, 2 and 3 as a building.");
                    }
                    valid = true;
                } catch (Exception except) {
                    System.out.println(except.getMessage());
                }
            }
        }
        return venue;
    }
    //checking if the venue can handle the capacity
    public int capacityHandling(int capacity){

        boolean containable = false;
        while(!containable) {
            if (venue.maxCapacity >= capacity) {
                System.out.print("The venue can Handle the predected amount");
                containable = true;
            } else {
                System.out.print("The venue cant Handle the predected amount. please Change the venue or the amount");
                capacity = scar.nextInt();
            }
        }
        return capacity;
    }

}