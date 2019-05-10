package com.donn.leet;

public class P832 {

    public static void main(String[] args) {
        System.out.println(flipAndInvertImage(new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } }));
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                if (A[i][j] != A[i][A[i].length - 1 - j]) {
                    int t = A[i][j];
                    A[i][j] = A[i][A[i].length - 1 - j];
                    A[i][A[i].length - 1 - j] = t;
                }
            }
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }
        return A;
    }
}
