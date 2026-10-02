/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Concurrency Q2 - Thread-safe Vector vs ArrayList with multiple threads
 */
package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Q02_VectorThreadSafe {

    static final int THREADS = 4;
    static final int ADDS_PER_THREAD = 10_000;

    static int fill(List<Integer> list) throws InterruptedException {
        Thread[] workers = new Thread[THREADS];
        for (int t = 0; t < THREADS; t++) {
            workers[t] = new Thread(() -> {
                for (int i = 0; i < ADDS_PER_THREAD; i++) {
                    try { list.add(i); } catch (ArrayIndexOutOfBoundsException ignored) { }
                }
            });
            workers[t].start();
        }
        for (Thread w : workers) w.join();
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {
        int expected = THREADS * ADDS_PER_THREAD;
        System.out.println(THREADS + " threads each add " + ADDS_PER_THREAD + " elements. Expected size = " + expected);

        int vectorSize = fill(new Vector<>());
        System.out.println("Vector size    = " + vectorSize + (vectorSize == expected ? "  (correct - add() is synchronized)" : ""));

        int arrayListSize = fill(new ArrayList<>());
        System.out.println("ArrayList size = " + arrayListSize
                + (arrayListSize == expected ? "  (got lucky this run - still NOT thread-safe)" : "  (elements lost - NOT thread-safe)"));
    }
}
