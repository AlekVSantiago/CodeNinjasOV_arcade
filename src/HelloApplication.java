import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {
    ArrayList<ArrayList<VBox>> gameBoxArr = new ArrayList<ArrayList<VBox>>();
    GridPane workingGrid;
    int rowNumber; // Number of rows that the current gridPane has for reference
    int currRow = 0;
    int currCol = 0;

    public void start(Stage stage) throws Exception {
        Font.loadFont(getClass().getResourceAsStream("src/fonts/ARCADECLASSIC.TTF"), 18);
        Font.loadFont(getClass().getResourceAsStream("src/fonts/ka1.ttf"), 18);
        Controller controller = new Controller();
        int column = 4;


        /* 1--------------------------
            INITIALIZING ALL UI COMPONENTS
            --------------------------
         */

        /*
            Housing for all of the nodes
         */
        BorderPane root = new BorderPane();
        root.getStyleClass().add("root");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("StyleSheet.css");
        root.getStylesheets().add("my-node");
        VBox mainBox = new VBox();
        VBox topBox = new VBox();
        mainBox.setSpacing(0);
        mainBox.getStyleClass().add("main-box");
        topBox.getStyleClass().add("top-box");
        topBox.setSpacing(20);
        VBox.setMargin(topBox, new Insets(20, 15, 0, 15));
        HBox buttonBox = new HBox();

        //setting Panes and Boxes with each other
        Label appTitle = new Label("Code Ninjas ARCADE");
        appTitle.getStyleClass().add("app-title");
        topBox.getChildren().addAll(appTitle, buttonBox);
        mainBox.getChildren().addAll(topBox);
        mainBox.setAlignment(Pos.TOP_LEFT);
        root.setCenter(mainBox);


        Font.loadFont(getClass().getResourceAsStream("/fonts/myfont.ttf"), 18);


        /*
            REFERENCES

                ----------------Scrolling the ScrolePane with controls-------------
                scrollPane.setVvalue(scrollPane.getVvalue() + 0.1); // scroll down
                scrollPane.setVvalue(scrollPane.getVvalue() - 0.1); // scroll up



                ----------------KeyCode Pressing and releasing---------------------
                boolean isHeld = false;


                ----------------Scrolling the ScrolePane with controls-------------
               boolean isHeld = false;

                scene.setOnKeyPressed(event -> {
                    if(event.getCode() == KeyCode.A){
                        isHeld = true;
                    }
                });
                scene.setOnKeyReleased(event -> {
                    if(event.getCode() == KeyCode.A){
                        isHeld = false;
                    }
                });
         */

        //Initialize the Quest Button
        Button questBtn = new Button("ADVENTURE");
        questBtn.setPrefSize(180, 110);
        questBtn.getStyleClass().add("big-button");

	//Initialize the Freebuild Button
        Button freeBtn = new Button("SANDBOX");
        freeBtn.setPrefSize(180, 110);
        freeBtn.getStyleClass().add("big-button");

	//Initialize the Build Button
        Button buildBtn = new Button("Game Build Session");
        buildBtn.setPrefSize(300, 110);
        buildBtn.getStyleClass().add("big-button");

 	//Initialize Sensei button
        Button senseiBtn = new Button("SENSEI");
        senseiBtn.setPrefSize(180, 110);
        senseiBtn.getStyleClass().add("big-button");

 	

	// buttonBox setUp
        buttonBox.getChildren().addAll(questBtn, freeBtn, buildBtn, senseiBtn);
        buttonBox.setSpacing(40);
        buttonBox.setAlignment(Pos.TOP_CENTER);


        populateGrid(controller.getModel().getCurrGames(), column);

        ScrollPane gameScroll = new ScrollPane(workingGrid);
        gameScroll.setFitToWidth(true);
        gameScroll.setFitToHeight(true);

        mainBox.getChildren().add(gameScroll);
        mainBox.setPadding(new Insets(0));
        mainBox.setSpacing(0);


        /*
            Here is where I am going to test some of the event handling
         */
        scene.setOnKeyPressed(event -> {
            System.out.println(event.getCode());
            System.out.println("(" + currRow + ", " + currCol + ")");
            switch(event.getCode()){
                case W:
                    if(currRow > 0){
                        this.gameBoxArr.get(currRow).get(currCol).getStyleClass().remove("highlighted");
                        currRow--;
                        this.gameBoxArr.get(currRow).get(currCol).getStyleClass().add("highlighted");
                    }
                    break;


                case A:
                    if(currCol > 0){
                        this.gameBoxArr.get(currRow).get(currCol).getStyleClass().remove("highlighted");
                        currCol--;
                        this.gameBoxArr.get(currRow).get(currCol).getStyleClass().add("highlighted");
                    }
                    break;
                case D:
                    if(currCol < 4) {
                        this.gameBoxArr.get(currRow).get(currCol).getStyleClass().remove("highlighted");
                        currCol++;
                        this.gameBoxArr.get(currRow).get(currCol).getStyleClass().add("highlighted");

                    }
                    break;
                case S:
                    if(currRow < 3){
                        this.gameBoxArr.get(currRow).get(currCol).getStyleClass().remove("highlighted");
                        currRow++;
                        this.gameBoxArr.get(currRow).get(currCol).getStyleClass().add("highlighted");
                    }
                    break;
                case Z:
                    try {
                        controller.selectGame(currRow, currCol, controller.getModel().getCurrGames());
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
        });



        controller.sortAllBelt();
        stage.setTitle("Code Ninjas OV ARCADE");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
    /*
    This will create the thumbnail GUI to represent the Game
     */
    public VBox thumbnailBuilder(CreateGame game){
        /*
            Initializing all components
         */
        VBox contentBox = new VBox(); //Main box that everything is in
        VBox topLabelBox = new VBox();
        VBox bottomLabelBox = new VBox();

        Label authorLabel = new Label(game.getAuthor().replace("-", " ") + "'s");
        Label nameLabel = new Label(game.getName().replace("-", " "));
        Label releaseLabel = new Label(game.getReleaseDate().toString());
        Rectangle recPicture = new Rectangle(200, 130);
        recPicture.getStyleClass().add("rectangle");

        contentBox.setMinSize(260, 300);
        contentBox.setMaxSize(260, 300);
        contentBox.setSpacing(20);
        contentBox.setAlignment(Pos.CENTER);
        topLabelBox.setAlignment(Pos.BOTTOM_LEFT);
        topLabelBox.setSpacing(0);


        VBox.setMargin(topLabelBox, new Insets(5, 0, 0, 7));
        VBox.setMargin(bottomLabelBox, new Insets(0, 0, 0, 7));

        bottomLabelBox.setAlignment(Pos.TOP_LEFT);



        /*
            Initialize Styling
         */
        contentBox.getStyleClass().add("content-box");
        switch (game.getBeltColor()){
            case WHITE -> contentBox.getStyleClass().add("white-belt");
            case YELLOW -> contentBox.getStyleClass().add("yellow-belt");
            case ORANGE -> contentBox.getStyleClass().add("orange-belt");
            case GREEN -> contentBox.getStyleClass().add("green-belt");
            case BLUE -> contentBox.getStyleClass().add("blue-belt");
            case PURPLE -> contentBox.getStyleClass().add("purple-belt");
            case BROWN -> contentBox.getStyleClass().add("brown-belt");
            case RED -> contentBox.getStyleClass().add("red-belt");
            case BLACK -> contentBox.getStyleClass().add("black-belt");
            default -> contentBox.getStyleClass().add("gbs");
        }
        authorLabel.getStyleClass().add("labels");
        nameLabel.getStyleClass().add("labels");
        releaseLabel.getStyleClass().add("labels");

        authorLabel.getStyleClass().add("author");
        nameLabel.getStyleClass().add("name");
        nameLabel.setWrapText(true);
        nameLabel.setPadding(new Insets(0));
        releaseLabel.getStyleClass().add("release");

        topLabelBox.getChildren().addAll(authorLabel, nameLabel);
        bottomLabelBox.getChildren().add(releaseLabel);
        contentBox.getChildren().addAll(topLabelBox, recPicture, bottomLabelBox);
        return contentBox;

    }


    /*
    This will populate the grid with game thumbnails
     */
    public void populateGrid(ArrayList<CreateGame> gameArr, int colNum){
        this.workingGrid = new GridPane();
        ArrayList<VBox> rowArray = new ArrayList<>();
        workingGrid.setAlignment(Pos.TOP_CENTER);
        workingGrid.setHgap(20);
        workingGrid.setVgap(10);
        int row = 0;
        int col = 0;
        for(int i = 0; i < gameArr.size(); i++){
            VBox currBox = thumbnailBuilder(gameArr.get(i));
            rowArray.add(currBox);
            workingGrid.add(currBox, col, row);
            if(col == colNum){
                this.gameBoxArr.add(rowArray);
                rowArray = new ArrayList<VBox>();
                row++;
                col = 0;
            }
            else{
                col++;
            }
        }
        if(!rowArray.isEmpty()){
            this.gameBoxArr.add(rowArray);
        }

    }
    public ArrayList<VBox> populateArray(ArrayList<CreateGame> gameArr){
        ArrayList<VBox> result = new ArrayList<>();
        for(int i = 0; i < gameArr.size(); i++){
            result.add(thumbnailBuilder(gameArr.get(i)));
        }
        return result;
    }
    public ArrayList<VBox> populateSelectionArray(ArrayList<CreateGame> gameArr){
        ArrayList<VBox> result = new ArrayList<>();
        for(int i = 0; i < gameArr.size(); i++){
            result.add(thumbnailBuilder(gameArr.get(i)));
        }
        return result;
    }
}
