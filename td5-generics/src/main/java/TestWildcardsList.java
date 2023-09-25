
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author School
 */
public class TestWildcardsList {

    public static void printList(List<?> list) {
        for (Object n : list) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Point> list1 = new ArrayList<>();
        list1.add(new Point(0,2));
        list1.add(new Point(2,2));
        
        //ArrayList<Object> list = new ArrayList<>();
        list.add(44);
        list.add(42);
        list.add(43);
        printList(list);
        printList(list1);
    }

}
