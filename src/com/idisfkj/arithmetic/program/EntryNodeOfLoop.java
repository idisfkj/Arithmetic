package com.idisfkj.arithmetic.program;

import java.util.ArrayList;

/**
 * 链表中环的入口结点
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * Created by idisfkj on 16/9/19.
 */
public class EntryNodeOfLoop {
    public static void main(String[] args) {

    }

    public static FindFirstCommonNode.ListNode solution(FindFirstCommonNode.ListNode pHead) {
        ArrayList<Integer> list = new ArrayList<>();
        while (pHead != null) {
            if (list.contains(pHead.val)) {
                return pHead;
            }
            list.add(pHead.val);
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * p1走一步p2走两步相遇必定在环中,且p2相对而言多走了一个环
     * 再让p1从头走,p2继续接着走,再次相遇点就是环的入口
     * @param pHead
     * @return
     */
    public static FindFirstCommonNode.ListNode solution1(FindFirstCommonNode.ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        FindFirstCommonNode.ListNode p1 = pHead;
        FindFirstCommonNode.ListNode p2 = pHead;
        p1 = p1.next;
        p2 = p2.next.next;
        while (p1 != p2 && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p2 != null && p2.next != null) {
            p1 = pHead;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }
        return null;
    }
}
