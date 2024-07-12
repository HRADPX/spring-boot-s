package com.kuaishou.springboot.code.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-16
 */
public class DiameterOfBinaryTree_543 {

    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        deepOfTree(root);
        return max;
    }

    private static int deepOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deepOfTree(root.left);
        int right = deepOfTree(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
