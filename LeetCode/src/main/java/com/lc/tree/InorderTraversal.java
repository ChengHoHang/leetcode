package com.lc.tree;

import com.lc.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chh
 * @date 2022/3/17 20:53
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode p, List<Integer> result) {
        if (p == null) {
            return;
        }
        
        if (p.left != null) {
            dfs(p.left, result);
        }

        result.add(p.val);

        if (p.right != null) {
            dfs(p.right, result);
        }
    }
}
