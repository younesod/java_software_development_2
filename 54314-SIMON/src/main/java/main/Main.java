 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;

/**
 * Class Main 
 * Start and launch the game
 * @author 54314
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        var model = new Model();
        var controller= new Controller(model,stage);
        controller.start();
        controller.last();
        controller.longest();
        
    }
    
}
