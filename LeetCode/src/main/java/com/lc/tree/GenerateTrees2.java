package com.lc.tree;

import com.lc.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chanhaoheng
 * @date 2023/7/8
 */
public class GenerateTrees2 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            // 得先加叶子节点，后面的组装时需要遍历
            result.add(null);
            return result;
        }

        // 以i为tree root, 获取所有左右子树
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTrees(start, i - 1);
            List<TreeNode> rightTree = generateTrees(i + 1, end);

            // 将不同的左右子树组装
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    result.add(treeNode);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GenerateTrees2 generateTrees2 = new GenerateTrees2();
        System.out.println(generateTrees2.generateTrees(3));
        
    }
}
