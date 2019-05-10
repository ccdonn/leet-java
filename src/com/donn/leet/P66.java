package com.donn.leet;

public class P66 {

    public static void main(String[] args) {
        foo(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });
    }

    static int[] foo(int[] digits) {
        boolean newArray = true;
        for (int i : digits) {
            if (i != 9) {
                newArray = false;
                break;
            }
        }

        int[] n = null;
        if (newArray) {
            n = new int[digits.length + 1];
        } else {
            n = new int[digits.length];
        }

        boolean plus = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1 || plus) {
                digits[i]++;
                plus = false;
            }

            if (digits[i] == 10) {
                n[i] = 0;
                plus = true;
            } else {
                n[i] = digits[i];
            }
        }

        return n;
    }
}
