package com.donn.leet;

import java.util.Arrays;

public class P59 {

    public int[][] generateMatrix(int n) {

        int total = n * n;
        int i = 0;
        int j = 0;
        int status = 1;
        int[][] array = new int[n][n];
        int count = 0;

        while (total > count) {
            array[i][j] = ++count;
            switch (status) {
                case 1:
                    if (j == n - 1 || array[i][j + 1] != 0) {
                        status = 2;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case 2:
                    if (i == n - 1 || array[i + 1][j] != 0) {
                        status = 3;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case 3:
                    if (j == 0 || array[i][j - 1] != 0) {
                        status = 4;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case 4:
                    if (array[i - 1][j] != 0) {
                        status = 1;
                        j++;
                    } else {
                        i--;
                    }
                    break;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        print(new P59().generateMatrix(3));
        print(new P59().generateMatrix(4));
    }

    private static void print(int[][] array) {
        StringBuilder sb = new StringBuilder();
        if (array.length == 0 || array[0].length == 0) {
            System.out.println(sb.toString());
        } else {
            sb.append("[");
            Arrays.stream(array).forEach(v -> {
                sb.append("[");
                Arrays.stream(v).forEach(vv -> {
                    sb.append(vv).append(", ");
                });
                sb.setLength(sb.length() - 2);
                sb.append("],");
            });
            sb.setLength(sb.length() - 1);
            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}
