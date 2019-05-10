package com.donn.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P41 {

    public static void main(String[] args) {
        int[] c1 = new int[] { 1, 2, 0 };
        int[] c2 = new int[] { 3, 4, -1, 1 };
        int[] c3 = new int[] { 7, 8, 9, 11, 12 };

        System.out.println(firstMissingPositive(c1));
        System.out.println(firstMissingPositive(c2));
        System.out.println(firstMissingPositive(c3));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i < max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return max + 1;
    }
}
