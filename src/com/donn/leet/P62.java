package com.donn.leet;

public class P62 {
    public int uniquePaths(int m, int n) {
        int[][] val = new int[n][m];
        for (int i = 0; i < m; i++) {
            val[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            val[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                val[i][j] = val[i - 1][j] + val[i][j - 1];
            }
        }
        return val[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new P62().uniquePaths(3, 2));
        System.out.println(new P62().uniquePaths(7, 3));
        System.out.println(new P62().uniquePaths(7, 4));

        long t = System.currentTimeMillis();
        System.out.println(new P62().uniquePaths(51, 9));
        System.out.println(System.currentTimeMillis() - t);
    }
}
