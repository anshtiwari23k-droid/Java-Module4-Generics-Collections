/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Collections Utility Q3 - Making a collection thread-safe with Collections.synchronizedList
 */
package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q03_SynchronizedCollection {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());

        Runnable task = () -> { for (int i = 0; i < 5000; i++) syncList.add(i); };
        Thread t1 = new Thread(task), t2 = new Thread(task), t3 = new Thread(task);
        t1.start(); t2.start(); t3.start();
        t1.join(); t2.join(); t3.join();
        System.out.println("synchronizedList size after 3 threads x 5000 adds = " + syncList.size());

        // Iteration must be manually synchronized on the list
        long sum = 0;
        synchronized (syncList) {
            for (int x : syncList) sum += x;
        }
        System.out.println("Sum computed inside synchronized(syncList) block = " + sum);
    }
}
