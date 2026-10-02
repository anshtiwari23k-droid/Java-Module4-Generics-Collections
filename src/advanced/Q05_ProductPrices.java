/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Advanced Q5 - Products and prices in a TreeMap, displayed sorted by name
 */
package advanced;

import java.util.Map;
import java.util.TreeMap;

public class Q05_ProductPrices {
    public static void main(String[] args) {
        TreeMap<String, Double> products = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        products.put("Laptop", 65999.00);
        products.put("Mouse", 599.00);
        products.put("Keyboard", 1499.00);
        products.put("Monitor", 12999.00);
        products.put("Headphones", 2499.00);
        products.put("charger", 899.00);   // lower case - still sorted correctly

        System.out.println("Products sorted by name:");
        System.out.println("  ---------------------------");
        double total = 0;
        for (Map.Entry<String, Double> e : products.entrySet()) {
            System.out.printf("  %-12s Rs %10.2f%n", e.getKey(), e.getValue());
            total += e.getValue();
        }
        System.out.println("  ---------------------------");
        System.out.printf("  %-12s Rs %10.2f%n", "TOTAL", total);
        System.out.println("Products with names from C up to (not incl.) L: " + products.subMap("C", "L"));
    }
}
