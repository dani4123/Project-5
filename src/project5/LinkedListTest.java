package project5;
import student.TestCase;

/**
 * This test class tests the methods in the LinkedList class
 * to ensure that the methods are all functioning correctly.
 * @author Phillip
 * @version 2016.11.12
 */
public class LinkedListTest extends TestCase {

    private LinkedList<String> list;

    /**
     * Called upon before every test method is called.
     */
    public void setUp() {
        list = new LinkedList<String>();
    }

    /**
     * Tests both add() methods to make sure size is incremented correctly
     * and that when the index is out of bounds, an exception is
     * thrown. 
     */
    public void testAdd() {
        list.add("item 1");
        assertEquals(list.getLength(), 1);
        list.add(1, "item 2");
        assertEquals(list.getLength(), 2);
        list.add(1, "item 3");
        assertEquals(list.getLength(), 3);
        Exception thrown = null;
        try {
            list.add(-1, "item 4");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        try {
            list.add(4, "item 4");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }

    /**
     * Tests that remove() correctly removes the node
     * at the specified index in the list. Also tests that the
     * correct exceptions are thrown when the index is out of bounds.
     */
    public void testRemove() {
        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        Exception thrown = null;
        try {
            list.remove(-1);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        try {
            list.remove(3);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        assertEquals(list.remove(0), "item 1");
        assertEquals(list.getLength(), 2);
        assertEquals(list.remove(0), "item 2");
        assertEquals(list.getLength(), 1);
    }

    /**
     * Tests that when clear() is called, the list no longer contains
     * any entries.
     */
    public void testClear() {
        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        assertEquals(list.getLength(), 3);
        assertFalse(list.isEmpty());
        list.clear();
        assertEquals(list.getLength(), 0);
        assertTrue(list.isEmpty());
    }

    /**
     * Tests that getEntry() correctly gets the data from the Node at the
     * specified index in the list. 
     */
    public void testGetEntry() {
        assertNull(list.getEntry(0));
        assertNull(list.getEntry(-1));
        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        assertEquals(list.getEntry(0), "item 1");
        assertEquals(list.getEntry(1), "item 2");
        assertEquals(list.getEntry(2), "item 3");
        assertEquals(list.getLength(), 3);
    }

    /**
     * Tests that when contains() is called, that true is returned
     * when the object is in the list and false when it is not 
     * in the list.
     */
    public void testContains() {
        assertFalse(list.contains("item 1"));
        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        assertTrue(list.contains("item 1"));
        assertTrue(list.contains("item 2"));
        assertTrue(list.contains("item 3"));
        assertFalse(list.contains("item 4"));
    }
}