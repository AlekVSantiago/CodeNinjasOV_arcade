import java.util.ArrayList;

public class Model {
    private ArrayList<Game> library;
    private Theme theme;

    Model(ArrayList<Game> library, Theme theme){
        this.library = library;
        this.theme = theme;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public ArrayList<Game> getLibrary() {
        return library;
    }

    public void setLibrary(ArrayList<Game> library) {
        this.library = library;
    }
}
