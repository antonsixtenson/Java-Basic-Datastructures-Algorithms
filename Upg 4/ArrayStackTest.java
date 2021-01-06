import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayStackTest {

    ArrayStack s1;
    ArrayStack s2;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void copyArrayStack(){
        ArrayStack testStack = new ArrayStack();
        boolean val = true;
        for(int i = 0; i < 50; i++){
            testStack.push(i);
        }
        ArrayStack cpStack = testStack.copy();
        for(int j = 0; j<50; j++){
            if(! cpStack.pop().equals(testStack.pop())) {
                val = false;
                break;
            }
            assertEquals("copy Stack test: ", true, val);
        }
    }
}
