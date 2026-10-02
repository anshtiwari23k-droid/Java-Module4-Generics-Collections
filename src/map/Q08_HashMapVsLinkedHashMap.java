/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Map Interface Q8 - HashMap vs LinkedHashMap iteration order
 */
package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q08_HashMapVsLinkedHashMap {
    public static void main(String[] args) {
        String[] keys = {"Zebra", "Lion", "Elephant", "Tiger", "Monkey", "Deer"};

        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], i + 1);
            linkedHashMap.put(keys[i], i + 1);
        }

        System.out.println("Insertion order : Zebra, Lion, Elephant, Tiger, Monkey, Deer");
        System.out.println("HashMap         : " + hashMap + "   <- order by hash buckets");
        System.out.println("LinkedHashMap   : " + linkedHashMap + "   <- insertion order kept");
    }
}
