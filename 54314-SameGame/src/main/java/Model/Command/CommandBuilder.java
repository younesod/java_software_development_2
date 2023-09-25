package Model.Command;

import Model.Command.Command;
import Model.FacadeGame;
import java.util.Stack;

/**
 * Class commandBuilder manages the undo, redo and play
 *
 * @author 54314
 */
public class CommandBuilder {

    private final Stack<Command> historyCommand;
    private final Stack<Command> redoCommand;
    private final FacadeGame facadeGame;

    /**
     * Constructor of CommandBuilder
     *
     * @param facadeGame
     */
    public CommandBuilder(FacadeGame facadeGame) {
        historyCommand = new Stack<>();
        redoCommand = new Stack<>();
        this.facadeGame = facadeGame;
    }

    /**
     * This method execute the command and push in the history Stack
     *
     * @param command
     */
    private void executeCommand(Command command) {
        command.execute();
        if (facadeGame.getnbAppels() >= 2) {
            redoCommand.clear();
            historyCommand.push(command);

        }

    }

    /**
     * this methode execute the command play with the given parameters
     *
     * @param x the row
     * @param y the column
     */
    public void playCommand(int x, int y) {
        Command play = new playCommand(x, y, facadeGame);
        executeCommand(play);
        facadeGame.notifyObservers(facadeGame.endGame());
    }

    /**
     * This method undo the last command in the history Stack
     */
    public void undo() {
        if (!historyCommand.isEmpty()) {
            Command commandUndo = historyCommand.pop();
            redoCommand.push(commandUndo);
            commandUndo.undo();
            facadeGame.notifyObservers(facadeGame.endGame());
        }

    }

    /**
     * This method redo the last undone command
     */
    public void redo() {
        if (!redoCommand.isEmpty()) {
            historyCommand.clear();
            Command commandRedo = redoCommand.pop();
            historyCommand.push(commandRedo);
            commandRedo.execute();
            facadeGame.notifyObservers(facadeGame.endGame());
        }
    }

    /**
     * This method clear all the stack
     */
    public void clear() {
        historyCommand.clear();
        redoCommand.clear();
    }

    /**
     * This method call the undo or redo with the given command
     *
     * @param command
     */
    public void runCommand(String command) {
        switch (command) {
            case "undo":
                undo();
                break;
            case "u":
                undo();
                break;
            case "redo":
                redo();
                break;
            case "r":
                redo();
                break;
        }
    }

    /**
     * Getter of Facade;
     *
     * @return facade;
     */
    public FacadeGame getFacadeGame() {
        return facadeGame;
    }

    /**
     * Getter of Stack Redo
     *
     * @return stack redo
     */
    public Stack<Command> getRedoCommand() {
        return redoCommand;
    }

    /**
     * Getter of Stack History
     *
     * @return stack history
     */
    public Stack<Command> getHistoryCommand() {
        return historyCommand;
    }

}
