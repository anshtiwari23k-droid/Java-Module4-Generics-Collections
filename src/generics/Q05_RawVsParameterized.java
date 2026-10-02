/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Generics Q5 - Raw types vs parameterized types
 */
package generics;

import java.util.ArrayList;
import java.util.List;

public class Q05_RawVsParameterized {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {
        // Raw type: no type information, compiler cannot check anything
        List rawList = new ArrayList();
        rawList.add("Hello");
        rawList.add(100);              // allowed - mixes types silently
        try {
            for (Object o : rawList) {
                String s = (String) o; // cast needed; fails at RUNTIME for 100
                System.out.println("Raw element: " + s);
            }
        } catch (ClassCastException e) {
            System.out.println("Runtime error with raw type -> " + e.getClass().getSimpleName());
        }

        // Parameterized type: compiler checks types, no casts
        List<String> safeList = new ArrayList<>();
        safeList.add("Hello");
        // safeList.add(100);          // compile-time error
        for (String s : safeList) System.out.println("Parameterized element: " + s);
    }
}
