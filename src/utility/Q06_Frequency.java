/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Collections Utility Q6 - Frequency of elements using Collections.frequency()
 */
package utility;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Q06_Frequency {
    public static void main(String[] args) {
        List<String> languages = List.of("Java", "Python", "C", "Java", "Python", "Java", "Go", "C");
        System.out.println("List: " + languages);

        for (String lang : new LinkedHashSet<>(languages))   // each distinct element once
            System.out.println("  " + lang + " occurs " + Collections.frequency(languages, lang) + " time(s)");

        List<Integer> nums = List.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        System.out.println("\nList: " + nums);
        System.out.println("  frequency of 4 = " + Collections.frequency(nums, 4));
        System.out.println("  frequency of 9 = " + Collections.frequency(nums, 9));
    }
}
