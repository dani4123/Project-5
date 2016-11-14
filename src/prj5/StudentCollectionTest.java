package prj5;

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
        student1 = new Student("Computer Science", "Northeast", "reading");
        student1.addSong("Work", true, true);
        student2 = new Student("Other Engineering", "Southeast", "art");
        student2.addSong("Work", false, false);
        student3 = new Student("Math or CMDA", "United States (other than Southeast or Northwest)", "sports");
        student3.addSong("Work", true, true);
        student4 = new Student("Other", "Outside of United States", "music");
        student4.addSong("Work", false, false);
        student5 = new Student("Other", "Northeast", "music");
        student5.addSong("Views", true, true);
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
