// Same concept of the sportArea
import java.util.Random;
public class lectureHall extends Venue{

    //randomizing room numbers
    Random rand = new Random(1);
    // Sport event venues
    public void buildingOne(){
        //randomizing room numbers
        for (int i = 0; i < 6; i++){
            rooms.add("Rooms-" + rand.nextInt(500) + 1);
            //Hashmap to link the building with rooms
            map.put("Building 22", rooms);
        }

        for(int i = 0;i < rooms.size();i++){
            maxCapicty = rand.nextInt(150);
            max.put(rooms.get(i) ,maxCapicty);
        }




    }

    public void buildingTwo(){
        for (int i = 0; i < 6; i++) {
            rooms.add("Room-" + rand.nextInt(100) + 1);
            map.put("Building 63", rooms);
        }

        for(int i = 0;i < rooms.size();i++){
            maxCapicty = rand.nextInt(200);
            max.put(rooms.get(i) ,maxCapicty);
        }


    }

    public void buildingThree(){
        for (int i = 0; i < 6; i++) {
            rooms.add("Room-" + rand.nextInt(100) + 1);
            map.put("Building 57", rooms);
        }

        for(int i = 0;i < rooms.size();i++){
            maxCapicty = rand.nextInt(200);
            max.put(rooms.get(i) ,maxCapicty);
        }


    }






}

