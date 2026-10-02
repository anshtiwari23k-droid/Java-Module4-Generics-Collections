/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : java.util & Collection Framework Q11 - Iterate a List of integers 3 ways
 */
package collectionframework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q11_IterateList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(5, 10, 15, 20, 25));

        // (a) simple for loop - index based
        System.out.print("(a) Simple for loop      : ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }

        // (b) enhanced for loop (for-each) - uses Iterable internally
        System.out.print("\n(b) Enhanced for loop    : ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }

        // (c) while loop with Iterator - allows safe removal while iterating
        System.out.print("\n(c) While loop + Iterator: ");
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
