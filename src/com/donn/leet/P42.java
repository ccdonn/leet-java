package com.donn.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Wrong anwser
 *
 */
public class P42 {

    public static void main(String[] args) {
        // System.out.println(trap(new int[] { 5, 1, 2 })); // 1
        // System.out.println(trap(new int[] { 5, 4, 1, 2 })); // 1
        // System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 })); // 6
        // System.out.println(trap(new int[] { 5, 1, 3, 1, 5, 1, 5, 1, 2 }));// 15
        // System.out.println(trap(new int[] { 2, 1, 0, 0, 1 }));// 2
        // System.out.println(trap(new int[] { 1, 0, 0, 1, 2 }));// 2
        // System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 }));// 9
        System.out.println(trap(new int[] { 9, 6, 8, 8, 5, 6, 3 }));// 2
    }

    static int[] pre(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                length++;
            }
        }
        int[] res = new int[length + 1];
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                res[j++] = nums[i];
            }
        }
        res[j] = nums[nums.length - 1];
        return res;
    }

    public static int trap(int[] height) {

        if (height.length <= 2) {
            return 0;
        }

        // height = pre(height);

        int max = -1;
        int maxFirstIndex = -1;
        int maxLastIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxFirstIndex = i;
                maxLastIndex = i;
            } else if (height[i] == max) {
                maxLastIndex = i;
            }
        }

        if (maxFirstIndex == maxLastIndex) {
            // only 1 max
            // return counting(height);
            return counting(Arrays.copyOfRange(height, 0, maxFirstIndex + 1)) + counting(Arrays.copyOfRange(height, maxLastIndex, height.length));
        } else {
            // multiple max
            int total = (maxLastIndex - maxFirstIndex + 1) * max;
            int allocate = 0;
            for (int k = maxFirstIndex; k <= maxLastIndex; k++) {
                if (height[k] == max) {
                    allocate += max;
                } else {
                    allocate += height[k];
                }
            }
            return total - allocate + counting(Arrays.copyOfRange(height, 0, maxFirstIndex + 1)) + counting(Arrays.copyOfRange(height, maxLastIndex, height.length));
        }

    }

    static int counting(int[] array) {
        if (array.length <= 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int maxIndex = -1;
        int max2Index = -1;
        Set<Integer> max2IndexSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != max) {
                if (array[i] > max2) {
                    max2 = array[i];
                    max2IndexSet.clear();
                    max2IndexSet.add(i);
                } else if (array[i] == max2) {
                    max2IndexSet.add(i);
                }
            }
        }

        int distance = 0;
        for (int i : max2IndexSet) {
            if (Math.abs(maxIndex - i) >= distance) {
                distance = Math.abs(maxIndex - i);
                max2Index = i;
            }
        }

        if (Math.abs(maxIndex - max2Index) == 1) {
            if (maxIndex == 0) {
                return counting(Arrays.copyOfRange(array, 1, array.length));
            } else {
                return counting(Arrays.copyOfRange(array, 0, array.length - 1));
            }
        }

        int total = max2 * (Math.abs(maxIndex - max2Index) + 1);
        int allocate = 0;
        for (int i = 0; i < (Math.abs(maxIndex - max2Index) + 1); i++) {
            if (array[Math.min(maxIndex, max2Index) + i] >= max2) {
                allocate += max2;
            } else {
                allocate += array[Math.min(maxIndex, max2Index) + i];
            }
        }

        if (max2Index < maxIndex) {
            return total - allocate + trap(Arrays.copyOfRange(array, 0, max2Index + 1));
        } else {
            return total - allocate + trap(Arrays.copyOfRange(array, max2Index, array.length - 1));
        }

    }
}
