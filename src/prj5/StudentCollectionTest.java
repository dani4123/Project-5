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


    /**
     * Called upon before each test method is called. Instantiates
     * a new StudentCollection class along with 4 students, adds 
     * some song information to the students and then adds the
     * students to the StudentCollection.
     */
    public void setUp() {
        collection = new StudentCollection();
        Student student1 = new Student("Computer Science", 
            "Northeast", "reading");
        student1.addSong("Work", 0, 0);
        Student student2 = new Student("Other Engineering", 
            "Southeast", "art");
        student2.addSong("Work", 1, 1);
        Student student3 = new Student("Math or CMDA", 
            "United States (other than Southeast or Northwest)", 
            "sports");
        student3.addSong("Work", 0, 0);
        Student student4 = new Student("Other", 
            "Outside of United States", "music");
        student4.addSong("Work", 1, 1);
        Student student5 = new Student("Computer Science", 
            "Northeast", "reading");
        student5.addSong("Work", 2, 2);
        Student student6 = new Student("Other Engineering", 
            "Southeast", "art");
        student6.addSong("Work", 2, 2);
        Student student7 = new Student("Math or CMDA", 
            "United States (other than Southeast or Northwest)", 
            "sports");
        student7.addSong("Work", 2, 2);
        Student student8 = new Student("Other", 
            "Outside of United States", "music");
        student8.addSong("Work", 2, 2);
        collection.add(student1);
        collection.add(student2);
        collection.add(student3);
        collection.add(student4);
        collection.add(student5);
        collection.add(student6);
        collection.add(student7);
        collection.add(student8);
    }

    /**
     * Tests heardAndLikedAccordingTo() when the Hobby enum is the parameter.
     */
    public void testHeardAndLikedAccordingToHobby() {
        int[] expectedHobby = {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0};
        int[] testArray = collection.heardAndLikedAccordingTo("Work",
            RepresentationEnum.HOBBY);
        for (int i = 0; i < 16; i++) {
            assertEquals(expectedHobby[i], testArray[i]);
        }
    }

    /**
     * Tests heardAndLikedAccordingTo() when the Major enum is the parameter.
     */
    public void testHeardAndLikedAccordingToMajor() {
        int[] expectedMajor = {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0};
        int[] testArray = collection.heardAndLikedAccordingTo("Work", 
            RepresentationEnum.MAJOR);
        for (int i = 0; i < 16; i++) {
            assertEquals(expectedMajor[i], testArray[i]);
        }
    }

    /**
     * Tests heardAndLikedAccordingTo() when the Region enum is the parameter.
     */
    public void testHeardAndLikedAccordingToRegion() {
        int[] expectedRegion = {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0};
        int[] testArray = collection.heardAndLikedAccordingTo("Work", 
            RepresentationEnum.REGION);
        for (int i = 0; i < 16; i++) {
            assertEquals(expectedRegion[i], testArray[i]);
        }
    }
    
    /**
     * Tests heardAndLikedAccordingTo() when the Default enum is the parameter.
     */
    public void testHeardAndLikedAccordingToDefault() {
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] testArray = collection.heardAndLikedAccordingTo("Work", 
                RepresentationEnum.DEFAULT);
        for (int i = 0; i < 16; i++) {
            assertEquals(expected[i], testArray[i]);
        }
    }
}
