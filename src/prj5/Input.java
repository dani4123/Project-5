/**
 * 
 */
package prj5;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * reads from data to initialize songCollection and studentCollection
 * intermediate submission only: outputs to system for tests
 * @author JulianNguyen
 * @version 11/13/16
 * 
 * 
 * fixed output problem
 * @author Jooyoung Whang (joo918)
 * @version 11/14/16
 */
public class Input {

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
    public Input(String studentData, String songList) throws IOException
    {
        this.songCollection = new SongCollection();
        this.studentCollection = new StudentCollection();
        readInSongList(songList);
        readInStudentData(studentData);
        new GUIWindow(this);
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
            new Input(args[0], args[1]);
        }
        else
        {
            new Input("Input/MusicSurveyData.csv", "Input/SongList.csv");
        }
    }

    /**
     * reads poll data from students
     * each students save data for each students
     * with and integer, values 0~2 indicating
     * 0:yes 1:no 2:no response
     * 
     * @param studentData   url of the poll data
     * @throws IOException  if file reading fails
     */
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
            if (entireLine.length < (songCollection.getLength() * 2 + 5)) 
            {
                dataArray = new String[songCollection.getLength() * 2 + 5];
                for (int i = 0; i < entireLine.length; i++) 
                {
                    dataArray[i] = entireLine[i];
                }
                for (int i = entireLine.length ; i < dataArray.length ; i++)
                {
                    dataArray[i] = "";
                }
            }
            else 
            {
                dataArray = entireLine;
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
                    song = songCollection.getEntry((i - 5) / 2);
                    if (dataArray[i].toString().equals("Yes"))
                    {
                        if (dataArray[i + 1].toString().equals("Yes"))
                        {
                            student.addSong(song.getTitle(), 0, 0); 
                        }
                        else if (dataArray[i + 1].toString().equals("No"))
                        {
                            student.addSong(song.getTitle(), 0, 1);
                        }
                        else
                        {
                            student.addSong(song.getTitle(), 0, 2);
                        }
                    }
                    else if (dataArray[i].toString().equals("No"))
                    {
                        if (dataArray[i + 1].toString().equals("Yes"))
                        {
                            student.addSong(song.getTitle(), 1, 0); 
                        }
                        else if (dataArray[i + 1].toString().equals("No"))
                        {
                            student.addSong(song.getTitle(), 1, 1);
                        }
                        else
                        {
                            student.addSong(song.getTitle(), 1, 2);
                        }
                    }
                    else
                    {
                        if (dataArray[i + 1].toString().equals("Yes"))
                        {
                            student.addSong(song.getTitle(), 2, 0); 
                        }
                        else if (dataArray[i + 1].toString().equals("No"))
                        {
                            student.addSong(song.getTitle(), 2, 1);
                        }
                        else
                        {
                            student.addSong(song.getTitle(), 2, 2);
                        }
                    }
                }
            }
        }

        scanner.close();

        outputAs(RepresentationEnum.HOBBY, SongPropertyEnum.GENRE);
        outputAs(RepresentationEnum.HOBBY, SongPropertyEnum.TITLE);
    }

    /**
     * ONLY FOR INTERMEDIATE SUBMISSION
     * 
     * outputs to System according to Representating style and
     * Song Property
     * 
     * @param rep   representation
     * @param prop  song property
     */
    public void outputAs(RepresentationEnum rep, SongPropertyEnum prop)
    {
        this.songCollection.changeRepresentationEnum(rep);
        this.songCollection.sort(prop);
        Iterator<Song> outputIter = this.songCollection.iterator();
        while (outputIter.hasNext())
        {
            Song currentOutput = outputIter.next();
            System.out.println("Song Title: " + currentOutput.getTitle());
            System.out.println("Song Artist: " + currentOutput.getArtist());
            System.out.println("Song Genre: " + currentOutput.getGenre());
            System.out.println("Song Year: " + currentOutput.getYear());
            System.out.println("Heard");
            int[] stats = currentOutput.getStatArray();
            int[] outputPerc = new int[8];
            for (int i = 0 ; i < 4 ; i++)
            {
                if (stats[i * 4 + 1] == 0)
                {
                    outputPerc[i * 2] = 0;
                }
                else
                {
                    outputPerc[i * 2] = (int) ((double) stats[i * 4 + 1] / stats[i * 4] * 100);
                }
                if (stats[i * 4 + 3] == 0)
                {
                    outputPerc[i * 2 + 1] = 0;
                }
                else
                {
                    outputPerc[i * 2 + 1] = (int) ((double) stats[i * 4 + 3] / stats[i * 4 + 2] * 100);
                }
            }
            System.out.printf("reading:%d art:%d sports:%d music:%d\n", outputPerc[0],
                    outputPerc[2], outputPerc[4], outputPerc[6]);
            System.out.println("Likes");
            System.out.printf("reading:%d art:%d sports:%d music:%d\n", outputPerc[1],
                    outputPerc[3], outputPerc[5], outputPerc[7]);
            System.out.println("");
        }
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
