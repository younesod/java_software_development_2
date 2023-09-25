/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev2.atlg3.td1;

/**
 *
 * @author zheln
 */
public class ColoredPoint extends Point {
    private int color;  // A 32-bit integer of the form: 0xRRGGBBAA
                        // where AA represents the alpha value

    public ColoredPoint(double x, double y, int color) {
        super(x, y);
        this.color = color;
    }

    public int getColor() { return color; }

    @Override
    public String toString() {
        return super.toString() + " - "+ String.format("%08X", color);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.color;
        return hash;
    }

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
        final ColoredPoint other = (ColoredPoint) obj;
        return true;
    }
    
}
