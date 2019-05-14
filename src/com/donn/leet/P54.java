package com.donn.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        int total = matrix.length * matrix[0].length;
        boolean[][] b = new boolean[matrix.length][matrix[0].length];
        int i = 0;
        int j = 0;
        int status = 1;
        List<Integer> list = new ArrayList<>();

        while (total > list.size()) {
            b[i][j] = true;
            list.add(matrix[i][j]);
            switch (status) {
                case 1:
                    if (j == matrix[0].length - 1 || b[i][j + 1]) {
                        status = 2;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case 2:
                    if (i == matrix.length - 1 || b[i + 1][j]) {
                        status = 3;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case 3:
                    if (j == 0 || b[i][j - 1]) {
                        status = 4;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case 4:
                    if (b[i - 1][j]) {
                        status = 1;
                        j++;
                    } else {
                        i--;
                    }
                    break;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new P54().spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
        System.out.println(new P54().spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));

    }
}
