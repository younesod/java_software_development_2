package View.ViewJFX;

import Controller.ControllerJavaFX;
import Model.Color;
import static Model.Color.*;
import Model.FacadeGame;
import Observer.Observer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 *
 * @author School
 */
public class GamePlate implements Observer {

    private final FacadeGame facade;
    private final ControllerJavaFX controller;

    private final BorderPane border;
    private final GridPane gridGame;
    private final Scene scene;

    private final HBox horizontal;
    private final VBox vertical;
    private final VBox verticalR;
    private final Label popup;

    private final Popup pop;
    private final ButtonMenu menu;
    private final Score scoreMenu;

    /**
     * Constructor of GamePlate
     *
     * @param controller
     * @param facade
     */
    public GamePlate(ControllerJavaFX controller, FacadeGame facade) {
        this.menu = new ButtonMenu();
        this.menu.createMenu();
        this.scoreMenu = new Score();
        this.scoreMenu.createScore();
        this.facade = facade;
        this.controller = controller;
        this.border = new BorderPane();
        this.gridGame = new GridPane();
        this.scene = new Scene(border, 1000, 750);

        this.horizontal = new HBox();
        this.vertical = new VBox();
        this.verticalR = new VBox();
        this.popup = new Label("Minimum 2 cases");
        this.pop = new Popup();

    }

    /**
     * This method create the game view
     *
     * @param stage
     */
    public void createView(Stage stage) {
        this.border.setPrefSize(800, 600);
        this.border.setStyle("-fx-background-color :#bdbdde;");
        this.border.setAlignment(this.gridGame, Pos.CENTER);
        this.gridGame.setMinSize(600, 400);
        this.gridGame.setHgap(5);
        this.gridGame.setVgap(5);
        Label labelStart = new Label("SameGame");
        labelStart.setStyle("-fx-font-size: 50;-fx-text-fill: #6F6FB6;-fx-font-family: Impact;-fx-border-color:white;-fx-background-color:white;-fx-border-width:5;-fx-border-radius:10 10 10 10; -fx-background-radius: 10 10 10 10;");
        this.scoreMenu.getGridScore().add(labelStart, 0, 0);
        this.horizontal.setAlignment(Pos.CENTER);
        this.horizontal.setMinSize(100, 150);
        this.horizontal.getChildren().add(this.scoreMenu.getGridScore());

        this.pop.getContent().add(this.popup);
        this.popup.setStyle("-fx-background-color: white;-fx-padding: 10; -fx-border-color: white;-fx-border-width: 5;-fx-font-size: 16;-fx-font-family: Arial;-fx-text-fill: red");

        this.border.setTop(this.horizontal);
        this.border.setLeft(this.vertical);
        this.border.setRight(this.verticalR);
        this.border.setCenter(this.gridGame);
        this.border.setBottom(this.menu.getGridMenu());

        stage.setTitle("SameGame");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method update the view
     */
    public void updateView() {
        this.gridGame.getChildren().clear();
        int size = 0;
        switch (this.menu.getLevel().getValue()) {
            case "normal":
                size = 70;
                this.vertical.setMinSize(120, 400);
                this.verticalR.setMinSize(80, 400);
                break;
            case "advanced":
                size = 65;
                this.vertical.setMinSize(95, 400);
                this.verticalR.setMinSize(105, 400);
                break;
            case "hardcore":
                size = 55;
                this.vertical.setMinSize(90, 400);
                this.verticalR.setMinSize(110, 400);
                break;
        }
        for (int i = 0; i < this.facade.getGame().length; i++) {
            for (int j = 0; j < this.facade.getGame()[i].length; j++) {
                Color col = this.facade.getGame()[i][j];
                if (col == null) {
                    Label button;
                    this.gridGame.add(button = new Label(), j, i);
                    button.setMinSize(size, size);
                    button.setStyle("-fx-background-color: #bdbdde;-fx-background-radius: 0em;");
                } else {
                    switch (col) {
                        case G:
                            Button button;
                            this.gridGame.add(button = new Button(), j, i);
                            button.setMinSize(size, size);
                            button.setStyle("-fx-background-color: #e79796;-fx-background-radius: 6em;");
                            this.controller.click(button);
                            break;
                        case Y:
                            this.gridGame.add(button = new Button(), j, i);
                            button.setMinSize(size, size);
                            button.setStyle("-fx-background-color: #ffffff;-fx-background-radius: 5em;");
                            this.controller.click(button);
                            break;
                        case R:
                            this.gridGame.add(button = new Button(), j, i);
                            button.setMinSize(size, size);
                            button.setStyle("-fx-background-color: #796f6e;-fx-background-radius: 5em;");
                            this.controller.click(button);
                            break;
                        case B:
                            this.gridGame.add(button = new Button(), j, i);
                            button.setMinSize(size, size);
                            button.setStyle("-fx-background-color: #834c4c;-fx-background-radius: 5em;");
                            this.controller.click(button);
                            break;
                        case O:
                            this.gridGame.add(button = new Button(), j, i);
                            button.setMinSize(size, size);
                            button.setStyle("-fx-background-color: #e46d5a;-fx-background-radius: 5em;");
                            this.controller.click(button);
                            break;
                    }
                }
            }
        }
    }

    @Override
    public void update(Boolean bool) {
        if (!bool) {
            this.scoreMenu.getCurrentScore().setText("Last strike : " + this.facade.getScorePlay());
            this.scoreMenu.getBlockLeft().setText("Bloc Left : " + this.facade.getNbBlock());
            this.scoreMenu.getScore().setText("Score : " + this.facade.getScore());
            updateView();
        } else {
            if (this.facade.winOrNot() == true && this.facade.getLeave() == false) {
                this.gridGame.getChildren().clear();
                this.scoreMenu.getGridScore().add(scoreMenu.getWin(), 2, 0);
                this.controller.getBuildCommand().clear();
            } else if (facade.winOrNot() == false || this.facade.getLeave() == true) {
                this.scoreMenu.getGridScore().add(this.scoreMenu.getGame_over(), 2, 0);
                this.controller.getBuildCommand().clear();
            }
            this.scoreMenu.getBlockLeft().setText("Bloc Left : " + this.facade.getNbBlock());
            this.menu.getLeave().setDisable(true);
            this.menu.getUndo().setDisable(true);
            this.menu.getRedo().setDisable(true);
            this.menu.getStart().setDisable(false);
            this.menu.getLevel().setDisable(false);
            this.menu.getColor().setDisable(false);
            updateView();

        }
    }

    /**
     * Getter of border
     *
     * @return BorderPane
     */
    public BorderPane getBorder() {
        return this.border;
    }

    /**
     * Getter of menu
     *
     * @return ButtonMenu
     */
    public ButtonMenu getMenu() {
        return this.menu;
    }

    /**
     * Getter of scoreMenu
     *
     * @return Score
     */
    public Score getScoreMenu() {
        return this.scoreMenu;
    }

    /**
     * Getter of gridGame
     *
     * @return GridPane gridGame
     */
    public GridPane getGridGame() {
        return this.gridGame;
    }

    /**
     * Getter of pop
     *
     * @return Popup
     */
    public Popup getPop() {
        return this.pop;
    }

    /**
     * Getter of label
     * @return label 
     */
    public Label getPopup() {
        return popup;
    }

}
