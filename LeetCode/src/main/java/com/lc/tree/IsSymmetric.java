package com.lc.tree;

import com.lc.base.TreeNode;

import java.util.Arrays;

/**
 * @author chanhaoheng
 * @date 2022/3/18
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();

        TreeNode tree1 = TreeNode.getByNodes(Arrays.asList(1, 2, 2, 3, 4, 4, 3));
        System.out.println(isSymmetric.isSymmetric(tree1));

        TreeNode tree2 = TreeNode.getByNodes(Arrays.asList(1,2,2,null,3,null,3));
        System.out.println(isSymmetric.isSymmetric(tree2));
    }
}
