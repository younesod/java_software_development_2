/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.ControllerJavaFX;
import Model.FacadeGame;
import Model.Game;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * class Main
 * Start and launch the game
 * @author zheln
 */
public class mainJavaFX  extends Application{
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game();
        FacadeGame facade = new FacadeGame(game);
        ControllerJavaFX controller= new ControllerJavaFX(facade, stage);
        controller.launch();

    }
    
    
}
