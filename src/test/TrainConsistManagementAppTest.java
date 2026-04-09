import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // ---------- UC10 TESTS ----------

    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 60)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(132, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("Sleeper", 70),
                new TrainConsistManagementApp.Bogie("AC Chair", 60),
                new TrainConsistManagementApp.Bogie("First Class", 40)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(170, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("Sleeper", 72)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(0, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("Sleeper", 50),
                new TrainConsistManagementApp.Bogie("AC Chair", 50)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(100, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(1, bogies.size());
    }
}