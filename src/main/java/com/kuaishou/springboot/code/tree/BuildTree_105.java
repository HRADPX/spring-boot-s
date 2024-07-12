package com.kuaishou.springboot.code.tree;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-26
 *
 * 前序和中序构造二叉树
 */
public class BuildTree_105 {

    // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps >= pe) {
            return new TreeNode(preorder[pe]);
        }

        int rootIdx;
        // 找到中序中的根节点的位置
        for (rootIdx = is; rootIdx <= ie; rootIdx++) {
            if (inorder[rootIdx] == preorder[ps]) break;
        }

        TreeNode root = new TreeNode(preorder[ps]);
        root.left = buildTree(preorder, ps + 1, ps + rootIdx - is, inorder, is, rootIdx - 1);
        root.right = buildTree(preorder, ps + rootIdx - is + 1, pe, inorder, rootIdx + 1, ie);
        return root;
    }

    public static void main(String[] args) {


        int[] preorder = {-1};
        int[] inorder = {-1};

        TreeNode root = ReflectUtils.getInstance(BuildTree_105.class).buildTree(preorder, inorder);

        System.out.println(TreeNodeUtils.preorderTraversalRecursion(root));
        System.out.println(TreeNodeUtils.inorderTraversalRecursion(root));

    }
}
