

import java.util.Stack;

public class Controller {
    private Model model;
    private Stack<Page> navStack;

    Controller(Model model) {
        this.model = model;
        this.navStack = new Stack();
    }

    public void navigateTo(Page page) {
        this.navStack.push(page);
    }
}
