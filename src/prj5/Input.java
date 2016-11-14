/**
 * 
 */
package prj5;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
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

        outputAs(RepresentationEnum.HOBBY, SongPropertyEnum.GENRE);
        outputAs(RepresentationEnum.HOBBY, SongPropertyEnum.TITLE);
    }

    public void outputAs(RepresentationEnum rep, SongPropertyEnum prop)
    {
        this.songCollection.changeRepresentationEnum(rep);
        this.songCollection.sort(prop);
        Iterator<Song> outputIter = this.songCollection.iterator();
        while (outputIter.hasNext())
        {
            Song currentOutput = outputIter.next();
            System.out.println("song title " + currentOutput.getTitle());
            System.out.println("song artist " + currentOutput.getArtist());
            System.out.println("song genre " + currentOutput.getGenre());
            System.out.println("song year " + currentOutput.getYear());
            System.out.println("heard");
            int[] statsTotal = new int[4];
            int[] stats = currentOutput.getStatArray();
            Iterator<Student> surveyer = this.studentCollection.iterator();
            while (surveyer.hasNext())
            {
                Student curStudent = surveyer.next();
                String curRep;
                switch (rep)
                {
                case HOBBY:
                    curRep = curStudent.getHobby();
                    if (curRep.equals("reading"))
                    {
                        statsTotal[0]++;
                    }
                    else if (curRep.equals("art"))
                    {
                        statsTotal[1]++;
                    }
                    else if (curRep.equals("sports"))
                    {
                        statsTotal[2]++;
                    }
                    else
                    {
                        statsTotal[3]++;
                    }
                    break;
                case MAJOR:
                    curRep = curStudent.getMajor();
                    if (curRep.equals("Computer Science"))
                    {
                        statsTotal[0]++;
                    }
                    else if (curRep.equals("Other Engineering"))
                    {
                        statsTotal[1]++;
                    }
                    else if (curRep.equals("Math or CMDA"))
                    {
                        statsTotal[2]++;
                    }
                    else
                    {
                        statsTotal[3]++;
                    }
                    break;
                case REGION:
                    curRep = curStudent.getRegion();
                    if (curRep.equals("Northeast"))
                    {
                        statsTotal[0]++;
                    }
                    else if (curRep.equals("Southeast"))
                    {
                        statsTotal[1]++;
                    }
                    else if (curRep.equals("United States (other than Southeast or Northwest)"))
                    {
                        statsTotal[2]++;
                    }
                    else
                    {
                        statsTotal[3]++;
                    }
                    break;
                }
            }
            System.out.println("stats - " + stats[0] + " " + stats[1]);
            int[] outputPerc = new int[8];
            for (int i = 0 ; i < 4 ; i++)
            {
                if (stats[i * 2] == 0)
                {
                    outputPerc[i * 2] = 0;
                    outputPerc[i * 2 + 1] = 0;
                }
                else
                {
                    outputPerc[i * 2] = stats[i * 2] / statsTotal[i] * 100;
                    outputPerc[i * 2 + 1] = stats[i * 2 + 1] / stats[i * 2] * 100;
                }
            }
            System.out.printf("reading%d art%d sports%d music%d\n", outputPerc[0],
                                outputPerc[2], outputPerc[4], outputPerc[6]);
            System.out.println("likes");
            System.out.printf("reading%d art%d sports%d music%d\n", outputPerc[1],
                                outputPerc[3], outputPerc[5], outputPerc[7]);
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
