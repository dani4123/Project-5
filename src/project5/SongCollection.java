package project5;

import java.util.Comparator;
import java.util.Iterator;

/**
 * 
 * @author Jooyoung Whang (joo918)
 *
 */
public class SongCollection {

	private LinkedList<Song> songList;
	private int position;
	
	public SongCollection()
	{
		songList = new LinkedList<Song>();
		position = 0;
	}
	
	/**
	 * moves position 9 ahead to
	 * reference when showing the next
	 * set of songs in the graphics window
	 * 
	 * @return
	 */
	public boolean nextNineSongs()
	{
		if (position + 9 < songList.getLength())
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
	 * @return
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
	
	public void changeRepresentationEnum(RepresentationEnum rep)
	{
		Iterator<Song> iter = songList.iterator();
		while (iter.hasNext())
		{
			Song currentSong = iter.next();
			currentSong.setStatArray(rep);
		}
	}
	
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
		
		sort(0, songList.getLength() - 1, comparator);
	}
	
	/**
	 * insertion sort according to
	 * the specified comparator
	 * 
	 * @param first
	 * @param last
	 * @param comp
	 */
	public void sort(int first, int last, Comparator<Object> comp)
	{
		if (first < last)
		{
			sort(first, last - 1, comp);
			
			insertInOrder(last, first, last - 1, comp);
		}
	}
	
	public void insertInOrder(int entryIndex, int begin, int end, Comparator<Object> comp)
	{
		if (comp.compare(songList.getEntry(entryIndex), songList.getEntry(end)) < 0)
		{
			Song currentSong = songList.getEntry(entryIndex);
			songList.replace(end + 1, songList.getEntry(end));
			songList.replace(end, currentSong);
			insertInOrder(end, begin, end - 1, comp);
		}
	}
	
	public Song[] getNineSongsToShow()
	{
		int end = position + 9;
		if (end > songList.getLength())
		{
			end = songList.getLength();
		}
		Song[] returnList = new Song[end - position];
		for (int i = position ; i < songList.getLength() ; i++)
		{
			returnList[i] = songList.getEntry(i);
		}
		return returnList;
	}
	
	public int getSize()
	{
	    return songList.getLength();
	}
	
	public Song getSong(int index)
	{
	    return songList.getEntry(index);
	}
}
