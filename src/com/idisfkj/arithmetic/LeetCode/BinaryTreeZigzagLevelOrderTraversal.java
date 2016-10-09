package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree{3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.
 * Created by idisfkj on 16/10/9.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        leftStack.push(root);
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            ArrayList<Integer> items = new ArrayList<>();
            if (!leftStack.isEmpty()) {
                while (!leftStack.isEmpty()) {
                    TreeNode node = leftStack.pop();
                    items.add(node.val);
                    if (node.left != null)
                        rightStack.push(node.left);
                    if (node.right != null)
                        rightStack.push(node.right);
                }
            } else {
                while (!rightStack.isEmpty()) {
                    TreeNode node = rightStack.pop();
                    items.add(node.val);
                    if (node.right != null)
                        leftStack.push(node.right);
                    if (node.left != null)
                        leftStack.push(node.left);
                }
            }
            result.add(items);
        }
        return result;
    }
}
