package com.donn.leet;

import java.util.HashMap;
import java.util.Map;

public class P55 {
    public static void main(String[] args) {
        System.out.println(new P55().canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(new P55().canJump(new int[] { 3, 2, 1, 0, 4 }));
        System.out.println(new P55().canJump(new int[] { 0 }));
        System.out.println(new P55().canJump(new int[] { 0, 1 }));
        System.out.println(new P55().canJump(new int[] { 2, 0 }));
        System.out.println(new P55().canJump(new int[] { 2, 1 }));
    }

    public boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        int n = 0;

        while (n < nums.length) {
            if (nums[n] == 0) {
                return false;
            }
            if (nums[n] >= nums.length - n) {
                return true;
            }
            n = findN(nums, n);
            if (n >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    private int findN(int[] nums, int n) {
        int[] t = new int[n + nums[n] >= nums.length ? nums.length - n : nums[n]];
        System.arraycopy(nums, n + 1, t, 0, n + nums[n] >= nums.length ? nums.length - n : nums[n]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length; i++) {
            map.put(i + n + 1, t[i] + i + n + 1);
        }
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

}
