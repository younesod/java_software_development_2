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

   
class A {
    A () {
        System.out.println("constructor of A");
    }
}
class B extends A {
    B () {
        super();
        System.out.println("constructor of B");
    }
}
class C extends B {
    C () {
        super();
        System.out.println("constructor of C");
    }
}

public class ConstructorTest {    
    public static void main(String[] args) {
        new C();
    }

}
