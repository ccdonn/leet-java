package com.donn.leet;

public class P29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        System.out.println(new P29().divide(10, 3));
        System.out.println(new P29().divide(7, -3));
        System.out.println(new P29().divide(-4, -2));
        System.out.println(new P29().divide(Integer.MIN_VALUE, -1));
    }
}
