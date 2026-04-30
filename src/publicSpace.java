//the class will be for any even that may occur in spaces like cafe , mosques , Student Mall etc...
public class publicSpace extends Venue {
    public String typeOne(){
        //here if-statement if the event is religious
        //then
        venue = "Cambus mosque";
        maxCapicty = 100;
        System.out.println("The maximum capacity for Campus mosque is "+ maxCapicty);
        return venue;
    }

    public String typeTwo(){
        //here if statements if it's a social event
        //then
        venue = "University cafe";
        maxCapicty = 24;

        System.out.println("The maximum capacity for University cafe is " + maxCapicty);
        return venue;

    }

    public String typeThree(){
        //here if statements if it's a social event
        //then
        venue = "Student mall";
        maxCapicty = 242;
        System.out.println("The maximum capacity for Student mall is " + maxCapicty);
        return venue;
    }


}
