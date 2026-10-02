/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Generics Q9 - User-defined generic Stack<T> with push, pop, peek
 */
package generics;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Q09_GenericStack {

    static class Stack<T> {
        private final ArrayList<T> elements = new ArrayList<>();

        void push(T item) { elements.add(item); }

        T pop() {
            if (isEmpty()) throw new EmptyStackException();
            return elements.remove(elements.size() - 1);
        }

        T peek() {
            if (isEmpty()) throw new EmptyStackException();
            return elements.get(elements.size() - 1);
        }

        boolean isEmpty() { return elements.isEmpty(); }

        int size() { return elements.size(); }

        @Override
        public String toString() { return elements + " <- top"; }
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("Integer stack : " + intStack);
        System.out.println("peek() = " + intStack.peek());
        System.out.println("pop()  = " + intStack.pop());
        System.out.println("After pop     : " + intStack + ", size = " + intStack.size());

        Stack<String> strStack = new Stack<>();
        strStack.push("Java");
        strStack.push("Python");
        strStack.push("C++");
        System.out.println("\nString stack  : " + strStack);
        System.out.println("pop()  = " + strStack.pop());
        System.out.println("pop()  = " + strStack.pop());
        System.out.println("peek() = " + strStack.peek());
        System.out.println("pop()  = " + strStack.pop());
        System.out.println("isEmpty() = " + strStack.isEmpty());
        try {
            strStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("pop() on empty stack -> EmptyStackException");
        }
    }
}
