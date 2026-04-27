//the class will be for any even that may occur in spaces like cafe , mosques , Student Mall etc...
public class publicSpace extends Venue {
    String venue;
    public void typeOne(){
        //here if-statement if the event is religious
        //then
        venue = "Cambus mosque";
        maxCapicty = 100;
    }

    public void typeTwo(){
        //here if statements if it's a social event
        //then
        venue = "University cafe";
        maxCapicty = 24;
        System.out.println(venue);
        System.out.println(maxCapicty);

    }

    public void typeThree(){
        //here if statements if it's a social event
        //then
        venue = "Student mall";
        maxCapicty = 242;
        System.out.println(venue);
        System.out.println(maxCapicty);
    }


}
