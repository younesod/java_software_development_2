/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author School
 */
public class TestBoxWildcards {

    public static void main(String[] args) {
        Box<?> box;
        box = new Box<Integer>(new Integer(42));
        box = new Box<Object>(new Integer(42));

        Object value = box.getElement();
        System.out.println(box);
        System.out.println(value);
        //box.setElement(new Integer(43));
        System.out.println(box);
    }
}
