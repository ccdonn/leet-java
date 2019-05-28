package com.donn.leet;

public class P112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, sum, 0);
    }

    public boolean hasPathSum(TreeNode root, int sum, int val) {
        val += root.val;
        if (root.left == null && root.right == null) {
            return val == sum;
        } else if (root.left == null) {
            return hasPathSum(root.right, sum, val);
        } else if (root.right == null) {
            return hasPathSum(root.left, sum, val);
        } else {
            return hasPathSum(root.right, sum, val) || hasPathSum(root.left, sum, val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(new P112().hasPathSum(root, 22));
    }
}
