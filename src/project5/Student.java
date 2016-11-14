package project5;
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
    private HashMap<String, Boolean> songInfo;
    
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
        songInfo = new HashMap<String, Boolean>();
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
    public void addSongHeard(String song, boolean liked) {
        songInfo.put(song, liked);
    }
    
    /**
     * Checks to see if a song has been heard by this Student.
     * @param song
     * @return True if the song was heard by the Student
     */
    public boolean hasHeard(String song) {
        return songInfo.containsKey(song);
    }
    
    /**
     * Checks to see if a song was liked by the Student
     * @param song The song to be checked if the student likes.
     * @return True if the Student likes the song
     * @throws IllegalArgumentException if the song has not been heard.
     */
    public boolean doesLike(String song) {
        if (hasHeard(song)) {
            return songInfo.get(song);
        }
        else {
            throw new IllegalArgumentException("has not heard song");
        }
    }
}

