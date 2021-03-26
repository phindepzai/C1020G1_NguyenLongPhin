package views;

import controllers.MainController;

public class View {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}
