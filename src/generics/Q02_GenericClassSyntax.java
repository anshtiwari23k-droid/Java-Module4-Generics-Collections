/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Generics Q2 - Syntax for creating a user-defined generic class
 */
package generics;

public class Q02_GenericClassSyntax {

    // Syntax:  class ClassName<T1, T2, ...> { ... }
    // T is a type parameter; it is replaced by a real type when an object is created.
    static class Container<T> {
        private T value;

        Container(T value) { this.value = value; }

        T getValue() { return value; }

        void setValue(T value) { this.value = value; }

        @Override
        public String toString() {
            return "Container[" + value + " : " + value.getClass().getSimpleName() + "]";
        }
    }

    public static void main(String[] args) {
        Container<String> name = new Container<>("Ansh");
        Container<Integer> roll = new Container<>(36);
        Container<Double> cgpa = new Container<>(8.5);

        System.out.println(name);
        System.out.println(roll);
        System.out.println(cgpa);

        roll.setValue(roll.getValue() + 1);   // no cast needed
        System.out.println("After update -> " + roll);
        // roll.setValue("abc");  // compile-time error: String cannot be converted to Integer
    }
}
