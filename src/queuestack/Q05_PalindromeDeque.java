/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Queue and Stack Q5 - Palindrome check using a Deque
 */
package queuestack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q05_PalindromeDeque {

    static boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toLowerCase().toCharArray())
            if (Character.isLetterOrDigit(c)) deque.addLast(c);   // ignore spaces/punctuation

        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] tests = {"madam", "racecar", "Java", "Never odd or even", "A man, a plan, a canal: Panama", "12321", "Ansh"};
        for (String t : tests)
            System.out.printf("%-32s -> %s%n", "\"" + t + "\"", isPalindrome(t) ? "Palindrome" : "Not a palindrome");
    }
}
