/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Generics Q8 - Generic method swapElements that swaps two elements in an array
 */
package generics;

import java.util.Arrays;

public class Q08_SwapElements {

    // Generic method: type parameter <T> is declared before the return type
    static <T> void swapElements(T[] array, int i, int j) {
        if (i < 0 || j < 0 || i >= array.length || j >= array.length)
            throw new IndexOutOfBoundsException("Invalid index");
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = {10, 20, 30, 40, 50};
        System.out.println("Integer array before: " + Arrays.toString(nums));
        swapElements(nums, 0, 4);
        System.out.println("Integer array after swap(0,4): " + Arrays.toString(nums));

        String[] names = {"Ansh", "Rahul", "Priya"};
        System.out.println("String array before: " + Arrays.toString(names));
        swapElements(names, 0, 2);
        System.out.println("String array after swap(0,2): " + Arrays.toString(names));

        Character[] chars = {'J', 'A', 'V', 'A'};
        System.out.println("Character array before: " + Arrays.toString(chars));
        Q08_SwapElements.<Character>swapElements(chars, 1, 2);  // explicit type argument
        System.out.println("Character array after swap(1,2): " + Arrays.toString(chars));
    }
}
