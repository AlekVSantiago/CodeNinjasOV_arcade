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
        VBox mainBox = new VBox();
        HBox buttonBox = new HBox();

        //setting Panes and Boxes with each other
        mainBox.getChildren().add(buttonBox);
        root.setCenter(mainBox);



        /*
        Button Tabs Collection
         */
        Button questBtn = new Button("QUEST");
        questBtn.setMinSize(180, 80);
        Button freeBtn = new Button("FREESTYLE");
        freeBtn.setMinSize(180, 80);
        Button buildBtn = new Button("GAME BUILDING SESSION");
        buildBtn.setMinSize(180, 80);
        Button senseiBtn = new Button("SENSEI");
        senseiBtn.setMinSize( 180, 80);
        Button workingBtn = questBtn;
        buttonBox.getChildren().addAll(questBtn, freeBtn, buildBtn, senseiBtn);

        root.setStyle("-fx-background-color: black, -fx-stroke-color: white");
        buttonBox.setSpacing(50);
        buttonBox.setPadding(new Insets(50, 20, 20, 20));
        buttonBox.setAlignment(Pos.TOP_CENTER);

        questBtn.setStyle("-fx-background-color: dodgerblue; -fx-border-width: 10; -fx-border-color: yellow; -fx-border-radius: 7; -fx-background-radius: 10");
        freeBtn.setStyle("-fx-background-color: dodgerblue;");
        buildBtn.setStyle("-fx-background-color: dodgerblue;");
        senseiBtn.setStyle("-fx-background-color: dodgerblue");
        /*
        GridPane Initialization
         */
        GridPane questGrid = new GridPane();
        GridPane freeGrid = new GridPane();
        GridPane buildGrid = new GridPane();
        GridPane senseiGrid = new GridPane();

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



        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Code Ninjas OV");
        stage.setScene(scene);
        stage.show();
    }
    /*
    This will create the thumbnail GUI to represent the Game
     */
    public VBox thumbnailBuilder(Game game){
        VBox result = new VBox(20);
        result.setPadding(new Insets(37));
        result.setOnMouseClicked(e -> System.out.println(game.getUrl()));

        // Initialize universal labels
        Label gameLabel = new Label(game.getName());
        Label authorLabel = new Label(game.getAuthorString());

        // Separate CreateGames with GBSGames
        if(game instanceof CreateGame){
            CreateGame workingGame = (CreateGame) game;
            Label beltLabel = new Label(workingGame.getBeltColor().toString());
            result.getChildren().addAll(gameLabel, authorLabel, beltLabel);
        }
        else if(game instanceof GBSGame){
            GBSGame workingGame = (GBSGame) game;
            Label templateLabel = new Label(workingGame.getTemplate().toString());
            result.getChildren().addAll(gameLabel, authorLabel, templateLabel);

        }
        return result;
    }

    /*
    This will populate the grid with game thumbnails
     */
    public GridPane populateGrid(String category, Controller controller){
        GridPane resultGrid = new GridPane();
        int librarySize = controller.getModel().getLibrary().size();
        int row = 0;
        int col = 0;
        for(int i = 0; i < librarySize; i++){
            Game currGame = controller.getModel().getLibrary().get(i);
            resultGrid.add(thumbnailBuilder(controller.getModel().getLibrary().get(i)), row, col);
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
