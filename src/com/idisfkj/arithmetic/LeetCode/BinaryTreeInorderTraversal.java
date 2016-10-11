package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * return[1,3,2].
 * Created by idisfkj on 16/10/11.
 */
public class BinaryTreeInorderTraversal {
    public static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new BinaryTreeInorderTraversal().inorderTraversal(root);
        for (int i = 0; i < result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return result;
        inorder(root);
        return result;
    }

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        result.add(node.val);
        inorder(node.right);
    }

}
