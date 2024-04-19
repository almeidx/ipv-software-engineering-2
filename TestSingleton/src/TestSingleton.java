import static org.junit.jupiter.api.Assertions.*;
import com.es2.singleton.Registry;
import org.junit.jupiter.api.*;

public class TestSingleton {
    @Test
    public void testSetPath() {
        Registry registry = Registry.getInstance();
        String path = "/path/to/file";
        registry.setPath(path);
        assertEquals(path, registry.getPath());
    }

    @Test
    public void testSetConnectionString() {
        Registry registry = Registry.getInstance();
        String connectionString = "jdbc:mysql://localhost:3306/db";
        registry.setConnectionString(connectionString);
        assertEquals(connectionString, registry.getConnectionString());
    }

    @Test
    public void testSetPathWithNullValue() {
        Registry registry = Registry.getInstance();
        registry.setPath(null);
        assertNull(registry.getPath());
    }

    @Test
    public void testSetConnectionStringWithNullValue() {
        Registry registry = Registry.getInstance();
        registry.setConnectionString(null);
        assertNull(registry.getConnectionString());
    }

    @Test
    public void testPrivateConstructor() {
        try {
            Registry.class.getDeclaredConstructor().newInstance();
            fail("Constructor is not private");
        } catch (Exception e) {
            // Constructor is private, so an exception is expected
        }
    }

    @AfterAll
    static void tearDown() {
        End end = new End();
    }
}
