package com.idisfkj.arithmetic.LeetCode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * Created by idisfkj on 16/10/8.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return root;
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;
        //从后序遍历中确定根节点,再从中序遍历中确定左右节点
        TreeNode node = new TreeNode(postorder[postEnd]);
        int n = -1;
        for (int i = inEnd; i >= inStart; i--) {
            n = i;
            if (inorder[i] == postorder[postEnd])
                break;
        }
        node.left = buildTree(inorder, postorder, inStart, n - 1, postStart, postEnd - (inEnd - n) - 1);
        node.right = buildTree(inorder, postorder, n - 1, inEnd, postEnd - (inEnd - n), postEnd - 1);
        return node;
    }
}
