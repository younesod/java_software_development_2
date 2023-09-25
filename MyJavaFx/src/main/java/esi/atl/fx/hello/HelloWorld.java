package esi.atl.fx.hello;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloWorld
        extends Application {

    public static void main(String[] args) {
        launch(args);

    }
    @Override
    public void init(){
        System.out.println("Initialisation de l'écran");
    }
    
    
    @Override
    public void stop(){
        System.out.println("Fin de l'écran");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();
        
        Label helloText = new Label("Hello World");
        helloText.setTextFill(Color.RED);
        helloText.setFont(Font.font("Verdana",20));
        System.out.println("Le message du Libellé est " + helloText.getText());
        System.out.println("Le police du Libellé est " + helloText.getFont());
        System.out.println("Le couleur du Libellé est " + helloText.getTextFill());
        helloText.setUnderline(true);
        root.setCenter(helloText);
        
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        
    }
    
    
}

