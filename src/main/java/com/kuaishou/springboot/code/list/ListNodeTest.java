package com.kuaishou.springboot.code.list;

import static java.util.stream.IntStream.range;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-16
 */
public class ListNodeTest {

    public static void main(String[] args) {

        int[] array = range(0, 10).toArray();
        ListNode head = ListNodeUtils.buildListNode(array);
        System.out.println(ListNodeUtils.traversalList(head));
        System.out.println(ListNodeUtils.traversalList(ListNodeUtils.reverseList(head, ModeType.RECURSION)));
    }
}
