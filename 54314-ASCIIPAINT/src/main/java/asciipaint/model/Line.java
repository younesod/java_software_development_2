/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asciipaint.model;

/**
 *
 * @author School
 */
public class Line {

    private final Point A;
    private final Point B;

    public Line(Point A, Point B) {
        this.A = A;
        this.B = B;
        double up = B.getY() - A.getY();
        double down = B.getX() - A.getX();
        double slope = up / down;
        double equation = A.getY() - slope * B.getX();

    }

    public static void main(String[] args) {
        var A = new Point(2.0, -7.0);
        var B = new Point(6.0, 8.0);
        Line line = new Line(A, B);
        line.slopLine();
    }
}
