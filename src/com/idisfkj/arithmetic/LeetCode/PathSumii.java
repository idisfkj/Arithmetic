package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree andsum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * Created by idisfkj on 16/10/7.
 */
public class PathSumii {
    public ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<Integer> item = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return result;
        preorderTraversal(root, sum);
        return result;
    }

    public void preorderTraversal(TreeNode node, int sum) {
        if (node == null)
            return;
        sum -= node.val;
        item.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                ArrayList<Integer> clone = (ArrayList<Integer>) item.clone();
                result.add(clone);
            }
            item.remove(item.size() - 1);
            return;
        }
        preorderTraversal(node.left, sum);
        preorderTraversal(node.right, sum);
        item.remove(item.size() - 1);
    }
}
