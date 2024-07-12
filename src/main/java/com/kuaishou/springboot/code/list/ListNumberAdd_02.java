package com.kuaishou.springboot.code.list;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-16
 *
 * l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class ListNumberAdd_02 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode();
        ListNode p = dummy;
        int bit = 0;
        while (l1 != null || l2 != null) {
            int val = bit;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            bit = val / 10;
            val %= 10;
            p.next = ListNodeUtils.newListNode(val);
            p = p.next;
        }
        if (bit > 0) {
            p.next = ListNodeUtils.newListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode l1 = ListNodeUtils.buildListNode(new int[] {4, 3});
        ListNode l2 = ListNodeUtils.buildListNode(new int[] {5, 6, 4});
        System.out.println(ListNodeUtils.traversalList(addTwoNumbers(l1, l2)));
    }

}
