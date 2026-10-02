/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Practical Use Cases Q1 - LruCache<K, V> using LinkedHashMap
 */
package practical;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q01_LruCache {

    static class LruCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        LruCache(int capacity) {
            super(capacity, 0.75f, true);   // accessOrder = true -> most recently used moves to end
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            boolean evict = size() > capacity;
            if (evict) System.out.println("    evicting least recently used -> " + eldest.getKey());
            return evict;
        }
    }

    public static void main(String[] args) {
        LruCache<Integer, String> cache = new LruCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println("Cache (capacity 3): " + cache);

        System.out.println("get(1) = " + cache.get(1) + "  -> 1 becomes most recently used");
        System.out.println("Cache: " + cache);

        System.out.println("put(4, \"Four\"):");
        cache.put(4, "Four");
        System.out.println("Cache: " + cache);

        cache.get(3);
        System.out.println("get(3) then put(5, \"Five\"):");
        cache.put(5, "Five");
        System.out.println("Cache: " + cache);
    }
}
