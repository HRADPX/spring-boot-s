package com.kuaishou.springboot.code.tree;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-29
 */
public class DeleteNode_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNode(root, null, key);
    }

    public TreeNode deleteNodeV1(TreeNode root, int key) {

        if (root == null) return null;

        if (key > root.val)
            root.right = deleteNode(root.right, key); // 去右子树删除

        else if(key < root.val)
            root.left = deleteNode(root.left, key);   // 去左子树删除

        else  {  // 当前节点就是要删除的节点

            if (root.left == null) return root.right;            // case1，欲删除节点无左子
            else if (root.right == null)  return root.left;      // case2，欲删除节点无右子
            else {                                               // case3，欲删除节点左右子都有
                TreeNode node = root.right;
                while (node.left != null)       // 寻找欲删除节点右子树的最左节点
                    node = node.left;

                node.left = root.left;          // 将欲删除节点的左子树成为其右子树的最左节点的左子树
                root = root.right;              // 欲删除节点的右子顶替其位置，节点被删除
            }
        }
        return root;
    }

    // 复杂版
    public TreeNode deleteNode(TreeNode root, TreeNode parent, int key) {

        if (root.val > key) {
            deleteNode(root.left, root, key);
            return parent == null ? root : parent;
        } else if (root.val < key) {
            deleteNode(root.right, root, key);
            return parent == null ? root : parent;
        }
        if (root.left == null && root.right == null) {
            if (parent == null) {
                return null;
            }
            if (parent.right == root) parent.right = null;
            if (parent.left == root) parent.left = null;
            return parent;
        }
        // 找到替换该节点的子节点
        TreeNode newRoot;
        TreeNode p;
        // 删除的是左节点还是右边节点
        boolean isLeft = parent != null && parent.left == root;
        if (root.right != null) {
            newRoot = root.right;
            p = root;
            while (newRoot.left != null) {
                p = newRoot;
                newRoot = newRoot.left;
            }
            // 删除的是跟节点
            if (parent == null && p != root) {
                newRoot.left = root.left;
                p.left = newRoot.right;
                newRoot.right = root.right;
                root.left = null;
                root.right = null;
                return newRoot;
            } else if (parent == null) {
                newRoot.left = root.left;
                root.left = null;
                root.right = null;
                return newRoot;
            } else if (p == root) {
                if (isLeft) parent.left = newRoot;
                else parent.right = newRoot;
                newRoot.left = root.left;
                root.left = null;
                root.right = null;
                return parent;
            } else {
                p.left = newRoot.right;
                newRoot.left = root.left;
                if (isLeft) parent.left = newRoot;
                else parent.right = newRoot;
                newRoot.right = root.right;
                root.left = null;
                root.right = null;
                return parent;
            }
        }

        newRoot = root.left;
        p = root;
        while (newRoot.right != null) {
            p = newRoot;
            newRoot = newRoot.right;
        }
        // 删除的是跟节点
        if (parent == null && p != root) {
            p.right = newRoot.left;
            newRoot.left = root.left;
            newRoot.right = null;
            root.left = null;
            root.right = null;
            return newRoot;
        } else if (parent == null) {
            newRoot.right = root.right;
            root.left = null;
            root.right = null;
            return newRoot;
        } else if (p == root) {
            if (isLeft) parent.left = newRoot;
            else parent.right = newRoot;
            newRoot.right = root.right;
            root.left = null;
            root.right = null;
            return parent;
        } else {
            p.right = newRoot.left;
            newRoot.left = root.left;
            if (isLeft) parent.left = newRoot;
            else parent.right = newRoot;
            newRoot.right = root.right;
            root.left = null;
            root.right = null;
            return parent;
        }
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        System.out.println(
                TreeNodeUtils.preorderTraversal(ReflectUtils.getInstance(DeleteNode_450.class).deleteNode(root, 2)));
    }
}
