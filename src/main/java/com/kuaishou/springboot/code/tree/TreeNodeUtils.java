package com.kuaishou.springboot.code.tree;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;

import lombok.NonNull;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-20
 */
public class TreeNodeUtils {

    private static final double HALF_CHOICE = 0.5;

    /* the method of build the tree by list */

    /**
     * build a balance tree by a list
     * @param array the elements of the array will be converted to {@link TreeNode} of the tree
     * @see #buildBalanceTreeByList(Collection)
     * @return the root of the balanced tree based on param array
     */
    public static TreeNode buildBalanceTreeByList(int[] array) {

        if (ArrayUtils.isEmpty(array)) return null;
        return buildBalanceTreeByList(array, 0, array.length - 1);
    }

    private static TreeNode buildBalanceTreeByList(@NonNull int[] array, int low, int high) {
        if (low > high) return null;
        if (low == high) return new TreeNode(array[low]);
        int mid = (low + high) >> 1;
        TreeNode root = new TreeNode(array[mid]);
        root.left = buildBalanceTreeByList(array, low, mid - 1);
        root.right = buildBalanceTreeByList(array, mid + 1, high);
        return root;
    }

    /**
     * build a balance tree by a collection
     * @param coll the elements of the array will be converted to {@link TreeNode} of the tree
     * @see #buildBalanceTreeByList(int[])
     * @return the root of the balanced tree based on param coll
     */
    public static TreeNode buildBalanceTreeByList(Collection<Integer> coll) {
        return buildBalanceTreeByList(CollectionUtils.emptyIfNull(coll).stream()
                .mapToInt(Integer::intValue)
                .toArray());
    }


    /* the common method of traversal the tree */

    public static List<Integer> traversalTree(TreeNode root, @NonNull TreeTraversalType traversalType) {
        switch (traversalType) {
            case IN_ORDER:
                return Math.random() > HALF_CHOICE ? inorderTraversal(root) : inorderTraversalRecursion(root);
            case PRE_ORDER:
                return Math.random() > HALF_CHOICE ? preorderTraversal(root) : preorderTraversalRecursion(root);
            case POST_ORDER:
                return Math.random() > HALF_CHOICE ? postOrderTraversal(root) : postOrderTraversalRecursion(root);
            case FLOOR_ORDER:
                return floorTraversal(root);
            default:
                return Collections.emptyList();
        }
    }

    /**
     * Return the value list of the treeNode order by  preorder
     * @param root The root of the tree that need to traversal
     * @see #preorderTraversalRecursion(TreeNode)
     * @return The value list of the tree
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
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

    /**
     * Return the value list of the treeNode order by  inorder
     * @param root The root of the tree that need to traversal
     * @see #inorderTraversalRecursion(TreeNode)
     * @return The value list of the tree
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                result.add(p.val);
                p = p.right;
            }
        }
        return result;
    }

    /**
     * Return the value list of the treeNode order by postOrder
     * @param root The root of the tree that need to traversal
     * @see #postOrderTraversalRecursion(TreeNode)
     * @return The value list of the tree
     */
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        TreeNode p = root;
        TreeNode preNode = null;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (p.right != null && preNode != p.right) {
                    stack.push(p);
                    p = p.right;
                } else {
                    result.add(p.val);
                    preNode = p;
                    p = null;
                }
            }
        }
        return result;
    }

    public static List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        preorderTraversalRecursion(root, result);
        return result;
    }

    private static void preorderTraversalRecursion(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorderTraversalRecursion(root.left, result);
        preorderTraversalRecursion(root.right, result);
    }

    public static List<Integer> inorderTraversalRecursion(TreeNode root) {

        List<Integer> result = Lists.newArrayList();
        inorderTraversalRecursion(root, result);
        return result;
    }

    private static void inorderTraversalRecursion(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversalRecursion(root.left, result);
        result.add(root.val);
        inorderTraversalRecursion(root.right, result);
    }


    public static List<Integer> postOrderTraversalRecursion(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        postOrderTraversalRecursion(root, result);
        return result;
    }

    private static void postOrderTraversalRecursion(TreeNode root, List<Integer> result) {
        if (root == null) return;
        preorderTraversalRecursion(root.left, result);
        preorderTraversalRecursion(root.right, result);
        result.add(root.val);
    }

    /**
     * Return the value list of the treeNode order by floorOrder
     * @param root The root of the tree that need to traversal
     * @return The value list of the tree
     */
    public static List<Integer> floorTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = Lists.newArrayList();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            result.add(p.val);
            if (p.left != null) queue.add(p.left);
            if (p.right != null) queue.add(p.right);
        }
        return result;
    }
}
