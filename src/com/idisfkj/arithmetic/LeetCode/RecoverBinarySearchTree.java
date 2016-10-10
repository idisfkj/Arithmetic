package com.idisfkj.arithmetic.LeetCode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * Created by idisfkj on 16/10/10.
 */
public class RecoverBinarySearchTree {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    int count = 0;
    TreeNode temp = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        new RecoverBinarySearchTree().recoverTree(root);
        System.out.println(root.val + " " + root.left.val + " " + root.right.val);
    }

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root);
        int t;
        t = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = t;
    }

    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        if (temp != null)
            if (node.val < temp.val) {
                if (count == 0) {
                    firstNode = temp;
                    count++;
                    secondNode = node;
                } else {
                    secondNode = node;
                    count++;
                }
            }
        temp = node;
        inorderTraversal(node.right);
    }
}
