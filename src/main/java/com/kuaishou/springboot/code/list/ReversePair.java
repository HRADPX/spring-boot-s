package com.kuaishou.springboot.code.list;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-09-08
 */
public class ReversePair {

    public ListNode reversePair(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy, q = head;

        while (q != null && q.next != null) {
            ListNode next = q.next;
            q.next = next.next;
            next.next = q;
            p.next = next;
            p = q;
            q = q.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(ListNodeUtils.traversalList(ReflectUtils.getInstance(ReversePair.class).reversePair(head)));
    }
}
