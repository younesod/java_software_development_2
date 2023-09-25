/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lambda;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 54314
 */
public class EventHandlerExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Event Handler Example");
        Button btn = new Button("Say 'Hello World'");
        Label textf = new Label("");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textf.setText("Hello world!");
            }
        });
        btn.setOnAction(event -> {
            textf.setText("Hi");
        });
        VBox root = new VBox(btn, textf);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    public static void main(String[] args) {        
        launch(args);        
    }
}
