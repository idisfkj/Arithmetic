package com.idisfkj.arithmetic.LeetCode;

/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * Created by idisfkj on 16/10/8.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0)
            return null;
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        //折半查找
        if (start > end)
            return null;
        int mid = (int) (((double)(start + end) / 2) + 0.5);
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, start, mid - 1);
        node.right = sortedArrayToBST(num, mid + 1, end);
        return node;
    }
}
