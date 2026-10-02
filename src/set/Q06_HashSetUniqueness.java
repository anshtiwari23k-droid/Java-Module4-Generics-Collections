/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Set Interface Q6 - Uniqueness property of HashSet
 */
package set;

import java.util.HashSet;

public class Q06_HashSetUniqueness {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        int[] input = {10, 20, 10, 30, 20, 40, 10, 50};

        for (int x : input) {
            boolean added = set.add(x);
            System.out.printf("add(%d) -> %-5s set = %s%n", x, added, set);
        }
        System.out.println("\nInput had " + input.length + " values, HashSet kept " + set.size() + " unique values.");
    }
}
