package com.idisfkj.arithmetic.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * <p>
 * For example,
 * Given the following binary tree,
 * **1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * <p>
 * After calling your function, the tree should look like:
 * **1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 * <p>
 * <p>
 * Created by idisfkj on 16/10/7.
 */
public class PopulatingNextRightPointersInEachNodeii {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            if (queue.peek() != null) {
                node.next = queue.peek();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            } else {
                node.next = null;
                queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
    }
}
