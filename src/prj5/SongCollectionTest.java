package prj5;

import student.TestCase;

/**
 * This test class tests the public methods of the Song Collection
 * class to ensure that they operate correctly. 
 * @author Phillip Hrinko
 * @version 2016.11.13
 * 
 * fixed some errors
 * @author Jooyoung Whang (joo918)
 * @version 2016.11.14
 */
public class SongCollectionTest extends TestCase {

    private SongCollection collection;
    private Song startSong;
    private Song song;
    private Song endSong;

    /**
     * Called upon before each test method is called.
     * Adds 27 songs to the SongCollection.
     */
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

    /**
     * Tests the nextNineSongs() method to make sure
     * when the next nine songs are available to display, the method
     * returns true
     */
    public void testNextNineSongs() {
        assertTrue(collection.nextNineSongs());
        assertTrue(collection.nextNineSongs());
        assertFalse(collection.nextNineSongs());
    }

    /**
     * Tests the prevNineSongs() method to make sure when
     * nine songs previously in the list are available to 
     * display, the method returns true.
     */
    public void testPrevNineSongs() {
        collection.nextNineSongs();
        assertTrue(collection.prevNineSongs());
        assertFalse(collection.prevNineSongs());
    }

    /**
     * tests changeRepresentationEnum()
     * checks to see if a song's internal statArray has been
     * updated successfully according to the RepresentationEnum
     * after calling the method
     */
    public void testChangeRepresentationEnum() {
        StudentCollection sCollection = new StudentCollection();
        Student student1 = new Student("Computer Science", "Northeast", "reading");
        student1.addSong("Famous", 1, 0);
        student1.addSong("Waves", 0, 2);
        Student student2 = new Student("Other", "Northeast", "sports");
        student2.addSong("Famous", 2, 2);
        student2.addSong("Waves", 0, 0);
        sCollection.add(student1);
        sCollection.add(student2);
        collection = new SongCollection();
        Song song1 = new Song("Famous", "Kanye", "2016", "Rap", sCollection);
        collection.add(song1);
        Song song2 = new Song("Waves", "Kanye", "2016", "Rap", sCollection);
        collection.add(song2);
        collection.changeRepresentationEnum(RepresentationEnum.HOBBY);
        assertEquals(1, song1.getStatArray()[0]);
        assertEquals(0, song1.getStatArray()[1]);
        assertEquals(1, song1.getStatArray()[2]);
        assertEquals(1, song1.getStatArray()[3]);
        assertEquals(1, song2.getStatArray()[8]);
        assertEquals(1, song2.getStatArray()[9]);
        assertEquals(1, song2.getStatArray()[10]);
        assertEquals(1, song2.getStatArray()[11]);
    }

    /**
     * Tests that the sort() method when called with the
     * Artist parameter sorts the list alphabetically by artist.
     */
    public void testSortArtist() {
        collection.sort(SongPropertyEnum.ARTIST);
        assertEquals(collection.getEntry(0), startSong);
        assertEquals(collection.getEntry(1), endSong);
        assertEquals(collection.getEntry(2).getTitle(), "Song1");
        assertEquals(collection.getEntry(26).getTitle(), "Song25");
    }

    /**
     * Tests that the sort() method when called with the
     * Title parameter sorts the list alphabetically by title.
     */
    public void testSortTitle() {
        collection.sort(SongPropertyEnum.TITLE);
        assertEquals(collection.getEntry(0), startSong);
        assertEquals(collection.getEntry(26), endSong);
        assertEquals(collection.getEntry(1).getTitle(), "Song1");
        assertEquals(collection.getEntry(2).getTitle(), "Song10");
        assertEquals(collection.getEntry(25).getTitle(), "Song9");
    }

    /**
     * Tests that the sort() method when called with the
     * year parameter sorts the list chronologically by year.
     */
    public void testSortYear() {
        collection.sort(SongPropertyEnum.YEAR);
        assertEquals(collection.getEntry(25), startSong);
        assertEquals(collection.getEntry(26), endSong);
        assertEquals(collection.getEntry(0).getTitle(), "Song1");
        assertEquals(collection.getEntry(1).getTitle(), "Song2");
        assertEquals(collection.getEntry(24).getTitle(), "Song25");
    }

    /**
     * Tests that the sort() method when called with the
     * genre parameter sorts the list alphabetically by genre.
     */
    public void testSortGenre() {
        collection.sort(SongPropertyEnum.GENRE);
        assertEquals(collection.getEntry(25), startSong);
        assertEquals(collection.getEntry(26), endSong);
        assertEquals(collection.getEntry(0).getTitle(), "Song1");
        assertEquals(collection.getEntry(1).getTitle(), "Song2");
        assertEquals(collection.getEntry(24).getTitle(), "Song25");
    }

    public void testGetNineSongsToShow() {
        Song[] songs = collection.getNineSongsToShow();
    }
}
