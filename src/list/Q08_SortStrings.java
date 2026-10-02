/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : List Interface Q8 - Sort an ArrayList of strings alphabetically and reverse
 */
package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q08_SortStrings {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>(List.of("Noida", "Delhi", "Mumbai", "Agra", "Kolkata", "Bengaluru"));
        System.out.println("Original            : " + cities);

        Collections.sort(cities);
        System.out.println("Alphabetical (A-Z)  : " + cities);

        cities.sort(Comparator.reverseOrder());
        System.out.println("Reverse (Z-A)       : " + cities);
    }
}
