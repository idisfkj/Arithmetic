package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree{3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * Created by idisfkj on 16/10/8.
 */
public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<Integer> item = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> res = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                item.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            } else {
                ArrayList<Integer> clone = (ArrayList<Integer>) item.clone();
                result.add(clone);
                item.clear();
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return result;
    }
}
