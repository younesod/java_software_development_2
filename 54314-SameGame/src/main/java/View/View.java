package View;

/**
 * Inteface View
 * @author 54314
 */
public interface View {
    /**
     * Display Welcome when the game start
     */
    void displayWelcome();
    /**
     * Display the game
     */
    void displayPlate();
    /**
     * Display the score
     */
    void displayScore();
    /**
     * Display if the game is win or not
     */
    void displayEnd();
    /**
     * Ask the position of row
     * @return int
     */
    int askPositionX();
    /**
     * Ask the position of column
     * @return int
     */
    int askPositionY();
    /**
     * Ask the size of the game
     * @return int
     */
    int askSize();
    /**
     * Ask the level of the game
     * @return int
     */
    int askLevel();
    /**
     * Ask the choice of commands
     * @return string
     */
    String askString();
    
}
