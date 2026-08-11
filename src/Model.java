import java.util.ArrayList;

public class Model {
    /*---------------------
        Fields
        all of the lists and such
     -------------------------*/
    private ArrayList<Game> library;
    private ArrayList<Game> questGames;
    private ArrayList<Game> freestyleGames;
    private ArrayList<Game> gbsGames;
    private ArrayList<Game> senseiGames;
    private Theme theme;

    /*---------------------
        Constructor
     -------------------------*/
    Model(ArrayList<Game> library,
          ArrayList<Game> questGames,
          ArrayList<Game> freestyleGames,
          ArrayList<Game> gbsGames,
          ArrayList<Game> senseiGames,
          Theme theme){
        this.library = library;
        this.questGames = questGames;
        this.freestyleGames = freestyleGames;
        this.gbsGames = gbsGames;
        this.senseiGames = senseiGames;
        this.theme = theme;
    }

    /*---------------------
        Setters and Getters
     -------------------------*/
    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public ArrayList<Game> getLibrary() {
        return library;
    }

    public void setLibrary(ArrayList<Game> library) {
        this.library = library;
    }

    public ArrayList<Game> getQuestGames() {
        return questGames;
    }

    public void setQuestGames(ArrayList<Game> questGames) {
        this.questGames = questGames;
    }
    public ArrayList<Game> getFreestyleGames(){
        return this.freestyleGames;
    }
    public void setFreestyleGames(ArrayList<Game> freestyleGames){
        this.freestyleGames = freestyleGames;
    }

    public ArrayList<Game> getGbsGames() {
        return gbsGames;
    }

    public void setGbsGames(ArrayList<Game> gbsGames) {
        this.gbsGames = gbsGames;
    }

    public ArrayList<Game> getSenseiGames() {
        return this.senseiGames;
    }

    public void setSenseiGames(ArrayList<Game> senseiGames) {
        this.senseiGames = senseiGames;
    }

}

