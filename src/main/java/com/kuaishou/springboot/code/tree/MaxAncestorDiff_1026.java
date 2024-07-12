package com.kuaishou.springboot.code.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-19
 */
public class MaxAncestorDiff_1026 {

    private int rs = 0;

    // 遍历二叉树的每条路径，记录每条路径上的最大和最小值
    public int maxAncestorDiff(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return rs;
        }
        maxAncestorDiffV1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return rs;
    }

    private void maxAncestorDiffV1(TreeNode root, int max, int min) {
        if (root == null) {
            rs = Math.max(rs, max - min);
            return;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        maxAncestorDiffV1(root.left, max, min);
        maxAncestorDiffV1(root.right, max, min);
    }
}
