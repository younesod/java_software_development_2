/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asciipaint.model;

/**
 *
 * @author younes
 */
public class Circle extends ColoredShape {

    private Point center;
    private double radius;

    /**
     * Constructor of Circle
     *
     * @param center
     * @param radius
     * @param color
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        if (center.getX() < 0 || center.getY() < 0) {
            throw new IllegalArgumentException("Le centre est négatif erreur");
        }
        this.center = center;
        this.radius = radius;
    }

    /**
     * Method that moves the circle
     *
     * @param dx
     * @param dy
     */
    @Override
    public void move(double dx, double dy) {
        this.center.move(dx, dy);
    }

    /**
     * Check if the point is inside the shape
     *
     * @param p
     * @return
     */
    @Override
    public boolean isInside(Point p) {
        return this.center.distanceTo(p) < this.radius;
    }

    /**
     * Simple getter of center
     * @return 
     */
    public Point getCenter() {
        return this.center;
    }
    
    

}
