package com.donn.leet;

import java.util.ArrayList;
import java.util.List;

public class P98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> l = inorder(root, new ArrayList<>());
        for (int i = 0; i < l.size() - 1; i++) {
            if (l.get(i) >= l.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private String inorder(TreeNode root, String s) {
        if (root == null)
            return s;
        s = inorder(root.left, s);
        // System.out.println(root.val);
        s += root.val + ",";
        s = inorder(root.right, s);
        return s;
    }

    private List<Integer> inorder(TreeNode root, List<Integer> l) {
        if (root == null)
            return l;
        l = inorder(root.left, l);
        l.add(root.val);
        l = inorder(root.right, l);
        return l;
    }

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(3);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(new P98().isValidBST(root));
    }
}
