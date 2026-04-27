
import java.util.Random;
public class SportArea extends Venue {

        //randomizing room numbers
        Random rand = new Random(1);
        // Sport event venues
        public void buildingOne(){
            //randomizing room numbers
            for (int i = 0; i < 6; i++){
                rooms.add("Rooms-" + rand.nextInt(500) + 1);
                //Hashmap to link the building with rooms
                map.put("Building 39", rooms);
            }
            //Randomizing room capacity
            for(int i = 0;i < rooms.size();i++){
                maxCapicty = rand.nextInt(150);
                max.put(rooms.get(i) ,maxCapicty);
            }




        }

        public void buildingTwo(){
            for (int i = 0; i < 6; i++) {
                rooms.add("Room-" + rand.nextInt(100) + 1);
                map.put("Building 11", rooms);
            }

            for(int i = 0;i < rooms.size();i++){
                maxCapicty = rand.nextInt(200);
                max.put(rooms.get(i) ,maxCapicty);
            }


        }

        public void buildingThree(){
            rooms.add("The playing ground");
            map.put("The stadium", rooms);
            maxCapicty = rand.nextInt(1000) + 1;
        }



    }


