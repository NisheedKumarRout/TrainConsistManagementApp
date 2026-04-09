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
    }

    // UC8
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // UC9
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));
    }

    // UC10
    public static int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // UC11
    public static boolean isValidTrainID(String trainID) {
        return Pattern.matches("TRN-\\d{4}", trainID);
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches("PET-[A-Z]{2}", cargoCode);
    }

    // UC12
    public static boolean isTrainSafe(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical")
                                || b.cargo.equalsIgnoreCase("Petroleum")
                );
    }

    // 🔥 UC13: Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // 🔥 UC13: Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        // Create dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", 50 + (i % 50)));
        }

        int threshold = 60;

        // 🔥 Loop Benchmark
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies, threshold);
        long endLoop = System.nanoTime();

        // 🔥 Stream Benchmark
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies, threshold);
        long endStream = System.nanoTime();

        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("Loop Time (ns): " + (endLoop - startLoop));
        System.out.println("Stream Time (ns): " + (endStream - startStream));
    }
}