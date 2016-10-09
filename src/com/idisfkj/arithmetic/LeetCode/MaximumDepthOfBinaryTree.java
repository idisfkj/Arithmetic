package com.idisfkj.arithmetic.LeetCode;


/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * <p>
 * Created by idisfkj on 16/10/9.
 */
public class MaximumDepthOfBinaryTree {
    public int max = Integer.MIN_VALUE;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        preorderTraversal(root, 0);
        return max;
    }

    public void preorderTraversal(TreeNode node, int sum) {
        if (node == null)
            return;
        sum++;
        if (node.left == null && node.right == null) {
            if (sum > max)
                max = sum;
            return;
        }
        preorderTraversal(node.left, sum);
        preorderTraversal(node.right, sum);
    }
}
