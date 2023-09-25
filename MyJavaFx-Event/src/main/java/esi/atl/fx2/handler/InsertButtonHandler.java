package esi.atl.fx2.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertButtonHandler
        implements EventHandler<ActionEvent> {

    private final TextArea tArea;
    private final TextField tfdText;
    //--- Constructeur ---------------------------------
    public InsertButtonHandler(TextArea tArea, TextField tfdText) {
        this.tArea = tArea;
        this.tfdText = tfdText;
    }
    
    //--- Code exécuté lorsque l'événement survient ----
    @Override
    public void handle(ActionEvent event) {
        tArea.appendText(tfdText.getText());
    }
}
