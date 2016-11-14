package project5;

import student.TestCase;

/**
 * This test class tests the public methods of the Song Collection
 * class to ensure that they operate correctly. 
 * @author Phillip Hrinko
 * @version 2016.11.13
 */
public class SongCollectionTest extends TestCase {

    private SongCollection collection;
    private Song startSong;
    private Song song;
    private Song endSong;
    
    public void setUp() {
        collection = new SongCollection();
        startSong = new Song("Famous", "Kanye", "2016", "Rap", null);
        collection.add(startSong);
        for (int i = 1; i < 26; i++) {
            song = new Song("Song" + i, "Various", Integer.toString(i) , "Random", null);
            collection.add(song);
        }
        endSong = new Song("Waves", "Kanye", "2016", "Rap", null);
        collection.add(endSong);
    }
    
    public void testNextNineSongs() {
        assertTrue(collection.nextNineSongs());
        assertTrue(collection.nextNineSongs());
        assertFalse(collection.nextNineSongs());
    }
    
    public void testPrevNineSongs() {
        collection.nextNineSongs();
        assertTrue(collection.prevNineSongs());
        assertFalse(collection.prevNineSongs());
    }
    
    public void testChangeRepresentationEnum() {
        int[] testArray;
    }
    
    public void testSort() {
        collection.sort(SongPropertyEnum.ARTIST);
        assertEquals(collection.getEntry(0), startSong);
    }
    
    public void testGetNineSongsToShow() {
        
    }
}
