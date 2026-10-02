/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Specialized Classes Q5 - WeakHashMap vs HashMap
 */
package specialized;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Q05_WeakHashMapVsHashMap {
    public static void main(String[] args) throws InterruptedException {
        Map<Object, String> hashMap = new HashMap<>();
        Map<Object, String> weakMap = new WeakHashMap<>();

        Object k1 = new Object();
        Object k2 = new Object();
        hashMap.put(k1, "value in HashMap");
        weakMap.put(k2, "value in WeakHashMap");
        System.out.println("Before GC -> HashMap size = " + hashMap.size() + ", WeakHashMap size = " + weakMap.size());

        k1 = null;   // remove our strong references to both keys
        k2 = null;
        for (int i = 0; i < 5 && !weakMap.isEmpty(); i++) {
            System.gc();
            Thread.sleep(200);
        }
        System.out.println("After GC  -> HashMap size = " + hashMap.size() + ", WeakHashMap size = " + weakMap.size());
        System.out.println("HashMap holds a strong reference to its key, so the entry survives.");
        System.out.println("WeakHashMap holds keys weakly, so the entry was removed once the key was garbage-collected.");
    }
}
