/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Set Interface Q8 - Iterate a LinkedHashSet and show its order-preserving property
 */
package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q08_LinkedHashSetOrder {
    public static void main(String[] args) {
        String[] input = {"Banana", "Apple", "Mango", "Cherry", "Apple", "Kiwi"};

        Set<String> linked = new LinkedHashSet<>();
        Set<String> hash = new HashSet<>();
        for (String s : input) { linked.add(s); hash.add(s); }

        System.out.print("Insertion order : ");
        for (String s : input) System.out.print(s + " ");

        System.out.print("\nLinkedHashSet   : ");
        for (String s : linked) System.out.print(s + " ");

        System.out.print("\nHashSet         : ");
        for (String s : hash) System.out.print(s + " ");

        System.out.println("\n\nLinkedHashSet keeps a doubly-linked list through its entries, so iteration");
        System.out.println("follows insertion order (duplicate \"Apple\" did not change its position).");
        System.out.println("HashSet iterates in hash-bucket order, which is not predictable.");
    }
}
