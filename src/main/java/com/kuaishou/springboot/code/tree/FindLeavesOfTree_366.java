package com.kuaishou.springboot.code.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-19
 *
 * 给你一棵二叉树，依次从左往右，每次收集并删除所有的叶子节点
 */
public class FindLeavesOfTree_366 {

    public static List<List<Integer>> findLeavesOfBinaryTree(TreeNode root) {

        List<List<Integer>> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }

        // 层序遍历存在重复遍历的问题
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            LinkedList<Integer> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.right != null && node.right.left == null && node.right.right == null) {
                        list.addFirst(node.right.val);
                        node.right = null;
                    }
                    if (node.left != null && node.left.left == null && node.left.right == null) {
                        list.addFirst(node.left.val);
                        node.left = null;
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            rs.add(new ArrayList<>(list));
            if (root.left == null && root.right == null) {
                rs.add(Collections.singletonList(root.val));
                break;
            }
            queue.add(root);
        }
        return rs;
    }


    public static List<List<Integer>> findLeavesOfBinaryTreeV1(TreeNode root) {

        List<List<Integer>> rs = new ArrayList<>();

        dfs(root, rs);
        return rs;
    }

    private static int dfs(TreeNode root, List<List<Integer>> rs) {

        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, rs);
        int right = dfs(root.right, rs);
        int deep = Math.max(left, right) + 1;
        if (rs.size() < deep) {
            rs.add(deep - 1, new ArrayList<>());
        }
        rs.get(deep - 1).add(root.val);
        return deep;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode fl = new TreeNode(2);
        TreeNode fr = new TreeNode(5);
        root.left = fl;
        root.right = fr;

        TreeNode sl = new TreeNode(1);
        TreeNode sr = new TreeNode(4);
        fl.left = sl;
        fl.right = sr;

        System.out.println(TreeNodeUtils.floorTraversal(root));
        System.out.println(findLeavesOfBinaryTreeV1(root));

    }
}
