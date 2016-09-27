package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * Created by idisfkj on 16/9/27.
 */
public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(6);
        ArrayList<Integer> result = new BinaryTreePreorderTraversal().preorderTraversal2(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public ArrayList<Integer> preorderTraversal2(TreeNode root) {
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        //递归
//        preorderTraversalRecursive(root);
        return result;
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                stack.push(node);

            } else if (node.right != null) {
                queue.offer(node.right);
                node.right = null;
                stack.push(node);
            } else {
                while (!stack.isEmpty()) {
                    TreeNode pre = stack.pop();
                    if (pre.right != null) {
                        queue.offer(pre.right);
                        break;
                    }
                }
            }
        }
        //递归
//        preorderTraversalRecursive(root);
        return result;
    }

    public void preorderTraversalRecursive(TreeNode root) {
        if (root == null)
            return;
        result.add(root.val);
        preorderTraversalRecursive(root.left);
        preorderTraversalRecursive(root.right);
    }
}
