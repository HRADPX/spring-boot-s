package com.kuaishou.springboot.code.list;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-28
 */
public class ReverseKGroup_24 {



    public static ListNode reverseKGroupV3(ListNode head, int k) {

        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy, q = head;

        while (true) {

            int i = 0;
            while (q != null && i < k - 1) {
                q = q.next;
                i++;
            }
            if (q == null || i < k - 1) {
                break;
            }
            // p pp   q
            // 0 1，2，3，4，5
            // 3,2,1,4
            ListNode newHead = q.next;
            ListNode pp = p.next, newP = pp;
            while (q != newHead) {
                ListNode next = pp.next;
                pp.next = newHead;
                newHead = pp;
                pp = next;
            }
            p.next = newHead;
            p = newP;
            q = pp;
        }
        return dummy.next;
    }







    /**
     * O(N) = 1
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k <= 1) return head;

        ListNode dummy = new ListNode(); ListNode p = dummy;
        p.next = head; ListNode q = head;
        while (true) {
            int i = 0;
            while (q != null && i < k - 1) {
                q = q.next;
                ++i;
            }
            // not enough k node, end
            if (q == null || i < k - 1) break;
            // 1 2 3 4 5
            // swap the k node
            // temp 下次开始的节点
            ListNode temp = p.next; ListNode pre = q.next; ListNode cur = temp;
            while (pre != q) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            p.next = pre;
            p = temp;
            q = p.next;
        }
        return dummy.next;
    }


    public static ListNode reverseKGroup0(ListNode head, int k) {

        if (head == null || head.next == null || k <= 1) return head;

        // p: traverse node, res: the head of result
        // join: link the end and head of node in cur and next loop
        ListNode p = head; ListNode res = null; ListNode join = null;
        while (true) {
            head = p;
            int i = 0;
            while (p != null && i < k) {
                p = p.next;
                ++i;
            }
            // not enough k node, end
            if (p == null && i < k) break;
            // swap the k node
            ListNode pre = p; ListNode cur = head;
            while (cur != p) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            p = head.next;
            if (join != null) join.next = pre;
            join = head;
            if (res == null) res = pre;
        }
        return res;
    }

    // recursion
    public static ListNode reverseKGroupRecursion(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        int i = 0;
        ListNode p = head;
        while (p != null && i < k) {
            p = p.next;
            ++i;
        }
        // reverse
        if (p == null && i < k) return head;
        ListNode pre = p; ListNode cur = head;
        while (cur != p) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroupRecursion(head.next, k);
        return pre;
    }


    ////////////////////////////////////////////////////

    // 不使用占位节点
    public static ListNode reverseKGroupV1(ListNode head, int k) {

        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode currentHead = head;
        ListNode nextHead;
        ListNode currentTail = null;
        ListNode rs = head;

        while (true) {
            int i = 1;
            while (i < k && p != null) {
                p = p.next;
                i++;
            }
            // 最后不足 k 个节点不处理
            if (i < k || p == null) {
                break;
            }
            nextHead = p.next;
            p.next = null;
            ListNode node = reverseList(currentHead);
            if (rs == head) {
                rs = node;
            } else {
                currentTail.next = p;
            }
            currentHead.next = nextHead;
            currentTail = currentHead;
            currentHead = nextHead;
            p = nextHead;
        }
        return rs;
    }

    public static ListNode reverseKGroupV2(ListNode head, int k) {

        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode nextHead;

        // 1 2 3 4 5
        int i = 1;
        while (i < k && p != null) {
            p = p.next;
            i++;
        }
        // 最后不足 k 个节点不处理
        if (i < k || p == null) {
            return head;
        }
        nextHead = p.next;
        p.next = null;
        ListNode newHead = reverseList(head);
        head.next = reverseKGroupV2(nextHead, k);
        return newHead;
    }

    private static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre, p, next;
        pre = null; p = head;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = ListNodeUtils.buildListNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        System.out.println(ListNodeUtils.traversalList(reverseKGroup0(node, 3)));
        System.out.println(ListNodeUtils.traversalList(reverseKGroupV3(node, 2)));

    }
}
