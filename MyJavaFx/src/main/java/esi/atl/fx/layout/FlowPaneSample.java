package esi.atl.fx.layout;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class FlowPaneSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER_LEFT);
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(5);
        
        List <Label> node = new ArrayList<>() ;
        for (int i = 0; i < 10; i++) {
            node.add(new Label("Label Num "+i));
        }
        
        root.getChildren().addAll(node);
        
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();        
    }

}
