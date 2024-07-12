package com.kuaishou.springboot.code.tree;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-29
 */
public class BstToGst_1038 {

    public TreeNode bstToGst(TreeNode root) {
        preorder(root);
        return root;
    }

    int val;
    private void preorder(TreeNode root) {

        if (root == null) return;

        preorder(root.right);
        root.val += val;
        val = root.val;
        preorder(root.left);
    }

    public static void main(String[] args) {

        TreeNode root = TreeNodeUtils.buildBalanceTreeByList(Arrays.asList(2, 1, 3));
        ReflectUtils.getInstance(BstToGst_1038.class).bstToGst(root);

        System.out.println(TreeNodeUtils.preorderTraversal(root));
    }
}
