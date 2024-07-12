package com.kuaishou.springboot.code.list;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-09
 */
public class Partition_86 {

    public static ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode headOfBiggerThanXDummy = new ListNode();
        ListNode headOfSmallerThanXDummy = new ListNode();
        ListNode headOfBiggerThanX = headOfBiggerThanXDummy;
        ListNode headOfSmallerThanX = headOfSmallerThanXDummy;

        while (p != null) {
            if (p.val >= x) {
                headOfBiggerThanX.next = p;
                headOfBiggerThanX = headOfBiggerThanX.next;
            } else {
                headOfSmallerThanX.next = p;
                headOfSmallerThanX = headOfSmallerThanX.next;
            }
            ListNode next = p.next;
            p.next = null;
            p = next;
        }

        headOfSmallerThanX.next = headOfBiggerThanXDummy.next;
        headOfBiggerThanXDummy.next = null;
        return headOfSmallerThanXDummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(4, 5, 6, 3, 2, 5, 1, 6, 4, 3));
        System.out.println(ListNodeUtils.traversalList(partition(head, 5)));
    }
}
