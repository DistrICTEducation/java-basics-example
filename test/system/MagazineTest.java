package system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <p>Java JUnit test class.</p>
 * @author  Joris Schelfaut
 * @since   6 august 2014
 */
public class MagazineTest {
    
    public MagazineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTopic method, of class Magazine.
     */
    @Test
    public void testGetTopic() {
        System.out.println("getTopic");
        Magazine instance = null;
        String expResult = "";
        String result = instance.getTopic();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
