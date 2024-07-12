package com.kuaishou.springboot.code.list;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-24
 */
public class MergeTwoLists_21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode dummy, p, h1, h2;
        dummy = new ListNode(); p = dummy; h1 = list1; h2 = list2;

        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                p.next = h2;
                h2 = h2.next;
            }
            else {
                p.next = h1;
                h1 = h1.next;
            }
            p = p.next;
        }
        if (h1 == null) p.next = h2;
        if (h2 == null) p.next = h1;

        return dummy.next;
    }

    public static ListNode recursionMergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode rs;
        if (list1.val < list2.val) {
            rs =  list1;
            list1 = list1.next;
        } else {
            rs = list2;
            list2 = list2.next;
        }
        rs.next = recursionMergeTwoList(list1, list2);
        return rs;
    }

    public static void main(String[] args) {

        ListNode list1 = ListNodeUtils.buildListNode(Arrays.asList(1, 3, 5, 9));
        ListNode list2 = ListNodeUtils.buildListNode(Arrays.asList(2, 4, 7));
        System.out.println(ListNodeUtils.traversalList(recursionMergeTwoList(list1, list2)));
    }
}
