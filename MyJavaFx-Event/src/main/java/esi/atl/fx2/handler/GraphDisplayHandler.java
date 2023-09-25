package esi.atl.fx2.handler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GraphDisplayHandler
        implements EventHandler<MouseEvent> {

    private final String text;

    public GraphDisplayHandler(String component) {
        this.text = component;
    }
    
    @Override
    public void handle(MouseEvent event) {
        System.out.println(text);
    }
}
