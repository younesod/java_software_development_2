package esi.atl.fx.hello;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.scene.control.PasswordField;

public class HelloWorldTextField
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();

        Label userName = new Label("User Name");
        
        PasswordField tfdUserName = new PasswordField();
        tfdUserName.setPrefColumnCount(15);
        tfdUserName.setAlignment(Pos.CENTER_LEFT);
        
        //Alignment
        root.setTop(userName);
        BorderPane.setAlignment(userName, Pos.CENTER);
        root.setCenter(tfdUserName);
        
        Scene scene = new Scene(root, 250, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
