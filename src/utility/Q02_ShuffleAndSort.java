/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Collections Utility Q2 - Shuffle and sort an ArrayList
 */
package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Q02_ShuffleAndSort {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Original : " + nums);

        Collections.shuffle(nums, new Random(36));   // seed 36 -> same shuffle every run
        System.out.println("Shuffled : " + nums);

        Collections.sort(nums);
        System.out.println("Sorted   : " + nums);

        Collections.sort(nums, Collections.reverseOrder());
        System.out.println("Reversed : " + nums);
    }
}
