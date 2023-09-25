/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author School
 */
public class TestBoxSubtyping {

    public static void main(String[] args) {
        Box<Object> box = new Box<>(new Integer(42));
        //Box<Integer> box = new Box<Integer>(new Integer(42));
        Object value = box.getElement();
        System.out.println(box);
        System.out.println(value);
        box.setElement(new Double(43));
        System.out.println(box);

    }
}
