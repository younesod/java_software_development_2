package Main;

import Controller.Controller;
import Model.FacadeGame;
import Model.Game;
import View.ViewConsole;

/**
 * Class Main 
 * Start and launch the game
 * @author 54314
 */
public class main {

    /**
     * Launch the game
     *
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        FacadeGame facade = new FacadeGame(game);
        Controller controller = new Controller(facade, new ViewConsole(facade));
        controller.play();
    }

}
