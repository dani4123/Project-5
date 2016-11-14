package project5;

import java.util.Iterator;

/**
 * 
 * stores the poll data by storing
 * each student and their poll information
 * 
 * @author Jooyoung Whang (joo918)
 * @version (2016.11.13)
 *
 */
public class StudentCollection extends LinkedList<Student>
{
	
	/**
	 * iterates through the
	 * studentCollection in order to
	 * gather poll information
	 * according to the
	 * song title and
	 * the representation type
	 * (Hobby, Major, Region)
	 * returns an integer array
	 * with each index containing:
	 * 0 - 1st category heard
	 * 1 - 1st category liked
	 * 2 - 2nd category heard
	 * 3 - 2nd category liked
	 * 4 - 3rd category heard
	 * 5 - 3rd category liked
	 * 6 - 4th category heard
	 * 7 - 5th category liked
	 * 
	 * @param title song's title
	 * @param rep representation type
	 * @return array with poll information
	 */
	public int[] heardAndLikedAccordingTo(String title, RepresentationEnum rep)
	{
		Iterator<Student> iter = iterator();
		int[] returnArray = new int[8];
		
		switch (rep)
		{
		case HOBBY:
			
			while (iter.hasNext())
			{
				Student current = iter.next();
				if (current.hasHeard(title))
				{
					int position = 0;
					switch (current.getHobby())
					{
					case "reading":
						returnArray[0]++;
						position = 1;
						break;
					case "art":
						returnArray[2]++;
						position = 3;
						break;
					case "sports":
						returnArray[4]++;
						position = 5;
						break;
					case "music":
						returnArray[6]++;
						position = 7;
						break;
					}
					if (current.doesLike(title))
					{
						returnArray[position]++;
					}
				}
			}
			
			break;
		case MAJOR:
			
			while (iter.hasNext())
			{
				Student current = iter.next();
				if (current.hasHeard(title))
				{
					int position = 0;
					switch (current.getHobby())
					{
					case "Computer Science":
						returnArray[0]++;
						position = 1;
						break;
					case "Other Engineering":
						returnArray[2]++;
						position = 3;
						break;
					case "Math or CMDA":
						returnArray[4]++;
						position = 5;
						break;
					case "Other":
						returnArray[6]++;
						position = 7;
						break;
					}
					if (current.doesLike(title))
					{
						returnArray[position]++;
					}
				}
			}
			
			break;
		case REGION:
			
			while (iter.hasNext())
			{
				Student current = iter.next();
				if (current.hasHeard(title))
				{
					int position = 0;
					switch (current.getHobby())
					{
					case "Northeast":
						returnArray[0]++;
						position = 1;
						break;
					case "Southeast":
						returnArray[2]++;
						position = 3;
						break;
					case "United States (other than Southeast or Northwest)":
						returnArray[4]++;
						position = 5;
						break;
					case "Outside of United States":
						returnArray[6]++;
						position = 7;
						break;
					}
					if (current.doesLike(title))
					{
						returnArray[position]++;
					}
				}
			}
			
			break;
		}
		
		return returnArray;
	}
}
