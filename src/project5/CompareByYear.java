package project5;

import java.util.Comparator;

public class CompareByYear implements Comparator{

	public int compare(Object o1, Object o2) {
		Song song1 = (Song) o1;
		Song song2 = (Song) o2;
		return song1.getYear() - song2.getYear();
	}

}
