package com.donn.leet;

public class P70_2 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] arr = new int[n + 1];

        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n - 1] + arr[n - 2];
    }

    public static void main(String[] args) {
        System.out.println(new P70_2().climbStairs(2));
        System.out.println(new P70_2().climbStairs(3));
        System.out.println(new P70_2().climbStairs(4));
        System.out.println(new P70_2().climbStairs(5));
        System.out.println(new P70_2().climbStairs(36));
    }
}
