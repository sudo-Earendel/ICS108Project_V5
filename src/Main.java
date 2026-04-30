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
        timecheck timeCheck = new timecheck();
        boolean endProgram = true;
        //String so the user can input the ( : )
        String startTime;
        String endTime;
        String answer;
        String venue;
        System.out.println("Welcome to KFUPM Event Booking platform");
        //while loop so the program continue

        while(endProgram) {
                System.out.print("Enter the Event type");
                System.out.print("Religious, Social, Sports, Academic, Other.");
                eventType = input.next();
                System.out.print("Select the desired venue");
                venue = event.venueSelection(eventType);
                //change the things in the print
                System.out.print("Please enter the predected amount of comeers to the Event");
                capacity = input.nextInt();
                event.capacityHandling(capacity);
                System.out.print("What is the start Time for the event");
                startTime = input.nextLine();
                timeCheck.startTime(startTime);
                System.out.print("What is the end Time for the event");
                endTime = input.nextLine();
                timeCheck.endTime(endTime);
                System.out.print("the venue know is booked");
                System.out.print("Do u wish  to continue? (yes, no)");
                answer = input.nextLine();
                if(answer == "no"){
                    endProgram = false;
                }


        }


        }




        }






