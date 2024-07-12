package com.kuaishou.springboot.code.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-22
 */
public class RecoverFromPreorder_1028 {

    public static TreeNode recoverFromPreorderV1(String traversal) {

        // 1-2--3---4-5--6---7
        Deque<TreeNode> path = new LinkedList<>();
        char[] chars = traversal.toCharArray();
        int pos = 0;
        while (pos < chars.length) {
            int level = 0;
            while (chars[pos] == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < chars.length && Character.isDigit(chars[pos])) {
                value = value * 10 + (chars[pos] - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }

    public static TreeNode recoverFromPreorder(String traversal) {

        char[] chars = traversal.toCharArray();
        Map<Integer, List<TreeNode>> floorNodeMap = new HashMap<>();
        Map<TreeNode, Integer> idxNumMap = new HashMap<>();

        int i = 0;
        int count = 0;
        while (i < chars.length) {

            int j = i;
            while (chars[j] == '-') {
                j++;
            }
            int floor = j - i;
            i = j;
            while (j < chars.length && chars[j] != '-') {
                j++;
            }
            int num = Integer.parseInt(new String(chars, i, j - i));
            TreeNode treeNode = new TreeNode(num);
            idxNumMap.put(treeNode, count++);
            floorNodeMap.computeIfAbsent(floor, v -> new ArrayList<>()).add(treeNode);
            i = j;
        }
        TreeNode root = null;
        LinkedList<TreeNode> list = new LinkedList<>();
        for (int j = 0; j < floorNodeMap.size(); j++) {
            if (j == 0) {
                root = floorNodeMap.get(j).get(0);
                list.add(root);
                continue;
            }
            // 第 j 层所有的节点
            List<TreeNode> nums = floorNodeMap.get(j);
            // 第 j 层所有的父节点（list）
            int idx = 0;
            List<TreeNode> currentFloorNodes = new ArrayList<>();
            while (!list.isEmpty() || idx < nums.size()) {

                // 如果当前层的节点（子节点）都已经处理完，但是父节点
                TreeNode currentParentNode = list.poll();
                TreeNode nextParentNode = list.peek();
                int nextIdx = nextParentNode == null ? Integer.MAX_VALUE : idxNumMap.get(nextParentNode);

                while (idx < nums.size()) {
                    int childIndex = idxNumMap.get(nums.get(idx));
                    if (childIndex > nextIdx) {
                        break;
                    }
                    TreeNode child = nums.get(idx);
                    // 左节点优先
                    if (currentParentNode.left == null) {
                        currentParentNode.left = child;
                    } else {
                        currentParentNode.right = child;
                    }
                    idx++;
                    currentFloorNodes.add(child);
                }
            }
            list.addAll(currentFloorNodes);
        }
        return root;
    }


    public static List<Integer> traverseTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p;
        stack.push(root);
        while (!stack.isEmpty()) {
            p = stack.pop();
            result.add(p.val);
            if (p.right != null) stack.push(p.right);
            if (p.left != null) stack.push(p.left);
        }
        return result;
    }

    public static List<Integer> traverseTreeV1(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        stack.push(root);

        while (!stack.isEmpty() || p != null) {

            if (p != null && p.left != null) {
                stack.push(p.left);
                p = p.left;
            } else {
                p = stack.pop();
                result.add(p.val);
                if (p.right != null) {
                    stack.push(p.right);
                }
                p = p.right;
            }

        }
        return result;
    }

    public static void main(String[] args) {


//        TreeNode root = TreeNodeUtils.buildBalanceTreeByList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
//        System.out.println(traverseTreeV1(root));

        String s  = "86-46--49---51----66--75---30-75--24---82----46-----38------5-----43----55---94----20";
        System.out.println(TreeNodeUtils.preorderTraversalRecursion(recoverFromPreorder(s)));
        System.out.println(TreeNodeUtils.inorderTraversalRecursion(recoverFromPreorder(s)));

        //        int n = 5 / 3;
//        int mod = 5 % 3;
//
//        for (int k = 0; k < 3; k++) {
//            int start = k * n + Math.min(k, mod);
//            int end = start + n - 1 + (k < mod ? 1 : 0);
//            System.out.println("[" + start + ", " + end + "]");
//        }
    }
}
