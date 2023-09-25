package Controller;

import Model.Command.CommandBuilder;
import Model.FacadeGame;
import View.ViewConsole;

/**
 * The controller send the views requests to the facade
 *
 * @author 54314
 */
public class Controller {

    private final FacadeGame facade;
    private final ViewConsole view;

    private final CommandBuilder buildCommand;

    /**
     * Constructor of Controller
     *
     * @param facade
     * @param view
     */
    public Controller(FacadeGame facade, ViewConsole view) {
        this.facade = facade;
        this.view = view;
        this.buildCommand = new CommandBuilder(facade);
        facade.subscribe(view);
    }

    /**
     * This method play the game
     */
    public void play() {
        int level = view.askLevel();
        int size = view.askSize();
        this.facade.start(level, size);
        this.view.displayWelcome();
        boolean endGame = this.facade.endGame();
        while (!endGame) {
            String command = this.view.askString();
            if (command.toLowerCase().equals("undo") || command.toLowerCase().equals("u") || command.toLowerCase().equals("redo") || command.toLowerCase().equals("r")) {
                this.buildCommand.runCommand(command);
            } else if (command.toLowerCase().equals("play") || command.toLowerCase().equals("p")) {
                int row = this.view.askPositionX();
                int col = this.view.askPositionY();
                while (!this.facade.isInside(row, col)) {
                    System.out.println("Position inconnu au bataillon");
                    row = this.view.askPositionX();
                    col = this.view.askPositionY();
                }
                this.buildCommand.playCommand(row, col);
            } else if (command.toLowerCase().equals("stop") || command.toLowerCase().equals("s")) {
                endGame = true;
                view.displayPlate();
                view.displayScore();
                view.displayEnd();
                break;
            }
            endGame = this.facade.endGame();
        }
        view.displayPlate();
        view.displayScore();
        view.displayEnd();
    }

}
