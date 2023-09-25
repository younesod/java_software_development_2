/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author School
 */

    public class Box<T> {

        T element;

        public Box(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "[" + element + "]";
        }

        public static void main(String[] args) {
            Box<Integer> box = new Box<Integer>(42);
            Integer value = box.getElement();
            System.out.println(box);
            System.out.println(value);
            box.setElement(43);
            System.out.println(box);
            Box<Object> box1 = new Box<>(new Integer(42));
            System.out.println(box1);

        }
    }
