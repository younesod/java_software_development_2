/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Color;
import model.Model;
import util.Observer;

/**
 * Manages the view of the game
 * @author 54314
 */
public class View implements Observer {

    private final Controller controller;
    private final Model model;
    private final Slider slider;
    private final CheckBox silent;
    private final Text game_over;

    private final Button colorGreen;
    private final Button colorRed;
    private final Button colorBlue;
    private final Button colorYellow;
    private final Button colorGreenLeft;
    private final Button colorYellowLeft;
    private final Button colorRedRight;
    private final Button colorBlueRight;

    private final Button longest;
    private final Button start;
    private final Button last;
    private final HBox top;
    private final HBox bot;
    private final VBox left;
    private final VBox right;
    private final HBox buttonStart;
    private final BorderPane border;
    private final GridPane root;

    private final Scene scene;

    /**
     * Constructor of View
     * @param controller
     * @param model 
     */
    public View(Controller controller, Model model) {
        this.game_over = new Text("Game_OVER");
        this.buttonStart = new HBox(10);
        this.root = new GridPane();
        this.border = new BorderPane();
        this.scene = new Scene(border, 400, 400);
        this.right = new VBox();
        this.left = new VBox();
        this.bot = new HBox();
        this.top = new HBox();
        this.last = new Button("Last");
        this.start = new Button("Start");
        this.longest = new Button("Longest");
        this.colorBlueRight = new Button();
        this.colorRedRight = new Button();
        this.colorYellowLeft = new Button();
        this.colorGreenLeft = new Button();
        this.colorYellow = new Button();
        this.colorBlue = new Button();
        this.colorRed = new Button();
        this.colorGreen = new Button();
        this.colorGreen.setId("green");
        this.colorBlue.setId("blue");
        this.colorYellow.setId("yellow");
        this.colorRed.setId("red");
        this.slider = new Slider(0.5, 1.5, 1.0);
        this.silent = new CheckBox("Silent Mode");
        this.controller = controller;
        this.model = model;
        model.subscribe(this);
    }

    /**
     * Getter of longest
     * @return the button longest
     */
    public Button getLongest() {
        return longest;
    }

    /**
     * Getter of last
     * @return the button last
     */
    public Button getLast() {
        return last;
    }
    
    /**
     * Getter of slider
     * @return the Slider slider
     */
    public Slider getSlider() {
        return slider;
    }

    /**
     * Getter of silent
     * @return the CheckBox silent
     */
    public CheckBox getSilent() {
        return silent;
    }
    
    /**
     * Getter of colorGreen
     * @return the button colorGreen
     */
    public Button getColorGreen() {
        return colorGreen;
    }

    /**
     * Getter of colorRed
     * @return the button colorRed
     */
    public Button getColorRed() {
        return colorRed;
    }

    /**
     * Getter of colorBlue
     * @return the button colorBlue
     */
    public Button getColorBlue() {
        return colorBlue;
    }

    /**
     * Getter of colorYellow
     * @return the button colorYellow
     */
    public Button getColorYellow() {
        return colorYellow;
    }

    /**
     * Getter of start
     * @return the button start
     */
    public Button getStart() {
        return start;
    }

    /**
     * Getter of left
     * @return the Vbox left
     */
    public VBox getLeft() {
        return left;
    }

    /**
     * Getter of right
     * @return the VBox right
     */
    public VBox getRight() {
        return right;
    }

    /**
     * Getter of border
     * @return the Border border
     */
    public BorderPane getBorder() {
        return border;
    }

    /**
     * Getter of root
     * @return the GridPane root
     */
    public GridPane getRoot() {
        return root;
    }

    /**
     * Create all the buttons necessary for the view
     * @param stage 
     */
    public void createView(Stage stage) {
        Text text = new Text("Simon");
        Text info = new Text("Info");
        Text speed = new Text("Speed");

        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        //Style
        colorGreen.setMinSize(200, 100);
        colorGreen.setStyle(Color.GREEN.getCol());
        colorRed.setMinSize(200, 100);
        colorRed.setStyle(Color.RED.getCol());
        colorBlue.setMinSize(200, 100);
        colorBlue.setStyle(Color.BLUE.getCol());
        colorYellow.setMinSize(200, 100);
        colorYellow.setStyle(Color.YELLOW.getCol());
        colorGreenLeft.setMinSize(100, 100);
        colorGreenLeft.setStyle(Color.GREEN.getCol());
        colorYellowLeft.setMinSize(100, 100);
        colorYellowLeft.setStyle(Color.YELLOW.getCol());
        colorRedRight.setMinSize(100, 100);
        colorRedRight.setStyle(Color.RED.getCol());
        colorBlueRight.setMinSize(100, 100);
        colorBlueRight.setStyle(Color.BLUE.getCol());

        root.setMinSize(200, 200);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        GridPane.setHalignment(text, HPos.CENTER);
        GridPane.setHalignment(info, HPos.CENTER);
        GridPane.setHalignment(silent, HPos.CENTER);
        GridPane.setHalignment(speed, HPos.CENTER);
        GridPane.setHalignment(game_over, HPos.CENTER);
        root.setStyle("-fx-background-color:#fafbf4;-fx-font-family:verdana");
        longest.setStyle("-fx-background-color: #9dcc14; -fx-background-radius:50;-fx-text-fill:white");
        start.setStyle("-fx-background-color: #cc3414; -fx-background-radius:50;-fx-text-fill:white");
        last.setStyle("-fx-background-color: #9dcc14; -fx-background-radius:50;-fx-text-fill:white");
        game_over.setFill(javafx.scene.paint.Color.RED);

        //ajout des élements
        //grid
        root.add(game_over, 1, 0);
        root.add(text, 1, 1);
        root.add(slider, 1, 2);
        root.add(speed, 1, 3);
        root.add(buttonStart, 1, 4);
        root.add(info, 1, 5);
        root.add(silent, 1, 6);

        game_over.setVisible(false);
        //border
        top.getChildren().addAll(colorGreen, colorRed);
        bot.getChildren().addAll(colorYellow, colorBlue);
        left.getChildren().addAll(colorGreenLeft, colorYellowLeft);
        right.getChildren().addAll(colorRedRight, colorBlueRight);
        buttonStart.getChildren().addAll(longest, start, last);

        border.setTop(top);
        border.setBottom(bot);
        border.setLeft(left);
        border.setRight(right);
        border.setCenter(root);

        stage.setTitle("Simon");
        stage.setScene(scene);
        stage.show();
 
    }


    @Override
    public void update(Boolean bool) {
        if (!bool) {
            System.out.println("Game_Over");
            model.getColorList().clear();
            colorGreen.setDisable(true);
            colorRed.setDisable(true);
            colorYellow.setDisable(true);
            colorBlue.setDisable(true);
            colorGreen.setMinSize(200, 100);
            colorRed.setMinSize(200, 100);
            colorYellow.setMinSize(200, 100);
            colorBlue.setMinSize(200, 100);
            left.setMinSize(50, 50);
            right.setMinSize(50, 50);
            root.setMinSize(200, 200);
            left.setVisible(true);
            right.setVisible(true);
            root.setVisible(true);
            game_over.setVisible(true);

        } else {
            model.start();
            controller.playSequence(model.getColorList());

        }
    }

}
