package com.donn.leet;

public class P69 {
    public static void main(String[] args) {
        double x = 2147395600;
        System.out.println(fun(x));
        double y = 46340 * 46340;
        System.out.println(y);
        y = (double) 46341 * (double) 46341;
        System.out.println(y);
    }

    static double fun(double x) {
        for (int i = 0; i <= x; i++) {
            if (i * i > x) {
                return (i - 1);
            }
        }
        return (x);
    }
}
