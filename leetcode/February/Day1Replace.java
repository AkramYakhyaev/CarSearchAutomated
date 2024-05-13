package com.test.leetcode.February;

import org.testng.annotations.Test;

public class Day1Replace {

    @Test
    public static void main(String[] args) {

        //my code
        String address = "1.1.1.1";
        String newAddress = address.replace(".", "[.]");
        System.out.println("New IP  " + newAddress);

        //LeetCode solution
        String address1 = "1.1.1.1";
        String output = "";
        for (int i = 0; i < address1.length(); i++) {
            if (address1.charAt(i) == '.') {
                output += "[.]";
            } else {
                output += address1.charAt(i);
            }
        }
        System.out.println(output);

    }


}

