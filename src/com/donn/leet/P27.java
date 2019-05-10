package com.donn.leet;

import java.util.Arrays;

public class P27 {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 2, 3 };
        int i = new P27().removeElement(arr, 3);

        System.out.println(i);
        Arrays.stream(arr).forEach(v -> {
            System.out.print(v + ",");
        });
    }

    public int removeElement(int[] nums, int val) {
        int position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
            } else {
                nums[position] = nums[i];
                position++;
            }
        }
        return position;
    }
}
