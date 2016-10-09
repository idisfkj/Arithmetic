package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.
 * <p>
 * Created by idisfkj on 16/10/9.
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        System.out.println(new SymmetricTree().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 != null && node2 != null) {
            if (node1.val != node2.val)
                return false;
            else
                return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }
        return false;
    }
}
