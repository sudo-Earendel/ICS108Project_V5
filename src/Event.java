import java.util.Scanner;
public class Event {
    // This is the method that will give the information of the venue
    public void venueSelection(String eventType){
        Scanner scnr = new Scanner(System.in);
        publicSpace space = new publicSpace();
        lectureHall lect = new lectureHall();
        SportArea sprt = new SportArea();
        // This will give the information of religious evet venue
        if(eventType.equals("Religious")){
            space.typeOne();
        }
        // This will give the information of Social event venues
        else if(eventType.equals("Social")){
            System.out.println("Choose between University cafe and Student mall");
            // if the user typed something other than the choices, an error will be thrown
            try {
                String place = scnr.nextLine();
                if((!place.equals("Student mall"))&&(!place.equals("University cafe"))) {
                    throw new Exception("You should choose between Student mall and University Cafe");
                }
                if(place.equals("University cafe")) {
                    space.typeTwo();
                }
                else {
                    space.typeThree();
                }

            }
            catch(Exception except){
                System.out.println(except.getMessage());

            }
        }
        // This will give the information of Sports event venues
        else if(eventType.equals("Sports")){
            System.out.println("Choose between building 1, building 2 and building 3");
            System.out.println("Choose a number");
            // if the user typed something other than the choices, an error will be thrown
            try{
                int building = scnr.nextInt();
                if(building == 1){
                    sprt.buildingOne();
                }
                else if (building == 2){
                    sprt.buildingTwo();
                }
                else if (building == 3){
                    sprt.buildingThree();
                }
                else{
                    throw new Exception("You should choose between 1, 2 and 3 as a building");
                }
            }
            catch(Exception except){
                System.out.println(except.getMessage());
            }
        }
        // This will give the information of Academic event venues
        else if(eventType.equals("Academic")) {
            System.out.println("Choose between building 1, building 2 and building 3");
            System.out.println("Choose a number");
            // if the user entered something other than the choice, an error will be thrown
            try{
                int building = scnr.nextInt();
                if(building == 1){
                    sprt.buildingOne();
                }
                else if (building == 2){
                    sprt.buildingTwo();
                }
                else if (building == 3){
                    sprt.buildingThree();
                }
                else{
                    throw new Exception("You should choose between 1, 2 and 3 as a building.");
                }
            }
            catch(Exception except){
                System.out.println(except.getMessage());
            }
        }
    }
}