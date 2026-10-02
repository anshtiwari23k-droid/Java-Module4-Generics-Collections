/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : List Interface Q5 - Stack class extends Vector, so it is also a List
 */
package list;

import java.util.List;
import java.util.Stack;

public class Q05_StackClassDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack: " + stack + " (top = " + stack.peek() + ")");

        // Because Stack extends Vector which implements List, List methods work too
        List<String> asList = stack;
        System.out.println("stack instanceof List   : " + (stack instanceof List));
        System.out.println("List.get(0) (bottom)    : " + asList.get(0));
        System.out.println("search(\"A\") (1 = top) : " + stack.search("A"));
        System.out.println("pop(): " + stack.pop() + " -> " + stack);
    }
}
