package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *  1
 * / \
 * 2  3
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * Return the sum = 12 + 13 =25.
 * Created by idisfkj on 16/10/4.
 */
public class SumRootToLeafNumbers {
    public int sum;
    public int temp;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);// 134 + 15
        root.right = new TreeNode(5);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        temp = temp * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += temp;
            temp = temp / 10;
            return;
        }
        dfs(root.left);
        dfs(root.right);
        temp = temp / 10;
    }
}
