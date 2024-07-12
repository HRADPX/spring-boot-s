package com.kuaishou.springboot.code.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-16
 */
public class PreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            rs.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return rs;
    }


}
