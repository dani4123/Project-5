package project5;

import java.util.Comparator;

/**
 * 
 * @author Jooyoung Whang (joo918), Julian Nguyen (julian18)
 * @version 11/13/16
 * 
 */

public class CompareByYear implements Comparator<Object>{

	public int compare(Object o1, Object o2) {
		Song song1 = (Song) o1;
		Song song2 = (Song) o2;
		return song1.getYear() - song2.getYear();
	}

}
