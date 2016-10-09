package com.idisfkj.arithmetic.LeetCode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * Created by idisfkj on 16/10/9.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        return bulidTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode bulidTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        //从前序遍历确定根节点,再从中序遍历确定左右节点
        TreeNode node = new TreeNode(preorder[preStart]);
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i])
                break;
        }
        node.left = bulidTree(preorder, inorder, preStart + 1, preStart + i - inStart, inStart, inEnd - 1);
        node.right = bulidTree(preorder, inorder, preStart + i - inStart + 1, preEnd, i + 1, inEnd);
        return node;
    }
}
