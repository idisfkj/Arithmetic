package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * Created by idisfkj on 16/10/8.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;
        //折半查找
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        if (temp == null) {
            head = null;
        } else {
            temp.next = null;
        }
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }
}
