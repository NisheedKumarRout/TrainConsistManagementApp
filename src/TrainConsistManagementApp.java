import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

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

    // UC10: Total capacity
    public static int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // 🔥 UC11: Validate Train ID
    public static boolean isValidTrainID(String trainID) {
        String regex = "TRN-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trainID);
        return matcher.matches();
    }

    // 🔥 UC11: Validate Cargo Code
    public static boolean isValidCargoCode(String cargoCode) {
        String regex = "PET-[A-Z]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sample bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));

        // UC8
        System.out.println("\nFiltered Bogies (capacity > 60):");
        filterHighCapacityBogies(bogies, 60).forEach(System.out::println);

        // UC9
        System.out.println("\nGrouped Bogies:");
        groupBogiesByType(bogies).forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach(System.out::println);
        });

        // UC10
        System.out.println("\nTotal Seating Capacity: " + calculateTotalCapacity(bogies));

        // 🔥 UC11 Input Validation
        System.out.print("\nEnter Train ID: ");
        String trainID = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

        if (isValidTrainID(trainID)) {
            System.out.println("Valid Train ID");
        } else {
            System.out.println("Invalid Train ID");
        }

        if (isValidCargoCode(cargoCode)) {
            System.out.println("Valid Cargo Code");
        } else {
            System.out.println("Invalid Cargo Code");
        }
    }
}