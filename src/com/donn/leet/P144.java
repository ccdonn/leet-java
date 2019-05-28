package com.donn.leet;

import java.util.ArrayList;
import java.util.List;

public class P144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> l = new P144().preorderTraversal(root);
        System.out.println("");
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal(root, new ArrayList<>());
    }

    private List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return list;
        }

        list.add(root.val);
        list = preorderTraversal(root.left, list);
        list = preorderTraversal(root.right, list);

        return list;
    }
}
