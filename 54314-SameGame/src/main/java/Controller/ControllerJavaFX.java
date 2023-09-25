package Controller;

import Model.Command.CommandBuilder;
import Model.FacadeGame;
import View.ViewJFX.GamePlate;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *The controller send the views requests to the facade
 * @author 54314
 */
public class ControllerJavaFX {

    private final Stage stage;
    private final FacadeGame facade;
    private final GamePlate view;
    private final CommandBuilder buildCommand;
    private final GridPane grid;

    /**
     * Constructor of ControllerJavaFX
     * @param facade
     * @param stage 
     */
    public ControllerJavaFX(FacadeGame facade, Stage stage) {
        this.stage = stage;
        this.facade = facade;
        this.buildCommand = new CommandBuilder(facade);
        this.view = new GamePlate(this, facade);
        this.view.createView(stage);
        facade.subscribe(view);
        this.grid = view.getGridGame();
    }

    /**
     * Getter of buildCommand
     * @return buildCommand
     */
    public CommandBuilder getBuildCommand() {
        return this.buildCommand;
    }

    /**
     * Launch the game
     */
    public void launch() {
        start();
        leave();
        undo();
        redo();
    }

    /**
     * This method manages the click of a block button in the game
     * @param button 
     */
    public void click(Button button) {
        if (this.facade.endGame() || this.facade.getLeave()) {
            button.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
                e.consume();
            });
        } else {
            button.addEventFilter(MouseEvent.MOUSE_ENTERED, e -> {
                button.setOpacity(0.7);
            });
            button.addEventFilter(MouseEvent.MOUSE_EXITED, e -> {
                button.setOpacity(1);
            });
            button.setOnAction(e -> {
                int row = GridPane.getRowIndex(button);
                int column = GridPane.getColumnIndex(button);
                this.buildCommand.playCommand(row, column);
                if (this.facade.getnbAppels() < 2) {
                    this.view.getPopup().setText("Minimum 2 cases");
                    var pause = new PauseTransition(Duration.seconds(1));
                    this.view.getPop().show(this.stage);
                    pause.setOnFinished(evt -> {
                        this.view.getPop().hide();
                    });
                    pause.play();
                }
                //this.facade.notifyObservers(this.facade.endGame());

            });
        }
    }

    /**
     * This method manages the undo button in the game 
     */
    public void undo() {
        this.view.getMenu().getUndo().setOnAction(e -> {
            if(this.buildCommand.getHistoryCommand().isEmpty()){
                this.view.getPopup().setText("There is nothing that you can undo");
                var pause = new PauseTransition(Duration.seconds(1));
                    this.view.getPop().show(this.stage);
                    pause.setOnFinished(evt -> {
                        this.view.getPop().hide();
                    });
                    pause.play();
            }
            else{
                this.buildCommand.undo();
            }
            //this.facade.notifyObservers(this.facade.endGame());

        });
    }

    /**
     * This method manages the redo button in the game
     */
    public void redo() {
        this.view.getMenu().getRedo().setOnAction(e -> {
            if(this.buildCommand.getRedoCommand().isEmpty()){
                this.view.getPopup().setText("There is nothing that you can redo");
                var pause = new PauseTransition(Duration.seconds(1));
                    this.view.getPop().show(this.stage);
                    pause.setOnFinished(evt -> {
                        this.view.getPop().hide();
                    });
                    pause.play();
            }
            else{
                this.buildCommand.redo();
            }
            //this.facade.notifyObservers(this.facade.endGame());
        });
    }

    /**
     * This method manages the leave button in the game
     */
    public void leave() {
        this.view.getMenu().getLeave().setOnAction(e -> {
            setDisable();
            this.view.getMenu().getStart().setDisable(false);
            this.view.getMenu().getColor().setDisable(false);
            this.view.getMenu().getLevel().setDisable(false);
            this.facade.setLeave(true);
            this.facade.getNotify();
            this.buildCommand.clear();
            //this.facade.notifyObservers(facade.getLeave());
        });
    }

    /**
     * This method start the game
     */
    public void start() {
        this.view.getMenu().getStart().setOnAction(e -> {
            this.facade.setLeave(false);
            this.view.getGridGame().getChildren().clear();
            setEnable();
            this.view.getScoreMenu().getGridScore().getChildren().clear();
            this.view.getScoreMenu().getGridScore().add(this.view.getScoreMenu().getScore(), 0, 0);
            this.view.getScoreMenu().getGridScore().add(this.view.getScoreMenu().getBlockLeft(), 1, 0);
            this.view.getScoreMenu().getGridScore().add(this.view.getScoreMenu().getCurrentScore(), 0, 2);
            this.view.getMenu().getStart().setDisable(true);
            this.view.getMenu().getColor().setDisable(true);
            this.view.getMenu().getLevel().setDisable(true);
            int color = this.view.getMenu().getColor().getValue();
            String size = this.view.getMenu().getLevel().getValue();
            int sizeChoose = 5;
            switch (size) {
                case "normal":
                    sizeChoose = 5;
                    break;
                case "advanced":
                    sizeChoose = 6;
                    break;
                case "hardcore":
                    sizeChoose = 7;
                    break;
            }
            this.facade.start(color, sizeChoose);
            
        });
    }
    
    /**
     * Disable all the necessary buttons
     */
    private void setDisable() {
        this.view.getMenu().getLeave().setDisable(true);
        this.view.getMenu().getUndo().setDisable(true);
        this.view.getMenu().getRedo().setDisable(true);
    }

    /**
     * Enable all the necessary buttons
     */
    private void setEnable() {
        this.view.getMenu().getLeave().setDisable(false);
        this.view.getMenu().getUndo().setDisable(false);
        this.view.getMenu().getRedo().setDisable(false);
    }

}
