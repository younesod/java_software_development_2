package View.ViewJFX;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * class ButtonMenu
 the part menu of the view
 * @author 54314
 */
public class ButtonMenu {
    
    private final GridPane gridMenu;
    private final GridPane gridButtonMenu;
    
    private final Button start;
    private final Button leave;
    private final Button undo;
    private final Button redo;
    
    private final Label forColor;
    private final Label forLevel;
    
    private final ComboBox<Integer> color;
    private final ComboBox<String> level;

    /**
     * Constructor of ButtonMenu
     */
    public ButtonMenu() {
        this.gridMenu = new GridPane();
        this.gridButtonMenu = new GridPane();
        this.start = new Button("start");
        this.leave = new Button("leave");
        this.undo = new Button("undo");
        this.redo = new Button("redo");
        this.forColor = new Label("Number of colors ");
        this.forLevel = new Label("Level section ");
        this.color = new ComboBox<>();
        this.level = new ComboBox<>();
    }
    
    /**
     * This methods create the menu
     */
    public void createMenu(){
        this.color.getItems().setAll(3, 4, 5);
        this.color.getSelectionModel().selectFirst();
        this.level.getItems().setAll("normal", "advanced", "hardcore");
        this.level.getSelectionModel().selectFirst();
        
        this.gridMenu.setMinSize(100, 100);

        this.start.setStyle("-fx-background-color :#6F6FB6;-fx-text-fill:white;-fx-pref-height: 20px; -fx-pref-width:50px ;-fx-font-family:Impact");
        this.leave.setStyle("-fx-background-color :#e2e2f0;-fx-text-fill: #6F6FB6;-fx-pref-height: 20px; -fx-pref-width:50px ;-fx-font-family: Impact;");
        this.undo.setStyle("-fx-background-color :#6F6FB6;-fx-text-fill: white;-fx-pref-height: 20px; -fx-pref-width:50px; -fx-font-family: Impact; ");
        this.redo.setStyle("-fx-background-color :#e2e2f0;-fx-text-fill: #6F6FB6;-fx-pref-height: 20px; -fx-pref-width:50px ; -fx-font-family: Impact;");
        
        this.color.setStyle("-fx-background-color :#e2e2f0;-fx-font-family: Impact;");
        this.level.setStyle("-fx-background-color :#e2e2f0;-fx-font-family: Impact;");
        this.forColor.setStyle("-fx-text-fill: white;-fx-font-family: Impact;");
        this.forLevel.setStyle("-fx-text-fill: white;-fx-font-family: Impact;");
        
        
        this.leave.setDisable(true);
        this.undo.setDisable(true);
        this.redo.setDisable(true);
        
        this.gridButtonMenu.add(this.start, 1, 0);
        this.gridButtonMenu.add(this.leave, 2, 0);
        this.gridButtonMenu.add(this.undo, 3, 0);
        this.gridButtonMenu.add(this.redo, 4, 0);
        this.gridButtonMenu.setHgap(5);
        GridPane.setHalignment(this.gridButtonMenu, HPos.CENTER);
        
        this.gridMenu.setHgap(2);
        this.gridMenu.add(gridButtonMenu, 1, 0);
        this.gridMenu.add(forColor, 1, 1);
        this.gridMenu.add(color, 2, 1);
        this.gridMenu.add(forLevel, 1, 3);
        this.gridMenu.add(level, 2, 3);
    }

    /**
     * Getter of gridMenu
     * @return gridMenu
     */
    public GridPane getGridMenu() {
        return this.gridMenu;
    }

    /**
     * Getter of gridButtonMenu
     * @return gridButtonMenu
     */
    public GridPane getGridButtonMenu() {
        return this.gridButtonMenu;
    }

    /**
     * Getter of button start
     * @return button
     */
    public Button getStart() {
        return this.start;
    }

    /**
     * Getter of button leave
     * @return button
     */
    public Button getLeave() {
        return this.leave;
    }

    /**
     * Getter of button undo
     * @return button
     */
    public Button getUndo() {
        return this.undo;
    }

    /**
     * Getter of button redo
     * @return button
     */
    public Button getRedo() {
        return this.redo;
    }

    /**
     * Getter of comboBox getColor
     * @return comboBox
     */
    public ComboBox<Integer> getColor() {
        return this.color;
    }

    /**
     * Getter of comboBox getLevel
     * @return comboBox
     */
    public ComboBox<String> getLevel() {
        return this.level;
    }
    
    
    
    
}

