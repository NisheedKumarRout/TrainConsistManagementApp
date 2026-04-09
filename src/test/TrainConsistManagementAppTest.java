import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TrainConsistManagementAppTest {

    // ---------- UC14 TESTS ----------

    @Test
    void testException_ValidCapacityCreation() throws Exception {
        TrainConsistManagementApp.Bogie b =
                new TrainConsistManagementApp.Bogie("Sleeper", 72);

        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.Bogie("Sleeper", -10)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.Bogie("Sleeper", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.Bogie("AC Chair", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        TrainConsistManagementApp.Bogie b =
                new TrainConsistManagementApp.Bogie("Sleeper", 70);

        assertEquals("Sleeper", b.type);
        assertEquals(70, b.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();

        list.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));
        list.add(new TrainConsistManagementApp.Bogie("AC Chair", 60));

        assertEquals(2, list.size());
    }
}