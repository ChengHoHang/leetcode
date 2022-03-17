package com.lc.base;

import java.util.List;

/**
 * @author chh
 * @date 2022/3/17 20:52
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public static TreeNode getByNodes(List<Integer> nodes) {
        return createTree(nodes, 0);
    }

    private static TreeNode createTree(List<Integer> nodes, int index) {
        if (index >= nodes.size() || nodes.get(index) == null) {
            return null;
        }

        TreeNode p = new TreeNode(nodes.get(index));
        p.left = createTree(nodes, 2 * index + 1);
        p.right = createTree(nodes, 2 * index + 2);
        return p;
    }
}
