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
public class BookTest {
    
    public BookTest() {
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
     * Test of correctISBNFormat method, of class Book.
     */
    @Test
    public void testCorrectISBNFormat() {
        System.out.println("correctISBNFormat");
        String isbn = "";
        boolean expResult = false;
        boolean result = Book.correctISBNFormat(isbn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCode method, of class Book.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        Book instance = null;
        String expResult = "";
        String result = instance.getCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
