package com.donn.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P101 {
    public boolean isSymmetric(TreeNode root) {
        List<String> l = inorder(root, new ArrayList<>(), 1);
        List<String> r = new ArrayList<>();
        r.addAll(l);
        Collections.reverse(r);
        return l.equals(r);
    }

    private List<String> inorder(TreeNode root, List<String> l, int level) {
        if (root == null) {
            return l;
        }
        l = inorder(root.left, l, level + 1);
        l.add(root.val + "-" + level);
        l = inorder(root.right, l, level + 1);
        return l;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // Utils.buildTree(new int[] { 1, 2, 2, 3, 4, 4, 3 });
        System.out.println(new P101().isSymmetric(root));
    }
}
