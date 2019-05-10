package com.donn.leet;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class P128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        System.out.println(longestConsecutive(new int[] { 0, -1 }));
        System.out.println(longestConsecutive(new int[] { 1, 2, 0, 1 }));
        System.out.println(longestConsecutive(new int[] { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 }));
    }

    class record {
        public int min;
        public int max;
        public int count;

        public record(int min, int max, int count) {
            this.max = max;
            this.min = min;
            this.count = count;
        }
    }

    public static int longestConsecutive(int[] nums) {
        return 0;
    }

    public static int[] pre(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).mapToObj(i -> new Integer(i)).collect(Collectors.toSet());
        int[] r = new int[set.size()];
        int c = 0;
        for (int i : set) {
            r[c++] = i;
        }
        return r;
    }

    public static int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        nums = pre(nums);

        Arrays.sort(nums);

        int maxLen = 1;
        int curLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            } else if (nums[i] + 1 == nums[i + 1]) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 1;
            }
        }

        return maxLen;
    }
}
