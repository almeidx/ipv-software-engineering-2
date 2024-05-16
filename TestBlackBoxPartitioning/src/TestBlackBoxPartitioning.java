import com.es2.blackboxpartitioning.Die;
import com.es2.blackboxpartitioning.ArrayUtils;
import com.es2.blackboxpartitioning.End;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestBlackBoxPartitioning {
    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testRandomness(){

    }

    @Test
    public void testConstructorNoParams(){
        Die testDie = new Die();
        assertEquals(6, testDie.getNumSides());
    }

    @Test
    public void testConstructorOneParam(){
        Die testDie = new Die(4);
        assertEquals(4, testDie.getNumSides());
        assertEquals(1, testDie.getResult());
    }

    @Test
    public void testConstructorTwoParams(){
        Die testDie = new Die(4, 2);
        assertEquals(4, testDie.getNumSides());
        assertEquals(2, testDie.getResult());
    }

    @Test
    public void testGetNumSidesSmall(){
        assertThrows(AssertionError.class, () -> {
            Die d = new Die(1);
        });
    }

    @Test
    public void testGetNumSidesBig(){
        assertThrows(AssertionError.class, () -> {
            Die d = new Die(10);
        });
    }

    @Test
    public void testRollNotOutOfBounds(){
        Die d = new Die(6);
        for(int x = 0; x < 10000; x++ ){
            d.roll();
            assertTrue(d.getResult()>=1 && d.getResult() <= 6);
        }
    }

    @Test
    public void testToString(){
        Die d = new Die(1, 1);
        assertEquals("Num sides " + d.getNumSides() + " result " + d.getResult(), d.toString());
    }

    @Test
    public void testFindMinInvalid(){
        int[] list = new int[0];
        assertThrows(AssertionError.class, () -> {
            ArrayUtils.findMin(list);
        });
    }

    @Test
    public void testFindMinValid(){
        int[] list = new int[4];
        list[0] = 1;
        list[1] = 2;
        list[2] = 3;
        list[3] = 4;
        assertEquals(ArrayUtils.findMin(list),0);;
    }

    @Test
    public void testGoodResizeInvalid(){
        int[] list = new int[0];
        assertThrows(AssertionError.class, () -> {
            ArrayUtils.goodResize(list, -1);
        });
    }

    @Test
    public void testGoodResizeValid(){
        int[] list = new int[4];
        list[0] = 1;
        list[1] = 2;
        list[2] = 3;
        list[3] = 4;
        assertEquals(ArrayUtils.goodResize(list, 6), new int[]{1,2,3,4,0,0});
        assertEquals(ArrayUtils.goodResize(list, 3), new int[]{1,2,3,4});;
    }

    @Test
    public void testFindAndPrintPairsInvalid(){
        int[] list = null;
        assertThrows(AssertionError.class, () -> {
            ArrayUtils.findAndPrintPairs(list, 0);
        });
    }

    @Test
    public void testFindAndPrintPairsValid(){
        int[] list = new int[4];
        list[0] = 1;
        list[1] = 2;
        list[2] = 3;
        list[3] = 4;
        outContent.reset();
        ArrayUtils.findAndPrintPairs(list, 6);
        assertEquals("The two elements at indices 1 and 3 are 2 and 4 add up to 6", outContent.toString());
        outContent.reset();
        ArrayUtils.findAndPrintPairs(list, -1);
        assertEquals("", outContent.toString());
        outContent.reset();
        ArrayUtils.findAndPrintPairs(list, 20);
        assertEquals("", outContent.toString());
    }

    @Test
    public void testByteArrayOutputStream(){
        ByteArrayOutputStream BA = new ByteArrayOutputStream();
        assertEquals(0, BA.size());
        BA.write(62);
        assertEquals(">", BA.toString());
        assertEquals(1, BA.size());
    }

    @AfterAll
    static void tearDown() {
        End e = new End();
    }
}
