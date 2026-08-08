

import javafx.util.converter.LocalDateStringConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private Model model;

    Controller() throws Exception {
        this.model = initializeModel();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    /*
    Format for the CSV for reference
        0       1       2      3          4         5      6
        Name    Author  URL
        ----------------------BeltColor  TwoPlayer  Genre  Tag
        ----------------------Template
     */
    public Model initializeModel() throws Exception {
        File file = new File("/Users/aleksantiago/Desktop/codeNinjas/CodeNinjasOV_arcade/src/games.csv");
        Scanner scanner = new Scanner(file);
        String currentLine = "";
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        ArrayList<Game> library = new ArrayList<>();
        String[] currentLineArr;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentLineArr = currentLine.split(",");
            library.add(textToGame(currentLineArr));
        }
        return new Model(library, Theme.NEUTRAL);
    }

    public Game textToGame(String[] lineArr) throws Exception {
        LocalDate now = LocalDate.now();
       return new Game("Beans", new ArrayList<String>(), "BeansAgain", now);
    }



    // TODO implement this later for GBS games private Template readTemplate(String s) throws Exception{
    public Template readTemplate(String s) throws Exception {
            return switch (s.toLowerCase()) {
            case "invaders" -> Template.INVADERS;
            case "keeper" -> Template.KEEPER;
            case "riddle" -> Template.HIDING;
            case "stars" -> Template.STARS;
            default -> throw new Exception("Template cannot be found");
        };
    }

    private boolean readTwoPlayer(String s) {
        return s.equalsIgnoreCase("true");
    }
    private Genre readGenre(String s) throws Exception {
        return switch (s.toLowerCase()) {
            case "horror" -> Genre.HORROR;
            case "action" -> Genre.ACTION;
            case "sports" -> Genre.SPORTS;
            case "platformer" -> Genre.PLATFORMER;
            case "music" -> Genre.MUSIC;
            case "rpg" -> Genre.RPG;
            default -> throw new Exception("Genre cannot be found");
        };
    }
    public Tag readTag(String s) throws Exception {
        return switch(s.toLowerCase()){
            case "relaxing" -> Tag.RELAXING;
            case "funny" -> Tag.FUNNY;
            case "impossible" -> Tag.IMPOSSIBLE;
            case "coop" -> Tag.COOP;
            case "vs" -> Tag.VS;
            case "series" -> Tag.SERIES;
            default -> throw new Exception("Tag Cannot be found");
        };
    }
    public Belt readBelt(String s) throws Exception {
        return switch (s.toLowerCase()) {
            case "white" -> Belt.WHITE;
            case "yellow" -> Belt.YELLOW;
            case "orange" -> Belt.ORANGE;
            case "blue" -> Belt.BLUE;
            default -> throw new Exception("Tag not found");
        };
    }
}
