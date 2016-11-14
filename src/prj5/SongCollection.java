package prj5;

import java.util.Comparator;
import java.util.Iterator;

/**
 * stores all the songs and their information.
 * the data is sorted in a certain way
 * (ARTIST, TITLE, YEAR, GENRE)
 * It provides methods to get the necessary information
 * needed when displaying on the GUIWindow
 * 
 * @author Jooyoung Whang (joo918)
 * @version (2016.11.13)
 *
 */
public class SongCollection extends LinkedList<Song>
{

    /**
     * position used to find from where to show nine song data
     */
    private int position;

    /**
     * constructor.
     * initialize position to 0
     */
    public SongCollection()
    {
        position = 0;
    }

    /**
     * moves position 9 ahead to
     * reference when showing the next
     * set of songs in the graphics window
     * 
     * @return whether position was moved or not
     */
    public boolean nextNineSongs()
    {
        if (position + 9 < getLength())
        {
            position += 9;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * moves position 9 behind to
     * reference when showing the previous
     * set of songs in the graphics window
     * 
     * @return whether position was moved or not
     */
    public boolean prevNineSongs()
    {
        if (position - 9 >= 0)
        {
            position -= 9;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * calls updateBy on all songs
     * so that each songs change their
     * statistics(poll) data from the
     * studentCollection in a certain representation method
     * 
     * @param rep  the representation method
     */
    public void changeRepresentationEnum(RepresentationEnum rep)
    {
        Iterator<Song> iter = iterator();
        while (iter.hasNext())
        {
            Song currentSong = iter.next();
            currentSong.setStatArray(rep);
        }
    }

    /**
     * calls the super's sort so it uses
     * the correct comparator of the 
     * certain song property the list
     * needs to be sorted by.
     * 
     * @param prop the song property
     */
    public void sort(SongPropertyEnum prop)
    {
        Comparator<Object> comparator;
        switch (prop)
        {
            case ARTIST:
                comparator = new CompareByArtist();
                break;
            case TITLE:
                comparator = new CompareByTitle();
                break;
            case YEAR:
                comparator = new CompareByYear();
                break;
            case GENRE:
                comparator = new CompareByGenre();
                break;
            default:
                comparator = new CompareByTitle();
                break;
        }

        super.sort(comparator);
    }

    /**
     * returns an array of at maximum nine songs
     * according to the position field.
     * (Used to display on GUIWindow)
     * 
     * @return song array
     */
    public Song[] getNineSongsToShow()
    {
        int end = position + 9;
        if (end > getLength())
        {
            end = getLength();
        }
        Song[] returnList = new Song[end - position];
        for (int i = position ; i < getLength() ; i++)
        {
            returnList[i] = getEntry(i);
        }
        return returnList;
    }
}
