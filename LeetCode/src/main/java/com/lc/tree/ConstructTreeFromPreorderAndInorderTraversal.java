package com.lc.tree;

import com.lc.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author chh
 * @date 2022/3/20 13:15
 */
public class ConstructTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 递归，preorder的第一个节点必定是根节点
        Map<Integer, Integer> value2IndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            value2IndexMap.put(inorder[i], i);
        }

        return buildTree(preorder, value2IndexMap);
    }

    private TreeNode buildTree(int[] preOrder, Map<Integer, Integer> value2IndexMap) {
        // todo
        return null;
    }
}
