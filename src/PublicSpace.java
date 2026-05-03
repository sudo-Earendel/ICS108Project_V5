//the class will be for any even that may occur in spaces like cafe , mosques , Student Mall etc...
public class PublicSpace extends Venue {

    public String typeOne(){
        // since the rooms and max are shared in all subclasses, we need to clear them every time
        rooms.clear();
        max.clear();
        rooms.add("Campus Mosque");
        max.put("Campus Mosque", 100);
        venue = "Campus Mosque";
        maxCapacity = getMaxCapacity();
        showRooms();
        return venue;
    }

    public String typeTwo(){
        // since the rooms and max are shared in all subclasses, we need to clear them every time
        rooms.clear();
        max.clear();

        rooms.add("University Cafe");
        max.put("University Cafe", 24);

        venue = "University Cafe";
        maxCapacity = getMaxCapacity();
        showRooms();
        return venue;

    }

    public String typeThree(){
        // since the rooms and max are shared in all subclasses, we need to clear them every time
        rooms.clear();
        max.clear();

        rooms.add("Student Mall");
        max.put("Student Mall", 242);

        venue = "Student Mall";
        maxCapacity = getMaxCapacity();
        showRooms();
        return venue;
    }


}
