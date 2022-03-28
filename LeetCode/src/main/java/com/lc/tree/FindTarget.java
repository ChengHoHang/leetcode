package com.lc.tree;

import com.lc.base.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chanhaoheng
 * @date 2022/3/23
 */
public class FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> existValues = new HashSet<>();
        return findTarget(root, k, existValues);
    }

    private boolean findTarget(TreeNode root, int k, Set<Integer> existValues) {
        if (root == null) {
            return false;
        }

        if (existValues.contains(k - root.val)) {
            return true;
        }

        existValues.add(root.val);

        return findTarget(root.left, k, existValues) || findTarget(root.right, k, existValues);
    }


    public static void main(String[] args) {
        FindTarget findTarget = new FindTarget();
        System.out.println(findTarget.findTarget(TreeNode.getByNodes(Arrays.asList(5, 3, 6, 2, 4, null, 7)), 9));
        System.out.println(findTarget.findTarget(TreeNode.getByNodes(Arrays.asList(5, 3, 6, 2, 4, null, 7)), 28));
    }
}
