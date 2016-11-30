package prj5;

import java.awt.Color;

import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * 
 * @author Jooyoung Whang (joo918)
 * @param songs 
 * @param students
 */

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
    
    private SongPropertyEnum currentProperty;
    private RepresentationEnum currentRepresentation;

    /**
     * window's width
     */
    private static final int WINDOW_WIDTH = 1280;
    /**
     * window's height
     */
    private static final int WINDOW_HEIGHT = 720;
    /**
     * legend's width
     */
    private static final int LEGEND_WIDTH = 220;
    /**
     * legend's height
     */
    private static final int LEGEND_HEIGHT = 400;
    /**
     * gap between texts in legend
     */
    private static final int LEGEND_TEXT_GAP = 20;

    private TextShape[] legendText;

    private SongGraphic[] currentShown;

    /**
     * constructor for GUIWindow
     * based on what the filereader initialized,
     * the constructor sets up the songcollection's data
     * and initializes the buttons
     * 
     * @param filereader    the Input class that has all the information needed
     */
    public GUIWindow(Input filereader)
    {
        if (filereader != null)
        {
            songcollection = filereader.getSongCollection();
        }
        else
        {
            songcollection = null;
        }
        //initialize window and buttons
        window = new Window("Music Preference Visualization");
        quitButton = new Button("Quit");
        nextButton = new Button("Next ->");
        previousButton = new Button("<- Prev");
        sortByArtist = new Button("Sort By Artist Name");
        sortByTitle = new Button("Sort By Song Title");
        sortByDate = new Button("Sort By Release Year");
        sortByGenre = new Button("Sort By Genre");
        representHobby = new Button("Represent Hobby");
        representMajor = new Button("Represent Major");
        representRegion = new Button("RepresentRegion");

        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
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
        
        //initalize enums and currentShown array
        currentProperty = SongPropertyEnum.ARTIST;
        currentRepresentation = RepresentationEnum.HOBBY;
        
        //create legend box
        Shape legendBox = new Shape(WINDOW_WIDTH - LEGEND_WIDTH,
                WINDOW_HEIGHT - LEGEND_HEIGHT,
                LEGEND_WIDTH, LEGEND_HEIGHT);
        legendBox.setBackgroundColor(Color.WHITE);
        legendBox.setForegroundColor(Color.BLACK);
        window.addShape(legendBox);

        setUpLegend(currentRepresentation);

        TextShape songtitle = new TextShape(0, 0, "Song Title");
        songtitle.setBackgroundColor(null);
        songtitle.setX(WINDOW_WIDTH - LEGEND_WIDTH / 2 - songtitle.getWidth() / 2);
        songtitle.setY(WINDOW_HEIGHT - LEGEND_HEIGHT + 6 * LEGEND_TEXT_GAP);
        window.addShape(songtitle);
        window.moveToFront(songtitle);

        Shape seperator = new Shape(WINDOW_WIDTH - LEGEND_WIDTH / 2 -
                LEGEND_TEXT_GAP / 2, 
                WINDOW_HEIGHT - LEGEND_HEIGHT + 
                7 * LEGEND_TEXT_GAP,
                LEGEND_TEXT_GAP, LEGEND_HEIGHT / 4);
        seperator.setBackgroundColor(Color.BLACK);
        seperator.setForegroundColor(Color.BLACK);
        window.addShape(seperator);
        window.moveToFront(seperator);

        TextShape heard = new TextShape(0, 0, "Heard");
        TextShape likes = new TextShape(0, 0, "Likes");
        heard.setBackgroundColor(null);
        likes.setBackgroundColor(null);
        heard.setX(seperator.getX() - heard.getWidth() - LEGEND_TEXT_GAP / 2);
        heard.setY(seperator.getY() + seperator.getHeight() / 2 - heard.getHeight() / 2);
        likes.setX(seperator.getX() + seperator.getWidth() + LEGEND_TEXT_GAP / 2);
        likes.setY(seperator.getY() + seperator.getHeight() / 2 - likes.getHeight() / 2);
        window.addShape(heard);
        window.addShape(likes);
        window.moveToFront(heard);
        window.moveToFront(likes);

        /*
        StudentCollection studentCol = new StudentCollection();
        Student dude1 = new Student("Computer Science", "Northeast", "reading");
        dude1.addSong("Default", 0, 0);
        Student dude2 = new Student("Computer Science", "Northeast", "art");
        dude2.addSong("Default", 0, 0);
        Student dude3 = new Student("Computer Science", "Northeast", "sports");
        dude3.addSong("Default", 0, 0);
        Student dude4 = new Student("Computer Science", "Northeast", "music");
        dude4.addSong("Default", 0, 0);
        for (int i = 0 ; i < 100 ; i++)
        {
            studentCol.add(dude1);
            studentCol.add(dude2);
            studentCol.add(dude3);
            studentCol.add(dude4);
        }
        Song testSong = new Song("Default", "me", "0", "genre", studentCol);
        testSong.setStatArray(RepresentationEnum.HOBBY);
        SongGraphic sg = new SongGraphic(testSong, SongPropertyEnum.ARTIST, 250, 100);
        sg.addToWindow(window);
        */
        
        //add functionalities to buttons
        
        quitButton.onClick(this, "pressedQuit");
        nextButton.onClick(this, "pressedNext");
        previousButton.onClick(this, "pressedPrev");
        sortByArtist.onClick(this, "pressedArtist");
        sortByTitle.onClick(this, "pressedTitle");
        sortByDate.onClick(this, "pressedDate");
        sortByGenre.onClick(this, "pressedGenre");
        representHobby.onClick(this, "pressedHobby");
        representMajor.onClick(this, "pressedMajor");
        representRegion.onClick(this, "pressedRegion");
        
        previousButton.disable();
    }

    /**
     * updates the legend to the appropriate representation
     * 
     * @param re    the representation 
     */
    public void setUpLegend(RepresentationEnum re)
    {
        if (legendText != null)
        {
            for (int i = 0 ; i < legendText.length ; i++)
            {
                window.removeShape(legendText[i]);
            }
        }
        legendText = new TextShape[5];
        switch (re)
        {
        case HOBBY:
            legendText[0] = new TextShape(0, 0, "Hobby Legend");
            legendText[1] = new TextShape(0, 0, "Read", Color.MAGENTA);
            legendText[2] = new TextShape(0, 0, "Art", Color.BLUE);
            legendText[3] = new TextShape(0, 0, "Sports", Color.ORANGE);
            legendText[4] = new TextShape(0, 0, "Music", Color.GREEN);
            break;
        case MAJOR:
            legendText[0] = new TextShape(0, 0, "Major Legend");
            legendText[1] = new TextShape(0, 0, "Comp Sci", Color.MAGENTA);
            legendText[2] = new TextShape(0, 0, "Other Eng", Color.BLUE);
            legendText[3] = new TextShape(0, 0, "Math/CMDA", Color.ORANGE);
            legendText[4] = new TextShape(0, 0, "Other", Color.GREEN);
            break;
        case REGION:
            legendText[0] = new TextShape(0, 0, "Region Legend");
            legendText[1] = new TextShape(0, 0, "NE", Color.MAGENTA);
            legendText[2] = new TextShape(0, 0, "SE", Color.BLUE);
            legendText[3] = new TextShape(0, 0, "Other US", Color.ORANGE);
            legendText[4] = new TextShape(0, 0, "Outside US", Color.GREEN);
            break;
        }
        for (int i = 0 ; i < 5 ; i++)
        {
            legendText[i].setBackgroundColor(null);
            legendText[i].setX(WINDOW_WIDTH - LEGEND_WIDTH + LEGEND_TEXT_GAP / 2);
            legendText[i].setY(WINDOW_HEIGHT - LEGEND_HEIGHT + i * LEGEND_TEXT_GAP +
                    LEGEND_TEXT_GAP / 2);
            window.addShape(legendText[i]);
            window.moveToFront(legendText[i]);
        }
    }
    
    public void pressedQuit(Button b)
    {
        System.exit(0);
    }
    
    public void pressedNext(Button b)
    {
        if (songcollection.nextNineSongs())
        {
            updateGraphics(songcollection.getNineSongsToShow());
            previousButton.enable();
        }
        else
        {
            b.disable();
        }
    }
    
    public void pressedPrev(Button b)
    {
        if (songcollection.prevNineSongs())
        {
            updateGraphics(songcollection.getNineSongsToShow());
            nextButton.enable();
        }
        else
        {
            b.disable();
        }
    }

    public void pressedArtist(Button b)
    {
        songcollection.sort(SongPropertyEnum.ARTIST);
        currentProperty = SongPropertyEnum.ARTIST;
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    public void pressedTitle(Button b)
    {
        songcollection.sort(SongPropertyEnum.TITLE);
        currentProperty = SongPropertyEnum.TITLE;
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    public void pressedDate(Button b)
    {
        songcollection.sort(SongPropertyEnum.YEAR);
        currentProperty = SongPropertyEnum.YEAR;
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    public void pressedGenre(Button b)
    {
        songcollection.sort(SongPropertyEnum.GENRE);
        currentProperty = SongPropertyEnum.GENRE;
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    public void pressedHobby(Button b)
    {
        songcollection.changeRepresentationEnum(RepresentationEnum.HOBBY);
        currentRepresentation = RepresentationEnum.HOBBY;
        setUpLegend(currentRepresentation);
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    public void pressedMajor(Button b)
    {
        songcollection.changeRepresentationEnum(RepresentationEnum.MAJOR);
        currentRepresentation = RepresentationEnum.MAJOR;
        setUpLegend(currentRepresentation);
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    public void pressedRegion(Button b)
    {
        songcollection.changeRepresentationEnum(RepresentationEnum.REGION);
        currentRepresentation = RepresentationEnum.REGION;
        setUpLegend(currentRepresentation);
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    public void updateGraphics(Song[] songs)
    {
        if (currentShown != null)
        {
            for (SongGraphic sg : currentShown)
            {
                sg.removeFromWindow(window);
            }
        }
        currentShown = new SongGraphic[songs.length];
        for (int i = 0 ; i < songs.length ; i++)
        {
            SongGraphic songgraphic = new SongGraphic(songs[i], currentProperty, 300 * (i % 3) + 200,
                                                        180 * (i/3) + 50);
            currentShown[i] = songgraphic;
            songgraphic.addToWindow(window);
        }
    }
    
    private class SongGraphic
    {
        private Song song;
        private SongPropertyEnum songInfo;
        private static final int sizeMultiplier = 1;
        private static final int graphThickness = 30;

        private Shape firstHeard;
        private Shape firstLiked;
        private Shape secondHeard;
        private Shape secondLiked;
        private Shape thirdHeard;
        private Shape thirdLiked;
        private Shape fourthHeard;
        private Shape fourthLiked;
        private Shape divider;
        private TextShape title;
        private TextShape representation;

        public SongGraphic()
        {
            this(new Song("Default", "artist", "0", "genre", null),
                    SongPropertyEnum.ARTIST, 300, 300);
        }

        public SongGraphic(Song theSong, SongPropertyEnum sortedBy, int x, int y)
        {
            song = theSong;
            songInfo = sortedBy;
            int[] stats = song.getStatArray();
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
            divider = new Shape(x, y, graphThickness / 2, graphThickness * 4, Color.BLACK);
            firstHeard = new Shape(x - outputPerc[0] * sizeMultiplier, y,
                    outputPerc[0] * sizeMultiplier, graphThickness, Color.MAGENTA);
            firstLiked = new Shape(x + graphThickness / 2, y,
                    outputPerc[1] * sizeMultiplier, graphThickness, Color.MAGENTA);
            secondHeard = new Shape(x - outputPerc[2] * sizeMultiplier, y + graphThickness,
                    outputPerc[2] * sizeMultiplier, graphThickness, Color.BLUE);
            secondLiked = new Shape(x + graphThickness / 2, y + graphThickness,
                    outputPerc[3] * sizeMultiplier, graphThickness, Color.BLUE);
            thirdHeard = new Shape(x - outputPerc[4] * sizeMultiplier, y + graphThickness * 2,
                    outputPerc[4] * sizeMultiplier, graphThickness, Color.ORANGE);
            thirdLiked = new Shape(x + graphThickness / 2, y + graphThickness * 2,
                    outputPerc[5] * sizeMultiplier, graphThickness, Color.ORANGE);
            fourthHeard = new Shape(x - outputPerc[6] * sizeMultiplier, y + graphThickness * 3,
                    outputPerc[6] * sizeMultiplier, graphThickness, Color.GREEN);
            fourthLiked = new Shape(x + graphThickness / 2, y + graphThickness * 3,
                    outputPerc[7] * sizeMultiplier, graphThickness, Color.GREEN);

            title = new TextShape(x, y, song.getTitle());
            title.setBackgroundColor(null);
            switch (sortedBy)
            {
            case ARTIST:
                representation = new TextShape(x, y, "by " + song.getArtist());
                break;
            case YEAR:
                representation = new TextShape(x, y, String.valueOf(song.getYear()));
                break;
            case GENRE:
                representation = new TextShape(x, y, "genre: " + song.getGenre());
                break;
            default:
                representation = new TextShape(x, y, "by " + song.getArtist());
                break;
            }
            representation.setBackgroundColor(null);
            title.setX(x + divider.getWidth() / 2 - title.getWidth() / 2);
            title.setY(y - representation.getHeight() - title.getHeight());
            representation.setX(x + divider.getWidth() / 2 - representation.getWidth() / 2);
            representation.setY(y - representation.getHeight());
        }

        public void addToWindow(Window win)
        {
            win.addShape(divider);
            win.addShape(firstHeard);
            win.addShape(firstLiked);
            win.addShape(secondHeard);
            win.addShape(secondLiked);
            win.addShape(thirdHeard);
            win.addShape(thirdLiked);
            win.addShape(fourthHeard);
            win.addShape(fourthLiked);
            win.addShape(title);
            win.addShape(representation);
        }

        public void removeFromWindow(Window win)
        {
            win.removeShape(divider);
            win.removeShape(firstHeard);
            win.removeShape(firstLiked);
            win.removeShape(secondHeard);
            win.removeShape(secondLiked);
            win.removeShape(thirdHeard);
            win.removeShape(thirdLiked);
            win.removeShape(fourthHeard);
            win.removeShape(fourthLiked);
            win.removeShape(title);
            win.removeShape(representation);
        }
    }
}
