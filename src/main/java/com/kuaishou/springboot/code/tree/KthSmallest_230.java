package com.kuaishou.springboot.code.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-29
 */
public class KthSmallest_230 {

    int val;
    int i;
    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);
        return val;
    }

    private void inorder(TreeNode root, int k) {
        if (i == k) return;
        if (root == null) return;
        inorder(root.left, k - 1);
        if (++i == k) {
            val = root.val;
            // 提前终止
            return;
        }
        inorder(root.right, k - 1);
    }
}
