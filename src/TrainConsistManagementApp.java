import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // Bogie class
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

    // UC8: Filter bogies
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // UC9: Group bogies
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));
    }

    // UC10: Calculate total capacity
    public static int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        // UC8
        System.out.println("\nFiltered Bogies (capacity > 60):");
        List<Bogie> filtered = filterHighCapacityBogies(bogies, 60);
        filtered.forEach(System.out::println);

        // UC9
        System.out.println("\nGrouped Bogies:");
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        grouped.forEach((type, list) -> {
            System.out.println(type + ":");
            list.forEach(System.out::println);
        });

        // UC10
        int totalCapacity = calculateTotalCapacity(bogies);
        System.out.println("\nTotal Seating Capacity: " + totalCapacity);
    }
}