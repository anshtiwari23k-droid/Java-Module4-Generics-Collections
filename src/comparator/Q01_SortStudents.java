/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Custom Comparator Q1 - Sort Student objects (name, marks) using Comparator
 */
package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q01_SortStudents {

    static class Student {
        final String name;
        final int marks;
        Student(String name, int marks) { this.name = name; this.marks = marks; }
        public String toString() { return name + "(" + marks + ")"; }
    }

    // Classic Comparator class
    static class MarksDescending implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) { return Integer.compare(b.marks, a.marks); }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ansh", 88));
        students.add(new Student("Riya", 92));
        students.add(new Student("Karan", 75));
        students.add(new Student("Neha", 88));
        students.add(new Student("Arjun", 64));
        System.out.println("Original              : " + students);

        students.sort(new MarksDescending());
        System.out.println("By marks (high->low)  : " + students);

        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("By name (A->Z)        : " + students);

        students.sort(Comparator.comparingInt((Student s) -> s.marks).reversed()
                .thenComparing(s -> s.name));
        System.out.println("By marks desc, then name: " + students);
    }
}
