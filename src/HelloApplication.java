import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class HelloApplication extends Application {
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        /*
        GridPane Initialization
         */
        GridPane questGrid = populateGrid("quest", controller);
        GridPane freeGrid = new GridPane();
        GridPane buildGrid = new GridPane();
        GridPane senseiGrid = new GridPane();
        /*


       /*
       Tab Initialization
        */
        Tab questTab = new Tab("Quest", questGrid);
        Tab freeTab = new Tab("FreeStyle", freeGrid);
        Tab buildTab = new Tab("GBS (Game Building Session)", buildGrid);
        Tab senseiTab = new Tab("Sensei", senseiGrid);



        /*
        All of the box components that the screen is going to be made of
         */
        BorderPane root = new BorderPane();
        TabPane tabs = new TabPane(questTab, freeTab, buildTab, senseiTab);


        /*
        rootSetting for the main BorderPane of the window
         */
        if(controller.getModel().getLibrary().size() == 0){
            System.out.println("Empty games brother");
        }
        else{
            System.out.println("There are " + controller.getModel().getLibrary().size() + " games here");
        }
        root.setCenter(tabs);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Code Ninjas Oro Valley");
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
