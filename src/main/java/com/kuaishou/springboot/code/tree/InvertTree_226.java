package com.kuaishou.springboot.code.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-21
 */
public class InvertTree_226 {

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private TreeNode traverse(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode left = traverse(root.left);

        root.left = traverse(root.right);
        root.right = left;

        return root;
    }

    private void traverseV1(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        traverseV1(root.left);
        traverseV1(root.right);

    }
}
