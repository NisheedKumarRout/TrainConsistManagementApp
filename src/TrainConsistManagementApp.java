import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // Existing Bogie class (assumed from UC7)
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " - Capacity: " + capacity;
        }
    }

    // 🔥 UC8 METHOD
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        // Sample data (reuse UC7 list ideally)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        // 🔥 Apply UC8 filtering
        List<Bogie> filtered = filterHighCapacityBogies(bogies, 60);

        System.out.println("\nFiltered Bogies (capacity > 60):");
        filtered.forEach(System.out::println);
    }
}