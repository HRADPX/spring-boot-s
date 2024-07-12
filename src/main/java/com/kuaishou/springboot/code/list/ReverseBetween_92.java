package com.kuaishou.springboot.code.list;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-15
 */
public class ReverseBetween_92 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }

        int i = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        ListNode leftNode, rightNode;

        while (i < left - 1 && p != null) {
            p = p.next;
            i++;
        }
        leftNode = p;
        while (i < right && p != null) {
            p = p.next;
            i++;
        }
        rightNode = p;
        ListNode newTail = leftNode.next;
        ListNode newHead = rightNode.next;

        leftNode.next = reverseList(leftNode.next, newHead);
        newTail.next = newHead;
        return dummy.next;
    }


    private static ListNode reverseList(ListNode head, ListNode tail) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode next;
        ListNode pre = null;
        ListNode p = head;

        while (p != tail) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(ListNodeUtils.traversalList(reverseBetween(head, 3, 5)));
    }
}
