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
public class SquareTest {
    
    @Test
    public void testIsInside() {
        Square square = new Square(new Point(10, 10), 5, 'c');
        Point point = new Point(11, 11);
        boolean expresult = true;
        boolean result = square.isInside(point);
        assertEquals(expresult, result);
    }

    @Test
    public void testIsNotInside() {
        Square square = new Square(new Point(10, 10), 5, 'c');
        Point point = new Point(0, 0);
        boolean expresult = false;
        boolean result = square.isInside(point);
        assertEquals(expresult, result);
    }

    @Test
    public void testMove() {
        Square square = new Square(new Point(10.0, 10.0), 5, 'c');
        square.move(5, 5);
        Square square2 = new Square(new Point(15.0, 15.0), 5, 'c');
        boolean expresult = square.equals(square2);
        boolean result = true;
        assertEquals(expresult, result);
    }

    @Test
    public void testMoveNegative() {
        Square square = new Square(new Point(10.0, 10.0), 5, 'c');
        square.move(-10.0,-9.5);
        Square square2 = new Square(new Point(0.0, 0.5), 5, 'c');
        boolean expresult = square.equals(square2);
        boolean result = true;
        assertEquals(expresult, result);
    }
    
}
