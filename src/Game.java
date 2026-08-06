//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
import java.util.ArrayList;


public class Game {
    private String name;
    private ArrayList<String> author;
    private String url;

    /*
    Constructor`
     */
    Game(String name, ArrayList<String> author, String url) {
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

    public ArrayList<String> getAuthor() {
        return this.author;
    }

    public String getUrl() {
        return this.url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void  setAuthor(ArrayList<String> author){this.author = author;}

    public void setUrl(String url) {
        this.url = url;
    }

    public void play() {
        System.out.println("Now Playing " + this.name + "..."); }
    public String getAuthorString(){
        String result = "";
        for(int i = 0; i < getAuthor().size(); i++){
            result += this.getAuthor().get(i) + ", ";
        }
        return result;
    }

}
