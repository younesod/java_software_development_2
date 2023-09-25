/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lambda;

/**
 *
 * @author 54314
 */

public class Point {

    private double x;
    private double y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point(Point p) {
        this(p.x, p.y);
    }

    public Point() {
        this(0, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
