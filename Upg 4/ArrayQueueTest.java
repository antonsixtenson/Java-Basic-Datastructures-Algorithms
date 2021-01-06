import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayQueueTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void reverse() {
        ArrayQueue aq = new ArrayQueue();
        boolean val = true;
        for(int i = 0; i < 50; i++) {
            Object ins = "" + i;
            aq.enqueue(ins);
        }

        ArrayQueue revQueue = aq.reverse();

        for(int i = 49; i >= 0; i--) {
            Object b = ""+i;
            if(!(revQueue.dequeue().equals(b))) val = false;
        }
        assertEquals("reverses and chech if same", true, val);
    }
}
