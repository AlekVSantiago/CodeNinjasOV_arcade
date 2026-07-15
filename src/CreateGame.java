

import java.io.PrintStream;
import java.util.ArrayList;

public class CreateGame extends Game {
    private Belt beltColor;
    private boolean testing;

    CreateGame(String name, String[] author, String url, Game.Genre genre, boolean twoPlayer, ArrayList<Game.Tag> tags, Belt beltColor, boolean testing) {
        super(name, author, url, genre, twoPlayer, tags);
        this.beltColor = beltColor;
        this.testing = testing;
    }

    public void displayConsoleInfo() {
        PrintStream var10000 = System.out;
        String var10001 = this.getName();
        var10000.println("Name: " + var10001 + "\n Author(s): " + String.valueOf(this.getAuthor()) + "Genre: " + this.getGenre().toString());
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
