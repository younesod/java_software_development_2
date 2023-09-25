/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author School
 */
import java.util.ArrayList;
import java.util.List;

public class TestMethod {

    public static <T> List<T> arrayToList(T[] t) {
        List<T> list = new ArrayList<>();
        for (T element : t) {
            list.add(element);
        }
        return list;
    }

    public static void main(String[] args) {
        Point[] points = {new Point(), new Point(1, 2)};
        List<Point> list = arrayToList(points);
        System.out.println(list);

    }
}
