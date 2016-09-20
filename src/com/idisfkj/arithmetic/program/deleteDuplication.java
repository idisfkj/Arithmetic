package com.idisfkj.arithmetic.program;

/**
 * 删除链表中重复的结点
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * Created by idisfkj on 16/9/19.
 */
public class deleteDuplication {
    public static void main(String[] args) {

    }

    public static FindFirstCommonNode.ListNode solution(FindFirstCommonNode.ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        FindFirstCommonNode.ListNode p1 = pHead;
        FindFirstCommonNode.ListNode p2 = pHead.next;
        FindFirstCommonNode.ListNode temp = null;
        boolean flag = false;
        while (p2 != null) {
            if (p1.val == p2.val) {
                p2 = p2.next;
                flag = true;
            } else {
                if (flag) {
                    if (temp != null)
                        temp.next = p2;
                    else
                        pHead = p2;
                    p1 = p2;
                    p2 = p2.next;
                    flag = false;
                } else {
                    temp = p1;
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
        }
        if (flag) {
            if (temp != null)
                temp.next = null;
            else
                return null;
        }
        return pHead;
    }
}
