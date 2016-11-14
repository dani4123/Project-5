/**
 * 
 */
package project5;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author JulianNguyen
 * @version 11/13/16
 */
public class FileReader {

    /**
     * Collection of Songs
     */
    private SongCollection songCollection;
    
    /**
     * Collection of Students
     */
    private StudentCollection studentCollection;

    /**
     * Default Constructor
     * 
     * @param studentData CSV with student feedback
     * @param songList CSV with song information
     * @throws IOException 
     */
    public FileReader(String studentData, String songList) throws IOException
    {
        this.songCollection = new SongCollection();
        this.studentCollection = new StudentCollection();
        readInSongList(songList);
        readInStudentData(studentData);
        new GUIWindow(this.songCollection, this.studentCollection);
    }

    /**
     * Main method that initiates instance of program
     * @param args I/O Input with filename input
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        if (args.length == 2)
        {
            new FileReader(args[0], args[1]);
        }
        else
        {
            new FileReader("MusicSurveyData.csv", "SongList.csv");
        }
    }

    public void readInStudentData(String studentData) throws IOException
    {
        Scanner scanner = new Scanner(new File(studentData));
        String[] dataArray;
        Song song;
        String major;
        String region;
        String hobby;

        scanner.nextLine();

        while (scanner.hasNextLine()) 
        {
            //String of entire line before being split up into specific info
            String[] entireLine = scanner.nextLine().trim().split(",");
            if (entireLine.length == (songCollection.getLength() * 2 + 4)) 
            {
                dataArray = new String[entireLine.length + 1];
                for (int i = 0; i < entireLine.length; i++) 
                {
                    dataArray[i] = entireLine[i];
                }
                dataArray[entireLine.length] = "";
            }
            else 
            {
                dataArray = entireLine;
            }
            if (dataArray.length <= 2) 
            {
                continue;
            }
            
            major = dataArray[2];
            region = dataArray[3];
            hobby = dataArray[4];
            if (!major.equals("") && !region.equals("") 
                    && !hobby.equals(""))
            {
                Student student = new Student(major, region, hobby);
                studentCollection.add(student);
                for (int i = 5; (i + 1) < dataArray.length; i += 2) 
                {
                    Iterator<Song> iter = songCollection.iterator();
                    song = iter.next();
                    if (dataArray[i].toString().equals("Yes"))
                    {
                        if (dataArray[i + 1].toString().equals("Yes"))
                        {
                            student.addSongHeard(song.getTitle(), true); 
                        }
                        else
                        {
                            student.addSongHeard(song.getTitle(), false);
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    /**
     * Read in songs from input file
     * and add to SongCollection
     * 
     * @param songList Input file
     * @throws IOException
     */
    public void readInSongList(String songList) throws IOException
    {
        Scanner scanner = new Scanner(new File(songList));
        String[] songArray;
        scanner.nextLine();
        while (scanner.hasNextLine()) 
        {
            songArray = scanner.nextLine().trim().split(",");
            this.songCollection.add(new Song(songArray[0], songArray[1], songArray[2], songArray[3],
                    this.studentCollection));
        }
        scanner.close();
    }
    
    /**
     * Getter method for songCollection param
     * @return songCollection param
     */
    public SongCollection getSongCollection()
    {
        return this.songCollection;
    }
}
