import java.util.ArrayList;
import java.util.HashMap;
//abstract class because its only a Venu (A general term)
public abstract class Venue {
        // protected so subclasses can use the variables
        protected ArrayList<String> rooms = new ArrayList<>();
        protected HashMap<String, ArrayList<String>> map = new HashMap<>(); //change the name latter
        protected int maxCapicty;
        //So I connect each room with a specif capacity
        protected HashMap< String, Integer> max = new HashMap<>();
        protected ArrayList<String> times;
        protected String venue;


        }





















