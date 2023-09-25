package esi.atl.fx.hello;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class HelloWorldCheckBox
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();

        CheckBox checkBox1 = new CheckBox();
        checkBox1.setText("First");
        checkBox1.setSelected(true);
        
        CheckBox checkBox2 = new CheckBox("Second");
        checkBox2.setIndeterminate(true);
        
        CheckBox checkBox3 = new CheckBox("Third");

        checkBox3.setAllowIndeterminate(true);
        
        //Alignment
        root.setLeft(checkBox1);

        root.setCenter(checkBox2);
        root.setRight(checkBox3);
       
        
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
