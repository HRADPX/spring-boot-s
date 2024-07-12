package com.kuaishou.springboot.code.list;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-16
 */
public class Palindrome_234 {

    private static ListNode left;

    // 借助堆栈实现
    public static boolean isPalindromeV1(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        p = head;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (node.val != p.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }


    public static boolean isPalindromeV2(ListNode head) {
        left = head;
        return traverseList(head);
    }

    // 借助线程栈实现
    private static boolean traverseList(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean result = traverseList(head.next);
        result = result && left.val == head.val;
        left = left.next;
        return result;
    }


    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast, slow, p;
        p = fast = slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            p = slow;
            slow = slow.next;
        }

        ListNode p2;
        if (fast != null) {
            p2 = slow.next;
        } else {
            p2 = p.next;
        }
        p.next = null; // 断开链表
        ListNode p1 = reverseList(head);

        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == null;
    }

    private static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode p = head;
        ListNode next;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }



    public static void main(String[] args) {

        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(1, 2, 2, 1));
        System.out.println(isPalindromeV2(head));
    }
}
