package com.lc.tree;

import com.lc.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chanhaoheng
 * @date 2022/3/23
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            postorderTraversal(root.left, result);
            postorderTraversal(root.right, result);
            result.add(root.val);
        }
    }


}
