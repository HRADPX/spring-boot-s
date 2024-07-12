package com.kuaishou.springboot.code.list;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-28
 */
public class MergeKLists_22 {

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length <= 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKLists(ListNode[] lists, int low, int high) {
        if (low >= high) {
            return lists[low];
        }
        int mid = (low + high) >>> 1;
        ListNode left = mergeKLists(lists, low, mid);
        ListNode right = mergeKLists(lists, mid + 1, high);
        return mergeTwoList(left, right);
    }

    private static ListNode mergeTwoList(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        ListNode dummy, p;
        dummy = new ListNode(); p = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left == null) p.next = right;
        if (right == null) p.next = left;
        return dummy.next;
    }



    public static void main(String[] args) {

        ListNode h1 = ListNodeUtils.buildListNode(Arrays.asList(1, 3, 6, 8, 12));
        ListNode h2 = ListNodeUtils.buildListNode(Arrays.asList(2, 4, 7, 9, 15));
        ListNode h3 = ListNodeUtils.buildListNode(Arrays.asList(3, 5, 10, 13, 14));
        ListNode h4 = ListNodeUtils.buildListNode(Arrays.asList(9, 11, 19, 20, 21));
        ListNode[] lists = new ListNode[] {h1, h2, h3, h4};
        System.out.println(ListNodeUtils.traversalList(mergeKLists(lists)));
    }
}
