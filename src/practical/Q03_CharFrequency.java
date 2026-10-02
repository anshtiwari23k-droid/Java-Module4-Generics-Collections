/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Practical Use Cases Q3 - Character frequency in a string using HashMap
 */
package practical;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Q03_CharFrequency {

    static Map<Character, Integer> countChars(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (c == ' ') continue;                       // skip spaces
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }

    public static void main(String[] args) {
        String text = "programming in java";
        Map<Character, Integer> freq = countChars(text);
        System.out.println("String: \"" + text + "\"");
        System.out.println("HashMap: " + freq);
        System.out.println("Sorted by character (TreeMap): " + new TreeMap<>(freq));
    }
}
