/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : List Interface Q6 - Add, remove by value & index, replace, print after each step
 */
package list;

import java.util.ArrayList;
import java.util.List;

public class Q06_ListOperations {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        // (a) Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Mango");
        fruits.add("Orange");
        System.out.println("(a) After adding           : " + fruits);

        // (b) Remove by value and by index
        fruits.remove("Banana");
        System.out.println("(b) After remove(\"Banana\") : " + fruits);
        fruits.remove(0);
        System.out.println("    After remove(index 0)  : " + fruits);

        // (c) Replace element at a specific index
        fruits.set(1, "Grapes");
        System.out.println("(c) After set(1, \"Grapes\") : " + fruits);

        // (d) printing is done after every operation above
        System.out.println("(d) Final list             : " + fruits + " (size " + fruits.size() + ")");
    }
}
