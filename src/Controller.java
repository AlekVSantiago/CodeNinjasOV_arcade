

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Controller {
    private Model model;

    Controller(Model model) throws FileNotFoundException {
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
        Name    Author  URL   BeltColor  TwoPlayer  Genre  Tag
        ----------------------Template
     */
    public Model initializeModel() throws FileNotFoundException {
        String currentLine = "";
        String[] currentLineArr;
        File file = new File("games.csv");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentLineArr = currentLine.split(" ");
            /*
            Fields for the Abstt
             */


            String name = currentLineArr[0];
            String[] author = currentLineArr[1].split(",");
            String url = currentLineArr[2];

            if(currentLineArr.length == 7){
                this.model.getLibrary().add(textToGame(currentLineArr));
            }
        }
        return null;
    }
    public Game textToGame(String[] lineArr){
        String name = lineArr[0];
        String[] author = lineArr[1].split(",");
        String url = lineArr[2];
       if(lineArr.length == 7){
           Genre genre = readGenre(lineArr[3]);
           boolean twoPlayer = readTwoPlayer(lineArr[4]);
           ArrayList<Tag> tags = readTags(lineArr[5]);
           Belt beltColor = readBelt(lineArr[6]);
       }
    }

    private boolean readTwoPlayer(String s) {
        if(s.toLowerCase().equals("false")){
            return false;
        }
        else if(s.toLowerCase().equals("true")){
            return true;
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
                switch(i){
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
