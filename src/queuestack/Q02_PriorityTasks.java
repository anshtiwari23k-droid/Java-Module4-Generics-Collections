/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Queue and Stack Q2 - PriorityQueue of tasks with priorities
 */
package queuestack;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q02_PriorityTasks {

    static class Task {
        final String name;
        final int priority;   // 1 = highest priority
        Task(String name, int priority) { this.name = name; this.priority = priority; }
        public String toString() { return name + "(P" + priority + ")"; }
    }

    public static void main(String[] args) {
        PriorityQueue<Task> tasks = new PriorityQueue<>(Comparator.comparingInt((Task t) -> t.priority));

        tasks.add(new Task("Submit Java assignment", 1));
        tasks.add(new Task("Watch lecture", 3));
        tasks.add(new Task("Prepare for quiz", 2));
        tasks.add(new Task("Clean desk", 5));
        tasks.add(new Task("Update GitHub", 4));
        System.out.println("PriorityQueue (internal heap order): " + tasks);

        Task top = tasks.poll();
        System.out.println("Removed highest-priority task: " + top);
        System.out.println("Queue after removal: " + tasks);

        System.out.println("\nRemaining tasks in priority order:");
        while (!tasks.isEmpty()) System.out.println("  " + tasks.poll());
    }
}
