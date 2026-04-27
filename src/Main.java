import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        String eventType;
        int capacity;
        Scanner input = new Scanner(System.in);
        SportArea sportArea = new SportArea();
        lectureHall lH = new lectureHall();
        publicSpace pS = new publicSpace();
        Event event = new Event();
        boolean endProgram = true;
        System.out.println("Welcome to KFUPM Event Booking platform");
        //while loop so the program continue
        while(endProgram) {
            System.out.print("Enter the Event type");
            System.out.print(event.types);
            // try and catch block to prevent dumb error
            // Handle ALL dumb input
            try {

                eventType = input.nextLine();
                System.out.print("Select the desired venue");
                event.venueSelection(eventType);
                //change the things in the print
                System.out.print("Please enter the predected amount of comeers to the Event");
                capacity = input.nextInt();
                //if statement for the maxCapacity in the specifc venue


            } catch (Exception e) {

                System.out.print("Please Enter a vaild type");

            }
        }






    }
}