/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Generics Q7 - Generic class Box<T> with addItem(T) and getItem()
 */
package generics;

public class Q07_Box {

    static class Box<T> {
        private T item;

        void addItem(T item) { this.item = item; }

        T getItem() { return item; }

        boolean isEmpty() { return item == null; }
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        System.out.println("String box empty? " + stringBox.isEmpty());
        stringBox.addItem("Java Generics");
        String s = stringBox.getItem();          // no cast
        System.out.println("String box item : " + s + " (length " + s.length() + ")");

        Box<Integer> intBox = new Box<>();
        intBox.addItem(36);
        int n = intBox.getItem();                // auto-unboxing, no cast
        System.out.println("Integer box item: " + n + " (squared " + (n * n) + ")");
    }
}
