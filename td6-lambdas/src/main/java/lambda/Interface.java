/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lambda;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.ToIntFunction;

/**
 *
 * @author 54314
 */

public class Interface {

    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(8, 5);

        // IntPredicate
        IntPredicate eq0 = (nb) -> nb == 0;
        IntPredicate max10 = (nb) -> nb <= 10;

        System.out.println("P1 : X = 0 ? : " + eq0.test((int) p1.getX()));
        System.out.println("P2 : X = 0 ? : " + eq0.test((int) p2.getX()));
        System.out.println("P1 : X = 0 AND max10 ? : " + eq0.and(max10).test((int) p1.getX()));
        System.out.println("P2 : X = 0 AND max10 ? : " + eq0.and(max10).test((int) p2.getX()));

        // BiPredicate
        BiPredicate<Double, Double> sameValue = (x, y) -> Objects.equals(x, y);
        System.out.println("P1 = P2 : Y ? : " + sameValue.test(p1.getY(), p2.getY()));
        System.out.println("P1 = P2 : X ? : " + sameValue.test(p1.getX(), p2.getX()));

        // DoubleConsumer
        DoubleConsumer dc = (d) -> System.out.println("Value exp 2 : " + Math.pow(d, 2));
        dc.accept(p1.getX());

        // ToIntFunction
        ToIntFunction<Point> XtoIntFct = (d) -> (int) d.getX();
        System.out.println(XtoIntFct.applyAsInt(p2));

        // IntToDoubleFunction
        DoubleFunction<Point> XtoDoubleFct = (e) -> new Point(e, e);
        Point p3 = XtoDoubleFct.apply(4.8);
        System.out.println(p3);

        // IntToDoubleFunction
        IntToDoubleFunction cos = Math::cos;
        System.out.println(cos.applyAsDouble(9));
    }

}
