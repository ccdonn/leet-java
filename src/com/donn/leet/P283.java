package com.donn.leet;

import java.util.Arrays;

public class P283 {
    public static void main(String[] args) {
        moveZeroes(new int[] { 0, 1, 12, 3, 0 });
    }

    public static void moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                nums[i] = 0;
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
    }
}
