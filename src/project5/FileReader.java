/**
 * 
 */
package project5;

import java.io.File;
import java.io.IOException;
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
     * Default Constructor
     * 
     * @param studentData CSV with student feedback
     * @param songList CSV with song information
     * @throws IOException 
     */
    public FileReader(String studentData, String songList) throws IOException
    {
        this.songCollection = new SongCollection();
        readInStudentData(studentData);
        readInSongList(songList);
        //new FrontEnd instance with songCollection parameter
    }

    /**
     * Main method that initiates instance of program
     * @param args I/O Input with filename input
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        if (args.length == 2){
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
        String hobby;
        String region;

        scanner.nextLine();

        while (scanner.hasNextLine()) 
        {
            //String of entire line before being split up into specific info
            String[] entireLine = scanner.nextLine().trim().split(",");
            if (entireLine.length == (songCollection. * 2 + 4)) 
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
            
            for (int i = 5; (i + 1) < dataArray.length; i += 2) {
                song = songCollection.getAt((i - 5) / 2);
                song.getMajorCount().increment(major, dataArray[i], dataArray[i + 1]);
                song.getRegionCount().increment(region, dataArray[i], dataArray[i + 1]);
                song.getHobbyCount().increment(hobby, dataArray[i], dataArray[i + 1]);
            }
        }

        scanner.close();
    }


}
