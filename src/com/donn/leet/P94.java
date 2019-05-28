package com.donn.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }

        list.add(root.val);

        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }

        return list;
    }
}
