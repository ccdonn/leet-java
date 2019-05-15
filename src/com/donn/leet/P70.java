package com.donn.leet;

public class P70 {
    /**
     * Time Limit Exceeded
     */
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new P70_2().climbStairs(2));
        System.out.println(new P70_2().climbStairs(3));
        System.out.println(new P70_2().climbStairs(4));
        System.out.println(new P70_2().climbStairs(5));
        System.out.println(new P70_2().climbStairs(36));
    }
}
