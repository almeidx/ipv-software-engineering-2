import com.es2.whiteboxconditions.Rating;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestWhiteBoxCondition {
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        new End();
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @DisplayName("Test White-box Conditions of evaluateScoreTemperature()")
    @Test
    void testScoreTemperature() {
        Rating r = new Rating();
        assertEquals("It's hot out, and so am I", r.evaluateScoreTemperature(10, 35));
        assertEquals("I'm balanced", r.evaluateScoreTemperature(8, 24));
        assertEquals("I'm in a bad mood", r.evaluateScoreTemperature(4, 5));
        assertEquals("I'm balanced", r.evaluateScoreTemperature(6, 21));
    }

    @DisplayName("Test White-box Conditions of evaluateIfCouldBeAcceptedAtDisco()")
    @Test
    void testAcceptedAtDisco() {
        Rating r = new Rating();
        assertEquals("Accepted", r.evaluateIfCouldBeAcceptedAtDisco(8, 5));
        assertEquals("Not Accepted", r.evaluateIfCouldBeAcceptedAtDisco(7, 4));
    }
}
