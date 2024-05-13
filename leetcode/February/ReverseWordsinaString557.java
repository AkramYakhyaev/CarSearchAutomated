package com.test.leetcode.February;

public class ReverseWordsinaString557 {

    public static void main(String[] args) { //printAlphabetUsingBuiltInMethods
        String s = "Let's take LeetCode contest";
        String rev = "";
        for(int i = s.length()-1; i >= 0; i--){
            rev += s.charAt(i);
        }
        System.out.println(rev);

    }
}
