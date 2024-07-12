package com.kuaishou.springboot.code.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-30
 */
public class IsValidBST_98 {

    boolean rs = true;
    Integer val;
    public boolean isValidBST(TreeNode root) {
        // 遍历解法
        inorder(root);
        return rs;
    }

    private void inorder(TreeNode root) {

        if (!rs) return;
        inorder(root.left);
        if (val == null) val = root.val;
        else {
            if (val >= root.val) rs = false;
            return;
        }
        inorder(root.right);
    }

    TreeNode node;
    public boolean isValidBSTV1(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!left) return false;
        if (node != null && node.val >= root.val)
            return false;
        else
            node = root;
        return isValidBST(root.right);
    }
}
