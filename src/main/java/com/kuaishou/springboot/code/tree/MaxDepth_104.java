package com.kuaishou.springboot.code.tree;

import java.util.LinkedList;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-16
 */
public class MaxDepth_104 {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }

    // 层序遍历
    public int maxDepthV1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int res = 0;

        while (!queue.isEmpty()) {
            ++res;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
