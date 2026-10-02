/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Practical Use Cases Q2 - To-do list application using ArrayList
 */
package practical;

import java.util.ArrayList;
import java.util.Scanner;

public class Q02_TodoList {

    private final ArrayList<String> tasks = new ArrayList<>();

    void addTask(String task) {
        tasks.add(task);
        System.out.println("Added: \"" + task + "\"");
    }

    void removeTask(int number) {
        if (number < 1 || number > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        System.out.println("Removed: \"" + tasks.remove(number - 1) + "\"");
    }

    void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks. Enjoy your day!");
            return;
        }
        System.out.println("Your tasks:");
        for (int i = 0; i < tasks.size(); i++) System.out.println("  " + (i + 1) + ". " + tasks.get(i));
    }

    public static void main(String[] args) {
        Q02_TodoList app = new Q02_TodoList();
        Scanner sc = new Scanner(System.in);
        System.out.println("===== TO-DO LIST =====");
        while (true) {
            System.out.println("\n1. Add task  2. Remove task  3. Display tasks  4. Exit");
            System.out.print("Enter choice: ");
            if (!sc.hasNextLine()) break;
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Enter task: ");
                    app.addTask(sc.nextLine().trim());
                    break;
                case "2":
                    app.displayTasks();
                    System.out.print("Enter task number to remove: ");
                    try { app.removeTask(Integer.parseInt(sc.nextLine().trim())); }
                    catch (NumberFormatException e) { System.out.println("Please enter a number."); }
                    break;
                case "3":
                    app.displayTasks();
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
