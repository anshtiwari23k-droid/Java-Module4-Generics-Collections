/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Specialized Classes Q4 - Simple Queue using LinkedList
 */
package specialized;

import java.util.LinkedList;

public class Q04_LinkedListQueue {

    // A small queue wrapper built on top of LinkedList
    static class SimpleQueue<T> {
        private final LinkedList<T> list = new LinkedList<>();

        void enqueue(T item) { list.addLast(item); }

        T dequeue() {
            if (list.isEmpty()) throw new RuntimeException("Queue is empty");
            return list.removeFirst();
        }

        T front() { return list.isEmpty() ? null : list.getFirst(); }
        boolean isEmpty() { return list.isEmpty(); }
        int size() { return list.size(); }
        public String toString() { return "front -> " + list + " <- rear"; }
    }

    public static void main(String[] args) {
        SimpleQueue<Integer> q = new SimpleQueue<>();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("After enqueue 10, 20, 30 : " + q);
        System.out.println("front()   = " + q.front());
        System.out.println("dequeue() = " + q.dequeue() + " -> " + q);
        q.enqueue(40);
        System.out.println("enqueue(40)              : " + q);
        System.out.println("size = " + q.size() + ", isEmpty = " + q.isEmpty());
        while (!q.isEmpty()) System.out.println("dequeue() = " + q.dequeue());
        System.out.println("isEmpty = " + q.isEmpty());
    }
}
