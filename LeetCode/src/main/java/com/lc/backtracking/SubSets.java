package com.lc.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/solution/c-zong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-gao-/
 * @author chh
 * @date 2022/3/13 16:38
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backTracking(nums, new LinkedList<>(), 0, result);
        return result;
    }

    private void backTracking(int[] nums, LinkedList<Integer> path, int offset, List<List<Integer>> result) {
        // nums不重复，且求所有子集，不需要剪枝，直接add
        result.add(new ArrayList<>(path));

        for (int i = offset; i < nums.length; i++) {
            path.addLast(nums[i]);
            backTracking(nums, path, i + 1, result);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        System.out.println(subSets.subsets(new int[]{1, 2, 3}));
    }
}
