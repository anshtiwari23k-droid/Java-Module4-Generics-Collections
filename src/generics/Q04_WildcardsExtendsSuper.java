/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Generics Q4 - Difference between ? extends T and ? super T (PECS)
 */
package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q04_WildcardsExtendsSuper {

    // ? extends Number -> PRODUCER: we only READ from the list (upper bounded)
    static double sumOf(List<? extends Number> list) {
        double total = 0;
        for (Number n : list) total += n.doubleValue();
        // list.add(5);  // not allowed: compiler does not know the exact subtype
        return total;
    }

    // ? super Integer -> CONSUMER: we only WRITE Integers into the list (lower bounded)
    static void addNumbers(List<? super Integer> list, int count) {
        for (int i = 1; i <= count; i++) list.add(i);
        // Integer x = list.get(0); // not allowed without cast: we only know it's an Object
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.5, 2.5);
        System.out.println("sumOf(List<Integer>) = " + sumOf(ints));
        System.out.println("sumOf(List<Double>)  = " + sumOf(doubles));

        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        addNumbers(numbers, 3);
        addNumbers(objects, 5);
        System.out.println("List<Number> after addNumbers  = " + numbers);
        System.out.println("List<Object> after addNumbers  = " + objects);
    }
}
