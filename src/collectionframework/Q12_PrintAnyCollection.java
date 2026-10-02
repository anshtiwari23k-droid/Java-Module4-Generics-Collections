/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : java.util & Collection Framework Q12 - Generic method to print any Collection
 */
package collectionframework;

import java.util.*;

public class Q12_PrintAnyCollection {

    // Works for List, Set, Queue, Deque ... anything that implements Collection<T>
    static <T> void printCollection(String label, Collection<T> collection) {
        System.out.print(label + " (" + collection.getClass().getSimpleName()
                + ", size " + collection.size() + "): ");
        for (T element : collection) System.out.print(element + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Java", "Python", "C"));
        Set<Integer> set = new TreeSet<>(Set.of(30, 10, 20));
        Queue<Double> queue = new LinkedList<>(List.of(1.1, 2.2, 3.3));
        Deque<Character> deque = new ArrayDeque<>(List.of('A', 'B', 'C'));

        printCollection("List ", list);
        printCollection("Set  ", set);
        printCollection("Queue", queue);
        printCollection("Deque", deque);
    }
}
