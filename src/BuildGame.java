//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
import java.util.ArrayList;

public class BuildGame extends Game {
    private Template template;

    BuildGame(String name, String[] author, String url, Game.Genre genre, boolean twoPlayer, ArrayList<Tag> tags, Template template) {
        super(name, author, url, genre, twoPlayer, tags);
        this.template = template;
    }

    public static enum Template {
        INVADERS,
        SOCCER,
        FIND,
        QUESTION;

        private Template() {
        }
    }
}