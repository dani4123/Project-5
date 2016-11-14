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
     * 0 - 1st category heard responded
     * 1 - 1st category heard total
     * 2 - 1st category liked responded
     * 3 - 1st category liked total 
     * 4 - 2nd category heard responded
     * 5 - 2nd category heard total
     * 6 - 2nd category liked responded
     * 7 - 2nd category liked total
     * 8 - 3rd category heard responded
     * 9 - 3rd category heard total
     * 10 - 3rd category liked responded
     * 11 - 3rd category liked total
     * 12 - 4th category heard responded
     * 13 - 4th category heard total
     * 14 - 4th category liked responded
     * 15 - 4th category liked total
     * 
     * @param title song's title
     * @param rep representation type
     * @return array with poll information
     */
    public int[] heardAndLikedAccordingTo(String title, RepresentationEnum rep)
    {
        Iterator<Student> iter = iterator();
        int[] returnArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

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
                        position = 0;
                    }
                    else if (curHobby.equals("art"))
                    {
                        position = 4;
                    }
                    else if (curHobby.equals("sports"))
                    {
                        position = 8;
                    }
                    else
                    {
                        position = 12;
                    }
                    if (current.getResponseHeard(title) != 2)
                    {
                        returnArray[position]++;
                        if (current.getResponseHeard(title) == 0)
                        {
                            returnArray[position + 1]++;
                        }
                    }
                    if (current.getResponseLiked(title) != 2)
                    {
                        returnArray[position + 2]++;
                        if (current.getResponseLiked(title) == 0)
                        {
                            returnArray[position + 3]++;
                        }
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
                        position = 0;
                    }
                    else if (curMajor.equals("Other Engineering"))
                    {
                        position = 4;
                    }
                    else if (curMajor.equals("Math or CMDA"))
                    {
                        position = 8;
                    }
                    else
                    {
                        position = 12;
                    }
                    if (current.getResponseHeard(title) != 2)
                    {
                        returnArray[position]++;
                        if (current.getResponseHeard(title) == 0)
                        {
                            returnArray[position + 1]++;
                        }
                    }
                    if (current.getResponseLiked(title) != 2)
                    {
                        returnArray[position + 2]++;
                        if (current.getResponseLiked(title) == 0)
                        {
                            returnArray[position + 3]++;
                        }
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
                        position = 0;
                    }
                    else if (curRegion.equals("Southeast"))
                    {
                        position = 4;
                    }
                    else if (curRegion.equals("United States (other than Southeast or Northwest)"))
                    {
                        position = 8;
                    }
                    else
                    {
                        position = 12;
                    }
                    if (current.getResponseHeard(title) != 2)
                    {
                        returnArray[position]++;
                        if (current.getResponseHeard(title) == 0)
                        {
                            returnArray[position + 1]++;
                        }
                    }
                    if (current.getResponseLiked(title) != 2)
                    {
                        returnArray[position + 2]++;
                        if (current.getResponseLiked(title) == 0)
                        {
                            returnArray[position + 3]++;
                        }
                    }
                }
                break;
            default:
                break;
            }
        return returnArray;
    }
}
