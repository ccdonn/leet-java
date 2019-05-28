package com.donn.leet;

public class P129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int val) {
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        } else if (root.left == null) {
            return sumNumbers(root.right, val);
        } else if (root.right == null) {
            return sumNumbers(root.left, val);
        } else {
            return sumNumbers(root.left, val) + sumNumbers(root.right, val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        System.out.println(new P129().sumNumbers(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new P129().sumNumbers(root));

        root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new P129().sumNumbers(root));
    }
}
