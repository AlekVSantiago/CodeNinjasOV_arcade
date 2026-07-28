//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
import java.util.ArrayList;

public class BuildGame extends Game {
    private Template template;

    BuildGame(String name, String[] author, String url, Genre genre, boolean twoPlayer, ArrayList<Tag> tags, Template template) {
        super(name, author, url);
        this.template = template;
    }


}