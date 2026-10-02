/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Custom Comparator Q2 - Sort a Map by its values
 */
package comparator;

import java.util.*;

public class Q02_SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Ansh", 88);
        scores.put("Riya", 92);
        scores.put("Karan", 75);
        scores.put("Neha", 81);
        scores.put("Arjun", 64);
        System.out.println("Original map: " + scores);

        // Put entries into a list and sort the list with a custom Comparator on the value
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(scores.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue().compareTo(b.getValue());   // ascending by value
            }
        });

        // LinkedHashMap keeps the sorted order
        Map<String, Integer> ascending = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> e : entries) ascending.put(e.getKey(), e.getValue());
        System.out.println("Sorted by value (ascending) : " + ascending);

        Map<String, Integer> descending = new LinkedHashMap<>();
        scores.entrySet().stream()
              .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
              .forEachOrdered(e -> descending.put(e.getKey(), e.getValue()));
        System.out.println("Sorted by value (descending): " + descending);
    }
}
