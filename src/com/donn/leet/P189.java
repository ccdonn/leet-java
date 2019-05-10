package com.donn.leet;

import java.util.Arrays;

public class P189 {
    public static void main(String[] args) {
        rotate2(new int[] { 1, 2, 3, 4, 5 }, 12);
    }

    public static void rotate(int[] nums, int k) {
        int k2 = k % nums.length;
        int[] n2 = new int[nums.length];

        if (k2 > 0) {
            for (int i = 0; i < nums.length; i++) {
                n2[k2++ % nums.length] = nums[i];
            }
            nums = n2;
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (k % nums.length == 0) {
            return;
        }
        int tmp = nums[k > nums.length ? nums.length - (k % nums.length) : nums.length - k];
        for (int i = nums.length - 1;; i--) {
            if (i * k % nums.length == 0) {
                nums[0] = tmp;
                break;
            }
            nums[(i * k) % nums.length] = nums[((i - 1) * k) % nums.length];
        }

        Arrays.stream(nums).forEach(System.out::print);
    }
}
