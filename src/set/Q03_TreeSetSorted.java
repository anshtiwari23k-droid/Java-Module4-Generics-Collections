/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Set Interface Q3 - TreeSet for storing sorted elements
 */
package set;

import java.util.TreeSet;

public class Q03_TreeSetSorted {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<>();
        names.add("Rahul");
        names.add("Ansh");
        names.add("Zoya");
        names.add("Meera");
        names.add("Ansh");            // duplicate - ignored
        System.out.println("TreeSet of names (auto-sorted, no duplicates): " + names);

        TreeSet<Integer> marks = new TreeSet<>(java.util.List.of(78, 45, 92, 66, 88));
        System.out.println("TreeSet of marks: " + marks);
        System.out.println("first() = " + marks.first() + ", last() = " + marks.last());
        System.out.println("headSet(70)  (< 70)  = " + marks.headSet(70));
        System.out.println("tailSet(70)  (>= 70) = " + marks.tailSet(70));
        System.out.println("ceiling(80) = " + marks.ceiling(80) + ", floor(80) = " + marks.floor(80));
        System.out.println("descendingSet() = " + marks.descendingSet());
    }
}
