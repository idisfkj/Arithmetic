package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * Created by idisfkj on 16/9/30.
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        new ReorderList().reorderList(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode t = slow;
        slow = slow.next;

        //将前部分链表分割开来
        t.next = null;

        ListNode bHead = slow;
        ListNode pre = null;
        //逆转后面的链表
        while (bHead != null) {
            ListNode temp = bHead.next;
            bHead.next = pre;
            pre = bHead;
            slow = bHead;
            bHead = temp;
        }
        ListNode p = head;
        ListNode q;
        ListNode n;
        while (p != null && slow != null) {
            q = p.next;
            p.next = slow;
            n = slow.next;
            slow.next = q;
            slow = n;
            p = q;
        }
    }
}
