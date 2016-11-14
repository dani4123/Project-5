package prj5;

import java.util.Comparator;

/**
 * 
 * @author Jooyoung Whang (joo918), Julian Nguyen (julian18)
 * @version 11/13/16
 * 
 * Used to compare songs by Artist
 * 
 */

public class CompareByArtist implements Comparator<Object> {

    /**
     * Default Constructor
     */
    public CompareByArtist()
    {
        //Intentionally left blank
    }

    /**
     * Compare method for comparator
     * @param o1 First Object
     * @param o2 Second object in comparison
     * @return Results of comparison
     */
    public int compare(Object o1, Object o2) {
        Song song1 = (Song) o1;
        Song song2 = (Song) o2;
        return song1.getArtist().compareTo(song2.getArtist());
    }

}
