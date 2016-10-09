package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Created by idisfkj on 16/10/8.
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
//        root.right = new TreeNode(4);
        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
//        if (root == null)
//            return true;
//        return preorderTraverasl(root);
        if (root == null)
            return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) <= 1) {
            if (isBalanced(root.left) && isBalanced(root.right)) {
                return true;
            }
        }
        return false;
    }

    public boolean preorderTraverasl(TreeNode node) {
        if (node.left != null)
            if (!preorderTraverasl(node.left))
                return false;
        int left = getDepth(node.left);
        if (node.right != null)
            if (!preorderTraverasl(node.right))
                return false;
        int right = getDepth(node.right);
        if (Math.abs(left - right) > 1)
            return false;
        else
            return true;
    }

    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        return (getDepth(node.left) > getDepth(node.right) ? getDepth(node.left) : getDepth(node.right)) + 1;
    }
}
