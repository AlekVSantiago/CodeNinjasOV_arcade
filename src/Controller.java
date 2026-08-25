import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
        ArrayList<CreateGame> library = new ArrayList<>();
        ArrayList<CreateGame> resultQuest = new ArrayList<>();
        ArrayList<CreateGame> resultFreestyle = new ArrayList<>();
        ArrayList<CreateGame> resultGbs = new ArrayList<>();
        ArrayList<CreateGame> resultSensei = new ArrayList<>();
        String[] currentLineArr;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentLineArr = currentLine.split(",");
            String currName = currentLineArr[0];
            String currAuthor = currentLineArr[1];
            String currUrl = currentLineArr[2];
            LocalDate currReleaseDate = LocalDate.parse(currentLineArr[3]);
            boolean currTwoPlayer = currentLineArr[4].equalsIgnoreCase("true");

            Belt currBelt = readBelt(currentLineArr[5]);
            Genre currGenre = readGenre(currentLineArr[6]);
            //Nothing to get Tags yet from currentLineArr[7]! Tags are not a thing yet
            ArrayList<Tag> nothingTags = new ArrayList<>();
            Type currType = readType(currentLineArr[8]);
            CreateGame currGame = new CreateGame(currName, currAuthor, currUrl, currReleaseDate, currGenre, currTwoPlayer, nothingTags, currBelt, currType);

            library.add(currGame);
            switch(currGame.getGameType()){
                case QUEST -> {
                    resultQuest.add(currGame);
                }
                case FREESTYLE -> {
                    resultFreestyle.add(currGame);
                }
                case GBS -> {
                    resultGbs.add(currGame);
                }
                case SENSEI -> {
                    resultSensei.add(currGame);
                }
            }
        }
        return new Model(library, resultQuest, resultFreestyle, resultGbs, resultSensei, Theme.NEUTRAL);
    }
    /*
        Sorting Algorithms
     */
    public static ArrayList<CreateGame> dateSort(ArrayList<CreateGame> inputArr){
        ArrayList<CreateGame> result = new ArrayList<>();
        if(inputArr.size() == 1){
            return inputArr;
        }else{
            int mid = inputArr.size() / 2;
            ArrayList<CreateGame> firstHalf = new ArrayList<>(inputArr.subList(0, mid));
            firstHalf = dateSort(firstHalf);
            ArrayList<CreateGame> secondHalf = new ArrayList<>(inputArr.subList(mid, inputArr.size()));

            secondHalf = dateSort(secondHalf);
            int inputIndex = 0;
            int returnIndex = 0;
            while(inputIndex < firstHalf.size() && returnIndex < secondHalf.size()){
                if(firstHalf.get(inputIndex).getReleaseDate().isBefore(
                        secondHalf.get(returnIndex).getReleaseDate())){
                    result.add(firstHalf.get(inputIndex));
                    inputIndex++;
                }
                else{
                    result.add(secondHalf.get(returnIndex));
                    returnIndex++;
                }
            }
            for(int i = returnIndex; i < secondHalf.size(); i++){
                result.add(secondHalf.get(i));
            }
            for(int i = inputIndex; i < firstHalf.size(); i++){
                result.add(firstHalf.get(i));
            }
        }
        return result;
    }
    public static ArrayList<CreateGame> beltSort(ArrayList<CreateGame> inputArr){
        ArrayList<CreateGame> result = new ArrayList<>();
        if(inputArr.size() == 1){
            return inputArr;
        }
        else{
            int mid = inputArr.size() / 2;
            ArrayList<CreateGame> firstHalf = new ArrayList<>(inputArr.subList(0, mid));
            firstHalf = beltSort(firstHalf);
            ArrayList<CreateGame> secondHalf = new ArrayList<>(inputArr.subList(mid, inputArr.size()));
            secondHalf = beltSort(secondHalf);

            int inputIndex = 0;
            int returnIndex = 0;

            while(inputIndex < firstHalf.size() && returnIndex < secondHalf.size()){
                if(firstHalf.get(inputIndex).getBeltColor().getBeltNum() < secondHalf.get(returnIndex).getBeltColor().getBeltNum()){
                    result.add(firstHalf.get(inputIndex));
                    inputIndex++;
                }else{
                    result.add(secondHalf.get(returnIndex));
                    returnIndex++;
                }
            }
            for(int i = returnIndex; i < secondHalf.size(); i++){
                result.add(secondHalf.get(i));
            }
            for(int i = inputIndex; i < firstHalf.size(); i++){
                result.add(firstHalf.get(i));
            }
        }
        return result;

    }
    public static ArrayList<CreateGame> nameSort(ArrayList<CreateGame> inputArr){
        ArrayList<CreateGame> result = inputArr;
        if(result.size() == 1){
            return result;
        }else{
            int mid = inputArr.size() / 2;
            ArrayList<CreateGame> firstHalf = new ArrayList<>(inputArr.subList(0, mid));
            firstHalf = nameSort(firstHalf);
            ArrayList<CreateGame> secondHalf = new ArrayList<>(inputArr.subList(mid, inputArr.size()));
            secondHalf = nameSort(secondHalf);

            int inputIndex = 0;
            int returnIndex = 0;
            while(inputIndex < firstHalf.size() && returnIndex < secondHalf.size()){
                if(firstHalf.get(inputIndex).getAuthor().compareTo(secondHalf.get(returnIndex).getAuthor()) < 0){
                    result.add(firstHalf.get(inputIndex));
                    inputIndex++;
                }
                else{
                    result.add(secondHalf.get(returnIndex));
                    returnIndex++;
                }
            }
            for(int i = returnIndex; i < secondHalf.size(); i++){
                result.add(secondHalf.get(i));
            }
            for(int i = inputIndex; i < firstHalf.size(); i++){
                result.add(firstHalf.get(i));
            }
        }
        return result;
    }
    public void sortAllBelt(){
        this.getModel().setLibrary(beltSort(this.getModel().getLibrary()));
        this.getModel().setQuestGames(beltSort(this.getModel().getQuestGames()));
        this.getModel().setFreestyleGames(beltSort(this.getModel().getFreestyleGames()));
        this.getModel().setSenseiGames(beltSort(this.getModel().getSenseiGames()));
        this.getModel().setGbsGames(beltSort(this.getModel().getGbsGames()));
    }
    public void sortAllName(){
        this.getModel().setLibrary(nameSort(this.getModel().getLibrary()));
        this.getModel().setQuestGames(nameSort(this.getModel().getQuestGames()));
        this.getModel().setFreestyleGames(nameSort(this.getModel().getFreestyleGames()));
        this.getModel().setSenseiGames(nameSort(this.getModel().getSenseiGames()));
        this.getModel().setGbsGames(nameSort(this.getModel().getGbsGames()));
    }
    public void sortAllDate(){
        this.getModel().setLibrary(dateSort(this.getModel().getLibrary()));
        this.getModel().setQuestGames(dateSort(this.getModel().getQuestGames()));
        this.getModel().setFreestyleGames(dateSort(this.getModel().getFreestyleGames()));
        this.getModel().setSenseiGames(dateSort(this.getModel().getSenseiGames()));
        this.getModel().setGbsGames(dateSort(this.getModel().getGbsGames()));
    }
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
            default -> Genre.SPORTS;
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
            case "green" -> Belt.GREEN;
            case "blue" -> Belt.BLUE;
            case "red" -> Belt.RED;
            case "brown" -> Belt.BROWN;
            case "black" -> Belt.BLACK;
            default -> Belt.WHITE;
        };
    }
    public Type readType(String s) throws Exception {
        return switch(s.toLowerCase()){
            case "quest" -> Type.QUEST;
            case "freestyle" -> Type.FREESTYLE;
            case "gbs" -> Type.GBS;
            case "sensei" -> Type.SENSEI;
            default -> throw new Exception("Type Cannot be found");
        };
    }
    public void selectGame(int currRow, int currCol, ArrayList<CreateGame> currGames) throws URISyntaxException, IOException {
        System.out.println("Now Playing " + currGames.get(currRow * 5 + currCol).getName());
        Desktop.getDesktop().browse(new URI(currGames.get(currRow * 5 + currCol).getUrl()));
    }
}
