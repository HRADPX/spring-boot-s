package com.kuaishou.springboot.code.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-30
 */
public class GenerateTrees_95 {

    public List<TreeNode> generateTrees(int n) {

         List<TreeNode> ans = new ArrayList<>();
         if(n == 0) return ans;
         return dfs(1, n);
    }

    private List<TreeNode> dfs(int low, int high) {

        List<TreeNode> list = new ArrayList<>();
        if (low > high) {
            list.add(null);
            return list;
        }
        if (low == high) {
            list.add(new TreeNode(low));
            return list;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> lefts = dfs(low, i - 1);
            List<TreeNode> rights = dfs(i + 1, high);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
