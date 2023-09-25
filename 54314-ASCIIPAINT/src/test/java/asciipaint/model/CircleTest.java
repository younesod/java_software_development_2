/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package asciipaint.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author zheln
 */
public class CircleTest {
    
    @Test
    public void testIsInside() {
        Circle circle = new Circle(new Point(10, 10), 5, 'c');
        Point point = new Point(6, 10);
        boolean expresult = true;
        boolean result = circle.isInside(point);
        assertEquals(expresult, result);
    }

    @Test
    public void testIsNotInside() {
        Circle circle = new Circle(new Point(10, 10), 5, 'c');
        Point point = new Point(50, 50);
        boolean expresult = false;
        boolean result = circle.isInside(point);
        assertEquals(expresult, result);
    }

    @Test
    public void testMove() {
        Circle circle = new Circle(new Point(10.0, 10.0), 5, 'c');
        circle.move(5.0, 5.0);
        Circle circle2 = new Circle(new Point(15.0, 15.0), 5, 'c');
        boolean expresult = circle2.getCenter().equals(circle.getCenter());
        boolean result = true;
        assertEquals(expresult, result);
    }

    @Test
    public void testMoveNegative() {
        Circle circle = new Circle(new Point(10.0, 10.0), 5, 'c');
        circle.move(-1.0, -2.0);
        Circle circle2 = new Circle(new Point(9.0, 8.0), 5, 'c');
        boolean expresult = circle2.getCenter().equals(circle.getCenter());
        boolean result = true;
        assertEquals(expresult, result);
    }
}
