package project5;

import java.util.Comparator;

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
		if (position + 9 < songList.size())
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
			currentSong.updateBy(rep);
		}
	}
	
	public void sort(SongPropertyEnum prop)
	{
		Comparator comparator;
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
		
		sort(0, songList.size() - 1, comparator);
	}
	
	/**
	 * insertion sort according to
	 * the specified comparator
	 * 
	 * @param first
	 * @param last
	 * @param comp
	 */
	public void sort(int first, int last, Comparator comp)
	{
		if (first < last)
		{
			sort(first, last - 1, comp);
			
			insertInOrder(last, first, last - 1, comp);
		}
	}
	
	public void insertInOrder(int entryIndex, int begin, int end, Comparator comp)
	{
		if (comp.compare(songList.get(entryIndex), songList.get(end)) < 0)
		{
			Song currentSong = songList.get(entryIndex);
			songList.set(end + 1, songList.get(end));
			songList.set(end, currentSong);
			insertInOrder(end, begin, end - 1, comp);
		}
	}
	
	public Song[] getNineSongsToShow()
	{
		int end = position + 9;
		if (end > songList.size())
		{
			end = songList.size();
		}
		Song[] returnList = new Song[end - position];
		for (int i = position ; i < songList.size() ; i++)
		{
			returnList[i] = songList.get(i);
		}
		return returnList;
	}
}
