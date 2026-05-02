
public class lectureHall extends Venue{


    //Building 22
    public String buildingOne(){
        rooms.clear();
        max.clear();

        rooms.add("Room-120");
        rooms.add("Room-335");
        rooms.add("Room-337");
        rooms.add("Room-339");

        max.put("Room-120", 100);
        max.put("Room-335", 20);
        max.put("Room-337", 20);
        max.put("Room-339", 20);

        venue = "Building 22";
        maxCapacity = getMaxCapacity();
        showRooms();
        return venue;
    }

    // Building 63
    public String buildingTwo(){
        rooms.clear();
        max.clear();

        rooms.add("Room-102");
        rooms.add("Room-227");
        rooms.add("Room-229");
        rooms.add("Room-334");

        max.put("Room-102", 30);
        max.put("Room-227", 40);
        max.put("Room-229", 40);
        max.put("Room-334", 100);

        venue = "Building 63";
        maxCapacity = getMaxCapacity();
        showRooms();
        return venue;
    }

    public String buildingThree(){
        rooms.clear();
        max.clear();

        rooms.add("Room-101");
        rooms.add("Room-205");
        rooms.add("Room-309");
        rooms.add("Room-313");

        max.put("Room-101", 15);
        max.put("Room-205", 20);
        max.put("Room-309", 40);
        max.put("Room-313", 40);

        venue = "Building 57";
        maxCapacity = getMaxCapacity();
        showRooms();
        return venue;
    }






}

