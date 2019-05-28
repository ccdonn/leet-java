package com.donn.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, 0, new LinkedList<>(), result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, int val, LinkedList<Integer> list, List<List<Integer>> result) {
        val += root.val;
        if (root.left == null && root.right == null) {
            if (val == sum) {
                list.add(root.val);
                List<Integer> t = new ArrayList<>();
                t.addAll(list);
                result.add(t);
                list.removeLast();
            }
        } else if (root.left == null) {
            list.add(root.val);
            pathSum(root.right, sum, val, list, result);
            list.removeLast();
        } else if (root.right == null) {
            list.add(root.val);
            pathSum(root.left, sum, val, list, result);
            list.removeLast();
        } else {
            list.add(root.val);
            pathSum(root.right, sum, val, list, result);
            pathSum(root.left, sum, val, list, result);
            list.removeLast();
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
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new P113().pathSum(root, 22));
    }
}
