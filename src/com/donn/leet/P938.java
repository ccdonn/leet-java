package com.donn.leet;

import java.util.ArrayList;
import java.util.List;

public class P938 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (root.left != null) {
            sum += rangeSumBST(root.left, L, R);
        }

        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        if (root.right != null) {
            sum += rangeSumBST(root.right, L, R);
        }

        return sum;
    }

    public static int rangeSumBST2(TreeNode root, int L, int R) {
        List<Integer> list = inorder(root);
        int sum = 0;
        for (int i = list.indexOf(L); i <= list.indexOf(R); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    static List<Integer> inorder(TreeNode tn) {
        List<Integer> list = new ArrayList<>();
        if (tn.left != null) {
            list.addAll(inorder(tn.left));
        }

        list.add(tn.val);

        if (tn.right != null) {
            list.addAll(inorder(tn.right));
        }

        return list;
    }
}
