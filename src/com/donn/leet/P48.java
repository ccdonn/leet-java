package com.donn.leet;

public class P48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++, len--) {
            for (int j = i; j < len; j++) {
                change(matrix, i, j);
            }
        }
    }

    private void change(int[][] matrix, int i, int j) {

        // t = d
        int t = matrix[matrix.length - 1 - j][i];
        // d = c
        matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
        // c = b
        matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
        // b = a
        matrix[j][matrix.length - 1 - i] = matrix[i][j];
        // a = t
        matrix[i][j] = t;

        // int t;
        // t = matrix[i][j];
        // matrix[i][j] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
        // matrix[matrix.length - 1 - i][matrix.length - 1 - j] = t;
        //
        // t = matrix[i][j];
        // matrix[i][j] = matrix[matrix.length - 1 - j][i];
        // matrix[matrix.length - 1 - j][i] = t;
        //
        // t = matrix[j][matrix.length - 1 - i];
        // matrix[j][matrix.length - 1 - i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
        // matrix[matrix.length - 1 - i][matrix.length - 1 - j] = t;
    }

    public static void main(String[] args) {
        // new P48().rotate(new int[][] { { 1, 2 }, { 3, 4 } });
        new P48().rotate(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
        new P48().rotate(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });
        new P48().rotate(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } });
        new P48().rotate(new int[][] { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 }, { 19, 20, 21, 22, 23, 24 }, { 25, 26, 27, 28, 29, 30 },
            { 31, 32, 33, 34, 35, 36 } });
    }
}
