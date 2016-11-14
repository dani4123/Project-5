package project5;

import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

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
    
    private SongGraphic[] currentShown;
    
    /**
     * 
     * @author Jooyoung Whang (joo918)
     * @param songs
     * @param students
     */
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
        representHobby = new Button("Represent Hobby");
        representMajor = new Button("Represent Major");
        representRegion = new Button("RepresentRegion");
        
        window.setSize(1920, 1080);
        window.addButton(previousButton, WindowSide.NORTH);
        window.addButton(sortByArtist, WindowSide.NORTH);
        window.addButton(sortByTitle, WindowSide.NORTH);
        window.addButton(sortByDate, WindowSide.NORTH);
        window.addButton(sortByGenre, WindowSide.NORTH);
        window.addButton(nextButton, WindowSide.NORTH);
        window.addButton(representHobby, WindowSide.SOUTH);
        window.addButton(representMajor, WindowSide.SOUTH);
        window.addButton(representRegion, WindowSide.SOUTH);
        window.addButton(quitButton, WindowSide.SOUTH);
    }
    
    private class SongGraphic
    {
        private Song song;
        private SongPropertyEnum songInfo;
        private static final int sizeMultiplier = 10;
        
        private Shape firstHeard;
        private Shape firstLiked;
        private Shape secondHeard;
        private Shape secondLiked;
        private Shape thirdHeard;
        private Shape thirdLiked;
        private Shape fourthHeard;
        private Shape fourthLiked;
        
        public SongGraphic()
        {
            this(new Song("Default", "genre", "artist", 0, null),
                    SongPropertyEnum.ARTIST);
        }
        
        public SongGraphic(Song theSong, SongPropertyEnum sortedBy)
        {
            song = theSong;
            songInfo = sortedBy;
            
            
        }
    }
}
