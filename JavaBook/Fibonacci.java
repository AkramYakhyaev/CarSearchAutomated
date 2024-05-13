package com.test.JavaBook;

public class Fibonacci {
    public static void main (String [] args){
        int lo = 1;
        int hi = 1;
        System.out.println(lo);
        while (hi < 50) {
            System.out.println(hi);
            hi = lo + hi; // new hi
            lo = hi - lo; /* new lo is (sum - old lo)  that is, the old hi */
        }
    }
}

