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
public class RectangleTest {
    
    @Test
    public void testIsInside() {
        Rectangle circle = new Rectangle(new Point(10, 10), 5, 10, 'c');
        Point point = new Point(11, 11);
        boolean expresult = true;
        boolean result = circle.isInside(point);
        assertEquals(expresult, result);
    }

    @Test
    public void testIsNotInside() {
        Rectangle circle = new Rectangle(new Point(10, 10), 5, 10, 'c');
        Point point = new Point(0, 0);
        boolean expresult = false;
        boolean result = circle.isInside(point);
        assertEquals(expresult, result);
    }

    public void testMove() {
        Rectangle rectangle = new Rectangle(new Point(10.0, 10.0), 5, 10, 'c');
        rectangle.move(5, 5);
        Rectangle rectangle2 = new Rectangle(new Point(15.0, 15.0), 5, 10, 'c');
        boolean expresult = rectangle.equals(rectangle2);
        boolean result = true;
        assertEquals(expresult, result);
    }

    public void testMoveNegatif() {
        Rectangle rectangle = new Rectangle(new Point(10.0, 10.0), 5, 10, 'c');
        rectangle.move(-4.0, -2.0);
        Rectangle rectangle2 = new Rectangle(new Point(6.0, 8.0), 5, 10, 'c');
        boolean expresult = rectangle.equals(rectangle2);
        boolean result = true;
        assertEquals(expresult, result);
    }
    
}
