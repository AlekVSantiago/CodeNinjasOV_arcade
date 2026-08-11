import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public void start(Stage stage) throws Exception {
        Font.loadFont(getClass().getResourceAsStream("src/fonts/ARCADECLASSIC.TTF"), 18);


        Font.loadFont(getClass().getResourceAsStream("src/fonts/ka1.ttf"), 18);


        Controller controller = new Controller();

        /* 1--------------------------
            INITIALIZING ALL UI COMPONENTS
            --------------------------
         */

        /*
            Housing for all of the nodes
         */
        BorderPane root = new BorderPane();
        root.getStyleClass().add("root");
        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add("StyleSheet.css");
        VBox mainBox = new VBox();
        mainBox.setSpacing(5);
        HBox buttonBox = new HBox();

        //setting Panes and Boxes with each other
        Label appTitle = new Label("Code Ninjas Oro Valley");
        appTitle.getStyleClass().add("app-title");
        mainBox.getChildren().addAll(appTitle,buttonBox);
        mainBox.setAlignment(Pos.TOP_CENTER);
        root.setCenter(mainBox);


        Font.loadFont(getClass().getResourceAsStream("/fonts/myfont.ttf"), 18);




        /*
        Button Tabs Collection
         */
        Button questBtn = new Button("QUEST");
        questBtn.setMinSize(180, 80);
        questBtn.getStyleClass().add("big-button");
        Button freeBtn = new Button("FREESTYLE");
        freeBtn.setMinSize(180, 80);
        freeBtn.getStyleClass().add("big-button");
        Button buildBtn = new Button("GAME BUILDING SESSION");
        buildBtn.setMinSize(180, 80);
        buildBtn.getStyleClass().add("big-button");
        Button senseiBtn = new Button("SENSEI");
        senseiBtn.setMinSize( 180, 80);
        senseiBtn.getStyleClass().add("big-button");
        Button workingBtn = questBtn;
        workingBtn.getStyleClass().add("big-button");
        buttonBox.getChildren().addAll(questBtn, freeBtn, buildBtn, senseiBtn);

        buttonBox.setSpacing(20);
        buttonBox.setPadding(new Insets(50, 20, 20, 20));
        buttonBox.setAlignment(Pos.TOP_CENTER);

        /*
        GridPane Initialization
         */
        GridPane questGrid = populateGrid(controller.getModel().getQuestGames());
        questGrid.setHgap(40);
        questGrid.setVgap(20);
        GridPane freeGrid = populateGrid(controller.getModel().getFreestyleGames());
        freeGrid.setHgap(40);
        freeGrid.setVgap(20);
        GridPane buildGrid = populateGrid(controller.getModel().getGbsGames());
        buildGrid.setHgap(40);
        buildGrid.setVgap(20);
        GridPane senseiGrid = populateGrid(controller.getModel().getSenseiGames());
        senseiGrid.setAlignment(Pos.TOP_CENTER);
        senseiGrid.setHgap(60);
        senseiGrid.setVgap(20);

        ScrollPane gameScroll = new ScrollPane(senseiGrid);
        gameScroll.setFitToWidth(true);
        mainBox.getChildren().add(gameScroll);
        mainBox.setPadding(new Insets(20));

        stage.setTitle("Code Ninjas OV");
        stage.setScene(scene);
        stage.show();
    }
    /*
    This will create the thumbnail GUI to represent the Game
     */
    public Button thumbnailBuilder(Game game){
        VBox buttonGraphic = new VBox();
        buttonGraphic.getStyleClass().add("game-box-content");
        buttonGraphic.setAlignment(Pos.TOP_CENTER);
        Label titleLabel = new Label(game.getName());

        titleLabel.getStyleClass().add("thumbnail-title");
        Label authorLabel = new Label(game.getAuthorString());
        authorLabel.setAlignment(Pos.TOP_CENTER);

        authorLabel.getStyleClass().add("thumbnail-author");
        VBox titleBox = new VBox();
        titleBox.getStyleClass().add("game-title-box");
        titleBox.setPrefSize(110, 140);
        titleBox.getChildren().add(titleLabel);
        titleBox.setAlignment(Pos.CENTER);



        buttonGraphic.getChildren().addAll(titleBox,authorLabel);
        Button result = new Button("");
        result.setPrefSize(300, 230);
        result.getStyleClass().add("game-button");
        result.setGraphic(buttonGraphic);
        return result;


    }

    /*
    This will populate the grid with game thumbnails
     */
    public GridPane populateGrid(ArrayList<Game> gameArr){
        GridPane resultGrid = new GridPane();
        int row = 0;
        int col = 0;
        for(int i = 0; i < gameArr.size(); i++){
            resultGrid.add(thumbnailBuilder(gameArr.get(i)), col, row);
            if(col == 3){
                row++;
                col = 0;
            }
            else{
                col++;
            }

        }
        return resultGrid;
    }
}
