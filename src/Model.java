import java.lang.reflect.Array;
import java.util.ArrayList;

public class Model {
    /*---------------------
        Fields
        all of the lists and such
     -------------------------*/
    //The entire Library of games inside of the program
    private ArrayList<CreateGame> library;

    // ArrayList of games separated by categories
    private ArrayList<CreateGame> questGames;
    private ArrayList<CreateGame> freestyleGames;
    private ArrayList<CreateGame> gbsGames;
    private ArrayList<CreateGame> senseiGames;
    
    //ArrayList of the current games that are within view of the user
    private ArrayList<CreateGame> currGames;


     //Enum of the theme
    private Theme theme;


    /*---------------------
        Constructor
     -------------------------*/
    Model(ArrayList<CreateGame> library,
          ArrayList<CreateGame> questGames,
          ArrayList<CreateGame> freestyleGames,
          ArrayList<CreateGame> gbsGames,
          ArrayList<CreateGame> senseiGames,
          Theme theme){

        this.library = library;
        this.questGames = questGames;
        this.freestyleGames = freestyleGames;
        this.gbsGames = gbsGames;
        this.senseiGames = senseiGames;
        this.currGames = senseiGames;
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

    public ArrayList<CreateGame> getLibrary() {
        return library;
    }

    public void setLibrary(ArrayList<CreateGame> library) {
        this.library = library;
    }

    public ArrayList<CreateGame> getQuestGames() {
        return questGames;
    }

    public void setQuestGames(ArrayList<CreateGame> questGames) {
        this.questGames = questGames;
    }
    public ArrayList<CreateGame> getFreestyleGames(){
        return this.freestyleGames;
    }
    public void setFreestyleGames(ArrayList<CreateGame> freestyleGames){
        this.freestyleGames = freestyleGames;
    }

    public ArrayList<CreateGame> getGbsGames() {
        return gbsGames;
    }

    public void setGbsGames(ArrayList<CreateGame> gbsGames) {
        this.gbsGames = gbsGames;
    }

    public ArrayList<CreateGame> getSenseiGames() {
        return this.senseiGames;
    }

    public void setSenseiGames(ArrayList<CreateGame> senseiGames) {
        this.senseiGames = senseiGames;
    }

    public ArrayList<CreateGame> getCurrGames() {
        return currGames;
    }

    public void setCurrGames(ArrayList<CreateGame> currGames) {
        this.currGames = currGames;
    }
}

