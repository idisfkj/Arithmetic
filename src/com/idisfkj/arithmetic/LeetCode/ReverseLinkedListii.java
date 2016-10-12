package com.idisfkj.arithmetic.LeetCode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given1->2->3->4->5->NULL, m = 2 and n = 4,
 * return1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Created by idisfkj on 16/10/12.
 */
public class ReverseLinkedListii {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode res = new ReverseLinkedListii().reverseBetween(head, 1, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n)
            return head;
        ListNode firstNode = head;
        ListNode firstPre = null;
        ListNode secondNode = head;
        ListNode secondNext = head.next;
        int count = 1;
        while (count < m) {
            firstPre = firstNode;
            firstNode = firstNode.next;
            count++;
        }
        count = 1;
        while (count < n) {
            secondNode = secondNode.next;
            secondNext = secondNode.next;
            count++;
        }
        ListNode p;
        ListNode q = secondNext;
        while (firstNode != secondNode) {
            p = firstNode.next;
            firstNode.next = q;
            q = firstNode;
            firstNode = p;
        }
        firstNode.next = q;
        q = firstNode;
        if (firstPre != null)
            firstPre.next = secondNode;
        else
            head = q;
        return head;
    }
}
