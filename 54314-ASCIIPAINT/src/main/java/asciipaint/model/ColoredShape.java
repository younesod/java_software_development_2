/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asciipaint.model;

/**
 *
 * @author younes
 */
public abstract class ColoredShape implements Shape {

    private char color;

    /**
     * Constructor of ColoredShape
     *
     * @param color
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    /**
     * Getter of Color
     *
     * @return color
     */
    public char getColor() {
        return this.color;
    }

    /**
     * Setter of color
     *
     * @param color
     */
    public void setColor(char color) {
        this.color = color;
    }

}
