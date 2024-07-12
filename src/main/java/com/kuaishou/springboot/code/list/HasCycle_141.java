package com.kuaishou.springboot.code.list;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-08
 */
public class HasCycle_141 {

    public static boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
