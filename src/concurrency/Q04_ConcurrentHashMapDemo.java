/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Concurrency Q4 - ConcurrentHashMap handling concurrent modifications
 */
package concurrency;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Q04_ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        // 1) Many threads updating counters at the same time
        ConcurrentHashMap<String, Integer> votes = new ConcurrentHashMap<>();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        String[] candidates = {"Alpha", "Beta", "Gamma"};
        for (int t = 0; t < 4; t++) {
            pool.submit(() -> {
                for (int i = 0; i < 3000; i++)
                    votes.merge(candidates[i % 3], 1, Integer::sum);   // atomic update
            });
        }
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Votes counted by 4 threads (expected 4000 each): " + votes);

        // 2) Modifying the map while iterating over it
        Map<Integer, String> chm = new ConcurrentHashMap<>(Map.of(1, "A", 2, "B", 3, "C"));
        for (Integer key : chm.keySet()) {
            if (key == 2) chm.put(4, "D");      // allowed - iterator is weakly consistent
        }
        System.out.println("ConcurrentHashMap modified during iteration: " + chm);

        Map<Integer, String> hm = new HashMap<>(Map.of(1, "A", 2, "B", 3, "C"));
        try {
            for (Integer key : hm.keySet()) {
                if (key == 2) hm.put(4, "D");
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("HashMap modified during iteration -> ConcurrentModificationException");
        }
    }
}
