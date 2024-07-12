package com.kuaishou.springboot.code.tree;

import java.util.Stack;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-29
 */
public class Codec_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return "";
        StringBuilder rs = new StringBuilder();
        preorder(root, rs);
        return rs.toString();
    }

    private void preorder(TreeNode root, StringBuilder rs) {

        if (root == null) {
            rs.append("#,");
            return;
        }
        rs.append(root.val).append(",");
        preorder(root.left, rs);
        preorder(root.right, rs);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 2) {
            return null;
        }
        String[] nodeValueArray = data.split(",");

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeValueArray[0]));
        stack.push(root);
        int idx = 1;

        while (idx < nodeValueArray.length && !nodeValueArray[idx].equals("#")) {
            TreeNode leftNode = new TreeNode(Integer.parseInt(nodeValueArray[idx++]));
            stack.peek().left = leftNode;
            stack.push(leftNode);
        }

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            if(++idx < nodeValueArray.length && !nodeValueArray[idx].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodeValueArray[idx++]));
                stack.push(node.right);

                while (idx < nodeValueArray.length && !nodeValueArray[idx].equals("#")) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(nodeValueArray[idx++]));
                    stack.peek().left = leftNode;
                    stack.push(leftNode);
                }
            }
        }
        return root;
    }

    private int idx = -1;
    public TreeNode deserializeV1(String data) {

        if (data == null || data.length() <= 2) {
            return null;
        }
        String[] chars = data.split(",");
        return deserializeV2(chars);
    }

    private TreeNode deserializeV2(String[] chars) {
        if (++idx >= chars.length) {
            return null;
        }
        if (chars[idx].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(chars[idx]));
        root.left = deserializeV2(chars);
        root.right = deserializeV2(chars);
        return root;
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        TreeNode rl = new TreeNode(4);
        TreeNode rr = new TreeNode(5);

        right.left = rl;
        right.right = rr;


        String data = ReflectUtils.getInstance(Codec_297.class).serialize(root);
        TreeNode root1 = ReflectUtils.getInstance(Codec_297.class).deserialize(data);

        System.out.println(TreeNodeUtils.preorderTraversal(root1));
        System.out.println(TreeNodeUtils.inorderTraversalRecursion(root1));
    }
}
