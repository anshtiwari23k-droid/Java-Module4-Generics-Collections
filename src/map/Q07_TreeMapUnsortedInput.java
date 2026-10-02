/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Map Interface Q7 - Sorted order of keys in TreeMap with unsorted input
 */
package map;

import java.util.TreeMap;

public class Q07_TreeMapUnsortedInput {
    public static void main(String[] args) {
        int[] keys = {42, 7, 99, 15, 63, 1, 36};
        String[] values = {"Forty-two", "Seven", "Ninety-nine", "Fifteen", "Sixty-three", "One", "Thirty-six"};

        TreeMap<Integer, String> map = new TreeMap<>();
        System.out.print("Insertion order of keys: ");
        for (int i = 0; i < keys.length; i++) {
            System.out.print(keys[i] + " ");
            map.put(keys[i], values[i]);
        }
        System.out.println("\nTreeMap iteration order :");
        map.forEach((k, v) -> System.out.println("  " + k + " -> " + v));
    }
}
