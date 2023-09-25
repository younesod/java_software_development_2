package Model;

/**
 * Enumeration of the differents colors used
 * @author 54314
 */
public enum Color {
    G("GREEN"), 
    Y("YELLOW"), 
    R("RED"), 
    B("BLUE"),
    O("ORANGE");

    private final String col;

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
        return this.col;
    }
    
}

