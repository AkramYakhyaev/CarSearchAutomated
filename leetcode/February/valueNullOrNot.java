package com.test.leetcode.February;

public class valueNullOrNot {
    public boolean hasValue(Object item){
        return item != null && !item.toString().isEmpty();
    }
    public static void main (String [] args){
        valueNullOrNot checker = new valueNullOrNot();
        Object [] items = {null, "", " ", "Hello", 0, 1, 0.0, 1.0, new Object()};
        for (Object item : items){
            System.out.println("Item: " + item + ", hasValue: " + checker.hasValue(item));
        }
    }
}
