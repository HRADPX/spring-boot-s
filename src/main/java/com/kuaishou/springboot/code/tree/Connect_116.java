package com.kuaishou.springboot.code.tree;

import java.util.LinkedList;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-21
 */
public class Connect_116 {

    // 层序遍历（思路最清晰，实现最简单）
    public Node connect(Node root) {

        if (root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node cur = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.pop();
                if (cur != null) {
                    cur.next = node;
                }
                cur = node;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;

    }

    // 非递归
    public Node connectV1(Node root) {

        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    // 递归
    public Node connectV2(Node root) {

        this.dfs(root);
        return root;
    }

    private void dfs(Node root) {

        if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;

        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }

        dfs(root.left);
        dfs(root.right);
    }
}
