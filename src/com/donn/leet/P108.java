package com.donn.leet;

import java.util.Arrays;

public class P108 {
    public static void main(String[] args) {
        TreeNode root = null;
        root = new P108().sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
        root = new P108().sortedArrayToBST(new int[] { 0, 1, 2, 3, 4, 5 });
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int middle = nums.length / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, middle + 1, nums.length));

        return root;
    }

}
