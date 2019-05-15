package com.donn.leet;

public class P62_2 {
    /**
     * Time Limit Exceeded
     */
    public int uniquePaths(int m, int n) {

        if (m == 1) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new P62_2().uniquePaths(3, 2));
        System.out.println(new P62_2().uniquePaths(7, 3));
        System.out.println(new P62_2().uniquePaths(7, 4));

        long t = System.currentTimeMillis();
        System.out.println(new P62_2().uniquePaths(51, 9));
        System.out.println(System.currentTimeMillis() - t);
    }
}
