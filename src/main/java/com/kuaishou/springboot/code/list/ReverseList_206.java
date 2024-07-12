package com.kuaishou.springboot.code.list;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-11
 */
public class ReverseList_206 {

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre, next, p;
        pre = null; p = head;

        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public static ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static void main(String[] args) {

        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(1, 3, 4, 5, 6, 7));
        System.out.println(ListNodeUtils.traversalList(reverseList(head)));
        System.out.println(ListNodeUtils.traversalList(reverseListRecursion(head)));
    }

}
