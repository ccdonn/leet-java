package com.donn.leet;

public class P494 {
    public static void main(String[] args) {
        System.out.println(new P494().findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {
        int cntr = 1 << nums.length;
        int r = 0;
        for (int i = 0; i < cntr; i++) {
            int val = 0;
            String s = Integer.toBinaryString(i);
            for (int j = s.length() - 1; j >= 0; j++) {
                if (nums[j] == '0') {
                    val = val + nums[j];
                } else {
                    val = val - nums[j];
                }
            }
            if (val == S) {
                r++;
            }
        }
        return r;
    }

}
