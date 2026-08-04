import java.io.FileNotFoundException;
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
    public void start(Stage stage) throws Exception {
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
        // Initialize universal labels
        Label gameLabel = new Label(game.getName());
        Label authorLabel = new Label(game.getAuthor().toString());

        // Separate CreateGames with GBSGames
        if(game instanceof CreateGame){
            CreateGame workingGame = (CreateGame) game;

            /*TODO change the beltLabel into an image corresponding to the belt color
            -------------------------------------------------------------------------
             */
            Label beltLabel = new Label(workingGame.getBeltColor().toString());
            //-----------------------------------------------------------------------

            result.getChildren().addAll(beltLabel, gameLabel, authorLabel);

        }
        else if(game instanceof GBSGame){
            GBSGame workingGame = (GBSGame) game;

            // TODO change the label into an image to be displayed
            Label buildLabel = new Label("GBS");
            //---------------------------------------------------

            Label template = new Label(workingGame.getTemplate().toString());
            result.getChildren().addAll(template);
        }
        return new VBox(20);
    }

    /*
    This will populate the grid with game thumbnails
     */
    public void populateGrid(String category, Controller controller){
        GridPane resultGrid = new GridPane();
        int librarySize = controller.getModel().getLibrary().size();
        int row = 0;
        int col = 0;
        for(int i = 0; i < librarySize; i++){
            Game currGame = controller.getModel().getLibrary().get(i);
            if(category.equals(currGame.getName())){
                resultGrid.add(thumbnailBuilder(controller.getModel().getLibrary().get(i)), row, col);
                if(col == 4){
                    row++;
                    col = 0;
                }
                else{
                    col++;
                }
            }
        }
    }
}
