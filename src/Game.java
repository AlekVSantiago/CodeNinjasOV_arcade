//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



import java.util.ArrayList;

public class Game {
    private String name;
    private String[] author;
    private String url;
    private Genre genre;
    private boolean twoPlayer;
    private ArrayList<Tag> tags;

    Game(String name, String[] author, String url, Genre genre, boolean twoPlayer, ArrayList<Tag> tags) {
        this.name = name;
        this.author = author;
        this.url = url;
        this.twoPlayer = twoPlayer;
        this.tags = tags;
    }

    public String getName() {
        return this.name;
    }

    public String[] getAuthor() {
        return this.author;
    }

    public String getUrl() {
        return this.url;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public boolean isTwoPlayer() {
        return this.twoPlayer;
    }

    public ArrayList<Tag> getTags() {
        return this.tags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTwoPlayer(boolean twoPlayer) {
        this.twoPlayer = twoPlayer;
    }

    public void play() {
        System.out.println("Now Playing " + this.name + "...");
    }

    public static enum Tag {
        SIXSEVEN,
        FUNNY,
        IMPOSSIBLE,
        COOP,
        SERIES;

        private Tag() {
        }
    }

    public static enum Genre {
        HORROR,
        ACTION,
        RPG,
        PLATFORMER,
        PUZZLE,
        FIGHTING;

        private Genre() {
        }
    }
}
