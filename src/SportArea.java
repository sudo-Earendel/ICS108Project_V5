import java.util.ArrayList;
import java.util.Random;
public class SportArea extends Venu{
    Random rand = new Random(1);
    //method to add the name of the Sport area
    public void buildingOne(){
        //randomizing room numbers
        for(int i = 0;i<6;i++){
            rooms.add("Room-" + rand.nextInt(500)+1);
            //Hashmap to link the building with random rooms
            map.put("Building 39" , rooms);
        }
        maxCapicty = 78;

    }
    public void buildingTwo(){
        for(int i = 0;i<6;i++){
            rooms.add("Room-" + rand.nextInt(100)+1);
            map.put("Building 11" , rooms);
        }
        maxCapicty = 50;

    }
    public void buildingThree(){
        rooms.add("The playing ground");
        map.put("The stadium", rooms);
        maxCapicty = 1000;
    }











}
