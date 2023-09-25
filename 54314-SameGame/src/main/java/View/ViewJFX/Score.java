package View.ViewJFX;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * class Score
 * the part score of the view
 * @author 54134
 */
public class Score {
    private final GridPane gridScore;
    private final Label win;
    private final Label game_over;
    private final Label score;
    private final Label currentScore;
    private final Label blockLeft;

    /**
     * Constructor of Score
     */
    public Score() {
        this.gridScore = new GridPane();
        this.score = new Label();
        this.currentScore = new Label();
        this.win = new Label("Damn such a good player");
        this.game_over = new Label("Look at this looser");
        this.blockLeft = new Label();
    }
    
    /**
     * This method create the score
     */
    public void createScore(){
        this.score.setStyle("-fx-font-size: 30;-fx-text-fill: #6F6FB6;-fx-font-family: Impact;-fx-border-color:white;-fx-background-color:white;-fx-border-width:5;-fx-border-radius:10 10 10 10; -fx-background-radius: 10 10 10 10;");
        this.win.setStyle("-fx-font-size: 30;-fx-text-fill: #6F6FB6;-fx-font-family: Impact;-fx-border-color:white;-fx-background-color:white;-fx-border-width:5;-fx-border-radius:10 10 10 10; -fx-background-radius: 10 10 10 10;");
        this.game_over.setStyle("-fx-font-size: 30;-fx-text-fill: #6F6FB6;-fx-font-family: Impact;-fx-border-color:white;-fx-background-color:white;-fx-border-width:5;-fx-border-radius:10 10 10 10; -fx-background-radius: 10 10 10 10;");
        this.blockLeft.setStyle("-fx-font-size: 30;-fx-text-fill: #6F6FB6;-fx-font-family: Impact;-fx-border-color:white;-fx-background-color:white;-fx-border-width:5;-fx-border-radius:10 10 10 10; -fx-background-radius: 10 10 10 10;");
        this.currentScore.setStyle("-fx-font-size: 30;-fx-text-fill: #6F6FB6;-fx-font-family: Impact;-fx-border-color:white;-fx-background-color:white;-fx-border-width:5;-fx-border-radius:10 10 10 10; -fx-background-radius: 10 10 10 10;");
        this.gridScore.setHgap(100);
        this.gridScore.setVgap(2);
        
    }

    /**
     * Getter of gridScore
     * @return gridScore
     */
    public GridPane getGridScore() {
        return this.gridScore;
    }

    /**
     * Getter of win
     * @return  label win
     */
    public Label getWin() {
        return this.win;
    }

    /**
     * Getter of game_over
     * @return  label game_over
     */
    public Label getGame_over() {
        return this.game_over;
    }

    /**
     * Getter of score
     * @return label score
     */
    public Label getScore() {
        return this.score;
    }

    /**
     * Getter of currentScore
     * @return label currentScore
     */
    public Label getCurrentScore() {
        return this.currentScore;
    }

    /**
     * Getter of blockLeft
     * @return label blockLeft
     */
    public Label getBlockLeft() {
        return this.blockLeft;
    }
    
    
    
    
}
