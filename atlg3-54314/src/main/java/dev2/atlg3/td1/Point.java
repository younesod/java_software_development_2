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
public class Point  {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public Point move(double dx, double dy) {
        x += dx;
        y += dy;
        return this;
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
}
