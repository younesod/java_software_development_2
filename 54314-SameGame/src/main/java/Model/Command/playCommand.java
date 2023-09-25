package Model.Command;

import Model.Command.Command;
import Model.Color;
import Model.FacadeGame;

/**
 * class playCommand Manages when the game is undone , redone or played
 *
 * @author 54314
 */
public class playCommand implements Command {

    private final int x;
    private final int y;
    private final FacadeGame facadeGame;
    private final Color[][] oldGame;
    private final int oldScore;
    private final int oldCurrentScore;

    /**
     * Constructor of playCommand
     *
     * @param x
     * @param y
     * @param facadeGame
     */
    public playCommand(int x, int y, FacadeGame facadeGame) {
        this.x = x;
        this.y = y;
        this.facadeGame = facadeGame;
        this.oldGame = this.facadeGame.getCopyGame();
        this.oldScore = this.facadeGame.getScore();
        this.oldCurrentScore = this.facadeGame.getScorePlay();
    }

    @Override
    public void execute() {
        this.facadeGame.play(x, y);
    }

    @Override
    public void undo() {
        this.facadeGame.setGame(this.oldGame);
        this.facadeGame.setScore(this.oldScore);
        this.facadeGame.setCurrentScore(this.oldCurrentScore);

    }

}
