import java.util.ArrayList;
public class dataSaving{
    protected ArrayList<String> names = new ArrayList<String>();
    protected ArrayList<String> types = new ArrayList<String>();
    protected ArrayList<String> venues = new ArrayList<>();
    protected ArrayList<Integer> capacities = new ArrayList<>();
    protected ArrayList<String> startDates = new ArrayList<>();
    protected ArrayList<String> endDates = new ArrayList<>();
    protected ArrayList<String> startTimes = new ArrayList<>();
    protected ArrayList<String> endTimes = new ArrayList<>();
    protected ArrayList<String> departments = new ArrayList<>();
    protected ArrayList<String> persons = new ArrayList<>();
    // This method will save the data
    public void savings(String name,String eventType, String venue, int capacity,String startDate, String endDate, String startTime, String endTime, String department, String person){
        names.add(name);
        types.add(eventType);
        venues.add(venue);
        capacities.add(capacity);
        startDates.add(startDate);
        endDates.add(endDate);
        startTimes.add(startTime);
        endTimes.add(endTime);
        departments.add(department);
        persons.add(person);
        //I did not put sponsor info until now
    }
    //This method will show all events datas
    public void showInfo(){

        for(int i = 0; i<names.size();i++){
            System.out.println("Name: " + names.get(i)+
                    ". Event type: "+types.get(i)+". Venue: " + venues.get(i) +
                    "\nThe event is sponsored by "+departments.get(i) +" department, and " +
                    persons.get(i) + " is the responsible person" +
                    ".\n Date: from" + startDates.get(i)+" at "+startTimes.get(i)+
                    "To "+endDates.get(i)+" at "+endTimes.get(i));
        }
    }
    //This method will delete desired event
    public boolean delete(String name, timecheck timeCheck){
        for(int i = 0; i<names.size(); i++){
            if(names.get(i).equals(name)){
                // to delete data from timecheck class
                timeCheck.delete(name);
                names.remove(i);
                types.remove(i);
                venues.remove(i);
                capacities.remove(i);
                startDates.remove(i);
                endDates.remove(i);
                startTimes.remove(i);
                endTimes.remove(i);
                departments.remove(i);
                persons.remove(i);
                System.out.println("The event has been deleted");
                return true;
            }
        }
        return false;

    }

}
