import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Control;
import javafx.scene.layout.Tab;

import javafx.stage.Stage;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public HelloApplication() {
    }

    public void start(Stage stage) throws IOException {
        Model model = new Model(new ArrayList(), Model.Theme.NEUTRAL);

        /*
        All of the box components that the screen is going to be made of
         */
        BorderPane root = new BorderPane();
		
	TabPane tabs = new TabPane();

	Tab questTab = new Tab();
	questTab.setText("Quest");

	Tab gbsTab = new gbsTab();
	gbsTab.setText("GBS");

	Tab senseiTab = new Tab();
	senseiTab.setText("Sensei");

	Tab freeStyleTab = new Tab();
	freeStyleTab.setText("FreeStyle");

	tabs.getTabs().addAll(questTab, gbsTab, senseiTab, freeStyleTab);


       /*
       Tabs
        */
       Button questButton  = new Button("Quest");
       Button GBSButton = new Button("Game Building Session");
       Button senseiButton = new Button("Sensei");
       Button freeStyle = new Button("Freestyle");
       verticalTabs.getChildren().addAll(questButton, GBSButton, senseiButton, freeStyle);

        /*
            Grid of Games
         */
        GridPane gameGrid = new GridPane();

        root.getChildren().add(verticalTabs);
        Scene scene = new Scene(root, 17, 15);
        stage.setTitle("Code Ninjas Or");
        stage.setScene(scene);
        stage.show();
    }
}
