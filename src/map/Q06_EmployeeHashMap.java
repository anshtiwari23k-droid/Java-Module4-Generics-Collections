/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Map Interface Q6 - HashMap of employee IDs and names: add, check key, iterate
 */
package map;

import java.util.HashMap;
import java.util.Map;

public class Q06_EmployeeHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> employees = new HashMap<>();

        // (a) Add new key-value pairs
        employees.put(101, "Ansh Tiwari");
        employees.put(102, "Riya Sharma");
        employees.put(103, "Karan Mehta");
        employees.put(104, "Neha Gupta");
        employees.putIfAbsent(101, "Duplicate");   // ignored, key exists
        System.out.println("(a) Employees: " + employees);

        // (b) Check if a key exists
        System.out.println("(b) containsKey(102)? " + employees.containsKey(102));
        System.out.println("    containsKey(110)? " + employees.containsKey(110));

        // (c-i) Iterate using keySet()
        System.out.println("(c-i) Using keySet():");
        for (Integer id : employees.keySet())
            System.out.println("    ID " + id + " -> " + employees.get(id));

        // (c-ii) Iterate using entrySet()
        System.out.println("(c-ii) Using entrySet():");
        for (Map.Entry<Integer, String> entry : employees.entrySet())
            System.out.println("    ID " + entry.getKey() + " -> " + entry.getValue());
    }
}
