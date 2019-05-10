package com.donn.leet;

import java.util.Arrays;

public class P88 {

    static int[] nums1 = { 1, 2, 3, 0, 0, 0 };
    static int[] nums2 = { 2, 5, 6 };

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int k = 0; k < n; k++) {
            nums1[m + k] = nums2[k];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        new P88().merge(nums1, 3, nums2, 3);
    }
}
