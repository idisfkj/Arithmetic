package com.idisfkj.arithmetic.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
 * Initially, all next pointers are set toNULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * <p>
 * For example,
 * Given the following perfect binary tree,
 * **1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * <p>
 * After calling your function, the tree should look like:
 * **1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 * Created by idisfkj on 16/10/7.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            if (queue.peek() == null) {
                queue.poll();
                node.next = null;
                if (node.left != null && node.right != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    queue.offer(null);
                }
            } else {
                node.next = queue.peek();
                if (node.left != null && node.right != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
    }
}
