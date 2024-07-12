package com.kuaishou.springboot.code.tree;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-26
 */
public class ConstructMaximumBinaryTree_654 {

    // [3,2,1,6,0,5]
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {

        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);

        // 找到跟节点
        int rootIdx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[rootIdx]) rootIdx = i;
        }

        TreeNode root = new TreeNode(nums[rootIdx]);
        root.left = constructMaximumBinaryTree(nums, start, rootIdx - 1);
        root.right = constructMaximumBinaryTree(nums, rootIdx + 1, end);
        return root;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,6,0,5};
        TreeNode root = ReflectUtils.getInstance(ConstructMaximumBinaryTree_654.class).constructMaximumBinaryTree(nums);

        System.out.println(TreeNodeUtils.preorderTraversalRecursion(root));
        System.out.println(TreeNodeUtils.inorderTraversalRecursion(root));
    }
}
