/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Generics Q10 - MinMaxFinder<T extends Comparable<T>> with findMin() and findMax()
 */
package generics;

import java.util.Arrays;
import java.util.List;

public class Q10_MinMaxFinder {

    static class MinMaxFinder<T extends Comparable<T>> {
        private final List<T> list;

        MinMaxFinder(List<T> list) {
            if (list == null || list.isEmpty())
                throw new IllegalArgumentException("List must not be empty");
            this.list = list;
        }

        T findMin() {
            T min = list.get(0);
            for (T item : list) if (item.compareTo(min) < 0) min = item;
            return min;
        }

        T findMax() {
            T max = list.get(0);
            for (T item : list) if (item.compareTo(max) > 0) max = item;
            return max;
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(45, 12, 89, 3, 67, 36);
        MinMaxFinder<Integer> intFinder = new MinMaxFinder<>(numbers);
        System.out.println("Integers: " + numbers);
        System.out.println("Min = " + intFinder.findMin() + ", Max = " + intFinder.findMax());

        List<String> words = Arrays.asList("Mango", "Apple", "Zebra", "Banana", "Kiwi");
        MinMaxFinder<String> strFinder = new MinMaxFinder<>(words);
        System.out.println("\nStrings: " + words);
        System.out.println("Min = " + strFinder.findMin() + ", Max = " + strFinder.findMax());
    }
}
