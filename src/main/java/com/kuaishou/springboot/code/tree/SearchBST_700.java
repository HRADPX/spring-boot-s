package com.kuaishou.springboot.code.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-30
 */
public class SearchBST_700 {

    TreeNode rs;
    public TreeNode searchBSTV1(TreeNode root, int val) {
        inorder(root, val);
        return rs;
    }

    private void inorder(TreeNode root, int val) {
        if (rs != null) return;
        if (root == null) return;
        if (root.val > val) {
            inorder(root.left, val);
        } else if (root.val < val) {
            inorder(root.right, val);
        } else {
            rs = root;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
