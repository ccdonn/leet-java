package com.donn.leet;

import java.util.ArrayList;
import java.util.List;

public class P145 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> l = new P145().postorderTraversal(root);
        System.out.println("");
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversal(root, new ArrayList<>());
    }

    private List<Integer> postorderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return list;
        }

        list = postorderTraversal(root.left, list);
        list = postorderTraversal(root.right, list);
        list.add(root.val);

        return list;
    }
}
