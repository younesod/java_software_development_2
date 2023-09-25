/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asciipaint.main;

import asciipaint.view.AsciiPaint;

/**
 *
 * @author younes
 */
public class Application {

    private AsciiPaint paint;

    /**
     * Method main
     *
     * @param args
     */
    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

    /**
     * Start the application
     */
    public void start() {
        this.paint = new AsciiPaint(150, 150);
        this.paint.displayHelp();
        boolean trigger = true;
        String[] forme;
        while (trigger) {
            forme = this.paint.askShapeShowOrQuit().split(" ");

                if (forme[0].equals("add")) {
                    switch (forme[1]) {
                        case "rectangle":
                            this.paint.newRectangle(Integer.parseInt(forme[2]),
                                    Integer.parseInt(forme[3]),
                                    Integer.parseInt(forme[4]),
                                    Integer.parseInt(forme[5]),
                                    forme[6].charAt(0));
                            break;

                        case "square":
                            this.paint.newSquare(Integer.parseInt(forme[2]),
                                    Integer.parseInt(forme[3]),
                                    Integer.parseInt(forme[4]),
                                    forme[5].charAt(0));
                            break;
                        case "circle":
                            this.paint.newCircle(Integer.parseInt(forme[2]),
                                    Integer.parseInt(forme[3]),
                                    Integer.parseInt(forme[4]),
                                    forme[5].charAt(0));
                            break;

                        default:
                            System.out.println("Mauvaise commande!");
                            break;
                    }
                } else if (forme[0].equals("show")) {
                    System.out.println(this.paint.asAscii());
                    trigger = false;
                } else if (forme[0].equals("quit")) {
                    trigger = false;
                }



        }

    }

}
