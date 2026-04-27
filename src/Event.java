
public class Event {
    public void venueSelection(String eventType){
        publicSpace space = new publicSpace();
        if(eventType == "Religious"){
            space.typeOne();
        }
        else if(eventType == "Social"){
            space.typeTwo();
            space.typeThree();
        }
    }
}