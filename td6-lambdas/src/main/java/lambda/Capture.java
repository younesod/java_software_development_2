/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lambda;

/**
 *
 * @author 54314
 */
public class Capture {
    public static void manyPrint(String str, int nb) {
        Runnable r = () -> {
            for (int i = 0; i < nb; i++) {
                System.out.println(str);
                Thread.yield();
            }
        };
        new Thread(r).start();
    }
    public static void main(String[] args) {
        manyPrint("Expression", 10);
        manyPrint("Lambda", 20);
    }
}

