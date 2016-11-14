/**
 * 
 */
package prj5;

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
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private Student student5;

    /**
     * Called upon before every test method is called.
     */
    public void setUp()
    {
        collection = new StudentCollection();
        student1 = new Student("Computer Science", "Northeast", "reading");
        student1.addSongHeard("Work", true);
        student2 = new Student("Other Engineering", "Southeast", "art");
        student2.addSongHeard("Work", false);
        student3 = new Student("Math or CMDA", "United States (other than Southeast or Northwest)", "sports");
        student3.addSongHeard("Work", true);
        student4 = new Student("Other", "Outside of United States", "music");
        student4.addSongHeard("Work", false);
        student5 = new Student("Other", "Northeast", "music");
        student5.addSongHeard("Views", true);
        collection.add(student1);
        collection.add(student2);
        collection.add(student3);
        collection.add(student4);
        collection.add(student5);
        song1 = new Song("Work", "The Killers", 
                "2005", "alternative", collection);
        
    }

    /**
     * Tests the getTitle method
     */
    public void testGetTitle()
    {
        assertTrue("Work".equals(song1.getTitle()));
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
    
    /**
     * Tests setStatArray method
     */
    public void testSetStatArray()
    {
        int[] expectedHobby = {1, 1, 1, 0, 1, 1, 1, 0};
        song1.setStatArray(RepresentationEnum.HOBBY);
        for (int i = 0; i < 8; i++) {
            assertEquals(expectedHobby[i], song1.getStatArray()[i]);
        }
    }
}