
public class SportArea extends Venue {

        // Building 39
        public String buildingOne(){
            // since the rooms and max are shared in all subclasses, we need to clear them every time
            rooms.clear();
            max.clear();
            rooms.add("Room-104");
            rooms.add("Room-202");
            max.put("Room-104", 30);
            max.put("Room-202", 20);
            venue = "Building 39";
            maxCapacity = getMaxCapacity();
            showRooms();
            return venue;
        }

        //building 11
        public String buildingTwo(){
            // since the rooms and max are shared in all subclasses, we need to clear them every time
            rooms.clear();
            max.clear();

            rooms.add("Room-129");
            rooms.add("Room-130");
            rooms.add("Room-131");
            rooms.add("Room-132");

            max.put("Room-129", 30);
            max.put("Room-130", 30);
            max.put("Room-131", 40);
            max.put("Room-132", 40);
            venue = "Building 11";
            maxCapacity = getMaxCapacity();
            showRooms();
            return venue;

        }
        // Playing Ground
        public String buildingThree(){
            // since the rooms and max are shared in all subclasses, we need to clear them every time
            rooms.clear();
            max.clear();

            rooms.add("Playing Ground");
            max.put("Playing Ground", 1000);

            venue = "The Stadium";
            maxCapacity = getMaxCapacity();
            showRooms();
            return venue;
        }



    }


