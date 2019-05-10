package com.donn.leet;

public class P35 {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(new P35().searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        System.out.println(new P35().searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        System.out.println(new P35().searchInsert(new int[] { 1, 3, 5, 6 }, 7));
        System.out.println(new P35().searchInsert(new int[] { 1, 3, 5, 6 }, 0));
    }
}
