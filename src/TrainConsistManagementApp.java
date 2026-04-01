import java.util.ArrayList;
import java.util.HashSet;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // UC1
        String trainName = "Chennai Express";
        System.out.println("Train Name: " + trainName);

        // UC2: Passenger Bogies (ArrayList)
        ArrayList<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("\nAfter Adding Bogies:");
        System.out.println(passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter Removing AC Chair:");
        System.out.println(passengerBogies);

        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nDoes Sleeper exist? " + exists);

        System.out.println("\nFinal Bogie List:");
        System.out.println(passengerBogies);


        // =========================
        // UC3: Unique Bogie IDs (HashSet)
        // =========================

        HashSet<String> bogieIds = new HashSet<>();

        // Adding bogie IDs (with duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIds);
    }
}