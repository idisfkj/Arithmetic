package com.idisfkj.arithmetic.LeetCode;

/**
 * Sort a linked list using insertion sort.
 * Created by idisfkj on 16/9/26.
 */
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(3);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(6);
        root.next.next.next.next = new ListNode(5);
        ListNode res = new InsertionSortList().insertionSortList(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {

        //哑节点
        ListNode dumy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = dumy;
        while (cur != null) {
            //保存当前节点下一个节点
            ListNode next = cur.next;
            pre = dumy;
            //寻找当前节点正确位置的一个节点
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //将当前节点加入新链表中
            cur.next = pre.next;
            pre.next = cur;
            //处理下一个节点
            cur = next;
        }
        return dumy.next;

//        if (head == null)
//            return head;
//        ListNode p = head;
//        ListNode q = head.next;
//        while (q != null) {
//            ListNode next = q.next;
//            if (q.val < p.val) {
//                ListNode pre = head;
//                ListNode cur = head.next;
//                if (q.val < pre.val) {
//                    q.next = head;
//                    head.next = next;
//                    head = q;
//                } else {
//                    boolean flag = true;
//                    while (flag) {
//                        if (q.val < cur.val) {
//                            pre.next = q;
//                            q.next = cur;
//                            cur.next = next;
//                            flag = false;
//                        }else {
//                            cur = cur.next;
//                            pre = pre.next;
//                        }
//                    }
//                }
//            }
//            q = next;
//            p = p.next;
//        }
//        return head;
    }
}
