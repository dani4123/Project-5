package project5;

import java.util.Comparator;

public class CompareByTitle implements Comparator<Object>{

	public int compare(Object o1, Object o2) {
		Song song1 = (Song) o1;
		Song song2 = (Song) o2;
		return song1.getTitle().compareTo(song2.getTitle());
	}

}
