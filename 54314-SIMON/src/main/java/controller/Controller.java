/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import model.Color;
import model.Model;
import view.View;

/**
 * The controller send the views requests to the model
 *
 * @author 54314
 */
public class Controller {

    private Model model;
    private View view;

    /**
     * Constructor of Controller
     *
     * @param model
     * @param stage
     */
    public Controller(Model model, Stage stage) {
        this.model = model;
        this.view = new View(this, model);
        view.createView(stage);
        model.subscribe(view);
    }

    /**
     * Illuminate the button on click
     *
     * @param button
     */
    public void illuminateButtonColor(Button button) {
        button.addEventFilter(ActionEvent.ACTION, (ActionEvent e) -> {
            {
                button.setOpacity(0.3);
                var pause = new PauseTransition(Duration.seconds(0.3));
                pause.setOnFinished(event
                        -> {
                    button.setOpacity(1.0);
                });
                pause.play();
            }
        });

    }

    /**
     * Illuminate the button for the sequence of color
     *
     * @param button
     */
    public void illuminateColor(Button button) {
        button.setOpacity(0.3);
        eventButton(button);
        var pause = new PauseTransition(Duration.seconds(0.3));
        pause.setOnFinished(event
                -> {

            button.setOpacity(1.0);
        });
        pause.play();
    }

