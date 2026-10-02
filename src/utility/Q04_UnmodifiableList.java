/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Collections Utility Q4 - Collections.unmodifiableList() and modification attempt
 */
package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q04_UnmodifiableList {
    public static void main(String[] args) {
        List<String> original = new ArrayList<>(List.of("Mon", "Tue", "Wed"));
        List<String> readOnly = Collections.unmodifiableList(original);
        System.out.println("Unmodifiable list: " + readOnly);
        System.out.println("Reading works -> get(1) = " + readOnly.get(1));

        try {
            readOnly.add("Thu");
        } catch (UnsupportedOperationException e) {
            System.out.println("readOnly.add(\"Thu\")    -> UnsupportedOperationException");
        }
        try {
            readOnly.set(0, "Sun");
        } catch (UnsupportedOperationException e) {
            System.out.println("readOnly.set(0, \"Sun\") -> UnsupportedOperationException");
        }
        try {
            readOnly.remove(0);
        } catch (UnsupportedOperationException e) {
            System.out.println("readOnly.remove(0)     -> UnsupportedOperationException");
        }

        // It is only a read-only VIEW: changes to the original list are still visible
        original.add("Thu");
        System.out.println("After original.add(\"Thu\"), view shows: " + readOnly);
    }
}
