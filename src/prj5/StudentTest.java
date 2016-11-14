package prj5;
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
        phil = new Student("CS", "Oakton", "Reading");
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
    public void testAddSong() {
        phil.addSong("Star Boy", 0, 0);
        assertEquals(phil.getResponseHeard("Star Boy"), 0);
        assertEquals(phil.getResponseLiked("Star Boy"), 0);
    }

    /**
     * Tests that hasHeard() returns true for songs that the student
     * has heard and false if not. Also tests than an exception is thrown
     * if the survey did not contain the song that was called for hasHeard()
     */
    public void testGetHeardResponse() {
        phil.addSong("Cinderella", 0, 0);
        phil.addSong("goosebumps", 1, 0);
        phil.addSong("Waves", 2, 2);
        assertEquals(phil.getResponseHeard("Cinderella"), 0);
        assertEquals(phil.getResponseHeard("goosebumps"), 1);
        assertEquals(phil.getResponseHeard("Waves"), 2);
    }


    /**
     * Tests that doesLike() returns true if a student likes a song,
     * false if he does not like a song, and an exception if the
     * survey did not contain the song.
     */
    public void testGetLikedResponse() {
        phil.addSong("wonderful", 0, 1);
        phil.addSong("Time", 0, 0);
        phil.addSong("Wolves", 2, 2);
        assertEquals(phil.getResponseLiked("Time"), 0);
        assertEquals(phil.getResponseLiked("wonderful"), 1);
        assertEquals(phil.getResponseLiked("Wolves"), 2);
    }
}