    /**
     * Put an event for the button if silent the music is not played otherwise
     * it's played
     *
     * @param button
     */
    public void eventButton(Button button) {
        try {
            int noteNumber;
            var synth = MidiSystem.getSynthesizer();
            synth.open();
            var channel = synth.getChannels()[0];
            var pause = new PauseTransition(Duration.seconds(1));
            pause.play();
            var silent = view.getSilent();
            switch (button.getId()) {
                case "green":
                    noteNumber = 69;
                    button.setOnAction(e -> {
                        model.click(Color.GREEN);
                        if (!silent.isSelected()) {
                            channel.noteOn(noteNumber, 80);
                        }
                    });

                    pause.setOnFinished(event -> channel.noteOff(noteNumber));
                    pause.play();
                    break;
                case "red":
                    noteNumber = 71;
                    button.setOnAction(e -> {
                        if (!silent.isSelected()) {
                            channel.noteOn(noteNumber, 80);
                        }
                        model.click(Color.RED);
                    });
                    pause.setOnFinished(event -> channel.noteOff(noteNumber));
                    pause.play();
                    break;
                case "blue":
                    noteNumber = 73;
                    button.setOnAction(e -> {
                        if (!silent.isSelected()) {
                            channel.noteOn(noteNumber, 80);
                        }
                        model.click(Color.BLUE);
                    });
                    pause.setOnFinished(event -> channel.noteOff(noteNumber));
                    pause.play();
                    break;
                case "yellow":
                    noteNumber = 74;
                    button.setOnAction(e -> {
                        if (!silent.isSelected()) {
                            channel.noteOn(noteNumber, 80);
                        }
                        model.click(Color.YELLOW);
                    });
                    pause.setOnFinished(event -> channel.noteOff(noteNumber));
                    pause.play();
                    break;
                default:
                    noteNumber = 0;
                    channel.allNotesOff();
                    break;
            }
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Play the sequence of colors by illuminate and produce sound for each
     * color
     *
     * @param colorList the sequence of color
     */
    public void playSequence(ArrayList<Color> colorList) {
        System.out.println("Début de la séquence de couleur");
        var colorGreen = view.getColorGreen();
        var colorRed = view.getColorRed();
        var colorYellow = view.getColorYellow();
        var colorBlue = view.getColorBlue();
        colorGreen.setDisable(true);
        colorRed.setDisable(true);
        colorYellow.setDisable(true);
        colorBlue.setDisable(true);
        double vitesse = view.getSlider().getValue();
        var timeline = new Timeline(new KeyFrame(
                Duration.seconds(vitesse), new EventHandler<ActionEvent>() {
            private int i = 0;

            @Override
            public void handle(ActionEvent t) {
                if (i < colorList.size()) {
                    Color color = colorList.get(i);
                    switch (color) {
                        case GREEN:
                            illuminateColor(colorGreen);
                            break;
                        case RED:
                            illuminateColor(colorRed);
                            break;
                        case YELLOW:
                            illuminateColor(colorYellow);
                            break;
                        case BLUE:
                            illuminateColor(colorBlue);
                            break;
                    }

                }
                i++;

            }

        }));
        timeline.setCycleCount(colorList.size());
        timeline.play();
        timeline.setOnFinished(e -> {
            model.timer();
            System.out.println("Entrez la séquence");
            colorGreen.setDisable(false);
            colorRed.setDisable(false);
            colorYellow.setDisable(false);
            colorBlue.setDisable(false);

        });
    }

    /**
     * Manages the launch when start is clicked
     */
    public void start() {
        view.getStart().addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                var colorGreen = view.getColorGreen();
                var colorRed = view.getColorRed();
                var colorYellow = view.getColorYellow();
                var colorBlue = view.getColorBlue();
                model.getLast().clear();
                model.getLongest().clear();
                model.start();
                view.getLeft().setMinSize(0, 0);
                view.getLeft().setVisible(false);
                view.getRight().setMinSize(0, 0);
                view.getRight().setVisible(false);
                view.getRoot().setMinSize(0, 0);
                view.getRoot().setVisible(false);
                view.getBorder().setCenter(view.getRoot());
                colorGreen.setMinSize(200, 200);
                colorRed.setMinSize(200, 200);
                colorYellow.setMinSize(200, 200);
                colorBlue.setMinSize(200, 200);
                illuminateButtonColor(colorGreen);
                illuminateButtonColor(colorRed);
                illuminateButtonColor(colorBlue);
                illuminateButtonColor(colorYellow);
                illuminateColor(colorGreen);
                illuminateColor(colorRed);
                illuminateColor(colorBlue);
                illuminateColor(colorYellow);
                eventButton(colorGreen);
                eventButton(colorRed);
                eventButton(colorBlue);
                eventButton(colorYellow);
                playSequence(model.getColorList());
            }
        });
    }

    /**
     * Manages the launch when longest is clicked
     */
    public void longest() {
        view.getLongest().addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                var left = view.getLeft();
                var right = view.getRight();
                var root = view.getRoot();
                var border = view.getBorder();
                var colorGreen = view.getColorGreen();
                var colorRed = view.getColorRed();
                var colorYellow = view.getColorYellow();
                var colorBlue = view.getColorBlue();
                playSequence(model.getLongest());
                left.setMinSize(0, 0);
                left.setVisible(false);
                right.setMinSize(0, 0);
                right.setVisible(false);
                root.setMinSize(0, 0);
                root.setVisible(false);
                border.setCenter(root);
                colorGreen.setMinSize(200, 200);
                colorRed.setMinSize(200, 200);
                colorYellow.setMinSize(200, 200);
                colorBlue.setMinSize(200, 200);
                var pause = new PauseTransition(Duration.seconds(model.getLongest().size() * 2));
                pause.setOnFinished(event
                        -> {
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

                });
                pause.play();
            }

        });
    }

    /**
     * Manages the launch when last is clicked
     */
    public void last() {
        view.getLast().addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                var left = view.getLeft();
                var right = view.getRight();
                var root = view.getRoot();
                var border = view.getBorder();
                var colorGreen = view.getColorGreen();
                var colorRed = view.getColorRed();
                var colorYellow = view.getColorYellow();
                var colorBlue = view.getColorBlue();
                playSequence(model.getLast());
                left.setMinSize(0, 0);
                left.setVisible(false);
                right.setMinSize(0, 0);
                right.setVisible(false);
                root.setMinSize(0, 0);
                root.setVisible(false);
                border.setCenter(root);
                colorGreen.setMinSize(200, 200);
                colorRed.setMinSize(200, 200);
                colorYellow.setMinSize(200, 200);
                colorBlue.setMinSize(200, 200);
                var pause = new PauseTransition(Duration.seconds(model.getLast().size() * 2));
                pause.setOnFinished(event
                        -> {
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

                });
                pause.play();
            }

        });
    }

}
