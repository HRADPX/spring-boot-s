package com.kuaishou.springboot.code.list;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-09-20
 */
public class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
