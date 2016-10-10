package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Created by idisfkj on 16/10/10.
 */
public class ValidateBinarySearchTree {
    public TreeNode temp = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return inorderTraversal(root);
    }

    public boolean inorderTraversal(TreeNode node) {
        if (node == null)
            return true;
        boolean left = inorderTraversal(node.left);
        if (temp != null) {
            if (node.val <= temp.val)
                return false;
        }
        temp = node;
        boolean right = inorderTraversal(node.right);
        return left && right;
    }
}
