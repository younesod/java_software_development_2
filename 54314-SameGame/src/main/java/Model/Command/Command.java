package Model.Command;

/**
 * interface Command
 * @author 54314
 */
public interface Command {
    
    /**
     * Execute the command
     */
    void execute();
    
    /**
     * Undo the command
     */
    void undo();
}
