import java.util.Scanner;
public class Event {
    public String[] theEventType(){


    }
    public void venueSelection(String eventType){
        Scanner scnr = new Scanner(System.in);
        publicSpace space = new publicSpace();
        lectureHall lect = new lectureHall();
        SportArea sprt = new SportArea();
        if(eventType.equals("Religious")){
            space.typeOne();
        }
        else if(eventType.equals("Social")){
            System.out.println("Choose between University cafe and Student mall");
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
        else if(eventType.equals("Sports")){
            System.out.println("Choose between building 1, building 2 and building 3");
            System.out.println("Choose a number");
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
        else{
            System.out.println("Choose between building 1, building 2 and building 3");
            System.out.println("Choose a number");
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
    }
}