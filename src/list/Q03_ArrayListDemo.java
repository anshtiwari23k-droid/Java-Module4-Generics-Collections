/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : List Interface Q3 - ArrayList for storing and iterating over elements
 */
package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Q03_ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Java");
        subjects.add("DBMS");
        subjects.add("Operating Systems");
        subjects.add("Machine Learning");
        subjects.add(1, "Data Structures");      // insert at index

        System.out.println("ArrayList: " + subjects);
        System.out.println("Size: " + subjects.size() + ", element at index 2: " + subjects.get(2));
        System.out.println("Contains \"DBMS\"? " + subjects.contains("DBMS"));

        System.out.println("\nIterating with for-each:");
        for (String s : subjects) System.out.println("  - " + s);

        System.out.println("Iterating with Iterator:");
        Iterator<String> it = subjects.iterator();
        while (it.hasNext()) System.out.println("  * " + it.next());

        System.out.println("Iterating backwards with ListIterator:");
        ListIterator<String> lit = subjects.listIterator(subjects.size());
        while (lit.hasPrevious()) System.out.println("  " + lit.previousIndex() + " -> " + lit.previous());

        System.out.println("Iterating with forEach + lambda:");
        subjects.forEach(s -> System.out.println("  > " + s.toUpperCase()));
    }
}
