package Model;

/**
 *Interface Game
 * @author 54314
 */
public interface GameInterface {
    
    /**
     * Create a game with the given level and size 
     * @param level
     * @param size 
     */
    public void start(int level, int size);
    
    /**
     * Check if the game is win or not
     * @return boolean
     */
    public boolean winOrNot();
    
    /**
     * Check if there is still move to be made
     * @return boolean
     */
    public boolean endGame();
    
   /**
    * Play 
     * @param i
     * @param j
    */
    public void play(int i, int j);
    
    /**
     * Check if the given position is inside the game
     * @param tab
     * @param x
     * @param y
     * @return 
     */
    public boolean isInside(Object[][] tab, int x, int y);
    

    
}
