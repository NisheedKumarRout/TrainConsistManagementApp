import java.util.*;

class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // toString() for printing
    public String toString() {
        return name + " -> " + capacity;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // UC1
        String trainName = "Chennai Express";
        System.out.println("Train Name: " + trainName);

        // UC2: ArrayList
        ArrayList<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        passengerBogies.remove("AC Chair");
        boolean exists = passengerBogies.contains("Sleeper");

        // UC3: HashSet
        HashSet<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");

        // UC4: LinkedList
        LinkedList<String> trainConsist = new LinkedList<>();
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");
        trainConsist.add(2, "Pantry");
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // UC5: LinkedHashSet
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        // UC6: HashMap
        HashMap<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);


        // =========================
        // UC7: Sort Bogies using Comparator
        // =========================

        List<Bogie> bogieList = new ArrayList<>();

        // Add bogie objects
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 24));

        System.out.println("\nBefore Sorting:");
        System.out.println(bogieList);

        // Sort using Comparator (by capacity)
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting (by Capacity):");
        System.out.println(bogieList);
    }
}