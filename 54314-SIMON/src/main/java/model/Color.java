
package model;

/**
 * Enumeration of the differents colors used
 * @author 54314
 */
public enum Color {
    GREEN("-fx-background-color: #7CE630;"), 
    YELLOW("-fx-background-color: #FCF928;"), 
    RED("-fx-background-color: #F5332B"), 
    BLUE("-fx-background-color: #2477F5");

    private String col;

    /**
     * Constructor of Color
     * @param col 
     */
    private Color(String col) {
        this.col = col;
    }

    /**
     * Getter of col
     * @return the enumeration color
     */
    public String getCol() {
        return col;
    }
    
}
