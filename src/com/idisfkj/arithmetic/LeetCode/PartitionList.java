package com.idisfkj.arithmetic.LeetCode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x
 * come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given1->4->3->2->5->2and x = 3,
 * return1->2->2->4->3->5.
 * <p>
 * Created by idisfkj on 16/10/17.
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode result = new PartitionList().partition(head, 3);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        ListNode next = new ListNode(0);
        ListNode preTemp = pre;
        ListNode nextTemp = next;
        while (head != null) {
            if (head.val < x) {
                preTemp.next = head;
                preTemp = preTemp.next;
            } else {
                nextTemp.next = head;
                nextTemp = nextTemp.next;
            }
            head = head.next;
        }
        nextTemp.next = null;
        preTemp.next = next.next;
        return pre.next;
    }
}
