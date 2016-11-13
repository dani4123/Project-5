package project5;

import CS2114.Button;
import CS2114.Window;

public class GUIWindow {

    private SongCollection songcollection;
    private Window window;
    private Button quitButton;
    private Button nextButton;
    private Button previousButton;
    private Button sortByTitle;
    private Button sortByArtist;
    private Button sortByDate;
    private Button sortByGenre;
    private Button representHobby;
    private Button representMajor;
    private Button representRegion;
    private SongPropertyEnum currentSongProperty;
    private RepresentationEnum currentRepresentation;
    
    public GUIWindow(SongCollection songs, StudentCollection students)
    {
        window = new Window("Music Preference Visualization");
        quitButton = new Button("Quit");
        nextButton = new Button("Next ¡æ");
        previousButton = new Button("¡ç Prev");
        sortByArtist = new Button("Sort By Artist Name");
        sortByTitle = new Button("Sort By Song Title");
        sortByDate = new Button("Sort By Release Year");
        sortByGenre = new Button("Sort By Genre");
    }
}