

import java.util.ArrayList;

public class CreateGame extends Game {
    /*
    Fields
     */
    private Type gameType;
    private Belt beltColor;
    private boolean twoPlayer;
    private Genre genre;
    private ArrayList<Tag> tags;
    /*
    Constructor
     */
    CreateGame(String name, ArrayList<String> author, String url, Genre genre, boolean twoPlayer, ArrayList<Tag> tags, Belt beltColor) {
        super(name, author, url);
        this.beltColor = beltColor;
        this.twoPlayer = twoPlayer;
        this.genre = genre;
        this.tags = tags;
    }

    /*
    Getters and Setters
     */
    public Belt getBeltColor() {
        return beltColor;
    }

    public void setBeltColor(Belt beltColor) {
        this.beltColor = beltColor;
    }
    public boolean isTwoPlayer() {
        return twoPlayer;
    }

    public void setTwoPlayer(boolean twoPlayer) {
        this.twoPlayer = twoPlayer;
    }
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}
