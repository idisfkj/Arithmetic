package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * Created by idisfkj on 16/10/11.
 */
public class UniqueBinarySearchTreesii {

    public ArrayList<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }


    public ArrayList<TreeNode> dfs(int left, int right) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        // 1 2 3 4 5
        for (int i = left; i <= right; i++) {
            ArrayList<TreeNode> lTree = dfs(left, i - 1);
            ArrayList<TreeNode> rTree = dfs(i + 1, right);
            for (TreeNode nodeL : lTree) {
                for (TreeNode nodeR : rTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = nodeL;
                    root.right = nodeR;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
