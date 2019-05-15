package com.donn.leet;

public class P63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] val = new int[n][m];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }

        int base = 1;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                base = 0;
            }
            val[0][i] = base;
        }
        base = 1;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                base = 0;
            }
            val[i][0] = base;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                val[i][j] = obstacleGrid[i][j] == 1 ? 0 : val[i - 1][j] + val[i][j - 1];
            }
        }
        return val[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new P63().uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));

        System.out.println(new P63().uniquePathsWithObstacles(new int[][] { { 0, 0 }, { 1, 1 }, { 0, 0 } }));
    }
}
