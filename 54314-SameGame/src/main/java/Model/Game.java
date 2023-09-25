package Model;

import java.util.Random;
import static Model.Color.*;
import Observer.Observable;
import Observer.Observer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class Game
 * The model of the game
 * @author 54314
 */
public class Game implements GameInterface, Observable {

    private Color[][] game;
    private int level;
    private int size;
    private int nbAppels;
    private int score;
    private int currentScore;
    private boolean leave;

    private final List<Observer> observers = new ArrayList<>();

    /**
     * Constructor of game
     */
    public Game() {
        this.game= new Color[0][0];
    }

    @Override
    public void start(int level, int size) {
        if((level>=6 || level <=2) ||size<=3 ){
            throw new IllegalArgumentException("Level must be between 3 and 5 && size must be greater than 4");
        }
        this.leave=false;
        this.currentScore=0;
        this.score=0;
        this.nbAppels=0;
        this.level = level;
        this.size = size;
        this.game = new Color[this.size][this.size * 2];
        Random r = new Random();
        ArrayList<Color> listColor = new ArrayList<>();
        switch (this.level) {
            case 3:
                Collections.addAll(listColor, G, Y, R);
                break;
            case 4:
                Collections.addAll(listColor, G, Y, R, B);
                break;
            case 5:
                Collections.addAll(listColor, G, Y, R, B, O);
                break;

        }
        for (int i = 0; i < this.game.length; i++) {
            for (int j = 0; j < this.game[i].length; j++) {
                int rand = r.nextInt(this.level);
                this.game[i][j] = listColor.get(rand);
            }
        }
        this.notifyObservers(this.endGame());
    }

    @Override
    public boolean isInside(Object[][] tab, int x, int y) {
        return estDansTableau(tab, x) && estDansTableau(tab[x], y);
    }
    

    @Override
    public void play(int i, int j) {
        if (this.game == null) {
            throw new IllegalArgumentException("le plateau de game est null");
        }
        estDansMêmeTâche(this.game, i, j, i, j);
        compactBlock();
        
    }

    /**
     * Recursive Call that deleteBlock whent it's empty
     * @param tab
     * @param i1
     * @param j1
     * @param i2
     * @param j2 
     */
    private void estDansMêmeTâche(Color[][] tab, int i1, int j1, int i2, int j2) {
        boolean[][] visités = new boolean[tab.length][tab[0].length];
        this.nbAppels = 0;
        estDMTRec(tab, i1, j1, i2, j2, visités);
        if (this.nbAppels >= 2) {
            this.currentScore=this.score;
            deleteBlock(visités);
            this.score = this.score + this.nbAppels * (nbAppels - 1);
            this.currentScore=this.score-this.currentScore;
        }
        //System.out.printf("Nombre de blocs selectionnés: %d\n", this.nbAppels);
    }

    /**
     * Getter of score
     * @return int
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Check if there is an adjacent block with the same color,
     * if yes put the visited array in x, y to true, the process is repeated for each block recursively
     * @param tab
     * @param x
     * @param y
     * @param xD
     * @param yD
     * @param visités 
     */
    private void estDMTRec(Color[][] tab, int x, int y, int xD, int yD, boolean[][] visités) {
        if (!isInside(tab, x, y) || tab[x][y] == null
                || !tab[x][y].equals(tab[xD][yD])
                || visités[x][y]) {
            return;
        }
        this.nbAppels++;
        visités[x][y] = true;
        estDMTRec(tab, x + 1, y, xD, yD, visités);
        estDMTRec(tab, x - 1, y, xD, yD, visités);
        estDMTRec(tab, x, y - 1, xD, yD, visités);
        estDMTRec(tab, x, y + 1, xD, yD, visités);

    }

    /**
     * Check if the parameter is inside
     * @param tab
     * @param x
     * @return 
     */
    private boolean estDansTableau(Object[] tab, int x) {
        return 0 <= x && x < tab.length;
    }

