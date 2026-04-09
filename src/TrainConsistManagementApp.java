import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

public class TrainConsistManagementApp {

    // Passenger Bogie
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

    // Goods Bogie
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " - Cargo: " + cargo;
        }
    }

    // UC8: Filter
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // UC9: Group
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));
    }

    // UC10: Reduce
    public static int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // UC11: Regex Validation
    public static boolean isValidTrainID(String trainID) {
        return Pattern.matches("TRN-\\d{4}", trainID);
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches("PET-[A-Z]{2}", cargoCode);
    }

    // 🔥 UC12: Safety Check
    public static boolean isTrainSafe(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical")
                                || b.cargo.equalsIgnoreCase("Petroleum")
                );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Passenger bogies
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

        // UC11
        System.out.print("\nEnter Train ID: ");
        String trainID = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

        System.out.println(isValidTrainID(trainID) ? "Valid Train ID" : "Invalid Train ID");
        System.out.println(isValidCargoCode(cargoCode) ? "Valid Cargo Code" : "Invalid Cargo Code");

        // 🔥 UC12
        List<GoodsBogie> goods = new ArrayList<>();
        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Open", "Coal"));
        goods.add(new GoodsBogie("Box", "Grain"));

        boolean safe = isTrainSafe(goods);

        System.out.println("\nTrain Safety Status: " + (safe ? "SAFE" : "UNSAFE"));
    }
}