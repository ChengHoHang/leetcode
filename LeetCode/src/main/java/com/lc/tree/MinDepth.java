package com.lc.tree;

import com.lc.base.TreeNode;

import java.util.Arrays;

/**
 * @author chanhaoheng
 * @date 2022/3/23
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }

        return 1 + minDepth(root.left) + minDepth(root.right);
    }

    public static void main(String[] args) {
        MinDepth minDepth = new MinDepth();
        System.out.println(minDepth.minDepth(TreeNode.getByNodes(Arrays.asList(2, null, 3, null, 4, null, 5, null, 6))));
        System.out.println(minDepth.minDepth(TreeNode.getByNodes(Arrays.asList(3,9,20,null,null,15,7))));
    }
}
