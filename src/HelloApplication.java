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
	//Initialize the Scene
        Scene scene = new Scene(root);
        scene.getStylesheets().add("StyleSheet.css");

	// Initialize the controller instance
        Controller controller = new Controller();
        int column = 4;//TODO this does not feel right to put this here. 

        /* 1--------------------------
            INITIALIZING ALL UI COMPONENTS
            --------------------------
         */
	//Initialize Border Pane
        BorderPane root = new BorderPane();
        root.getStyleClass().add("root");
        root.getStylesheets().add("my-node");
	
	//Initialize mainBox, topBox and buttonBox
        VBox topBox = new VBox();//box containing all tope elements
        topBox.getStyleClass().add("top-box");
        topBox.setSpacing(20);

        VBox mainBox = new VBox();//box that holds all of the games in the selection 
        mainBox.setSpacing(0);
        mainBox.getStyleClass().add("main-box");
        mainBox.setAlignment(Pos.TOP_LEFT);

        HBox buttonBox = new HBox(); //box containing all of the top category and control buttons (buttons over the game)
	
        VBox.setMargin(topBox, new Insets(20, 15, 0, 15));//Setting up margins for the topbox


        Label appTitle = new Label("Code Ninjas ARCADE");
        appTitle.getStyleClass().add("app-title");

        //setting Panes and Boxes with each other
        topBox.getChildren().addAll(appTitle, buttonBox);
        mainBox.getChildren().addAll(topBox);
        root.setCenter(mainBox);

	/*
	 * Initializing all of the category buttons (Main buttons)
	 */
	VBox questBox = new VBox();//Quest Box
	Label questLabel = new Label("Quest");


	VBox freeBox = new VBox();//Free Box
	Label freeLabel = new Label("FreeStyle");


	VBox buildBox = new VBox();//Build Box
	Label buildLabel = new Label("GBS");


	VBox senseiBox = new VBox(); //Sensei box
	Label senseiLabel = new Label("Sensei");


	//Initializing and configuring all elements inside of the sort menu
	VBox sortSelection = new VBox(10); //Box containing all sort buttons
	sortSelection.getStyleClass().add("sort-box");
	
	//All sort buttons as a VBox
	VBox beltSortBox = new VBox(); //Belt Sort
	Label beltSortLabel = new Label("Belt");
	beltSortBox.getStyleClass().add("sort-button");
	beltSortLabel.getStyleClass().add("sort-label");

	VBox authorSortBox = new VBox(); //Author Sort
	Label authorSortLabel = new Label("Author");
	authorSortBox.getStyleClass().add("sort-button");	
	authorSortLabel.getStyleClass().add("sort-label");

	VBox releaseSortBox = new VBox();//Release Sort
        Label releaseSortLabel = new Label("Release Date");
	releaseSortBox.getStyleClass().add("sort-button");
	releaseSortLabel.getStyleClass().add("sort-label");

	sortSelection.getChildren().addAll(beltSortLabel, authorSortLabel, releaseSortLabel);
	
	// buttonBox setUp
        buttonBox.getChildren().addAll(questBox, freeBox, buildBox, senseiBox);
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
