package com.donn.leet;

public class P114 {
    public void flatten(TreeNode root) {
        TreeNode tr = root;
        while (tr != null) {
            if (tr.left != null) {
                TreeNode t = tr.right;
                tr.right = tr.left;
                tr.left = null;
                TreeNode t2 = tr.right;
                while (t2.right != null) {
                    t2 = t2.right;
                }
                t2.right = t;
            }

            if (tr.right == null) {
                break;
            }
            tr = tr.right;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        new P114().flatten(root);
        System.out.println("");

    }
}
