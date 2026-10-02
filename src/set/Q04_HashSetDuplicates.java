/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Set Interface Q4 & Q5 - How HashSet handles duplicates; role of equals() and hashCode()
 */
package set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Q04_HashSetDuplicates {

    // Without equals/hashCode: two objects with same data are treated as DIFFERENT
    static class StudentNoOverride {
        final int roll; final String name;
        StudentNoOverride(int roll, String name) { this.roll = roll; this.name = name; }
        public String toString() { return roll + ":" + name; }
    }

    // With equals/hashCode: objects with same roll+name are treated as EQUAL
    static class Student {
        final int roll; final String name;
        Student(int roll, String name) { this.roll = roll; this.name = name; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student s = (Student) o;
            return roll == s.roll && name.equals(s.name);
        }

        @Override
        public int hashCode() { return Objects.hash(roll, name); }

        public String toString() { return roll + ":" + name; }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println("add(\"Java\")   -> " + set.add("Java"));
        System.out.println("add(\"Python\") -> " + set.add("Python"));
        System.out.println("add(\"Java\")   -> " + set.add("Java") + "  (duplicate rejected)");
        System.out.println("HashSet<String>: " + set);

        Set<StudentNoOverride> s1 = new HashSet<>();
        s1.add(new StudentNoOverride(36, "Ansh"));
        s1.add(new StudentNoOverride(36, "Ansh"));
        System.out.println("\nWithout equals()/hashCode(): size = " + s1.size() + " " + s1);

        Set<Student> s2 = new HashSet<>();
        s2.add(new Student(36, "Ansh"));
        s2.add(new Student(36, "Ansh"));
        System.out.println("With equals()/hashCode()   : size = " + s2.size() + " " + s2);
    }
}
