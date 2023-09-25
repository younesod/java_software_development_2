/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev2.atlg3.td1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author zheln
 */
public class PointTest {
    
    public static void main(String[] args) {
        ColoredPoint p = new ColoredPoint(2, 4, 0xFF0000FF);
        System.out.println(p.hashCode());
        p.move(1, 2);
        System.out.println(p);
        System.out.println("x: " + p.getX());
        System.out.println("color : " + String.format("%08X", p.getColor()));
    }
    
}
