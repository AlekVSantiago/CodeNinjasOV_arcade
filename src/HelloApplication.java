import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class HelloApplication extends Application {
    public HelloApplication() {
    }

    public void start(Stage stage) throws IOException {
        /*
        Initialize the model to display
         */
        Model model = new Model(new ArrayList(), Theme.NEUTRAL);


       /*
       Tab Initialization
        */
        Tab questTab = new Tab("Quest");
        Tab freeTab = new Tab("FreeStyle");
        Tab buildTab = new Tab("GBS (Game Building Session)");
        Tab senseiTab = new Tab("Sensei");

        /*
        GridPane Initialization
         */
        GridPane questGrid = new GridPane();
        GridPane freeGrid = new GridPane();
        GridPane buildGrid = new GridPane();
        GridPane senseiGrid = new GridPane();


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
}
