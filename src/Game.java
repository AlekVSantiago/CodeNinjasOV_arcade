//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
import java.util.ArrayList;


public class Game {
    private String name;
    private String[] author;
    private String url;

    /*
    Constructor`
     */
    Game(String name, String[] author, String url) {
        this.name = name;
        this.author = author;
        this.url = url;
    }

    /*
    Getters and Setters
     */
    public String getName() {
        return this.name;
    }

    public String[] getAuthor() {
        return this.author;
    }

    public String getUrl() {
        return this.url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void  setAuthor(String[] author){this.author = author;}

    public void setUrl(String url) {
        this.url = url;
    }

    public void play() {
        System.out.println("Now Playing " + this.name + "..."); }
    public String getAuthorString(){
        String result = "";
        for(int i = 0; i < getAuthor().length; i++){
            result += this.getAuthor()[i] + ", ";
        }
        return result;
    }

}
