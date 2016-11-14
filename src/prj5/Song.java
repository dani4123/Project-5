package prj5;

/**
 * @author JulianNguyen
 * @version 11/13/16
 * 
 * This class represents each song that is read in by the File Reader.
 * Each song has the following information: Title, Genre, Artist and Year.
 */
public class Song {

    private String title;
    private String genre;
    private String artist;
    private int year;
    private int[] statArray;
    /**
     * Set capacity of statArray. 
     */
    public static final int STAT_ARRAY_SIZE = 16;
    private StudentCollection studentCollection;

    /**
     * Default Constructor
     * 
     * @param title Song title
     * @param genre Song genre
     * @param artist Song artist
     * @param year Song year
     * @param studentCollection Every student with feedback on Song 
     */
    public Song(String title, String artist, String year, String genre,
            StudentCollection studentCollection)
    {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.year = Integer.valueOf(year);
        this.studentCollection = studentCollection;
        this.statArray = new int[STAT_ARRAY_SIZE];
    }

    /**
     * Getter method for title field
     * @return title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Getter method for genre field
     * @return field
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Getter method for artist field
     * @return artist
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Getter method for year field
     * @return year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Getter method for statArray field
     * @return statArray
     */
    public int[] getStatArray()
    {
        return statArray;
    }

    /**
     * Writes to statArray
     * @param rEnum Which category to write for
     */
    public void setStatArray(RepresentationEnum rEnum)
    {
        statArray = studentCollection.heardAndLikedAccordingTo(
            this.title, rEnum);
    }
}