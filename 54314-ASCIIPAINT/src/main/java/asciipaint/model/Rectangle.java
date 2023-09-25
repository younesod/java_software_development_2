/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asciipaint.model;

import java.util.Objects;

/**
 *
 * @author younes
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Constructor of Rectangle
     *
     * @param upperLeft
     * @param width
     * @param height
     * @param color
     */
    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Simple getter of UpperLeft
     *
     * @return
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Method that moves a rectangle
     *
     * @param dx
     * @param dy
     */
    @Override
    public void move(double dx, double dy) {
        this.upperLeft.move(dx, dy);
    }

    /**
     * Method that check if a point is inside the rectangle
     *
     * @param p
     * @return true/false
     */
    @Override
    public boolean isInside(Point p) {
        return this.upperLeft.getX() <= p.getX()
                && this.upperLeft.getY() <= p.getY()
                && this.upperLeft.getX() + this.width > p.getX()
                && this.upperLeft.getY() + this.height > p.getY();
    }

    /**
     * Method that defines hashcode
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Method that compares 2 object of type Rectangle
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rectangle other = (Rectangle) obj;
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (!Objects.equals(this.upperLeft, other.upperLeft)) {
            return false;
        }
        return true;
    }

}
