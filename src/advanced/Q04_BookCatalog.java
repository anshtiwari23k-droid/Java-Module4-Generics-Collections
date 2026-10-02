/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Advanced Q4 - Book catalog using HashMap (title -> author) with search by title
 */
package advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q04_BookCatalog {

    // Key = book title, Value = author name
    private final HashMap<String, String> catalog = new HashMap<>();

    void addBook(String title, String author) {
        catalog.put(title, author);
        System.out.println("Added \"" + title + "\" by " + author);
    }

    void searchByTitle(String title) {
        // 1) Exact lookup - O(1)
        if (catalog.containsKey(title)) {
            System.out.println("Found: \"" + title + "\" by " + catalog.get(title));
            return;
        }
        // 2) Case-insensitive / partial match over the keys
        boolean any = false;
        for (Map.Entry<String, String> e : catalog.entrySet()) {
            if (e.getKey().toLowerCase().contains(title.toLowerCase())) {
                if (!any) System.out.println("Matches for \"" + title + "\":");
                System.out.println("  \"" + e.getKey() + "\" by " + e.getValue());
                any = true;
            }
        }
        if (!any) System.out.println("No book found with title \"" + title + "\".");
    }

    void listAll() {
        System.out.println("Catalog (" + catalog.size() + " books):");
        catalog.forEach((t, a) -> System.out.println("  \"" + t + "\" by " + a));
    }

    public static void main(String[] args) {
        Q04_BookCatalog lib = new Q04_BookCatalog();
        lib.addBook("Effective Java", "Joshua Bloch");
        lib.addBook("Clean Code", "Robert C. Martin");
        lib.addBook("Head First Java", "Kathy Sierra");
        lib.addBook("The Pragmatic Programmer", "Andrew Hunt");
        lib.addBook("Java: The Complete Reference", "Herbert Schildt");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Search by title  2. Add book  3. List all  4. Exit");
            System.out.print("Enter choice: ");
            if (!sc.hasNextLine()) break;
            switch (sc.nextLine().trim()) {
                case "1":
                    System.out.print("Enter title: ");
                    lib.searchByTitle(sc.nextLine().trim());
                    break;
                case "2":
                    System.out.print("Title: ");
                    String t = sc.nextLine().trim();
                    System.out.print("Author: ");
                    lib.addBook(t, sc.nextLine().trim());
                    break;
                case "3":
                    lib.listAll();
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
