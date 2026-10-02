/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Advanced Q1 - Generic MultiMap<K, V> using HashMap<K, List<V>>
 */
package advanced;

import java.util.*;

public class Q01_MultiMap {

    static class MultiMap<K, V> {
        private final Map<K, List<V>> map = new HashMap<>();

        void put(K key, V value) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }

        List<V> get(K key) {
            return map.getOrDefault(key, Collections.emptyList());
        }

        boolean remove(K key, V value) {
            List<V> values = map.get(key);
            if (values == null) return false;
            boolean removed = values.remove(value);
            if (values.isEmpty()) map.remove(key);
            return removed;
        }

        List<V> removeAll(K key) { return map.remove(key); }

        boolean containsKey(K key) { return map.containsKey(key); }

        int size() {               // total number of values
            int total = 0;
            for (List<V> v : map.values()) total += v.size();
            return total;
        }

        Set<K> keySet() { return map.keySet(); }

        @Override
        public String toString() { return map.toString(); }
    }

    public static void main(String[] args) {
        MultiMap<String, String> courses = new MultiMap<>();
        courses.put("Ansh", "Java");
        courses.put("Ansh", "Machine Learning");
        courses.put("Ansh", "DBMS");
        courses.put("Riya", "Python");
        courses.put("Riya", "Data Science");
        System.out.println("MultiMap: " + courses);
        System.out.println("get(\"Ansh\") = " + courses.get("Ansh"));
        System.out.println("get(\"Karan\") = " + courses.get("Karan"));
        System.out.println("Total values = " + courses.size());

        courses.remove("Ansh", "DBMS");
        System.out.println("After remove(\"Ansh\", \"DBMS\"): " + courses);
        courses.removeAll("Riya");
        System.out.println("After removeAll(\"Riya\")     : " + courses);

        MultiMap<Integer, Integer> multiples = new MultiMap<>();
        for (int i = 1; i <= 10; i++) multiples.put(i % 3, i);
        System.out.println("Numbers 1-10 grouped by (n % 3): " + multiples);
    }
}
