package com.lc.tree.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * @author chanhaoheng
 * @date 2022/3/9
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return result;
        }

        dfs(candidates, new LinkedList<>(), 0,0, target, result);
        return result;
    }

    private void dfs(int[] candidates, LinkedList<Integer> pathNodes, int enableUseIndex, int pathSum, int target, List<List<Integer>> result) {
        if (pathSum == target) {
            result.add(new ArrayList<>(pathNodes));
            return;
        }

        outer: for (int i = enableUseIndex; i < candidates.length;) {
            int candidate = candidates[i];
            if (pathSum + candidate > target) {
                break;
            }

            pathNodes.push(candidate);
            dfs(candidates, pathNodes, i + 1, pathSum + candidate, target, result);
            pathNodes.pop();

            do {
                i++;
                if (i > candidates.length - 1) {
                    break outer;
                }
            } while (candidates[i - 1] == candidates[i]);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum = new CombinationSum2();
        System.out.println(combinationSum.combinationSum2(new int[]{1, 1}, 1));
        System.out.println(combinationSum.combinationSum2(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum.combinationSum2(new int[]{1, 2, 3, 6, 7}, 8));
        System.out.println(combinationSum.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
