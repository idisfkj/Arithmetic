package com.idisfkj.arithmetic.LeetCode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Created by idisfkj on 16/9/26.
 */
public class SortList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(3);
        root.next.next = new ListNode(2);
        ListNode re = new SortList().sortList(root);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }

    public ListNode sortList(ListNode head) {
        //要判断head.next是否为null 否则当数据为1个的时候会陷入死循环
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        ListNode left = head;
        mid.next = null;
        return mergeList(sortList(left), sortList(right));
    }

    public ListNode findMid(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left != null)
            temp.next = left;
        if (right != null)
            temp.next = right;
        return result.next;
    }
}
