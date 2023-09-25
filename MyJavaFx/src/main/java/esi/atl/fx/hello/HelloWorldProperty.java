package esi.atl.fx.hello;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class HelloWorldProperty
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();
        Label helloText = new Label("Hello World");
        helloText.setTextFill(Color.RED);
        helloText.setFont(Font.font("Verdana", 20));
        
        System.out.println("Le message du libellé est " + helloText.getText());
        System.out.println("La police du libellé est " + helloText.getFont());
        System.out.println("La couleur du libellé est " + helloText.getTextFill());
        
        root.setCenter(helloText);
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
