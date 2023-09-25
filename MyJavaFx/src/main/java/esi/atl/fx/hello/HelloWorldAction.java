package esi.atl.fx.hello;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class HelloWorldAction
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();
        Button btnHello = new Button("Hello World");
        btnHello.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World !");
            }
        });
        root.setCenter(btnHello);
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
