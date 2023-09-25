
import java.util.ArrayList;
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author School
 */

public class List {
    //Q10
    public static <T> void sort(ArrayList<T> list, Comparator<? super T> comparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(i)) > 0) {
                    Object tmp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, (T) tmp);
                }
            }
        }
    }

    
}
