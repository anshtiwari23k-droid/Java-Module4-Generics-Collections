/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Practical Use Cases Q5 - Merge two PriorityQueues and sort the result
 */
package practical;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q05_MergePriorityQueues {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(List.of(40, 10, 70, 25));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(List.of(55, 5, 90, 30, 15));
        System.out.println("PQ1 (heap order): " + pq1);
        System.out.println("PQ2 (heap order): " + pq2);

        PriorityQueue<Integer> merged = new PriorityQueue<>(pq1);
        merged.addAll(pq2);
        System.out.println("Merged PQ (heap order): " + merged);

        // Polling a PriorityQueue always returns the smallest element -> sorted output
        List<Integer> sorted = new ArrayList<>();
        while (!merged.isEmpty()) sorted.add(merged.poll());
        System.out.println("Merged and sorted     : " + sorted);
    }
}
