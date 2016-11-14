package prj5;

import student.TestCase;
/**
 * @author JulianNguyen, Phillip Hrinko
 * @version 11.13.16
 * 
 * Tests the Song class to ensure all its public methods are 
 * functioning correctly
 */
public class SongTest extends TestCase {

    private Song song1;
    private StudentCollection collection;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;

    /**
     * Called upon before every test method is called.
     */
    public void setUp()
    {
        collection = new StudentCollection();
        student1 = new Student("Computer Science", "Northeast", "reading");
        student1.addSong("Work", 0, 0);
        student2 = new Student("Other Engineering", "Southeast", "art");
        student2.addSong("Work", 1, 1);
        student3 = new Student("Math or CMDA", "United States (other than Southeast or Northwest)", "sports");
        student3.addSong("Work", 0, 0);
        student4 = new Student("Other", "Outside of United States", "music");
        student4.addSong("Work", 1, 1);
        collection.add(student1);
        collection.add(student2);
        collection.add(student3);
        collection.add(student4);
        song1 = new Song("Work", "The Killers", 
                "2005", "alternative", collection);
    }

    /**
     * Tests the getTitle method to make sure the correct 
     * title is returned.
     */
    public void testGetTitle()
    {
        assertTrue("Work".equals(song1.getTitle()));
    }
    
    /**
     * Tests the getGenre method to make sure the correct
     * genre is returned.
     */
    public void testGetGenre()
    {
        assertTrue("alternative".equals(song1.getGenre()));
    }
    
    /**
     * Tests the getArtist method to make sure the correct 
     * artist is returned.
     */
    public void testGetArtist()
    {
        assertTrue("The Killers".equals(song1.getArtist()));
    }
    
    /**
     * Tests the getYear method to make sure the correct 
     * year is returned.
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
        assertEquals(16, song1.getStatArray().length);
    }
    
    /**
     * Tests setStatArray method
     */
    public void testSetStatArray()
    {
        int[] expectedHobby = {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0};
        song1.setStatArray(RepresentationEnum.HOBBY);
        for (int i = 0; i < 12; i++) {
            assertEquals(expectedHobby[i], song1.getStatArray()[i]);
        }
    }
}