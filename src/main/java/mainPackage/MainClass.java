package mainPackage;

import controller.Controller;
import view.View;

public class MainClass {
    public static void main(String[] args) {
        View view = new View();
        view.getFrame().setVisible(true);
        Controller controller = new Controller(view);
    }
}
