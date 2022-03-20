package com.lc.tree;

import com.lc.base.TreeNode;

import java.util.*;

/**
 * @author chh
 * @date 2022/3/20 12:45
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> sameLevelNodes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                sameLevelNodes.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }

            result.add(sameLevelNodes);
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getByNodes(Arrays.asList(3, 9, 20, null, null, 15, 7));
        BinaryTreeLevelOrderTraversal orderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.println(orderTraversal.levelOrder(treeNode));
    }
}
