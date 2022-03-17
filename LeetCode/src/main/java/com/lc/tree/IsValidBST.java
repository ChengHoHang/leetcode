package com.lc.tree;

import com.lc.base.TreeNode;

import java.util.Arrays;

/**
 * @author chh
 * @date 2022/3/17 21:37
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.val < root.val) {
            return false;
        }

        if (root.right != null && root.right.val < root.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getByNodes(Arrays.asList(5, 4, 6, null, null, 3, 7));
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(treeNode));
    }
}
