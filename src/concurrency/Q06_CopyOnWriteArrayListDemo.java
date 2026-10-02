/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Concurrency Q6 - CopyOnWriteArrayList: iterate and modify safely across threads
 */
package concurrency;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Q06_CopyOnWriteArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new CopyOnWriteArrayList<>(List.of("Task-1", "Task-2", "Task-3"));

        // Reader thread iterates while a writer thread adds elements
        Thread reader = new Thread(() -> {
            for (String s : list) {               // iterates over a snapshot
                System.out.println("  [Reader] read " + s);
                sleep(50);
            }
        });
        Thread writer = new Thread(() -> {
            for (int i = 4; i <= 6; i++) {
                list.add("Task-" + i);
                System.out.println("  [Writer] added Task-" + i);
                sleep(40);
            }
        });
        reader.start();
        writer.start();
        reader.join();
        writer.join();
        System.out.println("Final CopyOnWriteArrayList: " + list);

        // Same thread: modify while iterating
        for (String s : list) if (s.equals("Task-2")) list.remove(s);
        System.out.println("After removing Task-2 during iteration: " + list);

        List<String> normal = new ArrayList<>(List.of("Task-1", "Task-2", "Task-3"));
        try {
            for (String s : normal) if (s.equals("Task-2")) normal.add("X");
        } catch (ConcurrentModificationException e) {
            System.out.println("ArrayList modified during iteration -> ConcurrentModificationException");
        }
    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
