package Model;

import Observer.Observer;

/**
 * class Facade
 * @author 54314
 */
public class FacadeGame {

    
    private Game game;

    /**
     * Constructor of FacadeGame
     * @param game 
     */
    public FacadeGame(Game game) {
        this.game = game;
    }

    /**
     * 
     * @param level
     * @param size 
     */
    public void start(int level, int size) {
        this.game.start(level, size);
    }

    /**
     * Play 
     * @param i
     * @param j 
     */
    public void play(int i, int j) {
        this.game.play(i, j);
    }

    /**
     * Getter of score
     * @return score
     */
    public int getScore() {
        return this.game.getScore();
    }

    /**
     * Check if endGame is true or false
     * @return boolean
     */
    public boolean endGame() {
        return this.game.endGame();
    }

    /**
     * Getter of leave
     * @return boolean
     */
    public boolean getLeave() {
        return this.game.leave();
    }
    /**
     * Setter of leave
     * @param leave 
     */
    public void setLeave(boolean leave){
        this.game.setLeave(leave);
    }
    
    /**
     * Check if the game is win or not
     * @return boolean
     */
    public boolean winOrNot(){
        return this.game.winOrNot();
    }

    /**
     * Getter of game
     * @return game
     */
    public Color[][] getGame() {
        return this.game.getGame();
    }

    /**
     * Getter of a copy game
     * @return copy of game
     */
    public Color[][] getCopyGame() {
        return this.game.getCopyGame();
    }

    /**
     * Setter of game
     * @param game 
     */
    public void setGame(Color[][] game) {
        this.game.setGame(game);
    }

    /**
     * Setter of score
     * @param score 
     */
    public void setScore(int score) {
        this.game.setScore(score);
    }

    /**
     * Check if a position is inside the game
     * @param x
     * @param y
     * @return 
     */
    public boolean isInside(int x, int y) {
        return this.game.isInside(this.game.getGame(), x, y);
    }

    /**
     * Getter of nbColumn
     * @return int
     */
    public int getColumn() {
        return this.game.getColumn();
    }

    /**
     * Getter of nbRow
     * @return int
     */
    public int getRow() {
        return this.game.getRow();
    }

    /**
     * Getter of nbBlock
     * @return int
     */
    public int getNbBlock() {
        return this.game.getNbBlockLeft();
    }
    
    /**
     * Getter of nbCalls
     * @return int
     */
    public int getnbAppels(){
        return this.game.getNbAppels();
    }
    
    /**
     * Getter of scorePlayed
     * @return int
     */
    public int getScorePlay(){
        return this.game.getScorePlay();
    }
    
    /**
     * Setter of currentScore
     * @param currentScore 
     */
    public void setCurrentScore(int currentScore){
        this.game.setCurrentScore(currentScore);
    }
    
    public void getNotify(){
        this.game.getNotify();
    }

    /**
     * Call the subscribe method
     * @param observer 
     */
    public void subscribe(Observer observer) {
        this.game.subscribe(observer);
    }

    /**
     * Call the unsubscribe method
     * @param observer 
     */
    public void unsubscribe(Observer observer) {
        this.game.unsubscribe(observer);
    }

    /**
     * Call the notifyObserver method
     * @param bool 
     */
    public void notifyObservers(boolean bool) {
        this.game.notifyObservers(bool);
    }
    

}
