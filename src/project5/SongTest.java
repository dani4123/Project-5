/**
 * 
 */
package project5;

import student.TestCase;
/**
 * @author JulianNguyen
 * @version 11.13.16
 * 
 * Tests the Song class
 */
public class SongTest extends TestCase {

    private Song song1;
    private StudentCollection collection;

    /**
     * Called upon before every test method is called.
     */
    public void setUp()
    {
        collection = new StudentCollection();
        song1 = new Song("All These Things I've Done", "The Killers", 
                "2005", "alternative", collection);
    }

    /**
     * Tests the getTitle method
     */
    public void testGetTitle()
    {
        assertTrue("All These Things I've Done".equals(song1.getTitle()));
    }
    
    /**
     * Tests the getGenre method
     */
    public void testGetGenre()
    {
        assertTrue("alternative".equals(song1.getGenre()));
    }
    
    /**
     * Tests the getArtist method
     */
    public void testGetArtist()
    {
        assertTrue("The Killers".equals(song1.getArtist()));
    }
    
    /**
     * Tests the getYear method
     */
    public void testGetYear()
    {
        assertEquals(2005, song1.getYear());
    }
    
    /**
     * Tests the getStatArray method
     */
    public void testGetStatArray()
    {
        assertEquals(8, song1.getStatArray().length);
    }
}
