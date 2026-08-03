import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class HelloApplication extends Application {
    public HelloApplication() {
    }

    public void start(Stage stage) throws IOException {
        Controller controller = new Controller();
        /*
        GridPane Initialization
         */
        GridPane questGrid = new GridPane();
        GridPane freeGrid = new GridPane();
        GridPane buildGrid = new GridPane();
        GridPane senseiGrid = new GridPane();

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
        root.setTop(tabs);
        /*
            Grid of Games
         */
        GridPane gameGrid = new GridPane();

        /*
        rootSetting for the main BorderPane of the window
         */
        root.setCenter(gameGrid);
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
        result.setOnMouseClicked(e -> System.out.println(game.getUrl()));

        if(game instanceof CreateGame){
            CreateGame workingGame = (CreateGame) game;
            Label beltLabel = new Label(workingGame.getBeltColor().toString());
            Label gameLabel = new Label(workingGame.getName());
            Label authorLabel = new Label(workingGame.getAuthor().toString());

            result.getChildren().addAll(beltLabel, gameLabel, authorLabel);

        }
        else if(game instanceof GBSGame){
            GBSGame workingGame = (GBSGame) game;
        }



        return new VBox(20);
    }





    /*
    This will populate the grid with game thumbnails
     */
    public void populateGrid(String category){
        GridPane resultGrid = new GridPane();

    }
}
