/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Queue and Stack Q3 - Stack class: push, pop, peek, empty
 */
package queuestack;

import java.util.Stack;

public class Q03_StackClassOps {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Is empty at start? " + stack.empty());

        for (int i = 10; i <= 50; i += 10) {
            stack.push(i);
            System.out.println("push(" + i + ") -> " + stack);
        }
        System.out.println("peek() = " + stack.peek());
        System.out.println("pop()  = " + stack.pop() + " -> " + stack);
        System.out.println("pop()  = " + stack.pop() + " -> " + stack);
        System.out.println("peek() = " + stack.peek());
        System.out.println("Is empty? " + stack.empty() + ", size = " + stack.size());
        while (!stack.empty()) stack.pop();
        System.out.println("After popping all -> " + stack + ", is empty? " + stack.empty());
    }
}
