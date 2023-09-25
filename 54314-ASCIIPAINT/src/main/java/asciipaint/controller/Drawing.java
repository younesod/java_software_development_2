/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asciipaint.controller;

import asciipaint.model.Point;
import asciipaint.model.Shape;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author younes
 */
public class Drawing {

    private List<Shape> shapes;
    private int height;
    private int width;

    /**
     * Constructor Drawing without parameter
     */
    public Drawing() {
    }

    /**
     * Constructor of Drawing
     *
     * @param height
     * @param width
     */
    public Drawing(int height, int width) {
        this.shapes = new LinkedList<>();
        this.height = height;
        this.width = width;
    }

    /**
     * Add a shape on the list of all shapes
     *
     * @param shape
     */
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    /**
     * Get a shape if point is inside otherwise not
     *
     * @param p
     * @return shape or null
     */
    public Shape getShapeAt(Point p) {
        for (Shape shape : shapes) {
            if (shape.isInside(p)) {
                return shape;
            }
        }
        return null;
    }

    /**
     * Simple getter of Height
     *
     * @return height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Simple getter of Width
     *
     * @return width
     */
    public int getWidth() {
        return this.width;
    }

}
