package project5;
import student.TestCase;

/**
 * This test class tests the methods of the Student class to
 * ensure the methods operate correctly.
 * @author Phillip Hrinko
 * @version 2016.11.12
 */
public class StudentTest extends TestCase {

    private Student phil;
    
    /**
     * Called upon before every test method is called.
     */
    public void setUp() {
        phil = new Student("CS", "Reading", "Oakton");
    }
    
    /**
     * Tests that getMajor() correctly returns the Student's major.
     */
    public void testGetMajor() {
        assertEquals(phil.getMajor(), "CS");
    }
    
    /**
     * Tests that getHobby() correctly returns the Student's hobby.
     */
    public void testGetHobby() {
        assertEquals(phil.getHobby(), "Reading");
    }
    
    /**
     * Tests that getRegion() correctly returns the Student's region.
     */
    public void testGetRegion() {
        assertEquals(phil.getRegion(), "Oakton");
    }
    
    /**
     * Tests that addSongHeard() adds a song to the HashMap that stores
     * all the song information.
     */
    public void testAddSongHeard() {
        phil.addSongHeard("Star Boy", true);
        assertTrue(phil.getSongInfo().containsKey("Star Boy"));
    }
    
    /**
     * Tests that hasHeard() returns true for songs that the student
     * has heard and false if not.
     */
    public void testHasHeard() {
        phil.addSongHeard("Cinderalla", false);
        phil.addSongHeard("goosebumps", true);
        assertTrue(phil.hasHeard("Cinderalla"));
        assertTrue(phil.hasHeard("goosebumps"));
        assertFalse(phil.hasHeard("Star Boy"));
    }
    
    /**
     * Tests that doesLike() returns true if a student likes a song,
     * false if he does not like a song, and an exception if the
     * student has never heard the song.
     */
    public void testDoesLike() {
        phil.addSongHeard("wonderful", false);
        phil.addSongHeard("Time", true);
        assertTrue(phil.doesLike("Time"));
        assertFalse(phil.doesLike("wonderful"));
        Exception exception = null;
        try {
            phil.doesLike("Black Beatles");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }
}
