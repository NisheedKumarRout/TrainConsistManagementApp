import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // ---------- UC12 TESTS ----------

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistManagementApp.GoodsBogie> list = List.of(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal")
        );

        assertTrue(TrainConsistManagementApp.isTrainSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistManagementApp.GoodsBogie> list = List.of(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(TrainConsistManagementApp.isTrainSafe(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistManagementApp.GoodsBogie> list = List.of(
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Box", "Grain")
        );

        assertTrue(TrainConsistManagementApp.isTrainSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistManagementApp.GoodsBogie> list = List.of(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(TrainConsistManagementApp.isTrainSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();

        assertTrue(TrainConsistManagementApp.isTrainSafe(list));
    }
}