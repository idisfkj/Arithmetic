package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree andsum = 22,
 * *5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.
 * Created by idisfkj on 16/10/7.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public boolean preorderTraversal(TreeNode node, int sum) {
        if (node == null)
            return false;
        sum -= node.val;
        if (node.left == null && node.right == null && sum == 0) {
            return true;
        }
        return preorderTraversal(node.left, sum) || preorderTraversal(node.right, sum);
    }
}
