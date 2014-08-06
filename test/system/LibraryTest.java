package system;

import java.util.List;
import java.util.Map;
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
public class LibraryTest {
    
    public LibraryTest() {
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
     * Test of addItem method, of class Library.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Item item = null;
        Library instance = new Library();
        instance.addItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItem method, of class Library.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        Item item = null;
        Library instance = new Library();
        instance.removeItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookup method, of class Library.
     */
    @Test
    public void testLookup() {
        System.out.println("lookup");
        String code = "";
        Library instance = new Library();
        Item expResult = null;
        Item result = instance.lookup(code);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeriodicals method, of class Library.
     */
    @Test
    public void testGetPeriodicals() {
        System.out.println("getPeriodicals");
        Library instance = new Library();
        Map<String, Periodical> expResult = null;
        Map<String, Periodical> result = instance.getPeriodicals();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBooks method, of class Library.
     */
    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        Library instance = new Library();
        List<Book> expResult = null;
        List<Book> result = instance.getBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class Library.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        Library instance = new Library();
        List<Item> expResult = null;
        List<Item> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
