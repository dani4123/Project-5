package project5;
import java.util.HashMap;

/**
 * 
 * @author Phillip
 *
 */
public class Student {

    private String major;
    private String hobby;
    private String region;
    private HashMap<String, Boolean> songInfo;
    
    public Student(String major, String hobby, String region) {
        this.major = major;
        this.hobby = hobby;
        this.region = region;
    }
    
    public String getMajor() {
        return major;
    }
    
    public String getHobby() {
        return hobby;
    }
    
    public String getRegion() {
        return region;
    }
    
    public void addSongHeard(String song, boolean liked) {
        songInfo.put(song, liked);
    }
    
    public boolean hasHeard(String song) {
        return songInfo.containsKey(song);
    }
    public boolean doesLike(String song) {
        if (hasHeard(song)) {
            return songInfo.get(song);
        }
        else {
            throw new IllegalArgumentException("has not heard song");
        }
    }
}
