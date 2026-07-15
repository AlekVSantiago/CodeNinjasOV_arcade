
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;

public class Model implements Observable {
    private ArrayList<Game> library;
    private Theme theme;

    public void addListener(InvalidationListener listener) {
    }

    public void removeListener(InvalidationListener listener) {
    }

    Model(ArrayList<Game> library, Theme theme) {
        this.library = library;
    }

    public ArrayList<Game> getLibrary() {
        return this.library;
    }

    public static enum Theme {
        NEUTRAL,
        DARK,
        LIGHT;

        private Theme() {
        }
    }

    public static enum ViewPage {
        HOME,
        CREATE,
        GBS,
        TESTER,
        SENSEI;

        private ViewPage() {
        }
    }
}
