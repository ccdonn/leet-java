package com.donn.leet;

public class P941 {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[] { 0, 1, 2, 4, 2, 1 }));
    }

    public static boolean validMountainArray(int[] A) {

        if (A.length < 3) {
            return false;
        }

        int leftPeak = -1;
        int rightPeak = -1;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                leftPeak = i;
                break;
            }
            if (A[i] == A[i + 1]) {
                return false;
            }
        }

        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] > A[i - 1]) {
                rightPeak = i;
                break;
            }
            if (A[i] == A[i - 1]) {
                return false;
            }
        }

        System.out.println(leftPeak + "," + rightPeak);
        return leftPeak > 0 && rightPeak > 0 && leftPeak == rightPeak;
    }
}
