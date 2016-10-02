package com.idisfkj.arithmetic.LeetCode;

/**
 * Created by idisfkj on 16/9/30.
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = root;
        ListNode result = new DetectCycle().detectCycle(root);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
