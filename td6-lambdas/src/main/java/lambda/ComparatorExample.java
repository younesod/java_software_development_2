/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.scene.text.TextFlow;

/**
 *
 * @author 54314
 */
public class ComparatorExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Welcome");
        list.add("to the ");
        list.add("hellHole");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return word1.length() - word2.length();
            }
        });
        Collections.sort(list, (w1, w2) -> 
            w1.length() - w2.length());
        
        
        System.out.println(list);
    }
}
