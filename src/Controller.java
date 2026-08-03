

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Controller {
    private Model model;

    Controller() throws FileNotFoundException {
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
    public Model initializeModel() throws FileNotFoundException {
        File file = new File("games.csv");
        Scanner scanner = new Scanner(file);
        String currentLine = scanner.nextLine();
        ArrayList<Game> library = new ArrayList<Game>();
        String[] currentLineArr = currentLine.split(",");
        while(scanner.hasNextLine()){
            currentLineArr = currentLine.split(",");
            library.add(textToGame(currentLineArr));
        }
        return new Model(library, Theme.NEUTRAL);
    }
    public Game textToGame(String[] lineArr){
        String name = lineArr[0];
        String[] author = lineArr[1].split("-");
        String url = lineArr[2];
       if(lineArr.length == 7){ //If it is a create game
           Genre genre = readGenre(lineArr[3]);
           boolean twoPlayer = readTwoPlayer(lineArr[4]);
           ArrayList<Tag> tags = readTags(lineArr[5]);
           Belt beltColor = readBelt(lineArr[6]);
           return new CreateGame(name, author, url, genre, twoPlayer, tags, beltColor);
       }
       else if(lineArr.length == 4){
            Template template = readTemplate(lineArr[3]);
            return  new GBSGame(name, author, url, template);
       }
       else{
           System.out.println("Unable to return any game or whatever");
           return null;
       }
    }
    // TODO implement this later for GBS games
    private Template readTemplate(String s) {

        //Just return this for now
        return Template.INVADERS;
    }

    private boolean readTwoPlayer(String s) {
        if(s.toLowerCase().equals("true")){
            return true;
        }
        else{
            return false;
        }
    }
    /*
    HORROR, ACTION, SPORTS, PLATFORMER, MUSIC, RPG
     */
    private Genre readGenre(String s) {
        switch(s.toLowerCase()){
            case "horror":
                return Genre.HORROR;
            case "action":
                return Genre.ACTION;
            case "sports":
                return Genre.SPORTS;
            case "platformer":
                return Genre.PLATFORMER;
            case "music":
                return Genre.MUSIC;
            case "rpg":
                return Genre.RPG;
            default:
                System.out.println("Cannot find which enum this is or whatever");
                return null;
        }
    }
    /*
    RELAXING,
    FUNNY,
    IMPOSSIBLE,
    COOP,
    VS,
    SERIES;
     */
    public ArrayList<Tag> readTags(String s){
        ArrayList<Tag> result = new ArrayList<Tag>();
        if(s.contains(",")){
            String[] sArr = s.split(",");
            for(int i = 0; i < sArr.length; i++){
                switch(s){
                    case "relaxing":
                        result.add(Tag.RELAXING);
                        break;
                    case "funny":
                        result.add(Tag.FUNNY);
                        break;
                    case "impossible":
                        result.add(Tag.IMPOSSIBLE);
                        break;
                    case "coop":
                        result.add(Tag.COOP);
                        break;
                    case "vs":
                        result.add(Tag.VS);
                        break;
                    case "SERIES":
                        result.add(Tag.SERIES);
                        break;
                    default:
                        System.out.println("Tag not found");
                }
            }
            return result;
        }else{
            switch(s){
                case "relaxing":
                    result.add(Tag.RELAXING);
                    break;
                case "funny":
                    result.add(Tag.FUNNY);
                    break;
                case "impossible":
                    result.add(Tag.IMPOSSIBLE);
                    break;
                case "coop":
                    result.add(Tag.COOP);
                    break;
                case "vs":
                    result.add(Tag.VS);
                    break;
                case "SERIES":
                    result.add(Tag.SERIES);
                    break;
                default:
                    System.out.println("Tag not found");
            }
        }

        return result;
    }
    public Belt readBelt(String s){
        switch(s.toLowerCase()){
            case "white":
                return Belt.WHITE;
            case "yellow":
                return Belt.YELLOW;
            case "orange":
                return Belt.ORANGE;
            case "blue":
                return Belt.BLUE;
            default:
                System.out.println("Defaulting to white");
                return Belt.WHITE;
        }
    }
}
