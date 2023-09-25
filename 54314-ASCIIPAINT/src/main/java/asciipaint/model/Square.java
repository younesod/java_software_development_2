/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asciipaint.model;

/**
 *
 * @author younes
 */
public class Square extends Rectangle {

    /**
     * Constructor of Square
     *
     * @param upperLeft
     * @param side
     * @param color
     */
    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

}
