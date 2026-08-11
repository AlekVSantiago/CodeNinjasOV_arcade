import java.time.LocalDate;
import java.util.ArrayList;

public class CreateGame extends Game {
    /*
    Fields
     */
    private Belt beltColor;
    private boolean twoPlayer;
    private Genre genre;
    private ArrayList<Tag> tags;
    private Type gameType;
    /*
     Constructor
    */
    CreateGame(String name,
               ArrayList<String> author,
               String url,
               LocalDate releaseDate,
               Genre genre,
               boolean twoPlayer,
               ArrayList<Tag> tags,
               Belt beltColor,
               Type gameType) {

        super(name, author, url, releaseDate);

        this.twoPlayer = twoPlayer;
        this.beltColor = beltColor;
        this.genre = genre;
        this.tags = tags;
        this.gameType = gameType;
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
    public Type getGameType() {
        return gameType;
    }

    public void setGameType(Type gameType) {
        this.gameType = gameType;
    }
}