    /**
     * Delete all the block when it's empty
     * @param visited 
     */
    private void deleteBlock(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j] == true) {
                    this.game[i][j] = null;
                }
            }
        }
    }

    /**
     * Compact the game by moving   all the blocks down 
     */
    private void compactBlock() {
        {
            for (int i = 0; i < getColumn(); i++) {
                int nextRowEmpty = getRow() - 1;
                int nextRow = nextRowEmpty;
                while (nextRow >= 0 && nextRowEmpty >= 0) {
                    while (nextRowEmpty >= 0 && game[nextRowEmpty][i] != null) {
                        nextRowEmpty--;
                    }
                    if (nextRowEmpty >= 0) {
                        nextRow = nextRowEmpty - 1;
                        while (nextRow >= 0 && game[nextRow][i] == null) {
                            nextRow--;
                        }
                        if (nextRow >= 0) {
                            game[nextRowEmpty][i] = game[nextRow][i];
                            game[nextRow][i] = null;
                        }
                    }
                }
            }
            compactCol();
        }
    }

    /**
     * Compact the game by moving all the columns to the left
     */
    private void compactCol() {
        int nextColEmpty = 0;
        int nextCol = nextColEmpty;
        while (nextColEmpty < getColumn() && nextCol < getColumn()) {
            while (nextColEmpty < getColumn() && this.game[getRow() - 1][nextColEmpty] != null) {
                nextColEmpty++;
            }
            if (nextColEmpty < getColumn()) {
                nextCol = nextColEmpty + 1;
                while (nextCol < getColumn() && this.game[getRow() - 1][nextCol] == null) {
                    nextCol++;
                }
                if (nextCol < getColumn()) {
                    for (int row = 0; row < getRow(); row++) {
                        this.game[row][nextColEmpty] = this.game[row][nextCol];
                        this.game[row][nextCol] = null;
                    }
                }
            }
        }
    }


    @Override
    public boolean endGame() {
        for (int col = 0; col < getColumn(); col++) {
            for (int row = getRow() - 1; row >= 0; row--) {
                Color colorBlock = this.game[row][col];
                if (colorBlock == null) {
                    break;
                } else {
                    if (row - 1 >= 0 && game[row - 1][col] == colorBlock) {
                        return false;
                    } else if (col + 1 < getColumn() && game[row][col + 1] == colorBlock) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    /**
     * Get a copy of the game
     * @return copy of game
     */
    public Color[][] getCopyGame() {
        Color[][] copy = new Color[getRow()][getColumn()];
        for (int i = 0; i < this.game.length; i++) {
            for (int j = 0; j < this.game[i].length; j++) {
                Color color = this.game[i][j];
                copy[i][j] = color;
            }
        }
        return copy;
    }

    public void print(Color[][] game) {
        System.out.println("Plateau:");

        for (int i = 0; i < game.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < game[0].length; j++) {
                if (game[i][j] == null) {
                    System.out.print("/ ");
                } else if (game[i][j] instanceof Color) {
                    System.out.print(game[i][j] + " ");
                }

            }
            System.out.println(" ");
        }
    }

    @Override
    public boolean winOrNot() {
        for (int i = 0; i < this.game.length; i++) {
            for (int j = 0; j < this.game[i].length; j++) {
                if (this.game[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Get the number of block left
     * @return int
     */
    public int getNbBlockLeft(){
        int cpt=0;
        for (int i = 0; i < this.game.length; i++) {
            for (int j = 0; j < this.game[i].length; j++) {
                if (this.game[i][j] instanceof Color) {
                    cpt++;
                }
            }
        }
        
        return cpt;
    }
    
    public void getNotify(){
        this.notifyObservers(leave);
    }

    @Override
    public void unsubscribe(Observer observer) {
        if (!observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void subscribe(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void notifyObservers(Boolean bool) {
        for (Observer observer : observers) {
            observer.update(bool);
        }
    }
    

    /**
     * Getter of game
     * @return game
     */
    public Color[][] getGame() {
        return game;
    }

    /**
     * Getter of size
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter of row
     * @return int
     */
    public int getRow() {
        return this.game.length;
    }

    /**
     * Getter of column
     * @return int
     */
    public int getColumn() {
        return this.game.length * 2;
    }

    /**
     * Setter of Game
     * @param game 
     */
    public void setGame(Color[][] game) {
        this.game = game;
    }

    /**
     * Setter of score
     * @param score 
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Getter of NbCalls
     * @return int
     */
    public int getNbAppels() {
        return nbAppels;
    }

    /**
     * Getter of currentScore
     * @return int
     */
    public int getScorePlay() {
        return currentScore;
    }

    /**
     * Setter of currentScore
     * @param currentScore 
     */
    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    /**
     * Setter of leave
     * @param leave 
     */
    public void setLeave(boolean leave) {
        this.leave = leave;
    }

    /**
     * Getter of leave
     * @return 
     */
    public boolean leave() {
        return leave;
    }


    

}
