package prj5;

import java.util.Iterator;

/**
 * stores the poll data by storing
 * each student and their poll information
 * 
 * @author Jooyoung Whang (joo918)
 * @version (2016.11.13)
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
     * 
     * 0 - 1st category student total
     * 1 - 1st category heard
     * 2 - 1st category liked
     * 3 - 2nd category student total
     * 4 - 2nd category heard
     * 5 - 2nd category liked
     * 6 - 3rd category student total
     * 7 - 3rd category heard
     * 8 - 3rd category liked
     * 9 - 4th category student total 
     * 10 - 4th category heard
     * 11 - 4th category liked
     * 
     * @param title song's title
     * @param rep representation type
     * @return array with poll information
     */
    public int[] heardAndLikedAccordingTo(String title, RepresentationEnum rep)
    {
        Iterator<Student> iter = iterator();
        int[] returnArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        switch (rep)
        {
        case HOBBY:
            while (iter.hasNext())
            {
                Student current = iter.next();
                int position = 0;
                String curHobby = current.getHobby();
                if (curHobby.equals("reading"))
                {
                    returnArray[0]++;
                    position = 0;
                }
                else if (curHobby.equals("art"))
                {
                    returnArray[3]++;
                    position = 3;
                }
                else if (curHobby.equals("sports"))
                {
                    returnArray[6]++;
                    position = 6;
                }
                else
                {
                    returnArray[9]++;
                    position = 9;
                }
                if (current.hasHeard(title))
                {
                    returnArray[position + 1]++;
                }
                if (current.doesLike(title))
                {
                    returnArray[position + 2]++;
                }
            }
            
            break;
        case MAJOR:
            while (iter.hasNext())
            {
                Student current = iter.next();
                int position = 0;
                String curMajor = current.getMajor();
                if (curMajor.equals("Computer Science"))
                {
                    returnArray[0]++;
                    position = 0;
                }
                else if (curMajor.equals("Other Engineering"))
                {
                    returnArray[3]++;
                    position = 3;
                }
                else if (curMajor.equals("Math or CMDA"))
                {
                    returnArray[6]++;
                    position = 6;
                }
                else
                {
                    returnArray[9]++;
                    position = 9;
                }
                if (current.hasHeard(title))
                {
                    returnArray[position + 1]++;
                }
                if (current.doesLike(title))
                {
                    returnArray[position + 2]++;
                }
            }
			break;
		case REGION:
		    while (iter.hasNext())
            {
                Student current = iter.next();
                int position = 0;
                String curRegion = current.getRegion();
                if (curRegion.equals("Northeast"))
                {
                    returnArray[0]++;
                    position = 0;
                }
                else if (curRegion.equals("Southeast"))
                {
                    returnArray[3]++;
                    position = 3;
                }
                else if (curRegion.equals("United States (other than Southeast or Northwest)"))
                {
                    returnArray[6]++;
                    position = 6;
                }
                else
                {
                    returnArray[9]++;
                    position = 9;
                }
                if (current.hasHeard(title))
                {
                    returnArray[position + 1]++;
                }
                if (current.doesLike(title))
                {
                    returnArray[position + 2]++;
                }
            }
			break;
		}
		return returnArray;
	}
}
