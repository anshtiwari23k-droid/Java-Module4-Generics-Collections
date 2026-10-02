/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Generics Q6 - Generic class Pair<K, V> with getters and setters
 */
package generics;

public class Q06_Pair {

    static class Pair<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() { return key; }
        V getValue() { return value; }
        void setKey(K key) { this.key = key; }
        void setValue(V value) { this.value = value; }

        @Override
        public String toString() { return "(" + key + ", " + value + ")"; }
    }

    public static void main(String[] args) {
        Pair<String, Integer> student = new Pair<>("Ansh Tiwari", 36);
        System.out.println("Student pair : " + student);
        System.out.println("Key = " + student.getKey() + ", Value = " + student.getValue());

        student.setValue(37);
        System.out.println("After setValue(37): " + student);

        Pair<Integer, Double> marks = new Pair<>(101, 92.5);
        marks.setKey(102);
        System.out.println("Marks pair   : " + marks);

        Pair<String, Boolean> flag = new Pair<>("isPassed", true);
        System.out.println("Flag pair    : " + flag);
    }
}
