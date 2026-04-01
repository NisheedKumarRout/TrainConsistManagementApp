import java.util.ArrayList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // UC1 (already existing)
        String trainName = "Chennai Express";
        System.out.println("Train Name: " + trainName);

        // UC2: Passenger Bogies using ArrayList
        ArrayList<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("\nAfter Adding Bogies:");
        System.out.println(passengerBogies);

        // Remove a bogie
        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter Removing AC Chair:");
        System.out.println(passengerBogies);

        // Check existence
        boolean exists = passengerBogies.contains("Sleeper");

        System.out.println("\nDoes Sleeper exist? " + exists);

        // Final state
        System.out.println("\nFinal Bogie List:");
        System.out.println(passengerBogies);
    }
}