/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Practical Use Cases Q4 - Student grades in a TreeMap: add, remove, query
 */
package practical;

import java.util.Scanner;
import java.util.TreeMap;

public class Q04_StudentGrades {

    private final TreeMap<String, String> grades = new TreeMap<>();

    void addGrade(String name, String grade) {
        String old = grades.put(name, grade.toUpperCase());
        System.out.println(old == null ? "Added " + name + " -> " + grade.toUpperCase()
                                       : "Updated " + name + ": " + old + " -> " + grade.toUpperCase());
    }

    void removeStudent(String name) {
        System.out.println(grades.remove(name) != null ? "Removed " + name : name + " not found.");
    }

    void queryGrade(String name) {
        System.out.println(grades.containsKey(name) ? name + "'s grade: " + grades.get(name) : name + " not found.");
    }

    void showAll() {
        System.out.println("All students (sorted by name): " + grades);
    }

    public static void main(String[] args) {
        Q04_StudentGrades book = new Q04_StudentGrades();
        Scanner sc = new Scanner(System.in);
        System.out.println("===== STUDENT GRADE BOOK =====");
        while (true) {
            System.out.println("\n1. Add/Update grade  2. Remove student  3. Query grade  4. Show all  5. Exit");
            System.out.print("Enter choice: ");
            if (!sc.hasNextLine()) break;
            switch (sc.nextLine().trim()) {
                case "1":
                    System.out.print("Student name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Grade: ");
                    book.addGrade(name, sc.nextLine().trim());
                    break;
                case "2":
                    System.out.print("Student name to remove: ");
                    book.removeStudent(sc.nextLine().trim());
                    break;
                case "3":
                    System.out.print("Student name to query: ");
                    book.queryGrade(sc.nextLine().trim());
                    break;
                case "4":
                    book.showAll();
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
