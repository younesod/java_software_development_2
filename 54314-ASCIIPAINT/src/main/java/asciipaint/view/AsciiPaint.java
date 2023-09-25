/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asciipaint.view;

import asciipaint.controller.Drawing;
import asciipaint.model.Circle;
import asciipaint.model.Point;
import asciipaint.model.Rectangle;
import asciipaint.model.Shape;
import asciipaint.model.Square;
import java.util.Scanner;

/**
 *
 * @author younes
 */
public class AsciiPaint {

    private Drawing drawing;

    /**
     * Constructor of AsciiPaint without parameter
     */
    public AsciiPaint() {
    }

    /**
     * Constructor of AsciiPaint
     *
     * @param width
     * @param height
     */
    public AsciiPaint(int width, int height) {
        this.drawing = new Drawing(width, height);
    }

    /**
     * Method that creates a new Circle
     *
     * @param x
     * @param y
     * @param radius
     * @param color
     */
    public void newCircle(int x, int y, double radius, char color) {
        this.drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    /**
     * Method that creates a new Rectangle
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        this.drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
    }

    /**
     * Method that creates a new Square
     *
     * @param x
     * @param y
     * @param side
     * @param color
     */
    public void newSquare(int x, int y, double side, char color) {
        this.drawing.addShape(new Square(new Point(x, y), side, color));
    }

    /**
     * Method that creates the view of a shape
     *
     * @return
     */
    public String asAscii() {
        String dessin = "";
        for (int i = 0; i < this.drawing.getWidth(); i++) {
            for (int j = 0; j < this.drawing.getHeight(); j++) {
                if (this.drawing.getShapeAt(new Point(i, j)) instanceof Shape) {
                    dessin += this.drawing.getShapeAt(new Point(i, j)).getColor() + " ";
                } else {
                    dessin += " ";
                }
            }
            dessin += "\n";
        }
        return dessin;
    }

    /**
     * Ask a request to add a shape/show or quit
     *
     * @return
     */
    public String askShapeShowOrQuit() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une forme , show ou quit : ");
        String reponse = clavier.nextLine().toLowerCase();
        return reponse;
    }

    /**
     * Method wich display help
     */
    public void displayHelp() {
        System.out.println("Ajoutez une forme parmi les suivantes : ");
        System.out.println("Cercle : add circle 5 3 1 c");
        System.out.println("Rectangle : add rectangle 10 10 5 20 r");
        System.out.println("Carée : add square 7 3 6 b");
        System.out.println("Pour visualiser les formes -> show");
        System.out.println("Pour quitter -> quit");
    }

}
