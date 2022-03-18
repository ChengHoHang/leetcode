package com.lc.tree;

import com.lc.base.TreeNode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author chh
 * @date 2022/3/17 21:37
 */
public class IsValidBST {

    private long lowerBoard = Long.MIN_VALUE;
    private long upperBoard = Long.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        return dfs(root, lowerBoard, upperBoard);
    }

    private boolean dfs(TreeNode root, long lowerBoard, long upperBoard) {
        if (root == null) {
            return true;
        }

        if (root.val >= upperBoard || root.val <= lowerBoard) {
            return false;
        }

        return dfs(root.left, lowerBoard, root.val) && dfs(root.right, root.val, upperBoard);
    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        TreeNode treeNode = TreeNode.getByNodes(Arrays.asList(5, 4, 7, null, null, 6, 8));
        System.out.println(isValidBST.isValidBST(treeNode));

        TreeNode treeNode1 = TreeNode.getByNodes(Collections.singletonList(2147483647));
        System.out.println(isValidBST.isValidBST(treeNode1));
    }
}
