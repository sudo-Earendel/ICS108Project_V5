import java.util.ArrayList;
import java.util.HashMap;
//abstract class because its only a Venu (A general term)
public abstract class Venue {
        // protected so subclasses can use the variables
        protected ArrayList<String> rooms = new ArrayList<>();
        // Miximum capacity
        protected int maxCapacity;
        //So I connect each room with a specif capacity
        protected HashMap< String, Integer> max = new HashMap<>();
        // Name of the venue
        protected String venue;

        // This method will find the highest capacity room available
        // AI helped us in this
        public int getMaxCapacity() {
            int highest = 0;
            for (int cap : max.values()) {
                if (cap > highest) {
                    highest = cap;
                }
            }
            return highest;
        }

        // Returns the capacity of a specific room
        public int getRoomCapacity(String room) {
            return max.get(room);
        }

        // Returns all available rooms
        public ArrayList<String> getRooms() {
            return rooms;
        }

        // Shows all rooms and their capacities
        public void showRooms() {
            System.out.println("Available rooms in " + venue + ":");
            for (String room : rooms) {
                System.out.println("  " + room + " → Capacity: " + max.get(room));
            }
        }

}





















