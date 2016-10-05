package com.idisfkj.arithmetic.LeetCode;

import com.idisfkj.arithmetic.search.Main;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 * 1
 * / \
 * 2   3
 * <p>
 * Return6.
 * <p>
 * Created by idisfkj on 16/10/5.
 */
public class BinaryTreeMaximumPathSum {
    public int sum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
//        root.right = new TreeNode(3);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        preordeTraversal(root);
        return sum;
    }

    public int preordeTraversal(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(0, preordeTraversal(node.left));
        int right = Math.max(0, preordeTraversal(node.right));
        sum = Math.max(sum, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
