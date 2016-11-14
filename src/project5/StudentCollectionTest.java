package project5;

import student.TestCase;

/**
 * This test class tests the public methods in the 
 * StudentCollection to ensure they are operating correctly.
 * @author Phillip Hrinko
 * @version 2016.11.13
 */
public class StudentCollectionTest extends TestCase {
    
    private StudentCollection collection;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private Student student5;
    
    /**
     * Called upon before each test method is called. Instantiates
     * a new StudentCollection class along with 5 students, adds 
     * some song information to the students and then adds the
     * students to the StudentCollection.
     */
    public void setUp() {
        collection = new StudentCollection();
        student1 = new Student("Computer Science", "reading", "Northeast");
        student1.addSongHeard("Work", true);
        student2 = new Student("Other Engineering", "art", "Southeast");
        student2.addSongHeard("Work", false);
        student3 = new Student("Math or CMDA", "sports", "United States (other than Southeast or Northwest)");
        student3.addSongHeard("Work", true);
        student4 = new Student("Other", "music", "Outside of United States");
        student4.addSongHeard("Work", false);
        student5 = new Student("Other", "music", "Northeast");
        student5.addSongHeard("Views", true);
        collection.add(student1);
        collection.add(student2);
        collection.add(student3);
        collection.add(student4);
        collection.add(student5);
    }
    
    /**
     * Tests heardAndLikedAccordingTo() when the Hobby enum is the parameter.
     */
    public void testHeardAndLikedAccordingToHobby() {
        int[] expectedHobby = {1, 1, 1, 0, 1, 1, 1, 0};
        int[] testArray = collection.heardAndLikedAccordingTo("Work", RepresentationEnum.HOBBY);
        for (int i = 0; i < 8; i++) {
            assertEquals(expectedHobby[i], testArray[i]);
        }
    }
    
    /**
     * Tests heardAndLikedAccordingTo() when the Major enum is the parameter.
     */
    public void testHeardAndLikedAccordingToMajor() {
        int[] expectedMajor = {1, 1, 1, 0, 1, 1, 1, 0};
        int[] testArray = collection.heardAndLikedAccordingTo("Work", RepresentationEnum.MAJOR);
        for (int i = 0; i < 8; i++) {
            assertEquals(expectedMajor[i], testArray[i]);
        }
    }
    
    /**
     * Tests heardAndLikedAccordingTo() when the Region enum is the parameter.
     */
    public void testHeardAndLikedAccordingToRegion() {
        int[] expectedRegion = {1, 1, 1, 0, 1, 1, 1, 0};
        int[] testArray = collection.heardAndLikedAccordingTo("Work", RepresentationEnum.REGION);
        for (int i = 0; i < 8; i++) {
            assertEquals(expectedRegion[i], testArray[i]);
        }
    }
}
