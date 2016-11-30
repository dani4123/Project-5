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
    
    private boolean legendShown;
    
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
        representRegion = new Button("Represent Region");

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
        
        //legend box should not be shown yet.
        legendShown = false;
        
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
        if (!legendShown)
        {
          //create legend box
            Shape legendBox = new Shape(WINDOW_WIDTH - LEGEND_WIDTH,
                    WINDOW_HEIGHT - LEGEND_HEIGHT,
                    LEGEND_WIDTH, LEGEND_HEIGHT);
            legendBox.setBackgroundColor(Color.WHITE);
            legendBox.setForegroundColor(Color.BLACK);
            window.addShape(legendBox);


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
        }
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
        default:
            legendText[0] = new TextShape(0, 0, "Hobby Legend");
            legendText[1] = new TextShape(0, 0, "Read", Color.MAGENTA);
            legendText[2] = new TextShape(0, 0, "Art", Color.BLUE);
            legendText[3] = new TextShape(0, 0, "Sports", Color.ORANGE);
            legendText[4] = new TextShape(0, 0, "Music", Color.GREEN);
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
    
    /**
     * button method for quit
     * exits program
     * 
     * @param b the quit button
     */
    public void pressedQuit(Button b)
    {
        System.exit(0);
    }
    
    /**
     * button method for next
     * shows the next 9 songs in the songcollection
     * 
     * @param b the next button
     */
    public void pressedNext(Button b)
    {
        if (songcollection.nextNineSongs())
        {
            updateGraphics(songcollection.getNineSongsToShow());
            previousButton.enable();
            if (songcollection.nextNineSongs())
            {
                songcollection.prevNineSongs();
            }
            else
            {
                b.disable();
            }
        }
        else
        {
            b.disable();
        }
    }
    
    /**
     * button method for previous
     * shows the previous 9 songs in the songcollection
     * 
     * @param b the previous button
     */
    public void pressedPrev(Button b)
    {
        if (songcollection.prevNineSongs())
        {
            updateGraphics(songcollection.getNineSongsToShow());
            nextButton.enable();
            if (songcollection.prevNineSongs())
            {
                songcollection.nextNineSongs();
            }
            else
            {
                b.disable();
            }
        }
        else
        {
            b.disable();
        }
    }

    /**
     * button method for sorting by artist
     * sorts songcollection by artist and shows the updated
     * 9 songs
     * 
     * @param b the sort artist button
     */
    public void pressedArtist(Button b)
    {
        songcollection.sort(SongPropertyEnum.ARTIST);
        currentProperty = SongPropertyEnum.ARTIST;
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    /**
     * button method for sorting by title
     * sorts songcollection by title and shows the updated
     * 9 songs
     * 
     * @param b the sort title button
     */
    public void pressedTitle(Button b)
    {
        songcollection.sort(SongPropertyEnum.TITLE);
        currentProperty = SongPropertyEnum.TITLE;
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    /**
     * button method for sorting by date
     * sorts songcollection by date and shows the updated
     * 9 songs
     * 
     * @param b the sort date button
     */
    public void pressedDate(Button b)
    {
        songcollection.sort(SongPropertyEnum.YEAR);
        currentProperty = SongPropertyEnum.YEAR;
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    /**
     * button method for sorting by genre
     * sorts songcollection by genre and shows the updated
     * 9 songs
     * 
     * @param b the sort genre button
     */
    public void pressedGenre(Button b)
    {
        songcollection.sort(SongPropertyEnum.GENRE);
        currentProperty = SongPropertyEnum.GENRE;
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    /**
     * button method for representing by hobby
     * modifies songcollection by artist and shows the updated
     * 9 songs
     * 
     * @param b the represent hobby button
     */
    public void pressedHobby(Button b)
    {
        songcollection.changeRepresentationEnum(RepresentationEnum.HOBBY);
        currentRepresentation = RepresentationEnum.HOBBY;
        setUpLegend(currentRepresentation);
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    /**
     * button method for representing by major
     * modifies songcollection by major and shows the updated
     * 9 songs
     * 
     * @param b the represent major button
     */
    public void pressedMajor(Button b)
    {
        songcollection.changeRepresentationEnum(RepresentationEnum.MAJOR);
        currentRepresentation = RepresentationEnum.MAJOR;
        setUpLegend(currentRepresentation);
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    /**
     * button method for representing by region
     * modifies songcollection by region and shows the updated
     * 9 songs
     * 
     * @param b the represent region button
     */
    public void pressedRegion(Button b)
    {
        songcollection.changeRepresentationEnum(RepresentationEnum.REGION);
        currentRepresentation = RepresentationEnum.REGION;
        setUpLegend(currentRepresentation);
        updateGraphics(songcollection.getNineSongsToShow());
    }
    
    /**
     * updates the graphics, especially the glyphs
     * 
     * @param songs 9 songs to show on the screen as a glyph
     */
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
    
    /**
     * a private glyph class so it can
     * represent a song
     * 
     * @author Jooyoung Whang (joo918)
     * @version (11.29.2016)
     *
     */
    private class SongGraphic
    {
        private Song song;
        private SongPropertyEnum songInfo;
        /**
         * multiplier used to change size of the glyph's bars
         */
        private static final int sizeMultiplier = 1;
        /**
         * each bar's thickness
         */
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

        /**
         * default constructor for SongGraphic
         * creates a SongGraphic object without any parameters,
         * setting everything to default.
         */
        public SongGraphic()
        {
            this(new Song("Default", "artist", "0", "genre", null),
                    SongPropertyEnum.ARTIST, 300, 300);
        }

        /**
         * constructor
         * creates the SongGraphic object with information from a specific song
         * can specify by what property to sort by.
         * 
         * @param theSong   the song to represent
         * @param sortedBy  what to be sorted by
         * @param x x coordinate for the glyph
         * @param y y coordinate for the glyph
         */
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

        /**
         * adds every element of the glyph to the window
         * 
         * @param win   window to add to
         */
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

        /**
         * removes every element of the glyph from the window
         * 
         * @param win   window to remove from
         */
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
