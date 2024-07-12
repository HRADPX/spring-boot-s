package com.kuaishou.springboot.code.list;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;

import lombok.NonNull;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-16
 */
public class ListNodeUtils {

    /* the common method of operating list */
    /**
     * use default type to reverse the specified list, and return the head of the reversed list
     * @param head the head of the list that need to reverse
     * @see #reverseListRecursion(ListNode)  {@link #reverseListNormal(ListNode)}
     * @return the head of the reversed list
     */
    public static ListNode reverseList(ListNode head) {
        return reverseList(head, ModeType.NORMAL);
    }

    public static ListNode reverseList(ListNode head, @NonNull ModeType modeType) {
        switch (modeType) {
            case RECURSION:
                return reverseListRecursion(head);
            case NORMAL:
            default:
                return reverseListNormal(head);
        }
    }

    private static ListNode reverseListNormal(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre, next, p;
        p = head; pre = null;

        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    private static ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * Return the common ListNode of two list
     * @param l1 the head of first list
     * @param l2 the head of second list
     * @return the common ListNode of the two list
     */
    public static ListNode commonNode(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode p1 = l1; ListNode p2 = l2;
        while (p1 != p2) {
            p1 = p1.next == null ? p2 : p1.next;
            p2 = p2.next == null ? p1 : p2.next;
        }
        return p1;
    }

    /* the method of build list */

    public static ListNode buildListNode(int[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return null;
        }
        ListNode dummy = newListNode();
        ListNode p = dummy;
        for (int val : array) {
            p.next = newListNode(val);
            p = p.next;
        }
        return dummy.next;
    }

    public static ListNode buildListNode(Collection<Integer> coll) {
        return buildListNode(CollectionUtils.emptyIfNull(coll)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray());
    }

    public static List<Integer> traversalList(ListNode head) {
        List<Integer> result = Lists.newArrayList();
        while (head != null) {
           result.add(head.val);
           head = head.next;
        }
        return result;
    }

    public static ListNode newListNode() {
        return new ListNode();
    }

    public static ListNode newListNode(int val) {
        return new ListNode(val);
    }
}
