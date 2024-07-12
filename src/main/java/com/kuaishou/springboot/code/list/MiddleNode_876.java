package com.kuaishou.springboot.code.list;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-10
 */
public class MiddleNode_876 {

    public static ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rs = slow.next;
        slow.next = null;
        return rs;
    }

    public static void main(String[] args) {

        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(1, 2));
        System.out.println(ListNodeUtils.traversalList(middleNode(head)));
    }
}
