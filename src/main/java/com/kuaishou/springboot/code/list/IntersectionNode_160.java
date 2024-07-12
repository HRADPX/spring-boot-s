package com.kuaishou.springboot.code.list;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-08
 */
public class IntersectionNode_160 {

    public ListNode intersectionNode(ListNode h1, ListNode h2) {

        ListNode p1 = h1;
        ListNode p2 = h2;

        while (p1 != p2) {
            p1 = p1 == null ? h2 : p1.next;
            p2 = p2 == null ? h1 : p2.next;
        }
        return p1;
    }
}
