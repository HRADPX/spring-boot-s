package com.kuaishou.springboot.code.list;

import java.util.Arrays;
import java.util.Objects;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-24
 */
public class RemoveDuplicatedNode {

    public ListNode removeDuplicatedNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast, slow;
        slow = head;
        fast = slow.next;

        while (fast != null) {
            if (fast.val != slow.val) {
                slow = fast;
                fast = fast.next;
            } else {
                ListNode next = fast.next;
                slow.next = next;
                fast.next = null;
                fast = next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(1, 1, 2, 2, 4, 5, 9));
        System.out.println(
                ListNodeUtils.traversalList(
                        Objects.requireNonNull(ReflectUtils.getInstance(RemoveDuplicatedNode.class))
                                .removeDuplicatedNode(head)
                )
        );
    }
}
