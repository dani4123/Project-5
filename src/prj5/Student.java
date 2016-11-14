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
    private HashMap<String, Boolean[]> songInfo;
    
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
        songInfo = new HashMap<String, Boolean[]>();
    }
    
    /**
     * 
     * @return the students major
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * 
     * @return the students hobby
     */
    public String getHobby() {
        return hobby;
    }
    
    /**
     * 
     * @return the students region of residence
     */
    public String getRegion() {
        return region;
    }
    
    /**
     * Adds the song to the list of songs the student has heard
     * @param song The song the student heard
     * @param True if he liked the song.
     */
    public void addSong(String song, boolean heard, boolean liked) {
        songInfo.put(song, new Boolean[] {heard, liked});
    }
    
    /**
     * Checks to see if a song has been heard by this Student.
     * @param song The song to be checked if the student has heard. 
     * @return True if the song was heard by the Student
     */
    public boolean hasHeard(String song) {
        if (!songInfo.containsKey(song)) {
            throw new IllegalArgumentException();
        }
        return songInfo.get(song)[0];
    }
    
    /**
     * Checks to see if a song was liked by the Student
     * @param song The song to be checked if the student likes.
     * @return True if the Student likes the song
     */
    public boolean doesLike(String song) {
        if (!songInfo.containsKey(song)) {
            throw new IllegalArgumentException();
        }
        return songInfo.get(song)[1];
    }
}

