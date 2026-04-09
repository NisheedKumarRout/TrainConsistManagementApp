import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // ---------- UC13 TESTS ----------

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> list = List.of(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 50)
        );

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingLoop(list, 60);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> list = List.of(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 50)
        );

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingStream(list, 60);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.Bogie> list = List.of(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 65)
        );

        List<TrainConsistManagementApp.Bogie> loopResult =
                TrainConsistManagementApp.filterUsingLoop(list, 60);

        List<TrainConsistManagementApp.Bogie> streamResult =
                TrainConsistManagementApp.filterUsingStream(list, 60);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));
        }

        long start = System.nanoTime();
        TrainConsistManagementApp.filterUsingStream(list, 60);
        long end = System.nanoTime();

        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(new TrainConsistManagementApp.Bogie("Sleeper", 50 + (i % 50)));
        }

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingStream(list, 60);

        assertTrue(result.size() > 0);
    }
}