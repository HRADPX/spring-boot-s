package com.kuaishou.springboot.code.tree;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-26
 */
public class ConstructFromPrePost_889 {

    // preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode constructFromPrePost(int[] preorder, int startPre, int endPre, int[] postorder, int startPost, int endPost) {

        if (startPre > endPre) return null;
        if (startPre == endPre) return new TreeNode(preorder[startPre]);

        TreeNode root = new TreeNode(preorder[startPre]);

        // 找到右节点的位置
        int rightIdx;
        for (rightIdx = startPre; rightIdx <= endPre; rightIdx++) {
            if (preorder[rightIdx] == postorder[endPost - 1]) break;
        }

        root.left = constructFromPrePost(preorder, startPre + 1, rightIdx - 1,
                postorder, startPost, endPost - 1 - (endPre - rightIdx + 1));
        root.right = constructFromPrePost(preorder, rightIdx, endPre,
                postorder, endPost - (endPre - rightIdx + 1), endPost - 1);
        return root;
    }

    public static void main(String[] args) {

        int[] preorder = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};

        TreeNode root = ReflectUtils.getInstance(ConstructFromPrePost_889.class).constructFromPrePost(preorder, postorder);

        System.out.println(TreeNodeUtils.preorderTraversalRecursion(root));
        System.out.println(TreeNodeUtils.postOrderTraversal(root));
    }
}
