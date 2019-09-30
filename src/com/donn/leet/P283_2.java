package com.donn.leet;

import java.util.Arrays;

public class P283_2 {
    public static void main(String[] args) {
        moveZeroes(new int[] { 0, 1, 12, 3, 0 });
    }

    public static void moveZeroes(int[] nums) {

    	int index = 0;
    	for (int i : nums) {
    		if (i!=0) {
    			nums[index++] = i;
    		}
    	}
    	for (int i = index;i<nums.length;i++) {
    		nums[i] = 0;
    	}
        Arrays.stream(nums).forEach(System.out::println);
    }
}
