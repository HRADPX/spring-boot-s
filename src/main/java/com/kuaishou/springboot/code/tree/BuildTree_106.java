package com.kuaishou.springboot.code.tree;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-26
 *
 * 中序 + 后序还原二叉树
 */
public class BuildTree_106 {

    // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int startIn, int endIn, int[] postorder, int startPost, int endPost) {
        if (startIn > endIn) return null;
        if (startIn == endIn) {
            return new TreeNode(inorder[startIn]);
        }

        int rootIdx;
        // 找到中序中的根节点的位置
        for (rootIdx = startIn; rootIdx <= endIn; rootIdx++) {
            if (inorder[rootIdx] == postorder[endPost]) break;
        }

        TreeNode root = new TreeNode(inorder[rootIdx]);
        root.left = buildTree(inorder, startIn, rootIdx - 1, postorder, startPost, startPost + rootIdx - startIn - 1);
        root.right = buildTree(inorder, rootIdx + 1, endIn, postorder, startPost + rootIdx - startIn, endPost - 1);
        return root;
    }

    public static void main(String[] args) {

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode root = ReflectUtils.getInstance(BuildTree_106.class).buildTree(inorder, postorder);

        System.out.println(TreeNodeUtils.inorderTraversalRecursion(root));
        System.out.println(TreeNodeUtils.postOrderTraversal(root));
    }
}
