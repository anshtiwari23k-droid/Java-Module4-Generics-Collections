/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Set Interface Q7 - TreeSet: add, find smallest & largest, remove an element
 */
package set;

import java.util.TreeSet;

public class Q07_TreeSetOperations {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        // (a) Add elements
        set.add(55); set.add(12); set.add(89); set.add(36); set.add(7); set.add(64);
        System.out.println("(a) TreeSet after adding : " + set);

        // (b) Smallest and largest
        System.out.println("(b) Smallest = " + set.first() + ", Largest = " + set.last());

        // (c) Remove a specific element
        boolean removed = set.remove(36);
        System.out.println("(c) remove(36) -> " + removed + ", TreeSet now: " + set);
    }
}
