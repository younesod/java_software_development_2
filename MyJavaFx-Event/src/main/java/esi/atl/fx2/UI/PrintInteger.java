package esi.atl.fx2.UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PrintInteger
        extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    private final BorderPane root = new BorderPane();

    private final HBox btnPanel = new HBox(10);
    private final Label lblTitle = new Label("Event Handling");
    private final TextArea txaMsg = new TextArea();
    private final Button btnInsert = new Button("Insert");
    private  TextField tfdText;
    private final Button btnQuit = new Button("Quit");
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Event Handling");
        root.setPadding(new Insets(10));
        //--- Title
        lblTitle.setFont(Font.font("System", FontWeight.BOLD, 20));
        lblTitle.setTextFill(Color.DARKGREEN);
        BorderPane.setAlignment(lblTitle, Pos.CENTER);
        BorderPane.setMargin(lblTitle, new Insets(0, 0, 10, 0));
        root.setTop(lblTitle);
        //--- Text-Area
        txaMsg.setWrapText(true);
        txaMsg.setPrefColumnCount(15);
        txaMsg.setPrefRowCount(10);
        root.setCenter(txaMsg);
        tfdText = createIntTextField("Entrez un entier");
        
        //--- Button Panel
        btnPanel.getChildren().add(btnInsert);
        btnPanel.getChildren().add(tfdText);
        btnPanel.getChildren().add(btnQuit);
        btnPanel.setAlignment(Pos.CENTER_RIGHT);
        btnPanel.setPadding(new Insets(10, 0, 0, 0));

        //--- Button Events Handling
        btnInsert.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                txaMsg.appendText(tfdText.getText());
            }
        });
        
        root.setBottom(btnPanel);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private TextField createIntTextField(String promptText) {
        TextField tfdInteger = new TextField();
        tfdInteger.setPromptText(promptText);
        tfdInteger.setPrefColumnCount(10);
        tfdInteger.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!isValid(event.getCharacter())) {
                    event.consume();
                }
            }

            private boolean isValid(String text) {
                boolean isValid = true;
                try {
                    Integer.parseInt(text);
                } catch (NumberFormatException numberFormatException) {
                    isValid = false;
                    System.out.println("Type a number");
                }
                return isValid;
            }
        });

        return tfdInteger;

    }    
}
