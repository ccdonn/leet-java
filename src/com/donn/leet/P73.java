package com.donn.leet;

import java.util.HashSet;
import java.util.Set;

public class P73 {

    /**
     * space: O(m+n)
     * 
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        for (int v : x) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[v][i] = 0;
            }
        }

        for (int v : y) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][v] = 0;
            }
        }

        Utils.printArray(matrix);
    }

    public static void main(String[] args) {
        new P73().setZeroes(new int[][] {
            { 1, 1, 1 },
            { 1, 0, 1 },
            { 1, 1, 1 }
        });

        new P73().setZeroes(new int[][] {
            { 0, 1, 2, 0 },
            { 3, 4, 5, 2 },
            { 1, 3, 1, 5 }
        });
    }
}
