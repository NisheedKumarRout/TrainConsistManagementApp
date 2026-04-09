import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 60)
        );

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 60);

        assertEquals(1, result.size());
        assertEquals(72, result.get(0).capacity);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("AC Chair", 60)
        );

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("First Class", 40)
        );

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("General", 80)
        );

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        TrainConsistManagementApp.filterHighCapacityBogies(bogies, 60);

        assertEquals(1, bogies.size()); // original unchanged
    }
}