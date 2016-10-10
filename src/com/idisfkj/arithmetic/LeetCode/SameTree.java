package com.idisfkj.arithmetic.LeetCode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical
 * and the nodes have the same value.
 * Created by idisfkj on 16/10/10.
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println(new SameTree().isSameTree(root1, root2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if ((p == null && q != null) || (p != null && q == null))
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
