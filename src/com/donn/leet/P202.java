package com.donn.leet;

public class P202 {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
        System.out.println(isHappy(4));
        System.out.println(isHappy(19));
        System.out.println(isHappy(10));
        System.out.println(isHappy(13));
        System.out.println(isHappy(2));
        System.out.println(isHappy(4));

    }

    public static boolean isHappy(int n) {

        int t = cal(n);

        if (t / 10 == 0) {
            if (t == 1 || t == 7) {
                return true;
            } else {
                return false;
            }
        }

        return isHappy(t);
    }

    public static int cal(int n) {
        int value = 0;
        while (n / 10 != 0) {
            value += Math.pow(n % 10, 2);
            n = n / 10;
        }
        value += Math.pow(n, 2);
        return value;
    }
}
