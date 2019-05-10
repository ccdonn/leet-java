package com.donn.leet;

import java.util.Arrays;

public class P665 {

    public static void main(String[] args) {
        System.out.println(new P665().checkPossibility(new int[] { 4, 2, 3 }));
        System.out.println(new P665().checkPossibility(new int[] { -1, 4, 2, 3 }));
        System.out.println(new P665().checkPossibility(new int[] { 4, 2, 1 }));
        System.out.println(new P665().checkPossibility(new int[] { 2, 3, 3, 2, 4 }));
    }

    public boolean checkPossibility(int[] nums) {
        int index;
        if ((index = popUnsortedIndex(nums)) > -1) {
            int[] numsCopy1 = new int[nums.length - 1];
            int[] numsCopy2 = new int[nums.length - 1];
            if (index == 0) {
                numsCopy1 = Arrays.copyOfRange(nums, 1, nums.length);
                return popUnsortedIndex(numsCopy1) == -1;
            } else if (index == nums.length - 1) {
                numsCopy1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
                return popUnsortedIndex(numsCopy1) == -1;
            } else {
                System.arraycopy(nums, 0, numsCopy1, 0, index);
                System.arraycopy(nums, index + 1, numsCopy1, index, nums.length - 1 - index);

                System.arraycopy(nums, 0, numsCopy2, 0, index + 1);
                System.arraycopy(nums, index + 1 + 1, numsCopy2, index + 1, nums.length - 1 - (index + 1));
            }

            return popUnsortedIndex(numsCopy1) == -1 || popUnsortedIndex(numsCopy2) == -1;
        }
        return true;
    }

    public int popUnsortedIndex(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] - arr[i + 1] <= 0) {
                continue;
            }
            return i;
        }
        return -1;
    }

}
