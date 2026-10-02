/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Map Interface Q4 - TreeMap for sorting keys
 */
package map;

import java.util.Map;
import java.util.TreeMap;

public class Q04_TreeMapSortKeys {
    public static void main(String[] args) {
        TreeMap<String, Integer> population = new TreeMap<>();
        population.put("Mumbai", 21);
        population.put("Delhi", 33);
        population.put("Kolkata", 15);
        population.put("Bengaluru", 14);
        population.put("Chennai", 12);

        System.out.println("City population (millions), keys sorted A-Z:");
        for (Map.Entry<String, Integer> e : population.entrySet())
            System.out.println("  " + e.getKey() + " = " + e.getValue());

        System.out.println("firstKey() = " + population.firstKey() + ", lastKey() = " + population.lastKey());
        System.out.println("headMap(\"D\") = " + population.headMap("D"));
        System.out.println("descendingMap() = " + population.descendingMap());
    }
}
