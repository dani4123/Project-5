package prj5;

import java.util.Comparator;

/**
 * 
 * @author Jooyoung Whang (joo918), Julian Nguyen (julian18)
 * @version 11/13/16
 * 
 * Used to compare songs by Genre
 */

public class CompareByGenre implements Comparator<Object>
{

    /**
     * Default Constructor
     */
    public CompareByGenre()
    {
        //Intentionally left blank
    }

    /**
     * Compare method for this comparator
     */
    public int compare(Object o1, Object o2) {
        Song song1 = (Song) o1;
        Song song2 = (Song) o2;
        return song1.getGenre().compareTo(song2.getGenre());
    }

}
