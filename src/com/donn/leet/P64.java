package com.donn.leet;

public class P64 {
    public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[][] val = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    val[i][j] = grid[i][j];
                } else if (i == 0) {
                    val[i][j] = val[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    val[i][j] = val[i - 1][j] + grid[i][j];
                } else {
                    val[i][j] = Math.min(val[i - 1][j], val[i][j - 1]) + grid[i][j];
                }
            }
        }

        return val[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new P64().minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
        System.out.println(new P64().minPathSum(new int[][] { { 1, 2, 5 }, { 3, 2, 1 } }));
    }
}
