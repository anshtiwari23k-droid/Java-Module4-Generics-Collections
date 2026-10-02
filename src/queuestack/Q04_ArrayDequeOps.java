/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Queue and Stack Q4 - ArrayDeque: add, remove and peek at both ends
 */
package queuestack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q04_ArrayDequeOps {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // (a) Add elements at both ends
        deque.addLast("B");
        deque.addLast("C");
        deque.addFirst("A");
        deque.offerLast("D");
        deque.offerFirst("Start");
        System.out.println("(a) After adding at both ends : " + deque);

        // (c) Peek at both ends
        System.out.println("(c) peekFirst() = " + deque.peekFirst() + ", peekLast() = " + deque.peekLast());

        // (b) Remove elements from both ends
        System.out.println("(b) removeFirst() = " + deque.removeFirst() + " -> " + deque);
        System.out.println("    removeLast()  = " + deque.removeLast() + " -> " + deque);
        System.out.println("    pollFirst()   = " + deque.pollFirst() + " -> " + deque);
        System.out.println("    pollLast()    = " + deque.pollLast() + " -> " + deque);

        System.out.println("(c) peekFirst() = " + deque.peekFirst() + ", peekLast() = " + deque.peekLast());
    }
}
