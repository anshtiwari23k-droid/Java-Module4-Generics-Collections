/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Collections Utility Q5 - Collections.binarySearch()
 */
package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q05_BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(45, 12, 78, 36, 90, 23, 56));
        Collections.sort(list);   // binary search needs a sorted list
        System.out.println("Sorted list: " + list);

        int[] keys = {36, 90, 50};
        for (int key : keys) {
            int idx = Collections.binarySearch(list, key);
            if (idx >= 0)
                System.out.println("binarySearch(" + key + ") -> found at index " + idx);
            else
                System.out.println("binarySearch(" + key + ") -> " + idx + " (not found, would be inserted at index " + (-idx - 1) + ")");
        }

        List<String> names = new ArrayList<>(List.of("Ansh", "Karan", "Neha", "Riya"));
        System.out.println("\nSorted names: " + names);
        System.out.println("binarySearch(\"Neha\") -> index " + Collections.binarySearch(names, "Neha"));
    }
}
