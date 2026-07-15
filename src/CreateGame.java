

import java.io.PrintStream;
import java.util.ArrayList;

public class CreateGame extends Game {
    private Belt beltColor;
    private boolean testing;
    private Genre genre;
    private ArrayList<Tag> tags;
    private boolean twoPlayer;

    CreateGame(String name, String[] author, String url, Genre genre, boolean twoPlayer, ArrayList<Game.Tag> tags, Belt beltColor, boolean testing) {
        super(name, author, url);
        this.beltColor = beltColor;
        this.twoPlayer = twoPlayer;
        this.testing = testing;
        this.genre = genre;
    }

    public static enum Belt {
        WHITE,
        YELLOW,
        BLUE,
        GREEN,
        BLACK;

        private Belt() {
        }
    }
}
