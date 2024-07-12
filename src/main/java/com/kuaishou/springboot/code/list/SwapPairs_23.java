package com.kuaishou.springboot.code.list;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-28
 */
public class SwapPairs_23 {

    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(); dummy.next = head;
        ListNode p, q;
        p = dummy; q = head;

        while (q != null && q.next != null) {
            ListNode next = q.next.next;
            p.next = q.next;
            q.next = next;
            p.next.next = q;
            p = q;
            q = next;
        }
        return dummy.next;
    }


    public static ListNode reversePairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;

        // 0 1 <- 2 3 4
        // 0 2 1 3 4

        while (q != null && q.next != null) {
            ListNode next = q.next.next;
            q.next.next = q;
            p.next = q.next;
            q.next = next;
            p = q;
            q = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(ListNodeUtils.traversalList(reversePairs(head)));
    }
}
