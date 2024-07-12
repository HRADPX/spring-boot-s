package com.kuaishou.springboot.code.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-09-20
 *
 * 复杂链表复制
 */
public class CopyRandomList_138 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node p = head;
        Node newHead = null;
        Node pp = null;
        while (p != null) {
            Node copy = new Node(p.val);
            if (newHead == null) {
                newHead = copy;
                pp = newHead;
            } else {
                pp.next = copy;
                pp = copy;
            }
            nodeMap.put(p, copy);
            p = p.next;
        }
        p = head;
        while (p != null) {
            Node copy = nodeMap.get(p);
            copy.random = nodeMap.get(p.random);
            p = p.next;
        }
        return nodeMap.get(head);
    }

    public Node copyRandomListV1(Node head) {

        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            Node copy = new Node(p.val);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        p = head;
        // 处理随机指针
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        // 断开链表
        Node newHead = null;
        Node pp = null;
        p = head;

        while (p != null) {
            Node next = p.next;
            if (newHead == null) {
                newHead = next;
            } else {
                p.next = next.next;
                pp.next = next;
            }
            p.next = next.next;
            next.next = null;
            pp = next;
            p = p.next;
        }
        return newHead;
    }
}
