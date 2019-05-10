package com.donn.leet;

public class P231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(5));
    }

    public static boolean isPowerOfTwo(int n) {

        // String s = Integer.toBinaryString(n);
        // if (s.indexOf("1") == s.lastIndexOf("1")) {
        // return true;
        // } else {
        // return false;
        // }

        while (n % 2 == 0 || n == 1) {
            if (n == 1) {
                return true;
            }
            n = n >> 1;
        }

        return false;
    }
}
