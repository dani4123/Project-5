package prj5;

import student.TestCase;

/**
 * This test class tests all four comparator classes to 
 * ensure that they return the correct values for the 
 * compare() methods.
 * @author Phillip Hrinko
 * @version 2016.11.13
 */
public class CompareTest extends TestCase {

    private Song song1;
    private Song song2;
    
    /**
     * Called upon before each test method is called.
     */
    public void setUp() {
        song1 = new Song("Time", "Pink Floyd", "1974", "Rock", null);
        song2 = new Song("Floats my Boat", "Aer", "2009", "Rap", null);
    }
    
    /**
     * Tests compare by artist.
     */
    public void testCompareByArtist() {
        CompareByArtist compare = new CompareByArtist();
        assertEquals(compare.compare(song1, song2), 15);
    }
    
    /**
     * Tests compare by genre.
     */
    public void testCompareByGenre() {
        CompareByGenre compare = new CompareByGenre();
        assertEquals(compare.compare(song1, song2), 14);
    }
    
    /**
     * Tests compare by title.
     */
    public void testCompareByTitle() {
        CompareByTitle compare = new CompareByTitle();
        assertEquals(compare.compare(song1, song2), 14);
    }
    
    /**
     * Tests compare by year.
     */
    public void testCompareByYear() {
        CompareByYear compare = new CompareByYear();
        assertEquals(compare.compare(song1, song2), -35);
    }
}
