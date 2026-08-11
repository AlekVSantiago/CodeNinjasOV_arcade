import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
public class HelloApplication extends Application {
    public void start(Stage stage) throws Exception {
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
        HBox buttonBox = new HBox();

        //setting Panes and Boxes with each other
        mainBox.getChildren().add(buttonBox);
        root.setCenter(mainBox);



        /*
        Button Tabs Collection
         */
        Button backButton = new Button("");
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
        questGrid.setHgap(30);
        GridPane freeGrid = populateGrid(controller.getModel().getFreestyleGames());
        freeGrid.setHgap(30);
        GridPane buildGrid = populateGrid(controller.getModel().getGbsGames());
        buildGrid.setHgap(30);
        GridPane senseiGrid = populateGrid(controller.getModel().getSenseiGames());
        senseiGrid.setHgap(30);

       switch(workingBtn.getText()) {
           case "QUEST":
               mainBox.getChildren().add(questGrid);
           case "FREESTYLE":
               mainBox.getChildren().add(freeGrid);
           case "GAME BUILDING SESSION":
               mainBox.getChildren().add(buildGrid);
           case "SENSEI":
               mainBox.getChildren().add(senseiGrid);
           default:
               System.out.println("Throw an exception here brother");
       }



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
        buttonGraphic.setAlignment(Pos.CENTER);
        buttonGraphic.setSpacing(20);
        Label titleLabel = new Label(game.getName());

        titleLabel.getStyleClass().add("thumbnail-title");
        Label authorLabel = new Label(game.getAuthorString());

        authorLabel.getStyleClass().add("thumbnail-author");
        Rectangle placeHolderRectangle = new Rectangle(250, 113);
        placeHolderRectangle.getStyleClass().add("placeholderImage");
        placeHolderRectangle.setArcWidth(10);
        placeHolderRectangle.setArcHeight(10);


        buttonGraphic.getChildren().addAll(placeHolderRectangle, titleLabel, authorLabel);
        Button result = new Button("");
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
            resultGrid.add(thumbnailBuilder(gameArr.get(i)), row, col);
            if(row == 4){
                col++;
                row = 0;
            }
            else{
                row++;
            }

        }
        return resultGrid;
    }
}
