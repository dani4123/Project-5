package prj5;
import java.util.HashMap;

/**
 * This class represents each individual student from the survey. 
 * This class holds the students basic information as well as 
 * information on whether the student has heard / liked a song.
 * @author Phillip Hrinko
 * @version 2016.11.10
 */
public class Student {

    private String major;
    private String hobby;
    private String region;
    private HashMap<String, Integer[]> songInfo;

    /**
     * The constructor for this class that takes the parameters 
     * and stores them in the field variables.
     * @param major The students major
     * @param hobby The students main hobby
     * @param region The students region of residence
     */
    public Student(String major, String region, String hobby) {
        this.major = major;
        this.region = region;
        this.hobby = hobby;
        songInfo = new HashMap<String, Integer[]>();
    }

    /**
     * Getter method for students major
     * @return the students major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Getter method for the students hobby
     * @return the students hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * Getter method for the students region
     * @return the students region of residence
     */
    public String getRegion() {
        return region;
    }

    /**
     * Adds the song to the map of songs the student has information on
     * @param heard 0 if heard, 1 if not, 2 if no response
     * @param liked 0 if liked, 1 if not, 2 is no response
     */
    public void addSong(String song, int heard, int liked) {
        songInfo.put(song, new Integer[] {heard, liked});
    }

    /**
     * Checks to see if a song has been heard by this Student.
     * @param song The song to be checked if the student has heard. 
     * @return 0 if the student heard it, 1 if the student did not hear it
     *          2, if there was no response
     */
    public int getResponseHeard(String song) {
        return songInfo.get(song)[0];
    }

    /**
     * Checks to see if a song was liked by the Student
     * @param song The song to be checked if the student likes.
     * @return 0 if the student liked it, 1 if the student did not like it
     *          2, if there was no response
     */
    public int getResponseLiked(String song) {
        return songInfo.get(song)[1];
    }
}

