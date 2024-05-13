package com.test.JavaBook;

public class Fibonacci2 {
    static final int max = 50;

    /**
     * Print out the Fibonacci sequence for values < max
     */
    public static void main(String[] args) {
        int lo = 1;
        int hi = 1;
        System.out.println(lo);
        while (hi < max) {
            System.out.println(hi);
            hi = lo + hi; // new hi
            lo = hi - lo; /* new lo is (sum - old lo)  that is, the old hi */
        }
    }
}
