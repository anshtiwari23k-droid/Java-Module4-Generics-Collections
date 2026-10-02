/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : List Interface Q7 - Performance: ArrayList vs LinkedList
 */
package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q07_ArrayListVsLinkedList {

    static final int N = 50_000;

    static long addAtBeginning(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) list.add(0, i);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long removeFromMiddle(List<Integer> list, int count) {
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) list.remove(list.size() / 2);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long iterate(List<Integer> list) {
        long start = System.nanoTime();
        long sum = 0;
        for (int x : list) sum += x;
        if (sum == -1) System.out.println(sum); // keeps JIT from removing the loop
        return (System.nanoTime() - start) / 1_000_000;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Operation (N = " + N + ")          ArrayList   LinkedList");
        System.out.printf("(a) Add at beginning           %6d ms   %6d ms%n",
                addAtBeginning(arrayList), addAtBeginning(linkedList));
        System.out.printf("(b) Remove 10000 from middle   %6d ms   %6d ms%n",
                removeFromMiddle(arrayList, 10_000), removeFromMiddle(linkedList, 10_000));
        System.out.printf("(c) Iterate (for-each)         %6d ms   %6d ms%n",
                iterate(arrayList), iterate(linkedList));

        System.out.println("\nObservations:");
        System.out.println("- Adding at the beginning: LinkedList is faster (O(1) link change vs O(n) shifting).");
        System.out.println("- Removing from the middle: both must reach the middle; ArrayList's System.arraycopy");
        System.out.println("  shift is usually faster than LinkedList's O(n) node traversal.");
        System.out.println("- Iteration: both are O(n); ArrayList is usually a bit faster (contiguous memory, cache friendly).");
        System.out.println("(Exact timings vary from machine to machine and run to run.)");
    }
}
