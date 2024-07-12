package com.kuaishou.springboot.code.list;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-23
 */
public class RemoveNthFromEnd_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || n <= 0) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head; ListNode slow = head; ListNode p = dummy;

        int i = 0;
        while (i < n && fast != null) {
            fast = fast.next;
            ++i;
        }
        if (fast == null && i < n) {
            return null;
        }

        while (fast != null) {
            fast = fast.next;
            p = slow;
            slow = slow.next;
        }
        p.next = slow.next;
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(ListNodeUtils.traversalList(removeNthFromEnd(head, 8)));
    }
}
