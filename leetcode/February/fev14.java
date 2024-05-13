package com.test.leetcode.February;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class fev14 {

    public static boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    public static void main(String[] args) {
        // Test cases with different palindromes and non-palindromes
        String[] inputs = {"racecar", "madam", "hello", "rotor", "kayak", "A man, a plan, a canal: Panama"};

        for (String input : inputs) {
            boolean isPalindrome = isPalindrome(input);
            System.out.println("Input: " + input + ", Is Palindrome: " + isPalindrome);
        }
    }
}
