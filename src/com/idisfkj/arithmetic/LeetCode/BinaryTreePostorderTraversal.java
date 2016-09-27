package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * Created by idisfkj on 16/9/27.
 */
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        ArrayList<Integer> result = new BinaryTreePostorderTraversal().postorderTraversal(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            if (stack.peek().left == null && stack.peek().right == null) {
                result.add(stack.pop().val);
            } else {
                TreeNode node = stack.peek();
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
                if (node.left != null) {
                    stack.push(node.left);
                    node.left = null;
                }
            }
        }
        //递归
//        postorderTraversalRecursive(root);
        return result;
    }

    public void postorderTraversalRecursive(TreeNode root) {
        if (root == null)
            return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
    }
}
